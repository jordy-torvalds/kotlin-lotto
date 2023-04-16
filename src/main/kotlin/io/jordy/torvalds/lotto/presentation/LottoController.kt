package io.jordy.torvalds.lotto.presentation

import io.jordy.torvalds.lotto.domain.Lotto
import io.jordy.torvalds.lotto.domain.Money
import io.jordy.torvalds.lotto.domain.WinningLotto
import io.jordy.torvalds.lotto.presentation.view.PurchaseInputView
import io.jordy.torvalds.lotto.presentation.view.PurchasedLottoView
import io.jordy.torvalds.lotto.presentation.view.VerifyingWinningLottoView
import io.jordy.torvalds.lotto.presentation.view.WinningLottoInputView
import io.jordy.torvalds.lotto.service.LottoService

class LottoController(private val lottoService: LottoService) {

  fun getPurchaseInputView(): PurchaseInputView {
    return PurchaseInputView()
  }

  fun purchaseLotto(purchaseAmount: String): PurchasedLottoView {
    require(purchaseAmount.toIntOrNull() != null) { "구입금액은 정수만 가능합니다." }
    require(purchaseAmount.toInt() > 0) { "구입금액은 0보다 커야 합니다." }

    val money = Money(purchaseAmount.toLong())
    val lottoDtos = lottoService.purchaseLotto(money)
    return PurchasedLottoView(lottoDtos)
  }

  fun getWinningLottoInputView(): WinningLottoInputView {
    return WinningLottoInputView()
  }

  fun verifyWinningLotto(winningLottoNumbers: String): VerifyingWinningLottoView {
    val parsedWinningLottoNumbers: List<Int> = winningLottoNumbers.split(",").map { it.trim().toInt() }
    require(parsedWinningLottoNumbers.size == Lotto.VALID_SIZE) { "당첨 번호는 6개여야 합니다." }
    require(parsedWinningLottoNumbers.distinct().size == Lotto.VALID_SIZE) { "당첨 번호는 중복되지 않아야 합니다." }

    val rankDtos = lottoService.verifyTheWinningLotto(
      WinningLotto.create(parsedWinningLottoNumbers)
    )
    val winningStatistics = lottoService.createWinningStatistics(rankDtos)
    val earningRate = lottoService.calculateEarningRate(winningStatistics)
    return VerifyingWinningLottoView(winningStatistics, earningRate)
  }
}

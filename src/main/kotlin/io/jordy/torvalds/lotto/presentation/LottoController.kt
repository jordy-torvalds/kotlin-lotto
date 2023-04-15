package io.jordy.torvalds.lotto.presentation

import io.jordy.torvalds.lotto.domain.Money
import io.jordy.torvalds.lotto.presentation.dto.PurchaseLottoRequest
import io.jordy.torvalds.lotto.presentation.dto.PurchaseLottoResponse
import io.jordy.torvalds.lotto.presentation.dto.VerifyingRankRequest
import io.jordy.torvalds.lotto.presentation.dto.VerifyingRankResponse
import io.jordy.torvalds.lotto.service.LottoService

class LottoController(private val lottoService: LottoService) {

  fun purchaseLotto(request: PurchaseLottoRequest): PurchaseLottoResponse {
    val money = Money(request.purchaseAmount.toLong())
    val lottoDtos = lottoService.purchaseLotto(money)
    return PurchaseLottoResponse(lottoDtos)
  }

  fun verifyWinningLotto(verifyingRankRequest: VerifyingRankRequest): VerifyingRankResponse {
    val rankDtos = lottoService.verifyTheWinningLotto(
      verifyingRankRequest.toLotto(),
    )
    val winningStatistics = lottoService.createWinningStatistics(rankDtos)
    val earningRate = lottoService.calculateEarningRate(winningStatistics)
    return VerifyingRankResponse(winningStatistics, earningRate)
  }
}

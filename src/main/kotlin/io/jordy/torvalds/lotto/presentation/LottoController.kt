package io.jordy.torvalds.lotto.presentation

import io.jordy.torvalds.lotto.presentation.dto.PurchaseLottoRequest
import io.jordy.torvalds.lotto.presentation.dto.PurchaseLottoResponse
import io.jordy.torvalds.lotto.service.LottoService
import io.jordy.torvalds.lotto.value.Money

class LottoController(private val lottoService: LottoService) {

  // purchaseLotto() -> 로또 구입 금액을 입력 받는다.
  // input: 금액
  // output: 구매된 로또 리스트
  fun purchaseLotto(request: PurchaseLottoRequest): PurchaseLottoResponse {
    val money = Money(request.purchaseAmount.toLong())
    val lottoDtos = lottoService.purchaseLotto(money)
    return PurchaseLottoResponse(lottoDtos)
  }

  // registerWinLottoNumber() -> 입력받은 당첨 번호를 기반으로 당첨 통계를 반환한다.
  // input: 당첨 번호 ints
  // output: nth.

  // getWinStatistics() -> 당첨 통계를 반환한다.
  // return: 당첨 통계 결과를 담은 String
  /*
  당첨 통계
  ---------
  3개 일치 (5000원)- 1개
  4개 일치 (50000원)- 0개
  5개 일치 (1500000원)- 0개
  6개 일치 (2000000000원)- 0개
  총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
   */

}
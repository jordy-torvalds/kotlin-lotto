import io.jordy.torvalds.lotto.config.Configuration
import io.jordy.torvalds.lotto.presentation.dto.PurchaseLottoRequest
import io.jordy.torvalds.lotto.presentation.dto.VerifyingRankRequest
import java.math.BigDecimal.ONE

val lottoController = Configuration.lottoController

fun main() {
  purchaseLotto()
  verifyTheWinningLotto()
}

fun purchaseLotto() {
  println("구입금액을 입력해 주세요.")

  // controller -> view ! 흐르게
  val purchaseAmount = readLine()!! // readln
  val purchaseLottoRequest = PurchaseLottoRequest(purchaseAmount)
  val result = lottoController.purchaseLotto(purchaseLottoRequest)

  println("${result.value.size}개를 구매했습니다.")
  result.value.forEach { println("[${it.joinToString(", ")}]") }
}

fun verifyTheWinningLotto() {
  println("지난 주 당첨 번호를 입력해 주세요.")

  val winningLottoNumbers = readLine()!!.split(",").map { it.trim().toInt() }
  val verifyingRankRequest = VerifyingRankRequest(winningLottoNumbers)
  val result = lottoController.verifyWinningLotto(verifyingRankRequest)

  val resultByRank = result.winningStatisticsDto.resultByRank
  val earningRate = result.earningRate

  println("당첨 통계")
  println("---------")
  listOf("FOURTH", "THIRD", "SECOND", "FIRST").forEach {
    val winningStatistic = resultByRank[it]
    println("${winningStatistic?.matchCount}개 일치 (${winningStatistic?.winningPrize}원) - ${winningStatistic?.count}개")
  }
  if (earningRate >= ONE) {
    println("총 수익률은 ${earningRate}입니다.")
  } else {
    println("총 수익률은 ${earningRate}입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)")
  }
}

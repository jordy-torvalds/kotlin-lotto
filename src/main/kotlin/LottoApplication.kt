import io.jordy.torvalds.lotto.config.Configuration
import io.jordy.torvalds.lotto.presentation.dto.PurchaseLottoRequest

val lottoController = Configuration.lottoController

fun main() {
   val purchaseAmount = readLine()!!
   val purchaseLottoRequest = PurchaseLottoRequest(purchaseAmount)
   val result = lottoController.purchaseLotto(purchaseLottoRequest)
   println(result)
}
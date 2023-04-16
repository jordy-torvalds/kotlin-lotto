import io.jordy.torvalds.lotto.config.Configuration

val lottoController = Configuration.lottoController

fun main() {
  val purchaseAmount = lottoController.getPurchaseInputView().render()
  lottoController.purchaseLotto(purchaseAmount).render()
  val winningLottoNumbers = lottoController.getWinningLottoInputView().render()
  lottoController.verifyWinningLotto(winningLottoNumbers).render()
}

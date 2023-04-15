package io.jordy.torvalds.lotto.presentation.dto

data class PurchaseLottoRequest(val purchaseAmount: String) {

  init {
    require(purchaseAmount.toIntOrNull() != null) { "로또 구입 금액은 정수만 가능합니다." }
    require(purchaseAmount.toInt() > 0) { "로또 구입 금액은 0보다 커야 합니다." }
  }
}

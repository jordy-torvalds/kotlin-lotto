package io.jordy.torvalds.lotto.value

data class Money(val value: Long) {

  init {
    require(value > 0) { "금액은 0보다 커야 합니다." }
  }

}

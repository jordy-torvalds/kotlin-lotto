package io.jordy.torvalds.lotto.domain

data class Money(val value: Long) {

  init {
    require(value >= 0) { "금액은 음수 일 수 없습니다." }
  }
}

package io.jordy.torvalds.lotto.domain

// value가 더 맞다
data class Money(val value: Long) {

  // divide 순서
  init {
    require(value >= 0) { "금액은 음수 일 수 없습니다." }
  }

  fun divide(divisor: Int): Long {
    return value / divisor
  }
}

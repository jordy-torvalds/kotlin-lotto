package io.jordy.torvalds.lotto.domain

@JvmInline
value class Money(val value: Long) {

  init {
    require(value >= 0) { "금액은 음수 일 수 없습니다." }
  }

  fun divide(divisor: Int): Long {
    return value / divisor
  }
}

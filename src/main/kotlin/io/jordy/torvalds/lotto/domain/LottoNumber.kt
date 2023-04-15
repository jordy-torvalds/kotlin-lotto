package io.jordy.torvalds.lotto.domain

class LottoNumber(val number: Int) {

  init {
    require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) {
      "로또 번호는 $MIN_LOTTO_NUMBER ~ $MAX_LOTTO_NUMBER 사이의 숫자만 가능합니다."
    }
  }

  companion object {
    const val MIN_LOTTO_NUMBER = 1
    const val MAX_LOTTO_NUMBER = 45
  }

  override fun equals(other: Any?): Boolean {
    if (this === other) return true
    if (javaClass != other?.javaClass) return false

    other as LottoNumber

    if (number != other.number) return false

    return true
  }

  override fun hashCode(): Int {
    return number
  }
}

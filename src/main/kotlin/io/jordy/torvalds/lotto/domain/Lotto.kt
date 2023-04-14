package io.jordy.torvalds.lotto.domain

import io.jordy.torvalds.lotto.value.Money

class Lotto(private val value: List<LottoNumber>) {

  init {
    require(value.distinct().size == VALID_SIZE) {
      "로또 번호는 ${VALID_SIZE}개만 가능합니다."
    }
  }

  val getValue: List<LottoNumber>
    get() = value.toList()

  companion object {

    @JvmStatic
    fun create(numberPicker: NumberPicker): Lotto {
      val lottoNumbers = numberPicker.pick()
        .map { LottoNumber(it) }
        .toList()
      return Lotto(lottoNumbers)
    }

    @JvmStatic
    fun getPurchasableQuantity(money: Money): Int = (money.value / LOTTO_PRICE).toInt()

    const val LOTTO_PRICE = 1000
    const val VALID_SIZE = 6
  }

}
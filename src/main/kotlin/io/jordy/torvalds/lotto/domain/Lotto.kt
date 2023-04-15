package io.jordy.torvalds.lotto.domain

class Lotto(private val value: List<LottoNumber>) {

  val getValue: List<LottoNumber>
    get() = value.toList()

  init {
    require(value.size == VALID_SIZE) {
      "로또 번호는 ${VALID_SIZE}개만 가능합니다."
    }
    require(value.distinct().size == VALID_SIZE) {
      "로또 번호가 중복됩니다."
    }
  }

  fun verify(winningLotto: Lotto): Rank {
    val matchCount = value.filter { winningLotto.value.contains(it) }.size
    return Rank.valueOf(matchCount)
  }

  companion object {
    fun create(numberPicker: NumberPicker): Lotto {
      val lottoNumbers = numberPicker.pick()
        .map { LottoNumber(it) }
        .toList()
      return Lotto(lottoNumbers)
    }

    fun getPurchasableQuantity(money: Money): Int = (money.value / LOTTO_PRICE).toInt()

    const val LOTTO_PRICE = 1000
    const val VALID_SIZE = 6
  }
}

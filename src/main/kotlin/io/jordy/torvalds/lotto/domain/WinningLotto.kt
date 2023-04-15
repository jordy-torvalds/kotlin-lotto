package io.jordy.torvalds.lotto.domain

class WinningLotto(val value: List<LottoNumber>) {

  init {
    require(value.size == VALID_SIZE) {
      "로또 번호는 ${VALID_SIZE}개만 가능합니다."
    }
    require(value.distinct().size == VALID_SIZE) {
      "로또 번호가 중복됩니다."
    }
  }

  fun verify(winningLotto: WinningLotto): Rank {
    val matchCount = value.filter { winningLotto.value.contains(it) }.size
    return Rank.valueOf(matchCount)
  }

  companion object {
    fun create(numberPicker: NumberPicker): WinningLotto {
      val lottoNumbers = numberPicker.pick()
        .map { LottoNumber(it) }
        .toList()
      return WinningLotto(lottoNumbers)
    }

    fun getPurchasableQuantity(money: Money): Int = (money.value / LOTTO_PRICE).toInt()

    const val LOTTO_PRICE = 1000
    const val VALID_SIZE = 6
  }
}

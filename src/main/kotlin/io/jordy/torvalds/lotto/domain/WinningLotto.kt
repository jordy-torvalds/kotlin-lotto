package io.jordy.torvalds.lotto.domain

import io.jordy.torvalds.lotto.domain.Lotto.Companion.VALID_SIZE

class WinningLotto(val value: List<LottoNumber>) {
  init {
    require(value.size == VALID_SIZE) {
      "로또 번호는 ${VALID_SIZE}개만 가능합니다."
    }
    require(value.distinct().size == VALID_SIZE) {
      "로또 번호가 중복됩니다."
    }
  }

  fun verify(lotto: Lotto): Rank {
    val matchCount = value.filter { lotto.contains(it) }.size
    return Rank.valueOf(matchCount)
  }

  companion object {
    fun create(winningLottoNumbers: List<Int>): WinningLotto {
      val parsedLottoNumbers = winningLottoNumbers.map { LottoNumber(it) }
      return WinningLotto(parsedLottoNumbers)
    }
  }
}

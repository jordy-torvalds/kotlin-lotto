package io.jordy.torvalds.lotto.domain

import io.jordy.torvalds.lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import io.jordy.torvalds.lotto.domain.LottoNumber.Companion.MIN_LOTTO_NUMBER

class RandomNumberPicker : NumberPicker {

  override fun pick(): List<Int> {
    return retrieveRandomNumbers()
  }

  companion object {

    fun retrieveRandomNumbers(): List<Int> {
      return (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).shuffled().take(Lotto.VALID_SIZE)
    }
  }
}

package io.jordy.torvalds.lotto.util

import io.jordy.torvalds.lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER

class RandomNumberUtil {

  companion object {
    fun generateRandomNumber(): Int {
      return (Math.random() * MAX_LOTTO_NUMBER + 1).toInt()
    }
  }
}

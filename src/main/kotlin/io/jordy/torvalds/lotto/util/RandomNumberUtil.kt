package io.jordy.torvalds.lotto.util

class RandomNumberUtil {

  companion object {
    @JvmStatic
    fun generateRandomNumber(): Int {
      return (Math.random() * 45 + 1).toInt()
    }
  }

}
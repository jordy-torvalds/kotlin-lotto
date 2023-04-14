package io.jordy.torvalds.lotto.domain

class RandomNumberPicker : NumberPicker {

  override fun pick(): List<Int> {
    return retrieveRandomNumbers()
  }

  companion object {
    @JvmStatic
    fun retrieveRandomNumbers(): List<Int> {
      return (1..45).shuffled().take(Lotto.VALID_SIZE)
    }
  }

}
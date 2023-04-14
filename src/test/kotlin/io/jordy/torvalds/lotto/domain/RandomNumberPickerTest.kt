package io.jordy.torvalds.lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.RepeatedTest

internal class RandomNumberPickerTest {

  @RepeatedTest(100)
  fun pick() {
    val randomNumberPicker = RandomNumberPicker()

    val result = randomNumberPicker.pick()

    assertEquals(Lotto.VALID_SIZE, result.distinct().size)
    println(result)
  }

}

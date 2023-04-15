package io.jordy.torvalds.lotto.util

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.RepeatedTest

internal class RandomNumberUtilTest {

  @RepeatedTest(100)
  fun generateRandomNumber() {
    val randomNumber = RandomNumberUtil.generateRandomNumber()
    assertTrue(randomNumber in 1..45)
  }
}

package io.jordy.torvalds.lotto.domain

import io.jordy.torvalds.lotto.fixture.domain.MockNumberPickerFixture
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MockNumberPickerTest {

  @Test
  fun pick() {
    val givenNumbers = MockNumberPickerFixture.mockNumbers
    val mockNumberPicker = MockNumberPickerFixture.create()

    repeat(givenNumbers.size) {
      assertEquals(givenNumbers[it], mockNumberPicker.pick())
    }

  }

}
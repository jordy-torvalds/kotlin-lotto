package io.jordy.torvalds.lotto.fixture.domain

import io.jordy.torvalds.lotto.domain.MockNumberPicker
import io.jordy.torvalds.lotto.domain.NumberPicker
import io.jordy.torvalds.lotto.domain.RandomNumberPicker.Companion.retrieveRandomNumbers

object MockNumberPickerFixture {

  val mockNumbers = listOf(
    retrieveRandomNumbers(),
    retrieveRandomNumbers(),
    retrieveRandomNumbers(),
    retrieveRandomNumbers(),
  )

  fun create(numbers: List<List<Int>> = mockNumbers): NumberPicker {
    return MockNumberPicker(numbers)
  }
}

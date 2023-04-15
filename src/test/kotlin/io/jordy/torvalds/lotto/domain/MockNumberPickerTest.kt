package io.jordy.torvalds.lotto.domain

import io.jordy.torvalds.lotto.fixture.domain.MockNumberPickerFixture
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class MockNumberPickerTest {

  @Test
  fun `모킹한 값과 동일한 결과가 반환되어야 한다`() {
    val givenNumbers = MockNumberPickerFixture.mockNumbers
    val mockNumberPicker = MockNumberPickerFixture.create()

    repeat(givenNumbers.size) {
      assertEquals(givenNumbers[it], mockNumberPicker.pick())
    }
  }

  @MethodSource("모킹 번호 선택기는 6개의 숫자를 반환해야 한다")
  @ParameterizedTest
  fun `모킹 번호 선택기는 6개의 숫자를 반환해야 한다`(givenNumbers: List<Int>) {
    assertThrows<IllegalArgumentException> {
      MockNumberPicker.create(givenNumbers)
    }
  }

  companion object {
    @JvmStatic
    fun `모킹 번호 선택기는 6개의 숫자를 반환해야 한다`(): Stream<List<Int>> {
      return Stream.of(
        listOf(1, 2, 3, 4, 5),
        listOf(1, 2, 3, 4, 5, 6, 7),
      )
    }
  }
}

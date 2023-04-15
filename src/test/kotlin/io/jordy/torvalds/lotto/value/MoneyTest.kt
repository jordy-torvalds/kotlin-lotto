package io.jordy.torvalds.lotto.value

import io.jordy.torvalds.lotto.domain.Money
import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class MoneyTest {

  @ValueSource(longs = [-1000, -1])
  @ParameterizedTest
  fun `금액이 0원 미만일 수 없습니다`(givenValue: Long) {
    assertThrows(IllegalArgumentException::class.java) {
      Money(givenValue)
    }
  }

  @ValueSource(longs = [0, 1, 1000])
  @ParameterizedTest
  fun `금액은 0원 이상이여야 합니다`(givenValue: Long) {
    assertDoesNotThrow {
      Money(givenValue)
    }
  }
}

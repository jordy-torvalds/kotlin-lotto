package io.jordy.torvalds.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class LottoTest {
  @Test
  fun `번호 추첨기를 통해 로또를 만든다`() {
    val lotto = Lotto.create(RandomNumberPicker())

    assertEquals(Lotto.VALID_SIZE, lotto.value.size)
  }

  @MethodSource("선택된 번호가 6개가 이어야 한다")
  @ParameterizedTest
  fun `선택된 번호가 6개가 이어야 한다`(lottoNumbers: List<LottoNumber>) {
    assertThrows<IllegalArgumentException> {
      Lotto(lottoNumbers)
    }
  }

  @MethodSource("구매 가능한 로또 게임 수를 확인한다")
  @ParameterizedTest
  fun `구매 가능한 로또 게임 수를 확인한다`(givenMoney: Long, expectedResult: Int) {
    val result = Lotto.getPurchasableQuantity(
      Money(givenMoney),
    )

    assertEquals(expectedResult, result)
  }

  companion object {
    @JvmStatic
    fun `선택된 번호가 6개가 이어야 한다`(): Stream<List<LottoNumber>> {
      return Stream.of(
        listOf(1, 2, 3, 4, 5).map { LottoNumber(it) },
        listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) },
      )
    }

    @JvmStatic
    fun `구매 가능한 로또 게임 수를 확인한다`(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(0L, 0),
        Arguments.of(200L, 0),
        Arguments.of(1001L, 1),
        Arguments.of(2000L, 2),
        Arguments.of(2001L, 2),
        Arguments.of(5000L, 5),
        Arguments.of(12000L, 12),
      )
    }
  }
}

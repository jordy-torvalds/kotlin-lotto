package io.jordy.torvalds.lotto.domain

import io.jordy.torvalds.lotto.domain.Lotto.Companion.VALID_SIZE
import io.jordy.torvalds.lotto.domain.LottoNumber.Companion.MAX_LOTTO_NUMBER
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource

internal class LottoNumberTest {

  @MethodSource("1에서 45까지의 정수")
  @ParameterizedTest
  fun `로또 번호가 1 ~ 45 사이의 숫자인 경우 정상적으로 생성된다`(number: Int) {
    val lottoNumber = LottoNumber(number)
    assertEquals(number, lottoNumber.number)
  }

  @ParameterizedTest
  @CsvSource("0, 46")
  fun `로또 번호가 1 ~ 45 사이가 아닌 경우 예외가 발생한다`(givenNumber: Int) {
    assertThrows(IllegalArgumentException::class.java) {
      LottoNumber(givenNumber)
    }
  }

  @Test
  fun `무작위의 번호를 가진 로또를 만든다`() {
    val lotto = Lotto.create(RandomNumberPicker())

    assertEquals(VALID_SIZE, lotto.getValue.distinct().size)
  }

  companion object {
    @JvmStatic
    fun `1에서 45까지의 정수`() = IntArray(MAX_LOTTO_NUMBER) { it + 1 }
  }
}

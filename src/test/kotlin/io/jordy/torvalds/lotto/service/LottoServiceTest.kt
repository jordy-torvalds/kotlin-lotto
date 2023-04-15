package io.jordy.torvalds.lotto.service

import io.jordy.torvalds.lotto.domain.Lotto
import io.jordy.torvalds.lotto.domain.Lotto.Companion.LOTTO_PRICE
import io.jordy.torvalds.lotto.domain.Money
import io.jordy.torvalds.lotto.fixture.domain.MockNumberPickerFixture
import io.jordy.torvalds.lotto.repository.LottoRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LottoServiceTest {

  val LottoService = LottoService(LottoRepository(), MockNumberPickerFixture.create())

  @Test
  fun purchaseLotto() {
    val purchasingCount = 4
    val money = Money((LOTTO_PRICE * purchasingCount).toLong())

    val result = LottoService.purchaseLotto(money)

    assertEquals(purchasingCount, result.size)
    result.forEach { assertEquals(Lotto.VALID_SIZE, it.numbers.toSet().size) }
  }
}

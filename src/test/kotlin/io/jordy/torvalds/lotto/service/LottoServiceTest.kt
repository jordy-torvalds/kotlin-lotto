package io.jordy.torvalds.lotto.service

import io.jordy.torvalds.lotto.config.Configuration
import io.jordy.torvalds.lotto.domain.Lotto
import io.jordy.torvalds.lotto.domain.Lotto.Companion.LOTTO_PRICE
import io.jordy.torvalds.lotto.domain.Money
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LottoServiceTest {

  private val lottoService = Configuration.lottoService

  @Test
  fun purchaseLotto() {
    val purchasingCount = 4
    val money = Money((LOTTO_PRICE * purchasingCount).toLong())

    val result = lottoService.purchaseLotto(money)

    assertEquals(purchasingCount, result.size)
    result.forEach { assertEquals(Lotto.VALID_SIZE, it.numbers.toSet().size) }
  }
}

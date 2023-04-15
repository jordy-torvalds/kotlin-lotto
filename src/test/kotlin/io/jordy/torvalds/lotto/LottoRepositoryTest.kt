package io.jordy.torvalds.lotto

import io.jordy.torvalds.lotto.domain.Lotto
import io.jordy.torvalds.lotto.domain.LottoNumber
import io.jordy.torvalds.lotto.domain.RandomNumberPicker
import io.jordy.torvalds.lotto.repository.LottoRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LottoRepositoryTest {

  @Test
  fun saveAll() {
    val lottos = mutableListOf<Lotto>()
    (1..5).forEach { _ ->
      val lottoNumbers = RandomNumberPicker().pick().map { LottoNumber(it) }.toList()
      lottos += Lotto(lottoNumbers)
    }

    val lottoRepository = LottoRepository()
    lottoRepository.saveAll(lottos)

    assertEquals(5, lottos.size)
    assertEquals(lottos, lottoRepository.get())
  }
}

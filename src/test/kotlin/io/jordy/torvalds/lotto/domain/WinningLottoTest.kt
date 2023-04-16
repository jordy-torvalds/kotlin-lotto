package io.jordy.torvalds.lotto.domain

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class WinningLottoTest {
  @MethodSource("로또를 당첨 여부를 확인한다")
  @ParameterizedTest
  fun `로또를 당첨 여부를 확인한다`(winningLottoNumbers: List<LottoNumber>, expectedRank: Rank) {
    val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
    val lotto = Lotto(lottoNumbers)
    val winningLotto = WinningLotto(winningLottoNumbers)

    val actualRank = winningLotto.verify(lotto)

    assertEquals(expectedRank, actualRank)
  }

  companion object {
    @JvmStatic
    fun `로또를 당첨 여부를 확인한다`(): Stream<Arguments> {
      return Stream.of(
        Arguments.of(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }, Rank.FIRST),
        Arguments.of(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }, Rank.SECOND),
        Arguments.of(listOf(1, 2, 3, 4, 7, 8).map { LottoNumber(it) }, Rank.THIRD),
        Arguments.of(listOf(1, 2, 3, 7, 8, 9).map { LottoNumber(it) }, Rank.FOURTH),
        Arguments.of(listOf(1, 2, 7, 8, 9, 10).map { LottoNumber(it) }, Rank.MISS),
        Arguments.of(listOf(1, 7, 8, 9, 10, 11).map { LottoNumber(it) }, Rank.MISS),
        Arguments.of(listOf(7, 8, 9, 10, 11, 12).map { LottoNumber(it) }, Rank.MISS),
      )
    }
  }
}

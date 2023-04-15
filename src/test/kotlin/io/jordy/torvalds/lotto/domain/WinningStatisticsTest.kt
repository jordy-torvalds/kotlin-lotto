package io.jordy.torvalds.lotto.domain

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

internal class WinningStatisticsTest {

  @MethodSource("당첨 결과를 통해 당첨 통계를 만든다")
  @ParameterizedTest
  fun `당첨 결과를 통해 당첨 통계를 만든다`(ranks: List<Rank>, expected: Map<Rank, Int>) {
    val result = WinningStatistics(ranks)
    val resultByRank = result.resultByRank

    Rank.valuesExcludeMiss().forEach {
      assertEquals(expected.getOrDefault(it, 0), resultByRank[it.name]?.count)
      assertEquals(it.matchCount, resultByRank[it.name]?.matchCount)
      assertEquals(it.winningPrize, resultByRank[it.name]?.winningPrize)
    }
  }

  companion object {
    @JvmStatic
    fun `당첨 결과를 통해 당첨 통계를 만든다`() = Stream.of(
      Arguments.of(
        listOf(
          Rank.FIRST,
          Rank.FIRST,
          Rank.SECOND,
          Rank.THIRD,
          Rank.FOURTH,
        ),
        mapOf(
          Rank.FIRST to 2,
          Rank.SECOND to 1,
          Rank.THIRD to 1,
          Rank.FOURTH to 1,
        ),
      ),
      Arguments.of(
        listOf(
          Rank.FIRST,
          Rank.SECOND,
          Rank.THIRD,
          Rank.FOURTH,
        ),
        mapOf(
          Rank.FIRST to 1,
          Rank.SECOND to 1,
          Rank.THIRD to 1,
          Rank.FOURTH to 1,
        ),
      ),
      Arguments.of(
        listOf(
          Rank.FIRST,
          Rank.SECOND,
          Rank.THIRD,
        ),
        mapOf(
          Rank.FIRST to 1,
          Rank.SECOND to 1,
          Rank.THIRD to 1,
        ),
      ),
      Arguments.of(
        listOf(
          Rank.FIRST,
          Rank.SECOND,
        ),
        mapOf(
          Rank.FIRST to 1,
          Rank.SECOND to 1,
        ),
      ),
      Arguments.of(
        emptyList<Rank>(),
        emptyMap<Rank, Int>(),
      ),
    )
  }
}

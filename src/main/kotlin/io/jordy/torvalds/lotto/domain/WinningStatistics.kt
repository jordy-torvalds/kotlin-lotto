package io.jordy.torvalds.lotto.domain

class WinningStatistics(val resultByRank: Map<String, WinningStatistic>) {
  constructor(ranks: List<Rank>) : this(aggregateRanks(ranks))

  companion object {
    private fun aggregateRanks(ranks: List<Rank>): Map<String, WinningStatistic> {
      val result = ranks.groupBy({ it.name }, { it })
        .mapValues {
          WinningStatistic(it.value.size, it.value.first().matchCount, it.value.first().winningPrize)
        }.toMutableMap()

      Rank.valuesExcludeMiss().filter { !ranks.contains(it) }
        .forEach {
          result[it.name] = WinningStatistic(0, it.matchCount, it.winningPrize)
        }

      return result
    }
  }
}

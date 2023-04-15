package io.jordy.torvalds.lotto.domain

class WinningStatistics(ranks: List<Rank>) {
  val resultByRank: Map<String, WinningStatistic>

  init {
    this.resultByRank = aggregateRanks(ranks)
  }

  private fun aggregateRanks(ranks: List<Rank>): MutableMap<String, WinningStatistic> {
    val result = ranks.groupBy({ it.name }, { it })
      .mapValues {
        WinningStatistic(it.value.size, it.value.first().matchCount, it.value.first().winningPrize)
      }
      .toMutableMap()
    addMissingRank(result)
    return result
  }

  private fun addMissingRank(result: MutableMap<String, WinningStatistic>) {
    Rank.valuesExcludeMiss().forEach {
      if (!result.containsKey(it.name)) {
        result[it.name] = WinningStatistic(0, it.matchCount, it.winningPrize)
      }
    }
  }
}

package io.jordy.torvalds.lotto.domain

class WinningStatistics(ranks: List<Rank>) {
  val resultByRank: Map<String, WinningStatistic>

  // construct 별도 선언및 컴패니언 추출
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
    // 외부에서 변활르 일으켜 사이드 이펙트를 일으키는 건 별로
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

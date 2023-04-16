package io.jordy.torvalds.lotto.service.dto

import io.jordy.torvalds.lotto.domain.WinningStatistics

class WinningStatisticsDto(val resultByRank: Map<String, WinningStatisticDto>) {
  companion object {
    fun of(winningStatistics: WinningStatistics): WinningStatisticsDto {
      val resultByRank = winningStatistics.resultByRank
        .entries.groupBy({ it.key }, { it.value })
        .mapValues {
          WinningStatisticDto(it.value.first().count, it.value.first().matchCount, it.value.first().winningPrize)
        }
      return WinningStatisticsDto(resultByRank)
    }
  }
}

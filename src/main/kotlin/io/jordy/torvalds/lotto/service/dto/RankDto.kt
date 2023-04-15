package io.jordy.torvalds.lotto.service.dto

import io.jordy.torvalds.lotto.domain.Rank

class RankDto(rank: Rank) {
  val name: String = rank.name
  val matchCount: Int = rank.matchCount
  val winningPrize: Int = rank.winningPrize

  fun toRank(): Rank {
    return Rank.valueOf(name)
  }
}

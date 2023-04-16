package io.jordy.torvalds.lotto.service.dto

import io.jordy.torvalds.lotto.domain.Rank

class RankDto(val name: String, val matchCount: Int, val winningPrize: Int) {
  constructor(rank: Rank) : this(rank.name, rank.matchCount, rank.winningPrize)

  fun toRank(): Rank {
    return Rank.valueOf(name)
  }
}

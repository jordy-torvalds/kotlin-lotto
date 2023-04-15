package io.jordy.torvalds.lotto.domain

enum class Rank(val matchCount: Int, val winningPrize: Int) {
  FIRST(6, 2_000_000_000),
  SECOND(5, 30_000_000),
  THIRD(4, 1_500_000),
  FOURTH(3, 50_000),
  MISS(0, 0),
  ;

  fun isMatch(matchCount: Int): Boolean {
    return this.matchCount == matchCount
  }

  companion object {
    fun valueOf(matchCount: Int): Rank {
      return values().firstOrNull { it.isMatch(matchCount) } ?: MISS
    }

    fun valuesExcludeMiss(): List<Rank> {
      return values().filter { it != MISS }
    }
  }
}

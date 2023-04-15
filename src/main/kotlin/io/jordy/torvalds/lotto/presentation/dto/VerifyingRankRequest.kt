package io.jordy.torvalds.lotto.presentation.dto

import io.jordy.torvalds.lotto.domain.Lotto
import io.jordy.torvalds.lotto.domain.LottoNumber

data class VerifyingRankRequest(val winningNumbers: List<Int>) {

  init {
    require(winningNumbers.size == 6) { "당첨 번호는 6개여야 합니다." }
    require(winningNumbers.distinct().size == 6) { "당첨 번호는 중복되지 않아야 합니다." }
  }

  fun toLotto() = Lotto(winningNumbers.map { LottoNumber(it) })
}

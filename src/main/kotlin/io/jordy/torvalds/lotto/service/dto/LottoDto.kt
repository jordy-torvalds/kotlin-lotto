package io.jordy.torvalds.lotto.service.dto

import io.jordy.torvalds.lotto.domain.Lotto

data class LottoDto(val value: List<Int>) {
  constructor(lotto: Lotto) : this(lotto.value.map { it.number })
}

package io.jordy.torvalds.lotto.service.dto

import io.jordy.torvalds.lotto.domain.Lotto

data class LottoDto(private val lotto: Lotto) {

  val numbers = lotto.value.map { it.number }.toList()
}

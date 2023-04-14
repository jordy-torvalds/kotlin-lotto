package io.jordy.torvalds.lotto.dto

import io.jordy.torvalds.lotto.domain.Lotto

data class LottoDto(private val lotto: Lotto) {

  val numbers = lotto.getValue.map {it.number}.toList()

}

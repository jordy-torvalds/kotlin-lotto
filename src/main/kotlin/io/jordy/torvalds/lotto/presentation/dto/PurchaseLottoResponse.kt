package io.jordy.torvalds.lotto.presentation.dto

import io.jordy.torvalds.lotto.dto.LottoDto

data class PurchaseLottoResponse(private val lottoDtos: List<LottoDto>) {
  val value = lottoDtos.map { it -> it.numbers }.toList()
}

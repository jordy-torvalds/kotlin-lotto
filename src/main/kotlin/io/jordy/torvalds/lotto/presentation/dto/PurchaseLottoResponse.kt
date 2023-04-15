package io.jordy.torvalds.lotto.presentation.dto

import io.jordy.torvalds.lotto.service.dto.LottoDto

data class PurchaseLottoResponse(private val lottoDtos: List<LottoDto>) {
  val value = lottoDtos.map { it.numbers }.toList()
}

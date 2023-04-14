package io.jordy.torvalds.lotto.config

import io.jordy.torvalds.lotto.domain.RandomNumberPicker
import io.jordy.torvalds.lotto.presentation.LottoController
import io.jordy.torvalds.lotto.service.LottoService

object Configuration {
  private val numberPicker = RandomNumberPicker()
  private val lottoService = LottoService(numberPicker)

  val lottoController = LottoController(lottoService)
}

package io.jordy.torvalds.lotto.config

import io.jordy.torvalds.lotto.domain.LottoRepository
import io.jordy.torvalds.lotto.domain.RandomNumberPicker
import io.jordy.torvalds.lotto.presentation.LottoController
import io.jordy.torvalds.lotto.service.LottoService

object Configuration {

  private val lottoRepository = LottoRepository()
  private val numberPicker = RandomNumberPicker()
  val lottoService = LottoService(lottoRepository, numberPicker)

  val lottoController = LottoController(lottoService)
}

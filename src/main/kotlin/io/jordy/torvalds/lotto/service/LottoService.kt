package io.jordy.torvalds.lotto.service

import io.jordy.torvalds.lotto.domain.Lotto
import io.jordy.torvalds.lotto.domain.Money
import io.jordy.torvalds.lotto.domain.NumberPicker
import io.jordy.torvalds.lotto.domain.WinningStatistics
import io.jordy.torvalds.lotto.repository.LottoRepository
import io.jordy.torvalds.lotto.service.dto.LottoDto
import io.jordy.torvalds.lotto.service.dto.RankDto
import io.jordy.torvalds.lotto.service.dto.WinningStatisticsDto
import java.math.BigDecimal
import java.math.RoundingMode

class LottoService(
  private val lottoRepository: LottoRepository,
  private val numberPicker: NumberPicker,
) {

  fun purchaseLotto(money: Money): List<LottoDto> {
    val result = mutableListOf<Lotto>()
    repeat(Lotto.getPurchasableQuantity(money)) {
      val lotto = Lotto.create(numberPicker)
      result.add(lotto)
    }

    lottoRepository.saveAll(result)

    return result.map { LottoDto(it) }.toList()
  }

  fun verifyTheWinningLotto(winningLotto: Lotto): List<RankDto> {
    val ranks = lottoRepository.get().map { it.verify(winningLotto) }
    return ranks.map { RankDto(it) }.toList()
  }

  fun createWinningStatistics(ranks: List<RankDto>): WinningStatisticsDto {
    val purchasedCount = lottoRepository.get().size
    val winningStatistic = WinningStatistics(ranks.map { it.toRank() })
    return WinningStatisticsDto.of(winningStatistic)
  }

  fun calculateEarningRate(winningStatistics: WinningStatisticsDto): BigDecimal {
    val totalPrize = winningStatistics.resultByRank.values.sumOf { it.winningPrize * it.count }.toBigDecimal()
    val totalPurchaseAmount = lottoRepository.get().size * Lotto.LOTTO_PRICE
    return totalPrize.divide(BigDecimal(totalPurchaseAmount), 2, RoundingMode.HALF_UP)
  }
}

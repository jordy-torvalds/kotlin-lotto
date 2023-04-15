package io.jordy.torvalds.lotto.presentation.dto

import io.jordy.torvalds.lotto.service.dto.WinningStatisticsDto
import java.math.BigDecimal

data class VerifyingRankResponse(val winningStatisticsDto: WinningStatisticsDto, val earningRate: BigDecimal)

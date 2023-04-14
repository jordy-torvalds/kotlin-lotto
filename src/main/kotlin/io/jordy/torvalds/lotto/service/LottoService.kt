package io.jordy.torvalds.lotto.service

import io.jordy.torvalds.lotto.domain.Lotto
import io.jordy.torvalds.lotto.domain.NumberPicker
import io.jordy.torvalds.lotto.dto.LottoDto
import io.jordy.torvalds.lotto.value.Money

class LottoService(private val numberPicker: NumberPicker) {

  fun purchaseLotto(money: Money): List<LottoDto> {
    val lottos = mutableListOf<Lotto>()
    repeat (Lotto.getPurchasableQuantity(money)) {
      val lotto = Lotto.create(numberPicker)
      lottos.add(lotto)
    }
    return lottos.map { LottoDto(it)}.toList()
  }

}

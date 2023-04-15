package io.jordy.torvalds.lotto.domain

class LottoRepository(private var lottos: List<Lotto>) {

  constructor() : this(emptyList())

  fun saveAll(lottos: List<Lotto>) {
    this.lottos += lottos
  }

  fun get(): List<Lotto> = this.lottos
}

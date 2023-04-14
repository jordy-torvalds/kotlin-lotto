package io.jordy.torvalds.lotto.domain

import io.jordy.torvalds.lotto.domain.Lotto.Companion.VALID_SIZE

class MockNumberPicker(private val numbers: List<List<Int>>) : NumberPicker {

  init {
    numbers.forEach {
      require(it.size == VALID_SIZE) {
        "번호 선택기는 $VALID_SIZE 개의 숫자를 반환해야 합니다"
      }
    }
  }

  private var index = 0

  override fun pick(): List<Int> {
    return numbers[index++]
  }
}

package io.jordy.torvalds.lotto.domain

import io.jordy.torvalds.lotto.domain.Lotto.Companion.VALID_SIZE

// 테스트로 옮기기
class MockNumberPicker(private val numbers: List<List<Int>>) : NumberPicker {

  private var index = 0

  init {
    numbers.forEach {
      require(it.size == VALID_SIZE) {
        "번호 선택기는 $VALID_SIZE 개의 숫자를 반환해야 합니다"
      }
    }
  }

  override fun pick(): List<Int> {
    return numbers[index++]
  }

  companion object {
    fun create(numbers: List<Int>): MockNumberPicker {
      return MockNumberPicker(listOf(numbers.toList()))
    }
  }
}

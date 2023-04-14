package io.jordy.torvalds.lotto.domain

interface NumberPicker {
  fun pick(): List<Int>
}
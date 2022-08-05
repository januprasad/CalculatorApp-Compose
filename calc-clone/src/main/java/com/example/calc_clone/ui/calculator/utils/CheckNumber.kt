package com.example.calc_clone.ui.calculator.utils

fun isNumber(s: String): Boolean {
    return if (s.isEmpty()) false else s.all { Character.isDigit(it) || s == "." }
}
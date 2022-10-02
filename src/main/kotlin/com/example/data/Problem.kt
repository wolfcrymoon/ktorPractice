package com.example.data

data class Problem(
    val id: String,
    val title: String,
    val description: String,
    val testCases: List<TestCase>
)

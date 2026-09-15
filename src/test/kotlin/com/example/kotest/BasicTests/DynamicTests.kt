package com.example.kotest.BasicTests

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength

class DynamicTests: FunSpec({
    
    listOf(
        "sam",
        "bob",
        "tim"
    ).forEach {
        test("$it should be a three letter name") {
            it.shouldHaveLength(3)
        }
    }
    
})
package com.example.kotest.BasicTests

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class FirstTests: FunSpec({
    test("first test") {
        1 + 2 shouldBe 3
    }
})
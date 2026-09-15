package com.example.kotest.TestingStyles

import io.kotest.core.spec.style.ShouldSpec
import io.kotest.matchers.string.shouldHaveLength
import io.kotest.matchers.shouldBe


class ShouldSpecTests: ShouldSpec ({
    
    should("return the length of a string") {
        "bob".length shouldBe 3
        "".length shouldBe 0
    }
    
    // with context
    
    context("String.length") {
        should("return the length of a string") {
            "bobby".length shouldBe 5
            "".length shouldBe 0
        }
    }
    
    context("enabled outer block") {
        xshould("disabled test") {
            "".length shouldBe 0
        }
    }
    
    xcontext("disabled outer block") {
        should("also disabled test") {
            "".length shouldBe 0
        }
    }
})
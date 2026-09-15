package com.example.kotest.TestingStyles

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength
import io.kotest.matchers.shouldBe

class FunSpecTest: FunSpec ({
    
    //enabled, disabled tests
    
    context("enabled") {
        test("test is enabled") {
            1 + 2 shouldBe 3
        }
    }
    
    context("enabled") {
        xtest("test is disabled") {
            3 + 2 shouldBe 5
        }
    }
    
    xcontext("enabled") {
        test("also disabled") {
            3 + 3 shouldBe 6
        }
    }
        
})




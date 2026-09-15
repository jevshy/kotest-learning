package com.example.kotest.TestingStyles

import io.kotest.core.spec.style.ExpectSpec
import io.kotest.matchers.shouldBe
import io.kotest.assertions.throwables.shouldThrow

class ExpectSpecTests : ExpectSpec ({
    
    context("calculator") {
        expect("simple addition") {
            1 + 1 shouldBe 2
        }
        
        expect("simple division") {
            4 / 2 shouldBe 2
        }
        
        expect("wrong division") {
            shouldThrow<ArithmeticException> {
                1 / 0
            }
        }
    }
})

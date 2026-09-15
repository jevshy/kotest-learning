package com.example.kotest.CustomSpecs

import io.kotest.matchers.shouldBe

class TransferTests : TestSuiteSpec() {
    init {
        
        var balance = 100
        
        test("Balance equals 100") {
            balance shouldBe 100
        }
        
        suite("Withdraw money") {
            test("Withdraw 90") {
                balance -= 90
                balance shouldBe 10
            }
            
            test("withdraw 10") {
                balance -= 10
                balance shouldBe 0
            }
            
        }
        
        suite("deposit money") {
            test("deposit 10") {
                balance += 10
                balance shouldBe 10
            }
            
            test("deposit 200") {
                balance += 200
                balance shouldBe 210
            }
        }
    }
}
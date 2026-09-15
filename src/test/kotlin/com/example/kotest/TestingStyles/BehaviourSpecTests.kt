package com.example.kotest.TestingStyles

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class BehaviourSpecTests: BehaviorSpec ({
    given("an account with balance of 100") {
        var balance = 100
        
        `when`("I withdraw 30") {
            balance -= 30
            
            then("new balance equals 70") {
                balance shouldBe 70
            }
        }
        
        `when`("I deposit 40") {
            
            balance += 40 
            
            then("new balance equals 110") {
                balance shouldBe 110
            }
        }
    }
    
    given("2 accounts, one with balance 50, other with balance 100") {
        var balance = 50
        var otherBalance = 100
        
        `when`("I withdraw 30") {
            balance -= 30
            
            and("I deposit 30 to otherBalance") {
                otherBalance += 30
            }
            
                then("new balance equals 20 and otherBalance equals 130") {
                    balance shouldBe 20
                    otherBalance shouldBe 130
                }
        }
    }
})


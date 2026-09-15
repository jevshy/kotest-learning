package com.example.kotest.TestingStyles

import io.kotest.core.spec.style.FeatureSpec
import io.kotest.matchers.shouldBe

class FeatureSpecTests: FeatureSpec ({
    
    feature("String length") {
        scenario("a string has the correct length") {
            "bob".length shouldBe 3
        }
    }
    
    feature("account withdraw work") {
        var balance = 100
        
        scenario("I withdraw 10") {
            balance -= 10
            
            balance shouldBe 90
        }
        
        scenario("I withdraw 40") {
            balance -= 40
            
            balance shouldBe 50
        }
        
    }
    
})
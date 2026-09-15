package com.example.kotest.BasicTests

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.string.shouldHaveLength

class CallBacks: FunSpec ({
    
    beforeEach {
        println("Hi from $it")
    }
    
    test("bob should have a three letter name") {
        "bob".shouldHaveLength(3)
    }
    
    afterEach {
        println("Goodbye form $it")
    }
    
})
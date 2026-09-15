package com.example.kotest.BasicTests

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class NestedTests: DescribeSpec({
    
    describe("an outer test") {
        it("an inner test") {
            1 + 2 shouldBe 3
        }
        
        it("another inner test") {
            3 + 4 shouldBe 7
        }
    }
})

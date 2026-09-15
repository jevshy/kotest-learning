package com.example.kotest.TestingStyles

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class FreeSpecTests : FreeSpec ({
    
    "String.length" - {
        "should return length of a string" {
            "bob".length shouldBe 3
        }
    }
    
    "1st nested container" - {
        "2nd" - {
            "3rd" - {
                "4th" - {
                    "final container (i can go as deep as needed)" {
                        1 + 2 shouldBe 3
                    }
                }
            }
        }
    }
    
})
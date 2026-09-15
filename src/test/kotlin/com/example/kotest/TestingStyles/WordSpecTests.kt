package com.example.kotest.TestingStyles

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe

class WordSpecTests: WordSpec ({
    
    "Hello" `when` {
        "asked for length" should {
            "return 5" {
                "Hello".length shouldBe 5
            }
        }

        "appended to bob" should{
            "return Hello bob" {
                "Hello " + "bob" shouldBe "Hello bob" 
            }
        }
    }
}) 
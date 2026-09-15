package com.example.kotest.TestingStyles

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe


class DescribeSpecTests: DescribeSpec ({
   
    var score = 0 
    
    beforeSpec {
        score = 0
    }
    
    context("scorers") {
        describe("score") {
            it("starts as zero"){
                score shouldBe 0
            }
        }
        
        describe("with a strike") {
            it("adds ten") {
                score += 10
            }
            
            it("checks score equals 10") {
                score shouldBe 10
            }
        }
    }
    
    context("big scorers") {
        describe("for the opposite team") {
            it("should negate one score") {
                score -= 1
            }
            it("check new score equals 9") {
                score shouldBe 9
            }
        }
    }
    
})
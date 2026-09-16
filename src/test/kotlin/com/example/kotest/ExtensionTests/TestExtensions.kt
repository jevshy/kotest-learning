package com.example.kotest.ExtensionTests

import com.example.kotest.ExtensionTests.Extensions.*
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe


class TestExtensions: FunSpec({
    extension(ContainerTracer)
    extension(EachTracer)
    extension(TestTracer)
    extension(SpecClassTracer)
    extension(SpecInstanceTracer)
    extension(InvocationTracer)
    
    
    
    context("container block") {
        test("leaf test inside container") {
            2 + 2 shouldBe 4
        }

        test("leaf test with invocations").config(invocations = 3) {
            1 + 1 shouldBe 2
        }
    }
    
    
    test("top level leaf test with no container") {
        "hello".length shouldBe 5
    }
})
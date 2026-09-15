package com.example.kotest.CustomSpecs

import io.kotest.core.names.TestNameBuilder
import io.kotest.core.spec.AbstractSpec
import io.kotest.core.spec.TestDefinitionBuilder
import io.kotest.core.spec.style.TestRunnable
import io.kotest.core.test.TestScope
import io.kotest.core.test.TestType

/*
 * @TestRunnable: Defines that calls to suite() or test() are test entry points
 *      -> First parameter of any @TestRunnable must be a String -> It's used as the test name
 */



abstract class TestSuiteSpec : AbstractSpec() {
    
    @TestRunnable
    fun suite(name: String, test: suspend TestSuiteScope.() -> Unit) {
        add(
            TestDefinitionBuilder
                .builder(TestNameBuilder.builder(name).build(), TestType.Container)
                .build { TestSuiteScope(this).test() }
        )
    }
    
    @TestRunnable
    fun test(name: String, test: suspend TestScope.() -> Unit) {
        add(
            TestDefinitionBuilder
                .builder(TestNameBuilder.builder(name).build(), TestType.Test)
                .build(test)
        )
    }
}
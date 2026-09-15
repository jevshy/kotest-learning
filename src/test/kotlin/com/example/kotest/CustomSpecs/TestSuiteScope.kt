package com.example.kotest.CustomSpecs

import io.kotest.core.names.TestNameBuilder
import io.kotest.core.spec.TestDefinitionBuilder
import io.kotest.core.spec.style.TestRunnable
import io.kotest.core.test.AbstractTestScope
import io.kotest.core.test.TestScope
import io.kotest.core.test.TestType


class TestSuiteScope(delegate: TestScope) : AbstractTestScope(delegate) {
    
    @TestRunnable
    suspend fun suite(name: String, test: suspend TestSuiteScope.() -> Unit) {
        registerTest(
            TestDefinitionBuilder
                .builder(TestNameBuilder.builder(name).build(), TestType.Container)
                .build { TestSuiteScope(this).test() }
        )
    }
    
    @TestRunnable
    suspend fun test(name: String, test: suspend TestScope.() -> Unit) {
        registerTest(
            TestDefinitionBuilder
                .builder(TestNameBuilder.builder(name).build(), TestType.Test)
                .build(test)
        )
    }
}


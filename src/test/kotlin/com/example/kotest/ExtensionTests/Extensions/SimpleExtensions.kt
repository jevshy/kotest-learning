package com.example.kotest.ExtensionTests.Extensions

import io.kotest.core.listeners.AfterContainerListener
import io.kotest.core.listeners.AfterEachListener
import io.kotest.core.listeners.AfterInvocationListener
import io.kotest.core.listeners.AfterSpecListener
import io.kotest.core.listeners.AfterTestListener
import io.kotest.core.listeners.BeforeContainerListener
import io.kotest.core.listeners.BeforeEachListener
import io.kotest.core.listeners.BeforeInvocationListener
import io.kotest.core.listeners.BeforeSpecListener
import io.kotest.core.listeners.BeforeTestListener
import io.kotest.core.listeners.FinalizeSpecListener
import io.kotest.core.listeners.PrepareSpecListener
import io.kotest.core.spec.Spec
import io.kotest.core.test.TestCase
import io.kotest.engine.test.TestResult
import kotlin.reflect.KClass


// Only gets executed with containers => "context/describe" (groups other tests)
object ContainerTracer: BeforeContainerListener, AfterContainerListener {
    override suspend fun beforeContainer(testCase: TestCase) {
        println("Entering container: ${testCase.name}" )
    }
    
    override suspend fun afterContainer(testCase: TestCase, result: TestResult) {
        println("Leaving container: ${testCase.name}" )
    }
}



// Only gets executed with leaf tests => Actual tests that get executed
object EachTracer: BeforeEachListener, AfterEachListener {
    override suspend fun beforeEach(testCase: TestCase) {
        println("Leaf test starting: ${testCase.name}")
    }
    
    override suspend fun afterEach(testCase: TestCase, result: TestResult) {
        println("Leaf test finishing: ${testCase.name}")
    }
}


// gets executed with any kind of test (container/leaf)
object TestTracer : BeforeTestListener, AfterTestListener {
    override suspend fun beforeTest(testCase: TestCase) {
        println("Any test starting: ${testCase.name}")
    }
    
    override suspend fun afterTest(testCase: TestCase, result: TestResult) {
        println("Any test finishing: ${testCase.name}")
    }
}


// gets executed once per spec
object SpecInstanceTracer: BeforeSpecListener, AfterSpecListener {
    override suspend fun beforeSpec(spec: Spec) {
        println("New spec instance created: ${spec.javaClass.simpleName}")
    }
    
    override suspend fun afterSpec(spec: Spec) {
        println("Spec instance finished: ${spec.javaClass.simpleName}")
    }
}


// gets executed once per class
object SpecClassTracer: PrepareSpecListener, FinalizeSpecListener {
    override suspend fun prepareSpec(kclass: KClass<out Spec>) {
        println("Preparing class: ${kclass.simpleName}")
    }
    
    override suspend fun finalizeSpec(kclass: KClass<out Spec>, results: Map<TestCase, TestResult>) {
        println("Finilazing class: ${kclass.simpleName}, ${results.size} tests ran")
    }
}

object InvocationTracer: BeforeInvocationListener, AfterInvocationListener {
    override suspend fun beforeInvocation(testCase: TestCase, iteration: Int) {
        println("${testCase.name}, invocation #$iteration")
    }

    override suspend fun afterInvocation(testCase: TestCase, iteration: Int) {
        println("${testCase.name}, invocation #$iteration done")
    }
}












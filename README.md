# Kotest Tests with Spring Boot

## Concurrency

### Spec Concurrency Mode

Can multiple specs be executed at the same time?

Three options:

- Sequential
  - All specs are executed sequentially
- Concurrent
  - All specs are executed concurrent
- LimitedConcurrency(max: Int)
  - Executed concurrently up to a given max number

Where?

- In the project config, by changing SpecExecutionMode

### Test Concurrency Mode

Can multiple (root) tests within a spec be executed at the same time?

Three options:

- Sequential
- Concurrent
- LimitedConcurrency(max: Int)

Configuration Levels:

- Project-wide configuration
- Package-level configuration
- Spec-level configuration
  - By overriding testExecutionMode()
  - by setting ExecutionMode() property

## Data Driven Testing

### WithXXX Variants

| Test Style | withXXX Function |
| ------------ | ------------- |
| FunSpec | withContext, withTests |
| StringSpec | withData |
| DescribeSpec | with Context, withDescribes, withIts |
| ShouldSpec | withContexts, withShoulds |
| WordSpec | withWhens, withShoulds |
| BehaviorSpec | withContexts, withGivens, withWhens, withTHens, withAnds |
| FreeSpec | withContexts, withTests |
| ExpectSpec | withContexts, withExpects |
| FeatureSpec | withFeatures. withScenarios |


## Non-deterministic Testing


### Eventually

Code that will eventually become true or pass but not necessarily on the first check. 

Eventually keeps retrying until no exception is thrown.

For example:
- Check if a user got created
- How:
  - Periodically checks if the function passes
  - Stops/Fails only after certain timeout out if too many iterations have passed


### Continually

Confirm that something stays true and never turns to false. 

For example:
- Check if a http connection is kept alive for 60 seconds
- Better option instead of letting a function sleep for 60 seconds and then checking
- Will check for 60 seconds if smth stays true. If it doesnt, it will immediatly fail


### Until

Periodically executes a function until either that funciton returns true or the given duration expires.

Until keeps retrying until the predicate returns true

What we can set:
- Duration
  - until(5.seconds)
  - Here: Test that smth happens within 5 seconds
- Interval
  - until(5.seconds, 250.milliseconds.fixed())
  - Default Interval: 1 second
  - Here: Checks every 250 milliseconds if smth happens


### Retry

Instead of checking a block of code over a period of time, Retry tries a block of code a maximum number of times.

Example:
- retry(4, 10.minutes) { }
- Here: Tries 4 times but gives up early if 10 minutes pass first


## Ordering


### Spec Ordering

Default: Ordering of Specs is random


How to manipulate order:
- In projct config
- override val specExecutionOrder = ...

Options:
- Undefined
  - Default
  - Executed in the order they are discovered at runtime
- Lexicographic:
  - Ordered lexicograpgically
- Random:
  - Random order
  - Can be used with specific Random Seed
    - Random but always same order
- Annotated
  - Ordered using @Order annotation (at class level)
  - Lowest values are executed first
  - Specs without annotation are considered last
  - For example: @Order(1)
- Custom Ordering
  - Implementing SpecExecutionOrderExtension and registering it with project config
  - In this case the specExecutionOrder will be ignored



### Test Ordering

Whats the order of multiple tests in a Spec?


Options:
- Sequential Ordering
- Random Ordering
- Lexicographic Ordering


## Tags

Tags are used when you don't want to run all tests at runtime but only a specific group of tests.


Examples:
- object Group : Tag ()
- val tag = NamedTag("Group")


### Adding tags to tests

Tagging Tests:
- via config
- test("needs to run with tag group").config(tags = setOf(Group))


Tagging Specs:
- inside the class init: 
  - tags(Group)


@RequiresTag:
- Tag that only checks if a certain Tag is present and running



## Temporary Files

By using tempfile() it's possible to create temporary fiels that are automatically deleted after all tests ran in a certain Spec.


With tempdir() you can do the same thing but with temporary directories.


## Configurations:

- Invocations
  - Number of times to run a test
- Enabled
  - Checks if a test is enabled or disabled
  - If disabled, this test will be skipped
- enabledIf
  - Checks a certain condition and sets the enabled accordingly to true or false
- timeout
  - if test hasn't finished after the timeout, it will be marked as failed
- kotlin.Duration
  - timeout for tests with invocations
  - if Duration time passes but not all invocations have run, the test is marked as failed
- invocationTimeout
  - tieout for each invocation individually
- tags
  - set of tags
- listeners
  - test listeners that are registered to only this test
- extensions
  - registered extensions for only this test
- severity
  - a severity level thats applied by some extensions
- assertSoftly
  - if true, then the assertions are run in soft mode
- failfast:
  - if true, then the test engine will stop running after the first failure
- blockingTest
  - if true, then each test in a spec will be run in a dedicated thread
- retries
  - how often a test will be executed before failing
- retryDelay
  - time between retries
- coroutinDebugProbes
  - if true, coroutine debugging probes are enabled


How to use:
- test("...").config(tags = setOf(Group))
- Or with defaultTestConfig
  - defaultTestConfig = DefaultTestConfig(enabled = true, invocation = 3)
  - are applied to each test inside a class, except if overwritten by a test


It's also possible to set configurations on a project-wide level or a package-wide level. 
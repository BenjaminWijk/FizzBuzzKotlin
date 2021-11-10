/**
 * FizzBuzz rule that will be tested on each number iterated.
 * In-parameter for both functions represent integer iterated over.
 */
data class Rule(
    val output: (Int) -> String,
    val predicate: (Int) -> Boolean
)
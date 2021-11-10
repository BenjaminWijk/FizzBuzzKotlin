import java.lang.IllegalArgumentException

class FizzBuzz(val gameLength: Int = 15, useDefaultRules: Boolean = true) {

    init {
        if (gameLength < 1) throw IllegalArgumentException("gameLength must be larger than 1")
    }

    companion object {
        val defaultRules = listOf(
            Rule({ "Fizz" }, { it % 3 == 0 }),
            Rule({ "Buzz" }, { it % 5 == 0 })
        )
    }

    private val rules: MutableList<Rule> = mutableListOf<Rule>().also {
        if (useDefaultRules) it.addAll(defaultRules)
    }

    fun addRules(vararg rules: Rule) {
        this.rules.addAll(rules)
    }

    fun play() {
        for (i in 1..gameLength) {
            var lineOutput = ""
            rules.forEach {
                if (it.predicate(i)) lineOutput += it.output(i)
            }
            if (lineOutput.isEmpty()) lineOutput = i.toString()
            println(lineOutput)
        }
    }
}


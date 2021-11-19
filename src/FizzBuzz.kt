import java.lang.IllegalArgumentException

class FizzBuzz(
    val gameLength: Int = 100,
    useDefaultRules: Boolean = true
) {

    init {
        if (gameLength < 1) throw IllegalArgumentException("gameLength must be larger than 0")
    }

    companion object {
        val defaultRules = arrayOf(
            Rule({ "Fizz" }, { it % 3 == 0 }),
            Rule({ "Buzz" }, { it % 5 == 0 })
        )
    }

    private val rules: MutableList<Rule> = if(useDefaultRules)
        mutableListOf(*defaultRules)
    else
        mutableListOf()

    fun addRules(vararg rules: Rule) = this.rules.addAll(rules)

    fun play() {
        for (i in 1..gameLength) {
            var lineOutput = ""

            rules.applyEach {
                if(predicate(i)) lineOutput += output(i)
            }

            if (lineOutput.isEmpty()) lineOutput = i.toString()
            println(lineOutput)
        }
    }
}



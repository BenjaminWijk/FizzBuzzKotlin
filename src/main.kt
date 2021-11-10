fun main(){

    FizzBuzz(gameLength = 100, useDefaultRules = false).apply {
        addRules(
            Rule({"Prime"}, {PrimeChecker.check(it)})
        )
    }.play()

}
/**
 * Dear god, please don't use this for anything of proper sizes
 */
object PrimeChecker {

    private val knownPrimes = hashSetOf(2)
    private var largestResolvedValue = 2
    private var largestKnown: Int = 2

    fun check(i: Int): Boolean {
        if (knownPrimes.contains(i)) return true
        if (i <= largestResolvedValue) return false

        for(n in largestKnown until i){
            resolveNext()
        }
        return (knownPrimes.contains(i))
    }

    fun resolveNext(): Boolean{
        val next = largestResolvedValue + 1
        var newPrime = true
        if(knownPrimes.any { next % it == 0 }) {
            newPrime = false
        } else {
            knownPrimes.add(next)
            largestKnown = next
        }

        largestResolvedValue = next
        return newPrime
    }

}
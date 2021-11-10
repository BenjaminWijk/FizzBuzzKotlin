
inline fun <T> Iterable<T>.applyEach(block: T.() -> Unit){
    forEach(block)
}
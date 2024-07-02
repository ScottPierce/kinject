package kinject

fun <T> ObjectGraph.get(clazz: Class<T>): T {
    return internalGet(clazz.name)
}

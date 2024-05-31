package kinject

open class KinjectException(message: String, cause: Throwable? = null) : RuntimeException(message, cause)

class BindingNotFoundException(message: String, cause: Throwable? = null) : KinjectException(message, cause)

class CyclicDependencyException(message: String, cause: Throwable? = null) : KinjectException(message, cause)

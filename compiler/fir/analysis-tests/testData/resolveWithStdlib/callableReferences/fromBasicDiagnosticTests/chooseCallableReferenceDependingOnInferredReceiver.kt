class A {
    fun foo(i: A) {}

    fun baz(i: A) {}
}

class B {
    fun foo(s: B) {}
    fun foo(c: Char) {}

    fun baz(s: B) {}
}

fun <T> bar(f: (T) -> Unit): T = TODO()

fun test() {
    <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER, TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER, TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>myWith<!>(A()) {
        val t1 = bar(::foo)

        val t2 = bar(::baz)

        myWith(B()) {
            val a: A = bar(::foo)
            val b: B = bar(::foo)

            val t3 = bar(::baz)

            bar(::<!OVERLOAD_RESOLUTION_AMBIGUITY!>foo<!>)
        }
    }
}

inline fun <T, R> myWith(receiver: T, block: T.() -> R): R = TODO()

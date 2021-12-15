// LANGUAGE: +InlineClasses, -JvmInlineValueClasses, +SealedInlineClasses
// IGNORE_BACKED: JVM

sealed inline class Result {
    inline class Ok(val value: Any): Result()
    inline class FileNotFound(val value: Int): Result()
    class Error(val value: Throwable): Result()
}
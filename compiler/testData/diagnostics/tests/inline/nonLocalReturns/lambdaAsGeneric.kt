fun box() : String {
    <!TYPE_INFERENCE_NO_INFORMATION_FOR_PARAMETER!>test<!> {
        <!RETURN_NOT_ALLOWED!>return@box<!> "123"
    }

    return "OK"
}

<!NOTHING_TO_INLINE!>inline<!> fun <T> test(p: T) {
    p.toString()
}

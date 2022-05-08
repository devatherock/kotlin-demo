package io.github.devatherock.demo

class OptionalProperty {
    var value: Any? = null
        set(value) {
            field = value
            valueSet = true
        }
    var valueSet: Boolean = false
}

package io.github.devatherock.demo

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import io.github.devatherock.demo.io.github.devatherock.demo.OptionalPropertyDeserializer

data class ResponseJson (
    val id: Int,
    @JsonDeserialize(using = OptionalPropertyDeserializer::class)
    val name: OptionalProperty
)
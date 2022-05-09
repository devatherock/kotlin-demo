package io.github.devatherock.demo

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

data class ResponseJson (
    @JsonDeserialize(using = OptionalPropertyDeserializer::class)
    val id: OptionalProperty,
    @JsonDeserialize(using = OptionalPropertyDeserializer::class)
    val name: OptionalProperty
)
package io.github.devatherock.demo

import com.fasterxml.jackson.databind.annotation.JsonDeserialize

data class ResponseJson (
    val id: Int,
    @JsonDeserialize(using = OptionalPropertyDeserializer::class)
    val name: OptionalProperty
)
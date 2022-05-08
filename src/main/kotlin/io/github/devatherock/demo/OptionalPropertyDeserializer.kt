package io.github.devatherock.demo.io.github.devatherock.demo

import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import io.github.devatherock.demo.OptionalProperty

class OptionalPropertyDeserializer : JsonDeserializer<OptionalProperty>() {
    override fun deserialize(parser: JsonParser, context: DeserializationContext): OptionalProperty {
        var property = OptionalProperty()
        property.value = parser.readValueAs(String::class.java)
        return property
    }

    override fun getNullValue(context: DeserializationContext): OptionalProperty {
        var property = OptionalProperty()
        property.value = null
        return property
    }

    override fun getAbsentValue(context: DeserializationContext): OptionalProperty {
        return OptionalProperty()
    }
}
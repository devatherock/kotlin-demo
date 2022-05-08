package io.github.devatherock.demo

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test

class ResponseJsonTest {
    var objectMapper = jacksonObjectMapper()

    @Test
    fun `test deserialization - name is non-null`() {
        var responseJson = objectMapper.readValue(
            """
                  {
                    "id": 5,
                    "name": "test"
                  }
                """.trimIndent(),
            ResponseJson::class.java
        )
        assert(responseJson.id == 5)
        assert(responseJson.name.value == "test")
        assert(responseJson.name.valueSet)
    }

    @Test
    fun `test deserialization - name is null`() {
        var responseJson = objectMapper.readValue(
            """
                  {
                    "id": 5,
                    "name": null
                  }
                """.trimIndent(),
            ResponseJson::class.java
        )
        assert(responseJson.id == 5)
        assert(responseJson.name.value == null)
        assert(responseJson.name.valueSet)
    }

    @Test
    fun `test deserialization - name is absent`() {
        var responseJson = objectMapper.readValue(
            """
                  {
                    "id": 5
                  }
                """.trimIndent(),
            ResponseJson::class.java
        )
        assert(responseJson.id == 5)
        assert(responseJson.name.value == null)
        assert(!responseJson.name.valueSet)
    }
}
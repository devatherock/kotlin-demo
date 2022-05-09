package io.github.devatherock.demo

import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import org.junit.jupiter.api.Test

class ResponseJsonTest {
    var objectMapper = jacksonObjectMapper()

    @Test
    fun `test deserialization - id and name are non-null`() {
        var responseJson = objectMapper.readValue(
            """
                  {
                    "id": 5,
                    "name": "test"
                  }
                """.trimIndent(),
            ResponseJson::class.java
        )
        assert(responseJson.id.value == 5)
        assert(responseJson.id.valueSet)
        assert(responseJson.id.value is Int)
        assert(responseJson.name.value == "test")
        assert(responseJson.name.valueSet)
        assert(responseJson.name.value is String)
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
        assert(responseJson.id.value == 5)
        assert(responseJson.id.valueSet)
        assert(responseJson.id.value is Int)
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
        assert(responseJson.id.value == 5)
        assert(responseJson.id.valueSet)
        assert(responseJson.id.value is Int)
        assert(responseJson.name.value == null)
        assert(!responseJson.name.valueSet)
    }

    @Test
    fun `test deserialization - id is null`() {
        var responseJson = objectMapper.readValue(
            """
                  {
                    "id": null,
                    "name": "test"
                  }
                """.trimIndent(),
            ResponseJson::class.java
        )
        assert(responseJson.id.value == null)
        assert(responseJson.id.valueSet)
        assert(responseJson.name.value == "test")
        assert(responseJson.name.valueSet)
        assert(responseJson.name.value is String)
    }

    @Test
    fun `test deserialization - id is absent`() {
        var responseJson = objectMapper.readValue(
            """
                  {
                    "name": "test"
                  }
                """.trimIndent(),
            ResponseJson::class.java
        )
        assert(responseJson.id.value == null)
        assert(!responseJson.id.valueSet)
        assert(responseJson.name.value == "test")
        assert(responseJson.name.valueSet)
        assert(responseJson.name.value is String)
    }
}
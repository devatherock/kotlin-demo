package io.github.devatherock.entities

import com.fasterxml.jackson.databind.DeserializationFeature
import com.fasterxml.jackson.databind.ObjectMapper

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import io.kotest.data.forAll
import io.kotest.data.headers
import io.kotest.data.row
import io.kotest.data.table

import org.junit.jupiter.api.Test

internal class RequestSpec {

	private val objectMapper = ObjectMapper()
		.configure(DeserializationFeature.FAIL_ON_NULL_FOR_PRIMITIVES, true)
	
	@Test
	fun `test deserialization - error`() {
		table(
			headers("json"),
			row("{}"),
			row("""{"isUserAgent":null}"""),
			row("""{"isUserAgent":""}"""),
		).forAll { json ->
			shouldThrow<Exception> {
				objectMapper.readValue(json, Request::class.java)
			}
		}
	}
	
	@Test
	fun `test deserialization - success`() {
		table(
			headers("json", "expectedOutput"),
			row("""{"isUserAgent":false}""", false),
			row("""{"isUserAgent":true}""", true),
		).forAll { json, expectedOutput ->
			val request = objectMapper.readValue(json, Request::class.java)
			request.userAgentSpecified shouldBe expectedOutput
		}
	}
}
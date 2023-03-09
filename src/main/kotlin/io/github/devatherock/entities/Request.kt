package io.github.devatherock.entities

import com.fasterxml.jackson.annotation.JsonProperty

data class Request(
	@JsonProperty(value = "isUserAgent", required = true)
	val userAgentSpecified: Boolean,
)
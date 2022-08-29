package io.github.devatherock.model

import com.fasterxml.jackson.annotation.JsonProperty
import io.swagger.v3.oas.annotations.media.Schema

class TrendEvaluationModel(
    @Schema(hidden = true)
    private val xAxisVal: Int,
    @Schema(hidden = true)
    private val yAxisVal: Int,
    val customValue: Int?
) {
    val xAxisValue: Int
        @Schema(name = "xAxisValue")
        @JsonProperty("xAxisValue")
        get() = xAxisVal

    val yAxisValue: Int
        @Schema(name = "yAxisValue")
        @JsonProperty("yAxisValue")
        get() = yAxisVal
}
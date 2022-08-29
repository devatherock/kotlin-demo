package io.github.devatherock.controller

import io.github.devatherock.model.TrendEvaluationModel
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TrendsController {

    @GetMapping("/trends")
    fun getTrends(): TrendEvaluationModel {
        return TrendEvaluationModel(
            20,
            50,
            100
        )
    }
}
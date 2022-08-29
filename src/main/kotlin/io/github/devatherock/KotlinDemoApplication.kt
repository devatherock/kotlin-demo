package io.github.devatherock

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinDemoApplication

fun main(args: Array<String>) {
	runApplication<KotlinDemoApplication>(*args)
}

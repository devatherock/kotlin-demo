package io.github.devatherock

import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths

open class CodeGenMain {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Generating code")

            val filePath = "src/generated/kotlin/io/github/devatherock/entities"
            Files.createDirectories(Paths.get(filePath))
            val entityFile = Paths.get(filePath, "Person.kt")
            val entityFileContent = """
                package io.github.devatherock.entities
                
                private const val BUILD_TIME = ${System.currentTimeMillis()}
                
                data class Person(val name: String)
            """.trimIndent()
            Files.write(entityFile, entityFileContent.toByteArray(StandardCharsets.UTF_8))
        }
    }
}
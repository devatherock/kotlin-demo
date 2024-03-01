import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
}

repositories {
    mavenCentral()
}

extra.apply {
    set("projectShortName", "My Project short name")
    set("mainClass", "io.github.devatherock.Application")
}

application {
    applicationName = project.ext.get("projectShortName").toString()
    mainClass.set(project.ext.get("mainClass").toString())
}

dependencies {
    val junitVersion = "5.8.2"

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events(
        	org.gradle.api.tasks.testing.logging.TestLogEvent.PASSED, 
        	org.gradle.api.tasks.testing.logging.TestLogEvent.FAILED
    	)
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

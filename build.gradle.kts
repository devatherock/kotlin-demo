import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
}

repositories {
    mavenCentral()
}

dependencies {
    val junitVersion = "5.8.2"
    val kotestVersion = "5.5.5"
    
    implementation("com.fasterxml.jackson.core:jackson-databind:2.14.2")

    testImplementation("org.junit.jupiter:junit-jupiter-api:$junitVersion")
    testImplementation("org.junit.jupiter:junit-jupiter-engine:$junitVersion")
    testImplementation("io.kotest:kotest-assertions-core-jvm:$kotestVersion")
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

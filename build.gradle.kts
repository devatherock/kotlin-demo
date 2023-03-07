import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("org.jetbrains.kotlin.jvm") version "1.6.21"
}

repositories {
    mavenCentral()
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

extra.apply {
    set("buildVersion", "1.0.0")
}

tasks.register("readImageVersion") {
     doLast {
         file("image.version").appendText("""Version=${project.property("buildVersion")}""")
     }
}

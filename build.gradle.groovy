plugins {
    id "org.jetbrains.kotlin.jvm" version "1.6.21"
}

repositories {
    mavenCentral()
}

dependencies {
    def junitVersion = '5.8.2'

    testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-api', version: junitVersion
    testImplementation group: 'org.junit.jupiter', name: 'junit-jupiter-engine', version: junitVersion
}


test {
    useJUnitPlatform()
    testLogging {
        events 'passed', 'failed'
    }
}

compileKotlin {
    kotlinOptions {
        jvmTarget = '1.8'
    }
}

ext {
    buildVersion = '1.0.0'
}

task readImageVersion() {
     doLast {
         new File("image.version").text = "Version=${buildVersion}"
     }
}

plugins {
    groovy
}

group = "io.thewokecoder"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.codehaus.groovy:groovy-all:3.0.9")

    testImplementation(platform("org.spockframework:spock-bom:2.0-groovy-3.0"))
    testImplementation("org.spockframework:spock-core:2.0-groovy-3.0")
    testImplementation("com.athaydes:spock-reports:2.1.1-groovy-3.0") {
        isTransitive = false // this avoids affecting the version of Groovy/Spock
    }

    testImplementation("io.rest-assured:rest-assured:4.4.0")

    testImplementation("org.slf4j:slf4j-api:1.7.32")
    testRuntimeOnly("org.slf4j:slf4j-simple:1.7.32")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}
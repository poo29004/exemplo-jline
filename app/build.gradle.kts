plugins {
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
    // https://mvnrepository.com/artifact/org.jline/jline
    implementation("org.jline:jline:3.27.0")

    // Use JUnit Jupiter for testing.
    testImplementation(libs.junit.jupiter)

    testRuntimeOnly("org.junit.platform:junit-platform-launcher")

    // This dependency is used by the application.
    implementation(libs.guava)
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    mainClass = "ads.poo.App"
}

// Define o System.in como entrada padrão para a execução do programa com o gradle
tasks.run.configure {
    standardInput = System.`in`
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}
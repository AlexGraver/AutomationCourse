plugins {
    id("java")
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    implementation ("org.seleniumhq.selenium:selenium-java:4.29.0")
    testImplementation("io.qameta.allure:allure-junit5:2.25.0")
}


tasks.test {
    useJUnitPlatform()
}
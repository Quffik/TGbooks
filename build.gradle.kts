plugins {
    id("java")
    aplication
}

aplication {
    mainClass.set("org.quffik.Main")
}

group = "org.quffik"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    implementation("org.telegram:telegrambots-longpolling:9.2.1")
    implementation("org.telegram:telegrambots-client:9.2.1")
}

tasks.test {
    useJUnitPlatform()
}

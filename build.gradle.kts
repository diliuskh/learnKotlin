
plugins {
    java
    kotlin("jvm") version "1.4.31"
}

group = "net.dilius"
version = "1.0-SNAPSHOT"

val coroutinesVersion = "1.4.3"
val junitVersion = "5.7.1"


repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("reflect"))
    implementation(kotlin("stdlib-jdk8"))
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-core", coroutinesVersion)
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-jdk8", coroutinesVersion)
    implementation("org.jetbrains.kotlinx", "kotlinx-coroutines-reactor", coroutinesVersion)
    testImplementation(platform("org.junit:junit-bom:$junitVersion"))
    testImplementation("org.junit.jupiter","junit-jupiter")
}

configure<JavaPluginConvention> {
    sourceCompatibility = JavaVersion.VERSION_1_8
}
tasks {
    compileKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
    compileTestKotlin {
        kotlinOptions {
            freeCompilerArgs = listOf("-Xjsr305=strict")
            jvmTarget = "1.8"
        }
    }
}

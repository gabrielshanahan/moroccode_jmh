import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Kotlin application project to get you started.
 */

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.3.61"

    id("me.champeau.gradle.jmh") version "0.5.0"
    id("org.jetbrains.kotlin.plugin.allopen") version "1.3.61"
}

repositories {

    maven {
        url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
    }
    mavenCentral()
    jcenter()
}

dependencies {
    // Align versions of all Kotlin components
    implementation(platform(kotlin("bom")))

    // Use the Kotlin JDK 8 standard library.
    implementation(kotlin("stdlib-jdk8"))

    testImplementation("io.kotlintest:kotlintest-runner-junit5:3.3.2")
    // This is needed due to a known issue with KotlinTest: https://github.com/kotlintest/kotlintest/issues/639
    testImplementation("org.slf4j", "slf4j-simple", "1.7.26")

    implementation("io.github.gabrielshanahan", "moroccode", "1.0.0-SNAPSHOT")
    implementation("com.github.pvdberg1998", "hashkode", "1.2.3")
    implementation("net.arhipov:equals-builder:0.3")
    implementation("au.com.console:kassava:2.0.0")
    implementation("org.apache.commons:commons-lang3:3.9")
}

tasks {
    withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = "1.8"
    }

    test {
        useJUnitPlatform()

        testLogging {
            // Make sure output from
            // standard out or error is shown
            // in Gradle output.
            showStandardStreams = true
        }
    }
}

// Added so jmh plugin doesn't fail with tests (https://github.com/melix/jmh-gradle-plugin/issues/79)
jmh {
    duplicateClassesStrategy = DuplicatesStrategy.WARN
}


// Make all SNAPSHOTs refresh every build
configurations.all {
    resolutionStrategy.cacheChangingModulesFor(0, "seconds")
}
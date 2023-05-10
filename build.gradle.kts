buildscript {
    repositories {
        google()
        mavenCentral()
        maven {
            setUrl("https://jitpack.io")
        }
    }

    dependencies {
        val kotlinVersion = "1.8.10"

        classpath(libs.gradle)
        classpath(libs.google.services)
        classpath(libs.firebase.perf.plugin)
        classpath(libs.firebase.crashlytics.gradle)
        classpath(kotlin("gradle-plugin", version = kotlinVersion))
        classpath(kotlin("serialization", version = kotlinVersion))
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
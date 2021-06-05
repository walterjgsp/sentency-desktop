import org.jetbrains.compose.compose
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val koinVersion = "3.0.2"
val retrofitVersion = "2.9.0"
val coroutineVersion = "1.5.0"


plugins {
    kotlin("jvm") version "1.4.30"
    id("org.jetbrains.compose") version "0.3.1"
}

group = "org.sentency.desktop"
version = "0.0.1"

repositories {
    jcenter()
    mavenCentral()
    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}

dependencies {
    testImplementation(kotlin("test"))
    implementation(compose.desktop.currentOs)

    // Core
    implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutineVersion")

    // Koin
    implementation ("io.insert-koin:koin-core:$koinVersion")

    // Retrofit
    implementation ("com.squareup.retrofit2:retrofit:$retrofitVersion")
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.1"))
    implementation ("com.squareup.retrofit2:converter-gson:$retrofitVersion")

}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "13"
}

compose.desktop {
    application {
        mainClass = "MainKt"
        nativeDistributions {
            targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
            packageName = "sentency-desktop"
            packageVersion = "1.0.0"
        }
    }
}

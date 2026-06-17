plugins {
    id("kotlin")
}

kotlin {
    jvmToolchain(11)
}

dependencies {
    implementation(libs.rxjava)
    implementation(libs.rxkotlin)
    implementation(libs.javax.inject)

    testImplementation(libs.junit)
    testImplementation(libs.mockk)
}

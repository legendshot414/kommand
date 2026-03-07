dependencies {
    api(projectApi)
}

tasks {
    jar{
        archiveClassifier.set("origin")
    }

    register<Jar>("coredevJar") {
        from(sourceSets["main"].output)
    }

    register<Jar>("corereobfJar") {
        from(sourceSets["main"].output)
    }
}

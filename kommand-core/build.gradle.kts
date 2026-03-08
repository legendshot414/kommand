plugins {
    alias(libs.plugins.dokka)
}

dependencies {
    api(projectApi)
}

tasks {
    jar {
        archiveClassifier.set("origin")
    }

    register<Jar>("coreDevJar") {
        from(sourceSets["main"].output)
    }

    register<Jar>("coreReobfJar") {
        from(sourceSets["main"].output)
    }

    register<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    register<Jar>("dokkaJar") {
        archiveClassifier.set("javadoc")
        dependsOn("dokkaHtml")
        from(layout.buildDirectory.dir("dokka/html"))
    }
}
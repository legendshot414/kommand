plugins {
    alias(libs.plugins.dokka)
}

tasks {
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

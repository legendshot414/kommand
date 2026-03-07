plugins {
    alias(libs.plugins.dokka)
}

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

    create<Jar>("sourcesJar") {
        archiveClassifier.set("sources")
        from(sourceSets["main"].allSource)
    }

    create<Jar>("dokkaJar") {
        archiveClassifier.set("javadoc")
        dependsOn("dokkaHtml")

        from("$buildDir/dokka/html/") {
            include("**")
        }
    }
}

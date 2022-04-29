pluginManagement {
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    versionCatalogs {
        create("lib") {
            from(files("gradle/lib.versions.toml"))
        }
    }
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "MyEduApplication"
include (":app")
enableFeaturePreview("VERSION_CATALOGS")
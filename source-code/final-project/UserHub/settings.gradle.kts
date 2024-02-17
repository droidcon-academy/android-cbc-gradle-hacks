pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "MiniTales"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

rootProject.name = "UserHub"

include(":app")
include(":network")
include(":storage")
include(":data")

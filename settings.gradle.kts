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

rootProject.name = "juicr"

include(":app")
include(":core:common")
include(":core:domain")
include(":data:local")
include(":data:repositories")
include(":feature:home")
include(":core:presentation")

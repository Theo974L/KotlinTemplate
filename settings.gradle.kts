pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}


rootProject.name = "TheoLaforgeEval"

include(
    ":app",
    ":core:api", ":core:data", ":core:domain", "core:ui",":core:system",
    ":features:client:home:api", ":features:client:home:data", ":features:client:home:domain", "features:client:home:ui"

)
 
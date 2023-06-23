rootProject.name = "MinimumViableDataspace"

pluginManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        mavenLocal()
        maven {
            url = uri("https://oss.sonatype.org/content/repositories/snapshots/")
        }
        mavenCentral()
    }
}

include(":launchers:connector")
include(":launchers:registrationservice")
//include(":system-tests")
include(":extensions:refresh-catalog")
include(":extensions:policies")

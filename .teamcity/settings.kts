import jetbrains.buildServer.configs.kotlin.v2019_2.*
import jetbrains.buildServer.configs.kotlin.v2019_2.projectFeatures.dockerRegistry
import jetbrains.buildServer.configs.kotlin.v2019_2.vcs.GitVcsRoot

/*
The settings script is an entry point for defining a TeamCity
project hierarchy. The script should contain a single call to the
project() function with a Project instance or an init function as
an argument.

VcsRoots, BuildTypes, Templates, and subprojects can be
registered inside the project using the vcsRoot(), buildType(),
template(), and subProject() methods respectively.

To debug settings scripts in command-line, run the

    mvnDebug org.jetbrains.teamcity:teamcity-configs-maven-plugin:generate

command and attach your debugger to the port 8000.

To debug in IntelliJ Idea, open the 'Maven Projects' tool window (View
-> Tool Windows -> Maven Projects), find the generate task node
(Plugins -> teamcity-configs -> teamcity-configs:generate), the
'Debug' option is available in the context menu for the task.
*/

version = "2020.1"

project {

    vcsRoot(Customtestkey_1)

    buildType(Customtestkey)

    features {
        dockerRegistry {
            id = "PROJECT_EXT_4"
            name = "Docker Registry"
            url = "https://docker.io"
            userName = "sdsd"
            password = "credentialsJSON:630c3de4-86af-458f-8a28-c54a0ba164fe"
        }
    }
}

object Customtestkey : BuildType({
    name = "customtestkey"

    vcs {
        root(Customtestkey_1)
    }
})

object Customtestkey_1 : GitVcsRoot({
    id("Customtestkey")
    name = "customtestkey"
    url = "https://github.com/achubatova/composite"
    authMethod = password {
        userName = "AChubatova"
        password = "credentialsJSON:a67309af-b2f3-45d2-91bd-40ec9bbed5b7"
    }
})

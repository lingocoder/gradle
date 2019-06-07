import org.gradle.gradlebuild.unittestandcompile.ModuleType

plugins {
    `java-library`
    gradlebuild.classycle
}

dependencies {
    implementation(project(":baseServices"))
    implementation(project(":messaging"))
    implementation(project(":logging"))
    implementation(project(":processServices"))
    implementation(project(":workerProcesses"))
    implementation(project(":persistentCache"))
    implementation(project(":coreApi"))
    implementation(project(":modelCore"))
    implementation(project(":core"))

    implementation(library("slf4j_api"))
    implementation(library("guava"))
    implementation(library("inject"))

    testImplementation(project(":native"))
    testImplementation(project(":files"))
    testImplementation(project(":resources"))
    testImplementation(testFixtures(project(":core")))
    testImplementation(testFixtures(project(":logging")))

    testRuntimeOnly(project(":runtimeApiInfo"))
    testRuntimeOnly(project(":dependencyManagement"))

    integTestImplementation(project(":jvmServices"))
    integTestImplementation(project(":internalIntegTesting"))

    testFixturesImplementation(project(":baseServices"))
    testFixturesImplementation(project(":internalTesting"))
}

gradlebuildJava {
    moduleType = ModuleType.CORE
}


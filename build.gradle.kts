// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id ("com.android.application") version "7.1.3" apply false
    id ("com.android.library") version "7.1.3" apply false
    id ("org.jetbrains.kotlin.android") version "1.8.0" apply false
}

task ("clean",Delete::class) {
    delete = setOf(rootProject.buildDir)
}
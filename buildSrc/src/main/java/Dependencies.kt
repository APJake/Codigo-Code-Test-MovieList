object ConfigData {
    const val compileSdkVersion = 32
    const val buildToolsVersion = "30.0.3"
    const val minSdkVersion = 21
    const val targetSdkVersion = 32
    private const val versionMajor = 2
    private const val versionMinor = 0
    private const val versionPatch = 1
    private const val versionBuild = 1
    const val versionName = "$versionMajor.$versionMinor.$versionPatch($versionBuild)"
    const val versionCode =
        17 * 10000000 + versionMajor * 1000000 + versionMinor * 10000 + versionPatch * 100 + versionBuild
    const val debugTag = "(testing)"
}

object ComposeUi {
    private const val FLOW_VERSION = "0.26.2-beta"
    const val flowLayout = "com.google.accompanist:accompanist-flowlayout:$FLOW_VERSION"
}

object DataStore {
    const val preferences = "androidx.datastore:datastore-preferences:1.0.0"
}

object Network{
    private const val RETROFIT_VERSION = "2.9.0"
    const val retrofit = "com.squareup.retrofit2:retrofit:$RETROFIT_VERSION"
    const val gsonConverter = "com.squareup.retrofit2:converter-gson:$RETROFIT_VERSION"

    private const val OKHTTP_VERSION = "5.0.0-alpha.2"
    const val okhttp = "com.squareup.okhttp3:okhttp:$OKHTTP_VERSION"
    const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:$OKHTTP_VERSION"

    const val jsonSerialization = "org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2"
}

object Hilt {
    private const val VERSION = "2.42"
    const val fragment = "androidx.hilt:hilt-navigation-fragment:1.0.0"
    const val navigationCompose = "androidx.hilt:hilt-navigation-compose:1.0.0"
    const val compiler = "com.google.dagger:hilt-android-compiler:$VERSION"
    const val android = "com.google.dagger:hilt-android:$VERSION"
    const val core = "com.google.dagger:hilt-core:$VERSION"
}

object CommonUi {
    private const val CONSTRAINT_VERSION = "2.1.4"
    private const val MATERIAL_VERSION = "1.4.0"
    const val material = "com.google.android.material:material:$MATERIAL_VERSION"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$CONSTRAINT_VERSION"
    const val core = "androidx.core:core-ktx:1.7.0"
    const val appCompat = "androidx.appcompat:appcompat:1.4.0"

    private const val GLIDE_VERSION = "4.13.0"
    const val glide = "com.github.bumptech.glide:glide:$GLIDE_VERSION"
}

object Others {
    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.6.10"
    const val dataBinding = "com.android.databinding:compiler:3.2.0-alpha10"

    const val codeGson = "com.google.code.gson:gson:2.9.0"
}

object Coroutine {
    private const val VERSION = "1.6.0"
    const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:$VERSION"
    const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:$VERSION"
}

object Lifecycle {
    private const val VERSION = "2.4.0"

    const val extension = "androidx.lifecycle:lifecycle-extensions:2.2.0"
    const val compiler = "androidx.lifecycle:lifecycle-compiler:$VERSION"
    const val common = "androidx.lifecycle:lifecycle-common-java8:$VERSION"
    const val viewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:$VERSION"
}

object Room {
    private const val VERSION = "2.4.2"
    const val compiler = "androidx.room:room-compiler:$VERSION"
    const val ktx = "androidx.room:room-ktx:$VERSION"
    const val runtime = "androidx.room:room-runtime:$VERSION"
    const val testing = "androidx.room:room-testing:$VERSION"
}

object Navigation {
    private const val VERSION = "2.3.5"
    const val fragment = "androidx.navigation:navigation-fragment-ktx:$VERSION"
    const val ui = "androidx.navigation:navigation-ui-ktx:$VERSION"
}
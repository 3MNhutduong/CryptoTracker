// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    // Alias gọi từ [plugins] trong toml: android-application -> android.application
    // apply false: Nghĩa là "Tải về thôi, đừng chạy ở root này, vì root không phải là App"
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.detekt) apply false
}

// 2. Clean task: Xóa thư mục build cũ để build lại cho sạch
// Task này thường được gọi khi bạn chạy lệnh ./gradlew clean
tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}
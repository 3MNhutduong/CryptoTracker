// 1. QUAN TRỌNG: Phải Import dòng này thì mới dùng được DetektExtension
import io.gitlab.arturbosch.detekt.extensions.DetektExtension

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    alias(libs.plugins.kotlin.compose) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.hilt.android) apply false
    alias(libs.plugins.ksp) apply false
    // Apply false ở đây là đúng, để load class vào classpath
    alias(libs.plugins.detekt) apply false
}

tasks.register("clean", Delete::class) {
    delete(rootProject.layout.buildDirectory)
}

// Cấu hình cho tất cả module con (app, core, data...)
subprojects {
    // Apply plugin cho module con
    apply(plugin = "io.gitlab.arturbosch.detekt")

    // 2. QUAN TRỌNG: Thay detekt {} bằng extensions.configure<DetektExtension> {}
    // Cách này giúp Kotlin nhận diện đúng kiểu dữ liệu cấu hình
    extensions.configure<DetektExtension> {

        // Logic chọn file config (giữ nguyên logic của bạn)
        val configFile = if (project.hasProperty("detektConfig")) {
            project.property("detektConfig") as String
        } else {
            "detekt.yml"
        }

        // Trỏ về file config ở thư mục gốc Project
        config.setFrom(rootProject.files(configFile))

        // Bây giờ các thuộc tính này sẽ không bị lỗi đỏ nữa
        buildUponDefaultConfig = true
        parallel = true
        // autoCorrect = true // Bật cái này nếu muốn nó tự sửa lỗi format cơ bản
    }
}
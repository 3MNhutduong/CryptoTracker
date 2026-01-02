# 🪙 CryptoTracker

A modern Android application for tracking cryptocurrency prices and portfolio, built with Clean Architecture principles and Jetpack Compose.

## 📱 Features

- Real-time cryptocurrency price tracking
- Portfolio management
- Price alerts and notifications
- Detailed coin information and charts
- Offline support with local caching

## 🏗️ Architecture

This project follows **Clean Architecture** with a multi-module structure:

```
CryptoTracker/
├── app/                    # Application module (Entry point)
├── core/                   # Core functionality modules
│   ├── common/            # Shared utilities and extensions
│   ├── database/          # Room database implementation
│   ├── model/             # Data models
│   ├── network/           # Retrofit API services
│   └── ui/                # Shared UI components
├── data/                   # Data layer
│   └── repository/        # Repository implementations
├── domain/                 # Domain layer (Pure Kotlin)
│   ├── repository/        # Repository interfaces
│   └── usecase/           # Business logic use cases
└── features/               # Feature modules
    ├── home/              # Home screen feature
    └── detail/            # Coin detail feature
```

### Layer Responsibilities

| Layer | Purpose |
|-------|---------|
| **App** | DI setup, Navigation, Theme |
| **Features** | UI screens, ViewModels |
| **Domain** | Use cases, Repository interfaces |
| **Data** | Repository implementations |
| **Core** | Shared utilities, Network, Database |

## 🛠️ Tech Stack

| Category | Technology |
|----------|------------|
| **Language** | Kotlin |
| **UI** | Jetpack Compose |
| **DI** | Hilt |
| **Network** | Retrofit + OkHttp + Moshi |
| **Database** | Room |
| **Async** | Kotlin Coroutines + Flow |
| **Testing** | JUnit + MockK |
| **Code Quality** | Detekt |

## 🚀 Getting Started

### Prerequisites

- Android Studio Hedgehog or later
- JDK 17
- Android SDK 36

### Setup

1. **Clone the repository**
   ```bash
   git clone https://github.com/yourusername/CryptoTracker.git
   cd CryptoTracker
   ```

2. **Open in Android Studio**
   - Open Android Studio
   - Select "Open an existing project"
   - Navigate to the cloned directory

3. **Build the project**
   ```bash
   ./gradlew assembleDebug
   ```

4. **Run the app**
   - Select a device/emulator
   - Click Run ▶️

## 🧪 Testing

```bash
# Run unit tests
./gradlew testDebugUnitTest

# Run instrumented tests
./gradlew connectedDebugAndroidTest

# Run code analysis
./gradlew detekt lintDebug
```

## 📋 Code Quality

This project uses **Detekt** for static code analysis with two configurations:

- `detekt.yml` - Strict rules for `master`, `develop`, `release/*` branches
- `detekt-loose.yml` - Relaxed rules for feature branches

## 🔄 CI/CD

GitHub Actions workflow automatically runs on every push:

1. ✅ Code checkout
2. ☕ JDK 17 setup
3. 🔍 Run Detekt + Android Lint
4. 🧪 Run Unit Tests
5. 📦 Build Debug/Release APK
6. 🚀 Create GitHub Release (on tags)

## 📄 License

```
MIT License

Copyright (c) 2026 CryptoTracker

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software.
```

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/...`)
3. Commit your changes (`git commit -m 'Add amazing feature'`)
4. Push to the branch (`git push origin feature/...`)
5. Open a Pull Request

---

Made with ❤️ using Kotlin and Jetpack Compose

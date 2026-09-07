# NotifAI

AI-powered Android notification filter, custom-built for the Indian ecosystem.

## Smart India Hackathon (SIH) Highlights
- **India-Specific AI Models**: Trained to recognize TRAI DLT alphanumeric sender formats, local bank SMS structures (SBI, HDFC, ICICI, etc.), and regional Hinglish scam phrases.
- **Cascading AI Providers**: Intelligent fallback mechanism between Groq, OpenRouter, and Gemini to ensure 99.9% uptime and zero missed classifications.
- **Privacy First**: Secure `EncryptedSharedPreferences` for API keys and local Room database. Your notification data never leaves your device except for the anonymous classification request.
- **Real-time Processing**: Fast classification pipeline using Kotlin Coroutines and StateFlow to filter spam before you even see it.

## Tech stack
- Jetpack Compose + Material 3
- Hilt (dependency injection)
- Room (local database)
- Retrofit + OkHttp + Gson (networking)
- Kotlin Coroutines + StateFlow
- EncryptedSharedPreferences (secure storage)
- Navigation Compose

## Project structure
```
app/src/main/java/com/notifai/
├── NotifAIApp.kt              # @HiltAndroidApp Application class
├── MainActivity.kt            # @AndroidEntryPoint + Compose host
├── ai/
│   ├── AIProviderManager.kt
│   ├── GroqProvider.kt
│   ├── OpenRouterProvider.kt
│   └── GeminiProvider.kt
├── data/
│   ├── db/
│   │   ├── NotificationDao.kt
│   │   └── NotificationDatabase.kt
│   ├── model/
│   │   ├── Category.kt
│   │   └── NotificationEntity.kt
│   └── repository/
│       └── NotificationRepository.kt
├── di/
│   └── AppModule.kt
├── service/
│   └── NotifListenerService.kt
└── ui/
    ├── apps/         AppSettingsScreen.kt
    ├── blocked/      BlockedScreen.kt
    ├── dashboard/    DashboardScreen.kt
    ├── navigation/   MainNavigation.kt
    ├── onboarding/   OnboardingScreen.kt
    └── settings/     SettingsScreen.kt
```

## Setup
1. Open project in Android Studio Ladybug (2024.2+)
2. Sync Gradle
3. Grant notification access via Settings → Notification Access → NotifAI

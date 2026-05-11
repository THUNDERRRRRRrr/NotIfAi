# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Keep Hilt generated code
-keep class dagger.hilt.** { *; }
-keep class * extends dagger.hilt.android.internal.managers.ComponentSupplier { *; }

# Keep Room entities and DAOs
-keep class com.notifai.data.model.** { *; }
-keep class com.notifai.data.db.** { *; }

# Keep Retrofit / Gson models
-keepattributes Signature
-keepattributes *Annotation*
-keep class retrofit2.** { *; }
-keep class com.google.gson.** { *; }

# Keep AI provider model classes (Gemini / OpenAI request/response DTOs)
-keep class com.notifai.ai.model.** { *; }

# Keep custom exception classes (used in catch blocks by class name)
-keep class com.notifai.ai.GeminiException { *; }
-keep class com.notifai.ai.OpenRouterException { *; }
-keep class com.notifai.ai.GroqException { *; }

# Keep AI response model used across the app
-keep class com.notifai.data.model.AIResponse { *; }

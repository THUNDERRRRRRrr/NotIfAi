package com.notifai.ai;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation"
})
public final class GeminiProvider_Factory implements Factory<GeminiProvider> {
  private final Provider<GeminiService> geminiServiceProvider;

  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  private final Provider<Gson> gsonProvider;

  public GeminiProvider_Factory(Provider<GeminiService> geminiServiceProvider,
      Provider<ApiKeyManager> apiKeyManagerProvider, Provider<Gson> gsonProvider) {
    this.geminiServiceProvider = geminiServiceProvider;
    this.apiKeyManagerProvider = apiKeyManagerProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public GeminiProvider get() {
    return newInstance(geminiServiceProvider.get(), apiKeyManagerProvider.get(), gsonProvider.get());
  }

  public static GeminiProvider_Factory create(Provider<GeminiService> geminiServiceProvider,
      Provider<ApiKeyManager> apiKeyManagerProvider, Provider<Gson> gsonProvider) {
    return new GeminiProvider_Factory(geminiServiceProvider, apiKeyManagerProvider, gsonProvider);
  }

  public static GeminiProvider newInstance(GeminiService geminiService, ApiKeyManager apiKeyManager,
      Gson gson) {
    return new GeminiProvider(geminiService, apiKeyManager, gson);
  }
}

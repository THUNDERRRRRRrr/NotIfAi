package com.notifai.ai;

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
public final class AIProviderManager_Factory implements Factory<AIProviderManager> {
  private final Provider<GroqProvider> groqProvider;

  private final Provider<OpenRouterProvider> openRouterProvider;

  private final Provider<GeminiProvider> geminiProvider;

  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  public AIProviderManager_Factory(Provider<GroqProvider> groqProvider,
      Provider<OpenRouterProvider> openRouterProvider, Provider<GeminiProvider> geminiProvider,
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    this.groqProvider = groqProvider;
    this.openRouterProvider = openRouterProvider;
    this.geminiProvider = geminiProvider;
    this.apiKeyManagerProvider = apiKeyManagerProvider;
  }

  @Override
  public AIProviderManager get() {
    return newInstance(groqProvider.get(), openRouterProvider.get(), geminiProvider.get(), apiKeyManagerProvider.get());
  }

  public static AIProviderManager_Factory create(Provider<GroqProvider> groqProvider,
      Provider<OpenRouterProvider> openRouterProvider, Provider<GeminiProvider> geminiProvider,
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    return new AIProviderManager_Factory(groqProvider, openRouterProvider, geminiProvider, apiKeyManagerProvider);
  }

  public static AIProviderManager newInstance(GroqProvider groqProvider,
      OpenRouterProvider openRouterProvider, GeminiProvider geminiProvider,
      ApiKeyManager apiKeyManager) {
    return new AIProviderManager(groqProvider, openRouterProvider, geminiProvider, apiKeyManager);
  }
}

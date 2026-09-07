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
public final class OpenAIProvider_Factory implements Factory<OpenAIProvider> {
  private final Provider<OpenAIService> openAiServiceProvider;

  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  private final Provider<Gson> gsonProvider;

  public OpenAIProvider_Factory(Provider<OpenAIService> openAiServiceProvider,
      Provider<ApiKeyManager> apiKeyManagerProvider, Provider<Gson> gsonProvider) {
    this.openAiServiceProvider = openAiServiceProvider;
    this.apiKeyManagerProvider = apiKeyManagerProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public OpenAIProvider get() {
    return newInstance(openAiServiceProvider.get(), apiKeyManagerProvider.get(), gsonProvider.get());
  }

  public static OpenAIProvider_Factory create(Provider<OpenAIService> openAiServiceProvider,
      Provider<ApiKeyManager> apiKeyManagerProvider, Provider<Gson> gsonProvider) {
    return new OpenAIProvider_Factory(openAiServiceProvider, apiKeyManagerProvider, gsonProvider);
  }

  public static OpenAIProvider newInstance(OpenAIService openAiService, ApiKeyManager apiKeyManager,
      Gson gson) {
    return new OpenAIProvider(openAiService, apiKeyManager, gson);
  }
}

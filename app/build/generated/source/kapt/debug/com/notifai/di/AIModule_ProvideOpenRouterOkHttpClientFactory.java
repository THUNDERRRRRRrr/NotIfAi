package com.notifai.di;

import com.notifai.ai.ApiKeyManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.notifai.di.OpenRouterRetrofit")
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
public final class AIModule_ProvideOpenRouterOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  public AIModule_ProvideOpenRouterOkHttpClientFactory(
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    this.apiKeyManagerProvider = apiKeyManagerProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOpenRouterOkHttpClient(apiKeyManagerProvider.get());
  }

  public static AIModule_ProvideOpenRouterOkHttpClientFactory create(
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    return new AIModule_ProvideOpenRouterOkHttpClientFactory(apiKeyManagerProvider);
  }

  public static OkHttpClient provideOpenRouterOkHttpClient(ApiKeyManager apiKeyManager) {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideOpenRouterOkHttpClient(apiKeyManager));
  }
}

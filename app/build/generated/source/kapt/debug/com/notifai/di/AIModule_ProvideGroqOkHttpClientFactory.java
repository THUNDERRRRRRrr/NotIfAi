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
@QualifierMetadata("com.notifai.di.GroqRetrofit")
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
public final class AIModule_ProvideGroqOkHttpClientFactory implements Factory<OkHttpClient> {
  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  public AIModule_ProvideGroqOkHttpClientFactory(Provider<ApiKeyManager> apiKeyManagerProvider) {
    this.apiKeyManagerProvider = apiKeyManagerProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideGroqOkHttpClient(apiKeyManagerProvider.get());
  }

  public static AIModule_ProvideGroqOkHttpClientFactory create(
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    return new AIModule_ProvideGroqOkHttpClientFactory(apiKeyManagerProvider);
  }

  public static OkHttpClient provideGroqOkHttpClient(ApiKeyManager apiKeyManager) {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideGroqOkHttpClient(apiKeyManager));
  }
}

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
@QualifierMetadata("javax.inject.Named")
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
public final class NetworkModule_ProvideGroqOkHttpFactory implements Factory<OkHttpClient> {
  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  public NetworkModule_ProvideGroqOkHttpFactory(Provider<ApiKeyManager> apiKeyManagerProvider) {
    this.apiKeyManagerProvider = apiKeyManagerProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideGroqOkHttp(apiKeyManagerProvider.get());
  }

  public static NetworkModule_ProvideGroqOkHttpFactory create(
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    return new NetworkModule_ProvideGroqOkHttpFactory(apiKeyManagerProvider);
  }

  public static OkHttpClient provideGroqOkHttp(ApiKeyManager apiKeyManager) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideGroqOkHttp(apiKeyManager));
  }
}

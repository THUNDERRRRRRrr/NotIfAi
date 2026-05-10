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
public final class NetworkModule_ProvideOpenRouterOkHttpFactory implements Factory<OkHttpClient> {
  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  public NetworkModule_ProvideOpenRouterOkHttpFactory(
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    this.apiKeyManagerProvider = apiKeyManagerProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOpenRouterOkHttp(apiKeyManagerProvider.get());
  }

  public static NetworkModule_ProvideOpenRouterOkHttpFactory create(
      Provider<ApiKeyManager> apiKeyManagerProvider) {
    return new NetworkModule_ProvideOpenRouterOkHttpFactory(apiKeyManagerProvider);
  }

  public static OkHttpClient provideOpenRouterOkHttp(ApiKeyManager apiKeyManager) {
    return Preconditions.checkNotNullFromProvides(NetworkModule.INSTANCE.provideOpenRouterOkHttp(apiKeyManager));
  }
}

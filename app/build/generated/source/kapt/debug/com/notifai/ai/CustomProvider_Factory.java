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
public final class CustomProvider_Factory implements Factory<CustomProvider> {
  private final Provider<CustomService> customServiceProvider;

  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  private final Provider<Gson> gsonProvider;

  public CustomProvider_Factory(Provider<CustomService> customServiceProvider,
      Provider<ApiKeyManager> apiKeyManagerProvider, Provider<Gson> gsonProvider) {
    this.customServiceProvider = customServiceProvider;
    this.apiKeyManagerProvider = apiKeyManagerProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public CustomProvider get() {
    return newInstance(customServiceProvider.get(), apiKeyManagerProvider.get(), gsonProvider.get());
  }

  public static CustomProvider_Factory create(Provider<CustomService> customServiceProvider,
      Provider<ApiKeyManager> apiKeyManagerProvider, Provider<Gson> gsonProvider) {
    return new CustomProvider_Factory(customServiceProvider, apiKeyManagerProvider, gsonProvider);
  }

  public static CustomProvider newInstance(CustomService customService, ApiKeyManager apiKeyManager,
      Gson gson) {
    return new CustomProvider(customService, apiKeyManager, gson);
  }
}

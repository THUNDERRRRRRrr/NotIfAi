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
public final class OpenRouterProvider_Factory implements Factory<OpenRouterProvider> {
  private final Provider<OpenRouterService> openRouterServiceProvider;

  private final Provider<Gson> gsonProvider;

  public OpenRouterProvider_Factory(Provider<OpenRouterService> openRouterServiceProvider,
      Provider<Gson> gsonProvider) {
    this.openRouterServiceProvider = openRouterServiceProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public OpenRouterProvider get() {
    return newInstance(openRouterServiceProvider.get(), gsonProvider.get());
  }

  public static OpenRouterProvider_Factory create(
      Provider<OpenRouterService> openRouterServiceProvider, Provider<Gson> gsonProvider) {
    return new OpenRouterProvider_Factory(openRouterServiceProvider, gsonProvider);
  }

  public static OpenRouterProvider newInstance(OpenRouterService openRouterService, Gson gson) {
    return new OpenRouterProvider(openRouterService, gson);
  }
}

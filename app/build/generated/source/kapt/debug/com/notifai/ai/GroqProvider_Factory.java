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
public final class GroqProvider_Factory implements Factory<GroqProvider> {
  private final Provider<GroqService> groqServiceProvider;

  private final Provider<Gson> gsonProvider;

  public GroqProvider_Factory(Provider<GroqService> groqServiceProvider,
      Provider<Gson> gsonProvider) {
    this.groqServiceProvider = groqServiceProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public GroqProvider get() {
    return newInstance(groqServiceProvider.get(), gsonProvider.get());
  }

  public static GroqProvider_Factory create(Provider<GroqService> groqServiceProvider,
      Provider<Gson> gsonProvider) {
    return new GroqProvider_Factory(groqServiceProvider, gsonProvider);
  }

  public static GroqProvider newInstance(GroqService groqService, Gson gson) {
    return new GroqProvider(groqService, gson);
  }
}

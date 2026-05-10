package com.notifai.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("com.notifai.di.GeminiRetrofit")
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
public final class AIModule_ProvideGeminiOkHttpClientFactory implements Factory<OkHttpClient> {
  @Override
  public OkHttpClient get() {
    return provideGeminiOkHttpClient();
  }

  public static AIModule_ProvideGeminiOkHttpClientFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static OkHttpClient provideGeminiOkHttpClient() {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideGeminiOkHttpClient());
  }

  private static final class InstanceHolder {
    private static final AIModule_ProvideGeminiOkHttpClientFactory INSTANCE = new AIModule_ProvideGeminiOkHttpClientFactory();
  }
}

package com.notifai.di;

import com.notifai.ai.OpenRouterService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AIModule_ProvideOpenRouterServiceFactory implements Factory<OpenRouterService> {
  private final Provider<Retrofit> retrofitProvider;

  public AIModule_ProvideOpenRouterServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public OpenRouterService get() {
    return provideOpenRouterService(retrofitProvider.get());
  }

  public static AIModule_ProvideOpenRouterServiceFactory create(
      Provider<Retrofit> retrofitProvider) {
    return new AIModule_ProvideOpenRouterServiceFactory(retrofitProvider);
  }

  public static OpenRouterService provideOpenRouterService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideOpenRouterService(retrofit));
  }
}

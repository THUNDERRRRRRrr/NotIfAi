package com.notifai.di;

import com.notifai.ai.GroqService;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AIModule_ProvideGroqServiceFactory implements Factory<GroqService> {
  private final Provider<Retrofit> retrofitProvider;

  public AIModule_ProvideGroqServiceFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public GroqService get() {
    return provideGroqService(retrofitProvider.get());
  }

  public static AIModule_ProvideGroqServiceFactory create(Provider<Retrofit> retrofitProvider) {
    return new AIModule_ProvideGroqServiceFactory(retrofitProvider);
  }

  public static GroqService provideGroqService(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AIModule.INSTANCE.provideGroqService(retrofit));
  }
}

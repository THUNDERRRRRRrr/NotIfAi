package com.notifai.ai;

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
public final class BlockingEngine_Factory implements Factory<BlockingEngine> {
  private final Provider<ApiKeyManager> apiKeyManagerProvider;

  public BlockingEngine_Factory(Provider<ApiKeyManager> apiKeyManagerProvider) {
    this.apiKeyManagerProvider = apiKeyManagerProvider;
  }

  @Override
  public BlockingEngine get() {
    return newInstance(apiKeyManagerProvider.get());
  }

  public static BlockingEngine_Factory create(Provider<ApiKeyManager> apiKeyManagerProvider) {
    return new BlockingEngine_Factory(apiKeyManagerProvider);
  }

  public static BlockingEngine newInstance(ApiKeyManager apiKeyManager) {
    return new BlockingEngine(apiKeyManager);
  }
}

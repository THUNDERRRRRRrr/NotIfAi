package com.notifai.security;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class ApiKeyManager_Factory implements Factory<ApiKeyManager> {
  @Override
  public ApiKeyManager get() {
    return newInstance();
  }

  public static ApiKeyManager_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ApiKeyManager newInstance() {
    return new ApiKeyManager();
  }

  private static final class InstanceHolder {
    private static final ApiKeyManager_Factory INSTANCE = new ApiKeyManager_Factory();
  }
}

package com.notifai.ui.apps;

import android.content.Context;
import com.notifai.data.repository.NotificationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AppSettingsViewModel_Factory implements Factory<AppSettingsViewModel> {
  private final Provider<NotificationRepository> repositoryProvider;

  private final Provider<Context> contextProvider;

  public AppSettingsViewModel_Factory(Provider<NotificationRepository> repositoryProvider,
      Provider<Context> contextProvider) {
    this.repositoryProvider = repositoryProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public AppSettingsViewModel get() {
    return newInstance(repositoryProvider.get(), contextProvider.get());
  }

  public static AppSettingsViewModel_Factory create(
      Provider<NotificationRepository> repositoryProvider, Provider<Context> contextProvider) {
    return new AppSettingsViewModel_Factory(repositoryProvider, contextProvider);
  }

  public static AppSettingsViewModel newInstance(NotificationRepository repository,
      Context context) {
    return new AppSettingsViewModel(repository, context);
  }
}

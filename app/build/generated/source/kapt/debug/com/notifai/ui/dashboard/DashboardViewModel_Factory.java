package com.notifai.ui.dashboard;

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
public final class DashboardViewModel_Factory implements Factory<DashboardViewModel> {
  private final Provider<NotificationRepository> repositoryProvider;

  private final Provider<Context> contextProvider;

  public DashboardViewModel_Factory(Provider<NotificationRepository> repositoryProvider,
      Provider<Context> contextProvider) {
    this.repositoryProvider = repositoryProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public DashboardViewModel get() {
    return newInstance(repositoryProvider.get(), contextProvider.get());
  }

  public static DashboardViewModel_Factory create(
      Provider<NotificationRepository> repositoryProvider, Provider<Context> contextProvider) {
    return new DashboardViewModel_Factory(repositoryProvider, contextProvider);
  }

  public static DashboardViewModel newInstance(NotificationRepository repository, Context context) {
    return new DashboardViewModel(repository, context);
  }
}

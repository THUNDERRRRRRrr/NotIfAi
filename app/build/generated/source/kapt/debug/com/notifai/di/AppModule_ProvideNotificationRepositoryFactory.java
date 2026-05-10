package com.notifai.di;

import com.notifai.data.db.NotificationDao;
import com.notifai.data.repository.NotificationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideNotificationRepositoryFactory implements Factory<NotificationRepository> {
  private final Provider<NotificationDao> daoProvider;

  public AppModule_ProvideNotificationRepositoryFactory(Provider<NotificationDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public NotificationRepository get() {
    return provideNotificationRepository(daoProvider.get());
  }

  public static AppModule_ProvideNotificationRepositoryFactory create(
      Provider<NotificationDao> daoProvider) {
    return new AppModule_ProvideNotificationRepositoryFactory(daoProvider);
  }

  public static NotificationRepository provideNotificationRepository(NotificationDao dao) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideNotificationRepository(dao));
  }
}

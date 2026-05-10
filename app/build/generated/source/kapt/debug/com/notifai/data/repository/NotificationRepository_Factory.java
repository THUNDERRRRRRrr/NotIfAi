package com.notifai.data.repository;

import com.notifai.data.db.NotificationDao;
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
public final class NotificationRepository_Factory implements Factory<NotificationRepository> {
  private final Provider<NotificationDao> daoProvider;

  public NotificationRepository_Factory(Provider<NotificationDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public NotificationRepository get() {
    return newInstance(daoProvider.get());
  }

  public static NotificationRepository_Factory create(Provider<NotificationDao> daoProvider) {
    return new NotificationRepository_Factory(daoProvider);
  }

  public static NotificationRepository newInstance(NotificationDao dao) {
    return new NotificationRepository(dao);
  }
}

package com.notifai.di;

import com.notifai.data.db.NotificationDao;
import com.notifai.data.db.NotificationDatabase;
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
public final class AppModule_ProvideNotificationDaoFactory implements Factory<NotificationDao> {
  private final Provider<NotificationDatabase> databaseProvider;

  public AppModule_ProvideNotificationDaoFactory(Provider<NotificationDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public NotificationDao get() {
    return provideNotificationDao(databaseProvider.get());
  }

  public static AppModule_ProvideNotificationDaoFactory create(
      Provider<NotificationDatabase> databaseProvider) {
    return new AppModule_ProvideNotificationDaoFactory(databaseProvider);
  }

  public static NotificationDao provideNotificationDao(NotificationDatabase database) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideNotificationDao(database));
  }
}

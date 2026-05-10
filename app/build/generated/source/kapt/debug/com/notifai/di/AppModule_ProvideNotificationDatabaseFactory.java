package com.notifai.di;

import android.content.Context;
import com.notifai.data.db.NotificationDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class AppModule_ProvideNotificationDatabaseFactory implements Factory<NotificationDatabase> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideNotificationDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public NotificationDatabase get() {
    return provideNotificationDatabase(contextProvider.get());
  }

  public static AppModule_ProvideNotificationDatabaseFactory create(
      Provider<Context> contextProvider) {
    return new AppModule_ProvideNotificationDatabaseFactory(contextProvider);
  }

  public static NotificationDatabase provideNotificationDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideNotificationDatabase(context));
  }
}

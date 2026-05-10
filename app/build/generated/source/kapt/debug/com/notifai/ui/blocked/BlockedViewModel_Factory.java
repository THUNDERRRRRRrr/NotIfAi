package com.notifai.ui.blocked;

import com.notifai.data.repository.NotificationRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class BlockedViewModel_Factory implements Factory<BlockedViewModel> {
  private final Provider<NotificationRepository> repositoryProvider;

  public BlockedViewModel_Factory(Provider<NotificationRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public BlockedViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static BlockedViewModel_Factory create(
      Provider<NotificationRepository> repositoryProvider) {
    return new BlockedViewModel_Factory(repositoryProvider);
  }

  public static BlockedViewModel newInstance(NotificationRepository repository) {
    return new BlockedViewModel(repository);
  }
}

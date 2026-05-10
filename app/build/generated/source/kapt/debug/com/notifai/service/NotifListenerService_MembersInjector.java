package com.notifai.service;

import com.notifai.ai.AIProviderManager;
import com.notifai.ai.BlockingEngine;
import com.notifai.data.repository.NotificationRepository;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class NotifListenerService_MembersInjector implements MembersInjector<NotifListenerService> {
  private final Provider<NotificationRepository> repositoryProvider;

  private final Provider<AIProviderManager> aiProviderManagerProvider;

  private final Provider<BlockingEngine> blockingEngineProvider;

  public NotifListenerService_MembersInjector(Provider<NotificationRepository> repositoryProvider,
      Provider<AIProviderManager> aiProviderManagerProvider,
      Provider<BlockingEngine> blockingEngineProvider) {
    this.repositoryProvider = repositoryProvider;
    this.aiProviderManagerProvider = aiProviderManagerProvider;
    this.blockingEngineProvider = blockingEngineProvider;
  }

  public static MembersInjector<NotifListenerService> create(
      Provider<NotificationRepository> repositoryProvider,
      Provider<AIProviderManager> aiProviderManagerProvider,
      Provider<BlockingEngine> blockingEngineProvider) {
    return new NotifListenerService_MembersInjector(repositoryProvider, aiProviderManagerProvider, blockingEngineProvider);
  }

  @Override
  public void injectMembers(NotifListenerService instance) {
    injectRepository(instance, repositoryProvider.get());
    injectAiProviderManager(instance, aiProviderManagerProvider.get());
    injectBlockingEngine(instance, blockingEngineProvider.get());
  }

  @InjectedFieldSignature("com.notifai.service.NotifListenerService.repository")
  public static void injectRepository(NotifListenerService instance,
      NotificationRepository repository) {
    instance.repository = repository;
  }

  @InjectedFieldSignature("com.notifai.service.NotifListenerService.aiProviderManager")
  public static void injectAiProviderManager(NotifListenerService instance,
      AIProviderManager aiProviderManager) {
    instance.aiProviderManager = aiProviderManager;
  }

  @InjectedFieldSignature("com.notifai.service.NotifListenerService.blockingEngine")
  public static void injectBlockingEngine(NotifListenerService instance,
      BlockingEngine blockingEngine) {
    instance.blockingEngine = blockingEngine;
  }
}

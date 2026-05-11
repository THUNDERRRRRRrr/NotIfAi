package com.notifai;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.gson.Gson;
import com.notifai.ai.AIProviderManager;
import com.notifai.ai.ApiKeyManager;
import com.notifai.ai.BlockingEngine;
import com.notifai.ai.GeminiProvider;
import com.notifai.ai.GeminiService;
import com.notifai.ai.GroqProvider;
import com.notifai.ai.GroqService;
import com.notifai.ai.OpenRouterProvider;
import com.notifai.ai.OpenRouterService;
import com.notifai.data.db.NotificationDao;
import com.notifai.data.db.NotificationDatabase;
import com.notifai.data.repository.NotificationRepository;
import com.notifai.di.AppModule_ProvideNotificationDaoFactory;
import com.notifai.di.AppModule_ProvideNotificationDatabaseFactory;
import com.notifai.di.AppModule_ProvideNotificationRepositoryFactory;
import com.notifai.di.NetworkModule_ProvideGeminiOkHttpFactory;
import com.notifai.di.NetworkModule_ProvideGeminiServiceFactory;
import com.notifai.di.NetworkModule_ProvideGroqOkHttpFactory;
import com.notifai.di.NetworkModule_ProvideGroqServiceFactory;
import com.notifai.di.NetworkModule_ProvideGsonFactory;
import com.notifai.di.NetworkModule_ProvideOpenRouterOkHttpFactory;
import com.notifai.di.NetworkModule_ProvideOpenRouterServiceFactory;
import com.notifai.service.NotifListenerService;
import com.notifai.service.NotifListenerService_MembersInjector;
import com.notifai.ui.apps.AppSettingsViewModel;
import com.notifai.ui.apps.AppSettingsViewModel_HiltModules;
import com.notifai.ui.blocked.BlockedViewModel;
import com.notifai.ui.blocked.BlockedViewModel_HiltModules;
import com.notifai.ui.dashboard.DashboardViewModel;
import com.notifai.ui.dashboard.DashboardViewModel_HiltModules;
import com.notifai.ui.onboarding.OnboardingViewModel;
import com.notifai.ui.onboarding.OnboardingViewModel_HiltModules;
import com.notifai.ui.settings.SettingsViewModel;
import com.notifai.ui.settings.SettingsViewModel_HiltModules;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;

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
public final class DaggerNotifAIApp_HiltComponents_SingletonC {
  private DaggerNotifAIApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public NotifAIApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements NotifAIApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public NotifAIApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements NotifAIApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public NotifAIApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements NotifAIApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public NotifAIApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements NotifAIApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public NotifAIApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements NotifAIApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public NotifAIApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements NotifAIApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public NotifAIApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements NotifAIApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public NotifAIApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends NotifAIApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends NotifAIApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends NotifAIApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends NotifAIApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(5).put(LazyClassKeyProvider.com_notifai_ui_apps_AppSettingsViewModel, AppSettingsViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_notifai_ui_blocked_BlockedViewModel, BlockedViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_notifai_ui_dashboard_DashboardViewModel, DashboardViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_notifai_ui_onboarding_OnboardingViewModel, OnboardingViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_notifai_ui_settings_SettingsViewModel, SettingsViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_notifai_ui_dashboard_DashboardViewModel = "com.notifai.ui.dashboard.DashboardViewModel";

      static String com_notifai_ui_settings_SettingsViewModel = "com.notifai.ui.settings.SettingsViewModel";

      static String com_notifai_ui_blocked_BlockedViewModel = "com.notifai.ui.blocked.BlockedViewModel";

      static String com_notifai_ui_apps_AppSettingsViewModel = "com.notifai.ui.apps.AppSettingsViewModel";

      static String com_notifai_ui_onboarding_OnboardingViewModel = "com.notifai.ui.onboarding.OnboardingViewModel";

      @KeepFieldType
      DashboardViewModel com_notifai_ui_dashboard_DashboardViewModel2;

      @KeepFieldType
      SettingsViewModel com_notifai_ui_settings_SettingsViewModel2;

      @KeepFieldType
      BlockedViewModel com_notifai_ui_blocked_BlockedViewModel2;

      @KeepFieldType
      AppSettingsViewModel com_notifai_ui_apps_AppSettingsViewModel2;

      @KeepFieldType
      OnboardingViewModel com_notifai_ui_onboarding_OnboardingViewModel2;
    }
  }

  private static final class ViewModelCImpl extends NotifAIApp_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AppSettingsViewModel> appSettingsViewModelProvider;

    private Provider<BlockedViewModel> blockedViewModelProvider;

    private Provider<DashboardViewModel> dashboardViewModelProvider;

    private Provider<OnboardingViewModel> onboardingViewModelProvider;

    private Provider<SettingsViewModel> settingsViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.appSettingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.blockedViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.dashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.onboardingViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.settingsViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(5).put(LazyClassKeyProvider.com_notifai_ui_apps_AppSettingsViewModel, ((Provider) appSettingsViewModelProvider)).put(LazyClassKeyProvider.com_notifai_ui_blocked_BlockedViewModel, ((Provider) blockedViewModelProvider)).put(LazyClassKeyProvider.com_notifai_ui_dashboard_DashboardViewModel, ((Provider) dashboardViewModelProvider)).put(LazyClassKeyProvider.com_notifai_ui_onboarding_OnboardingViewModel, ((Provider) onboardingViewModelProvider)).put(LazyClassKeyProvider.com_notifai_ui_settings_SettingsViewModel, ((Provider) settingsViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_notifai_ui_apps_AppSettingsViewModel = "com.notifai.ui.apps.AppSettingsViewModel";

      static String com_notifai_ui_blocked_BlockedViewModel = "com.notifai.ui.blocked.BlockedViewModel";

      static String com_notifai_ui_dashboard_DashboardViewModel = "com.notifai.ui.dashboard.DashboardViewModel";

      static String com_notifai_ui_settings_SettingsViewModel = "com.notifai.ui.settings.SettingsViewModel";

      static String com_notifai_ui_onboarding_OnboardingViewModel = "com.notifai.ui.onboarding.OnboardingViewModel";

      @KeepFieldType
      AppSettingsViewModel com_notifai_ui_apps_AppSettingsViewModel2;

      @KeepFieldType
      BlockedViewModel com_notifai_ui_blocked_BlockedViewModel2;

      @KeepFieldType
      DashboardViewModel com_notifai_ui_dashboard_DashboardViewModel2;

      @KeepFieldType
      SettingsViewModel com_notifai_ui_settings_SettingsViewModel2;

      @KeepFieldType
      OnboardingViewModel com_notifai_ui_onboarding_OnboardingViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.notifai.ui.apps.AppSettingsViewModel 
          return (T) new AppSettingsViewModel(singletonCImpl.provideNotificationRepositoryProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 1: // com.notifai.ui.blocked.BlockedViewModel 
          return (T) new BlockedViewModel(singletonCImpl.provideNotificationRepositoryProvider.get());

          case 2: // com.notifai.ui.dashboard.DashboardViewModel 
          return (T) new DashboardViewModel(singletonCImpl.provideNotificationRepositoryProvider.get(), singletonCImpl.aIProviderManagerProvider.get(), ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.notifai.ui.onboarding.OnboardingViewModel 
          return (T) new OnboardingViewModel(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.notifai.ui.settings.SettingsViewModel 
          return (T) new SettingsViewModel(singletonCImpl.apiKeyManagerProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends NotifAIApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends NotifAIApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }

    @Override
    public void injectNotifListenerService(NotifListenerService notifListenerService) {
      injectNotifListenerService2(notifListenerService);
    }

    @CanIgnoreReturnValue
    private NotifListenerService injectNotifListenerService2(NotifListenerService instance) {
      NotifListenerService_MembersInjector.injectRepository(instance, singletonCImpl.provideNotificationRepositoryProvider.get());
      NotifListenerService_MembersInjector.injectAiProviderManager(instance, singletonCImpl.aIProviderManagerProvider.get());
      NotifListenerService_MembersInjector.injectBlockingEngine(instance, singletonCImpl.blockingEngineProvider.get());
      return instance;
    }
  }

  private static final class SingletonCImpl extends NotifAIApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<NotificationDatabase> provideNotificationDatabaseProvider;

    private Provider<NotificationDao> provideNotificationDaoProvider;

    private Provider<NotificationRepository> provideNotificationRepositoryProvider;

    private Provider<ApiKeyManager> apiKeyManagerProvider;

    private Provider<OkHttpClient> provideGroqOkHttpProvider;

    private Provider<Gson> provideGsonProvider;

    private Provider<GroqService> provideGroqServiceProvider;

    private Provider<GroqProvider> groqProvider;

    private Provider<OkHttpClient> provideOpenRouterOkHttpProvider;

    private Provider<OpenRouterService> provideOpenRouterServiceProvider;

    private Provider<OpenRouterProvider> openRouterProvider;

    private Provider<OkHttpClient> provideGeminiOkHttpProvider;

    private Provider<GeminiService> provideGeminiServiceProvider;

    private Provider<GeminiProvider> geminiProvider;

    private Provider<AIProviderManager> aIProviderManagerProvider;

    private Provider<BlockingEngine> blockingEngineProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.provideNotificationDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<NotificationDatabase>(singletonCImpl, 2));
      this.provideNotificationDaoProvider = DoubleCheck.provider(new SwitchingProvider<NotificationDao>(singletonCImpl, 1));
      this.provideNotificationRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<NotificationRepository>(singletonCImpl, 0));
      this.apiKeyManagerProvider = DoubleCheck.provider(new SwitchingProvider<ApiKeyManager>(singletonCImpl, 7));
      this.provideGroqOkHttpProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 6));
      this.provideGsonProvider = DoubleCheck.provider(new SwitchingProvider<Gson>(singletonCImpl, 8));
      this.provideGroqServiceProvider = DoubleCheck.provider(new SwitchingProvider<GroqService>(singletonCImpl, 5));
      this.groqProvider = DoubleCheck.provider(new SwitchingProvider<GroqProvider>(singletonCImpl, 4));
      this.provideOpenRouterOkHttpProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 11));
      this.provideOpenRouterServiceProvider = DoubleCheck.provider(new SwitchingProvider<OpenRouterService>(singletonCImpl, 10));
      this.openRouterProvider = DoubleCheck.provider(new SwitchingProvider<OpenRouterProvider>(singletonCImpl, 9));
      this.provideGeminiOkHttpProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 14));
      this.provideGeminiServiceProvider = DoubleCheck.provider(new SwitchingProvider<GeminiService>(singletonCImpl, 13));
      this.geminiProvider = DoubleCheck.provider(new SwitchingProvider<GeminiProvider>(singletonCImpl, 12));
      this.aIProviderManagerProvider = DoubleCheck.provider(new SwitchingProvider<AIProviderManager>(singletonCImpl, 3));
      this.blockingEngineProvider = DoubleCheck.provider(new SwitchingProvider<BlockingEngine>(singletonCImpl, 15));
    }

    @Override
    public void injectNotifAIApp(NotifAIApp notifAIApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.notifai.data.repository.NotificationRepository 
          return (T) AppModule_ProvideNotificationRepositoryFactory.provideNotificationRepository(singletonCImpl.provideNotificationDaoProvider.get());

          case 1: // com.notifai.data.db.NotificationDao 
          return (T) AppModule_ProvideNotificationDaoFactory.provideNotificationDao(singletonCImpl.provideNotificationDatabaseProvider.get());

          case 2: // com.notifai.data.db.NotificationDatabase 
          return (T) AppModule_ProvideNotificationDatabaseFactory.provideNotificationDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 3: // com.notifai.ai.AIProviderManager 
          return (T) new AIProviderManager(singletonCImpl.groqProvider.get(), singletonCImpl.openRouterProvider.get(), singletonCImpl.geminiProvider.get(), singletonCImpl.apiKeyManagerProvider.get());

          case 4: // com.notifai.ai.GroqProvider 
          return (T) new GroqProvider(singletonCImpl.provideGroqServiceProvider.get(), singletonCImpl.apiKeyManagerProvider.get(), singletonCImpl.provideGsonProvider.get());

          case 5: // com.notifai.ai.GroqService 
          return (T) NetworkModule_ProvideGroqServiceFactory.provideGroqService(singletonCImpl.provideGroqOkHttpProvider.get(), singletonCImpl.provideGsonProvider.get());

          case 6: // @javax.inject.Named("groq") okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideGroqOkHttpFactory.provideGroqOkHttp(singletonCImpl.apiKeyManagerProvider.get());

          case 7: // com.notifai.ai.ApiKeyManager 
          return (T) new ApiKeyManager(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 8: // com.google.gson.Gson 
          return (T) NetworkModule_ProvideGsonFactory.provideGson();

          case 9: // com.notifai.ai.OpenRouterProvider 
          return (T) new OpenRouterProvider(singletonCImpl.provideOpenRouterServiceProvider.get(), singletonCImpl.apiKeyManagerProvider.get(), singletonCImpl.provideGsonProvider.get());

          case 10: // com.notifai.ai.OpenRouterService 
          return (T) NetworkModule_ProvideOpenRouterServiceFactory.provideOpenRouterService(singletonCImpl.provideOpenRouterOkHttpProvider.get(), singletonCImpl.provideGsonProvider.get());

          case 11: // @javax.inject.Named("openrouter") okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideOpenRouterOkHttpFactory.provideOpenRouterOkHttp(singletonCImpl.apiKeyManagerProvider.get());

          case 12: // com.notifai.ai.GeminiProvider 
          return (T) new GeminiProvider(singletonCImpl.provideGeminiServiceProvider.get(), singletonCImpl.apiKeyManagerProvider.get(), singletonCImpl.provideGsonProvider.get());

          case 13: // com.notifai.ai.GeminiService 
          return (T) NetworkModule_ProvideGeminiServiceFactory.provideGeminiService(singletonCImpl.provideGeminiOkHttpProvider.get(), singletonCImpl.provideGsonProvider.get());

          case 14: // @javax.inject.Named("gemini") okhttp3.OkHttpClient 
          return (T) NetworkModule_ProvideGeminiOkHttpFactory.provideGeminiOkHttp();

          case 15: // com.notifai.ai.BlockingEngine 
          return (T) new BlockingEngine(singletonCImpl.apiKeyManagerProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }
}

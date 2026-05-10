package com.notifai.util;

import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.ExperimentalCoroutinesApi;
import kotlinx.coroutines.test.TestDispatcher;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014J\u0010\u0010\t\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/notifai/util/MainDispatcherRule;", "Lorg/junit/rules/TestWatcher;", "testDispatcher", "Lkotlinx/coroutines/test/TestDispatcher;", "(Lkotlinx/coroutines/test/TestDispatcher;)V", "finished", "", "description", "Lorg/junit/runner/Description;", "starting", "app_debugUnitTest"})
@kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
public final class MainDispatcherRule extends org.junit.rules.TestWatcher {
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.test.TestDispatcher testDispatcher = null;
    
    public MainDispatcherRule(@org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.test.TestDispatcher testDispatcher) {
        super();
    }
    
    @java.lang.Override()
    protected void starting(@org.jetbrains.annotations.NotNull()
    org.junit.runner.Description description) {
    }
    
    @java.lang.Override()
    protected void finished(@org.jetbrains.annotations.NotNull()
    org.junit.runner.Description description) {
    }
    
    public MainDispatcherRule() {
        super();
    }
}
package com.notifai.ui.apps;

/**
 * Per-app override for the notification filter.
 *
 * - [AUTO]         — let the AI decide (default)
 * - [ALWAYS_ALLOW] — never block notifications from this app
 * - [ALWAYS_BLOCK] — always block notifications from this app
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u0000 \u00062\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0006B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005\u00a8\u0006\u0007"}, d2 = {"Lcom/notifai/ui/apps/AppMode;", "", "(Ljava/lang/String;I)V", "AUTO", "ALWAYS_ALLOW", "ALWAYS_BLOCK", "Companion", "app_debug"})
public enum AppMode {
    /*public static final*/ AUTO /* = new AUTO() */,
    /*public static final*/ ALWAYS_ALLOW /* = new ALWAYS_ALLOW() */,
    /*public static final*/ ALWAYS_BLOCK /* = new ALWAYS_BLOCK() */;
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.ui.apps.AppMode.Companion Companion = null;
    
    AppMode() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.notifai.ui.apps.AppMode> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/notifai/ui/apps/AppMode$Companion;", "", "()V", "fromString", "Lcom/notifai/ui/apps/AppMode;", "value", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.notifai.ui.apps.AppMode fromString(@org.jetbrains.annotations.Nullable()
        java.lang.String value) {
            return null;
        }
    }
}
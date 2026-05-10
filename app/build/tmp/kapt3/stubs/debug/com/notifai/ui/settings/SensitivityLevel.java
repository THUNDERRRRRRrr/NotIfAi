package com.notifai.ui.settings;

/**
 * Controls how aggressively NotifAI blocks notifications.
 *
 * - [AGGRESSIVE] — block anything with confidence ≥ 0.6
 * - [BALANCED]   — block anything with confidence ≥ 0.8  (default)
 * - [RELAXED]    — block only high-certainty spam/phishing (confidence ≥ 0.93)
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\u000b"}, d2 = {"Lcom/notifai/ui/settings/SensitivityLevel;", "", "(Ljava/lang/String;I)V", "confidenceThreshold", "", "getConfidenceThreshold", "()F", "AGGRESSIVE", "BALANCED", "RELAXED", "Companion", "app_debug"})
public enum SensitivityLevel {
    /*public static final*/ AGGRESSIVE /* = new AGGRESSIVE() */,
    /*public static final*/ BALANCED /* = new BALANCED() */,
    /*public static final*/ RELAXED /* = new RELAXED() */;
    @org.jetbrains.annotations.NotNull()
    private static final com.notifai.ui.settings.SensitivityLevel DEFAULT = com.notifai.ui.settings.SensitivityLevel.BALANCED;
    @org.jetbrains.annotations.NotNull()
    public static final com.notifai.ui.settings.SensitivityLevel.Companion Companion = null;
    
    SensitivityLevel() {
    }
    
    public final float getConfidenceThreshold() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.notifai.ui.settings.SensitivityLevel> getEntries() {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\tR\u0011\u0010\u0003\u001a\u00020\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\n"}, d2 = {"Lcom/notifai/ui/settings/SensitivityLevel$Companion;", "", "()V", "DEFAULT", "Lcom/notifai/ui/settings/SensitivityLevel;", "getDEFAULT", "()Lcom/notifai/ui/settings/SensitivityLevel;", "fromString", "value", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.notifai.ui.settings.SensitivityLevel getDEFAULT() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.notifai.ui.settings.SensitivityLevel fromString(@org.jetbrains.annotations.Nullable()
        java.lang.String value) {
            return null;
        }
    }
}
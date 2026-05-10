package com.notifai.data.model;

/**
 * AI-assigned category for a notification.
 * Stored as its [name] string in Room via [CategoryConverter].
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\t\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t\u00a8\u0006\n"}, d2 = {"Lcom/notifai/data/model/Category;", "", "(Ljava/lang/String;I)V", "OTP", "DELIVERY", "PROMOTIONAL", "SPAM", "PHISHING", "IMPORTANT", "UNKNOWN", "app_debug"})
public enum Category {
    /*public static final*/ OTP /* = new OTP() */,
    /*public static final*/ DELIVERY /* = new DELIVERY() */,
    /*public static final*/ PROMOTIONAL /* = new PROMOTIONAL() */,
    /*public static final*/ SPAM /* = new SPAM() */,
    /*public static final*/ PHISHING /* = new PHISHING() */,
    /*public static final*/ IMPORTANT /* = new IMPORTANT() */,
    /*public static final*/ UNKNOWN /* = new UNKNOWN() */;
    
    Category() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.notifai.data.model.Category> getEntries() {
        return null;
    }
}
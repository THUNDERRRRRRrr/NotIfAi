package com.notifai.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Represents the JSON payload returned by any AI provider after classifying
 * a notification.
 *
 * Expected JSON shape:
 * ```json
 * {
 *  "category":    "OTP",
 *  "confidence":  0.97,
 *  "reason":      "Contains a 6-digit one-time password.",
 *  "shouldBlock": false
 * }
 * ```
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BC\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u00c6\u0003JO\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000bH\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010 \u001a\u00020!H\u00d6\u0001J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u001e\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u000b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006#"}, d2 = {"Lcom/notifai/data/model/AIResponse;", "", "category", "", "confidence", "", "reason", "shouldBlock", "", "senderVerdict", "redFlags", "", "(Ljava/lang/String;FLjava/lang/String;ZLjava/lang/String;Ljava/util/List;)V", "getCategory", "()Ljava/lang/String;", "getConfidence", "()F", "getReason", "getRedFlags", "()Ljava/util/List;", "getSenderVerdict", "getShouldBlock", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class AIResponse {
    @com.google.gson.annotations.SerializedName(value = "category")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String category = null;
    @com.google.gson.annotations.SerializedName(value = "confidence")
    private final float confidence = 0.0F;
    @com.google.gson.annotations.SerializedName(value = "reason")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String reason = null;
    @com.google.gson.annotations.SerializedName(value = "shouldBlock", alternate = {"should_block"})
    private final boolean shouldBlock = false;
    @com.google.gson.annotations.SerializedName(value = "senderVerdict")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String senderVerdict = null;
    @com.google.gson.annotations.SerializedName(value = "redFlags")
    @org.jetbrains.annotations.Nullable()
    private final java.util.List<java.lang.String> redFlags = null;
    
    public AIResponse(@org.jetbrains.annotations.NotNull()
    java.lang.String category, float confidence, @org.jetbrains.annotations.NotNull()
    java.lang.String reason, boolean shouldBlock, @org.jetbrains.annotations.Nullable()
    java.lang.String senderVerdict, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> redFlags) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCategory() {
        return null;
    }
    
    public final float getConfidence() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getReason() {
        return null;
    }
    
    public final boolean getShouldBlock() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getSenderVerdict() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> getRedFlags() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final float component2() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.util.List<java.lang.String> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.data.model.AIResponse copy(@org.jetbrains.annotations.NotNull()
    java.lang.String category, float confidence, @org.jetbrains.annotations.NotNull()
    java.lang.String reason, boolean shouldBlock, @org.jetbrains.annotations.Nullable()
    java.lang.String senderVerdict, @org.jetbrains.annotations.Nullable()
    java.util.List<java.lang.String> redFlags) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}
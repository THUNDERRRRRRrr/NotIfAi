package com.notifai.ai.model;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J1\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/notifai/ai/model/GeminiRequest;", "", "systemInstruction", "Lcom/notifai/ai/model/GeminiContent;", "contents", "", "generationConfig", "Lcom/notifai/ai/model/GeminiGenerationConfig;", "(Lcom/notifai/ai/model/GeminiContent;Ljava/util/List;Lcom/notifai/ai/model/GeminiGenerationConfig;)V", "getContents", "()Ljava/util/List;", "getGenerationConfig", "()Lcom/notifai/ai/model/GeminiGenerationConfig;", "getSystemInstruction", "()Lcom/notifai/ai/model/GeminiContent;", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class GeminiRequest {
    @com.google.gson.annotations.SerializedName(value = "systemInstruction")
    @org.jetbrains.annotations.Nullable()
    private final com.notifai.ai.model.GeminiContent systemInstruction = null;
    @com.google.gson.annotations.SerializedName(value = "contents")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.notifai.ai.model.GeminiContent> contents = null;
    @com.google.gson.annotations.SerializedName(value = "generationConfig")
    @org.jetbrains.annotations.Nullable()
    private final com.notifai.ai.model.GeminiGenerationConfig generationConfig = null;
    
    public GeminiRequest(@org.jetbrains.annotations.Nullable()
    com.notifai.ai.model.GeminiContent systemInstruction, @org.jetbrains.annotations.NotNull()
    java.util.List<com.notifai.ai.model.GeminiContent> contents, @org.jetbrains.annotations.Nullable()
    com.notifai.ai.model.GeminiGenerationConfig generationConfig) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.notifai.ai.model.GeminiContent getSystemInstruction() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.notifai.ai.model.GeminiContent> getContents() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.notifai.ai.model.GeminiGenerationConfig getGenerationConfig() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.notifai.ai.model.GeminiContent component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.notifai.ai.model.GeminiContent> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.notifai.ai.model.GeminiGenerationConfig component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.model.GeminiRequest copy(@org.jetbrains.annotations.Nullable()
    com.notifai.ai.model.GeminiContent systemInstruction, @org.jetbrains.annotations.NotNull()
    java.util.List<com.notifai.ai.model.GeminiContent> contents, @org.jetbrains.annotations.Nullable()
    com.notifai.ai.model.GeminiGenerationConfig generationConfig) {
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
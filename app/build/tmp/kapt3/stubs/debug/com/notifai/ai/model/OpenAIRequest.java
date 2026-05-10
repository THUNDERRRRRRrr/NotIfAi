package com.notifai.ai.model;

import com.google.gson.annotations.SerializedName;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0015\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0010\u0010\u0018\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010\u0013J@\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001\u00a2\u0006\u0002\u0010\u001aJ\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001e\u001a\u00020\u001fH\u00d6\u0001J\t\u0010 \u001a\u00020\u0003H\u00d6\u0001R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004\u00a2\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006!"}, d2 = {"Lcom/notifai/ai/model/OpenAIRequest;", "", "model", "", "messages", "", "Lcom/notifai/ai/model/OpenAIMessage;", "responseFormat", "Lcom/notifai/ai/model/ResponseFormat;", "temperature", "", "(Ljava/lang/String;Ljava/util/List;Lcom/notifai/ai/model/ResponseFormat;Ljava/lang/Float;)V", "getMessages", "()Ljava/util/List;", "getModel", "()Ljava/lang/String;", "getResponseFormat", "()Lcom/notifai/ai/model/ResponseFormat;", "getTemperature", "()Ljava/lang/Float;", "Ljava/lang/Float;", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/util/List;Lcom/notifai/ai/model/ResponseFormat;Ljava/lang/Float;)Lcom/notifai/ai/model/OpenAIRequest;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class OpenAIRequest {
    @com.google.gson.annotations.SerializedName(value = "model")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String model = null;
    @com.google.gson.annotations.SerializedName(value = "messages")
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.notifai.ai.model.OpenAIMessage> messages = null;
    @com.google.gson.annotations.SerializedName(value = "response_format")
    @org.jetbrains.annotations.Nullable()
    private final com.notifai.ai.model.ResponseFormat responseFormat = null;
    @com.google.gson.annotations.SerializedName(value = "temperature")
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Float temperature = null;
    
    public OpenAIRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.util.List<com.notifai.ai.model.OpenAIMessage> messages, @org.jetbrains.annotations.Nullable()
    com.notifai.ai.model.ResponseFormat responseFormat, @org.jetbrains.annotations.Nullable()
    java.lang.Float temperature) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.notifai.ai.model.OpenAIMessage> getMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.notifai.ai.model.ResponseFormat getResponseFormat() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float getTemperature() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.notifai.ai.model.OpenAIMessage> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.notifai.ai.model.ResponseFormat component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Float component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.notifai.ai.model.OpenAIRequest copy(@org.jetbrains.annotations.NotNull()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.util.List<com.notifai.ai.model.OpenAIMessage> messages, @org.jetbrains.annotations.Nullable()
    com.notifai.ai.model.ResponseFormat responseFormat, @org.jetbrains.annotations.Nullable()
    java.lang.Float temperature) {
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
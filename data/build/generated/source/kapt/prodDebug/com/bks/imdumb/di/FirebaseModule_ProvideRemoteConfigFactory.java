package com.bks.imdumb.di;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
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
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class FirebaseModule_ProvideRemoteConfigFactory implements Factory<FirebaseRemoteConfig> {
  @Override
  public FirebaseRemoteConfig get() {
    return provideRemoteConfig();
  }

  public static FirebaseModule_ProvideRemoteConfigFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FirebaseRemoteConfig provideRemoteConfig() {
    return Preconditions.checkNotNullFromProvides(FirebaseModule.INSTANCE.provideRemoteConfig());
  }

  private static final class InstanceHolder {
    static final FirebaseModule_ProvideRemoteConfigFactory INSTANCE = new FirebaseModule_ProvideRemoteConfigFactory();
  }
}

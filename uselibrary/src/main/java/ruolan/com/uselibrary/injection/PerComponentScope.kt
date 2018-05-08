package ruolan.com.uselibrary.injection


import java.lang.annotation.Retention
import java.lang.annotation.RetentionPolicy
import javax.inject.Scope

@Suppress("DEPRECATED_JAVA_ANNOTATION")
@Scope
@Retention(RetentionPolicy.RUNTIME)
annotation class PerComponentScope
package org.cru.give.cdi.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.inject.Qualifier;


@Target(value=ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Mock
{

}

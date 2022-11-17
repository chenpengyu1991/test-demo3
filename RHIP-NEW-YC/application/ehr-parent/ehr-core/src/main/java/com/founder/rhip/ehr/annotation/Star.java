package com.founder.rhip.ehr.annotation;

import com.founder.rhip.ehr.common.StarType;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface Star {
    StarType star();
}

package com.founder.rhip.ehr.annotation;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Documented
@Target(ElementType.FIELD)
public @interface RecordTrace {
    //是否是字典类型（字典类型需要根据字典内容获取字典值）
    public abstract boolean isDic() default false;

    //字典类型代码
    public abstract String dictCode() default "";

    //是否是备注信息
    public abstract boolean isCommemt() default false;
}

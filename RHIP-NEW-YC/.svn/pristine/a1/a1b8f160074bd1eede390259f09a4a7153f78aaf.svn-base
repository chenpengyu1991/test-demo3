package com.founder.rhip.ehr.service.export;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * 列表导出单元格定义注解
 * @author liuk
 *
 */
@Retention(RUNTIME)
@Target({ FIELD })
public @interface Item {
	public String column();

	public int index() default Integer.MAX_VALUE;
	
	public boolean isDic() default false;

	public boolean isNumber() default false;

	public boolean isDate() default false;

	public boolean isOrganization() default false;

	public boolean isUser() default false;
	
	public boolean isStaff() default false;

	public boolean isMultiple() default false;

	public String dicType() default "";
	
	public String dicMap() default "";

	public String code() default "";

	public String datePattern() default "yyyy/MM/dd";

	public String numberPattern() default "";
	
	public String nullValue() default "";

}

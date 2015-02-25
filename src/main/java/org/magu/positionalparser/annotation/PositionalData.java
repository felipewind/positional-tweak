package org.magu.positionalparser.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation to be applied on POJOs fields which will receive data conversion.
 * 
 * @author Márcio Gurgel (marcio.rga@gmail.com)
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface PositionalData {

    /**
     * Position <i>(or identifier)</i> for a field. May be unique.
     */
    int position();
    
    /**
     * The legth is defined by another field.
     */
    int lengthPosition() default 0;
    
    /**
     * Field's <b>length</b>.
     */
    int length() default 1;
    
    /**
     * To be applied on fields where precision is relevant (eg. BigDecimal).
     */
    int precision() default 0;
  
    /**
     * Pattern to be applied on field's value, useful in date conversions.
     */
    String pattern() default "";
    
    /**
     * Indicates if the value should recieve {@link String#trim()} function.
     */
    boolean trim() default false;

}

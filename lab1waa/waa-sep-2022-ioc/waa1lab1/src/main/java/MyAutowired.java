import org.springframework.beans.factory.annotation.Autowired;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
public @interface MyAutowired {
    public String scan() default "";
    public String addIncludeFilter() default "";
}

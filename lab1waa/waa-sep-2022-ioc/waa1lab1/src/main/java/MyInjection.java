//import jdk.internal.icu.impl.UBiDiProps;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.ClassPathScanningCandidateComponentProvider;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

//import static jdk.javadoc.internal.doclets.formats.html.markup.HtmlStyle.packages;


public class MyInjection {
    private Map<Class,Object> Container =new HashMap<>();

    void  scanforbeens(){
        ClassPathScanningCandidateComponentProvider scanner =
                new ClassPathScanningCandidateComponentProvider(false);
        //new filter
        scanner.addIncludeFilter(new AnnotationTypeFilter(AtMyBean.class));
        //scan packages

        return Arrays.stream(packages)
                .map(scanner::findCandidateComponents)
                .flatMap(Collection::stream)
                .map(BeanDefinition::getBeanClassName)
                .map(name -> {
                    try {
                        return Class.forName(name);
                    }
                    catch (ClassNotFoundException e) {
                        //handle exception
                    }
                }).collect(Collectors.toList());

    }
void scanforAutowired(){
    ClassPathScanningCandidateComponentProvider scanner =
            new ClassPathScanningCandidateComponentProvider(false);
    //new filter
    scanner.addIncludeFilter(new AnnotationTypeFilter(MyAutowired.class));
    //scan packages

    return Arrays.stream(packages)
            .map(scanner::findCandidateComponents)
            .flatMap(Collection::stream)
            .map(BeanDefinition::getBeanClassName)
            .map(name -> {
                try {
                    return Class.forName(name);
                }
                catch (ClassNotFoundException e) {
                    //handle exception
                }
            }).collect(Collectors.toList());

}
}


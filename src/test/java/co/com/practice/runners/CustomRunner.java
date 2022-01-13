package co.com.practice.runners;

import co.com.practice.utils.exceldata.BeforeSuite;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.RunNotifier;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
* Personalización del Runner con el cual se puede determinar que busque y modifique los .feature antes de ser ejecutados
* @since 27/11/2017
*/
public class CustomRunner extends Runner {
       /**
        * private Class<Cucumber> classValue;
       private Cucumber cucumber;*/

        private Class<CucumberWithSerenity> classValue;
       private CucumberWithSerenity cucumberWithSerenity;
       
        
        public CustomRunner(Class<CucumberWithSerenity> classValue) throws Exception {
               this.classValue = classValue;
               cucumberWithSerenity = new CucumberWithSerenity(classValue);
           }
       
         @Override
           public Description getDescription() {
               return cucumberWithSerenity.getDescription();
           }
         
         private void runAnnotatedMethods(Class<?> annotation) throws Exception {
               if (!annotation.isAnnotation()) {
                   return;
               }
               Method[] methods = this.classValue.getMethods();
               for (Method method : methods) {
                   Annotation[] annotations = method.getAnnotations();
                   for (Annotation item : annotations) {
                       if (item.annotationType().equals(annotation)) {
                           method.invoke(null);
                           break;
                       }
                   }
               }
         }
         
         @Override
           public void run(RunNotifier notifier) {
               try {
                   runAnnotatedMethods(BeforeSuite.class);
                   cucumberWithSerenity = new CucumberWithSerenity(classValue);
               } catch (Exception e) {
                   e.printStackTrace();
               }
               cucumberWithSerenity.run(notifier);
           }
}
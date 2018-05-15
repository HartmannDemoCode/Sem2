/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *
 * @author tha
 * Annotations came to java in version 1.5
 * They can be used at compile time and at runtime (by use of java Reflection) to configure a Class, Method or Variable. 
 * Annotations uses the @-character to communicate with
 * Custom annotations are made with @interface() and must be annotated with @Target and @Retention
 * Additional annotations to put on @interface is: @Documented (saying that javadoc is available) and @Inherited (means the annotation can be applied to subtypes as well)
 */
@Target(ElementType.TYPE) //This means that this annotation will be used as a class annotation (not method or field)
@Retention(RetentionPolicy.RUNTIME) //This means that this annotation will be used at runtime (not compile or .class situation)
@interface Eatable{
    String category() default "Healthy";
    String color();
}
@Eatable(color="multiple")
class Fruit{
    private String name;
    private int calories;
    private String color;

    public Fruit(String name, int calories, String color) {
        this.name = name;
        this.calories = calories;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Fruit{" + "name=" + name + ", calories=" + calories + ", color=" + color + '}';
    }
    
}
public class AnnotationDemo {
    public static void main(String[] args) {
        Fruit fruit = new Fruit("Banana", 100, "Yellow");
        Annotation annotation = fruit.getClass().getAnnotation(Eatable.class);
        Eatable eatable = (Eatable)annotation;
        System.out.println(fruit + " annotations: "+eatable.category());
    }
}

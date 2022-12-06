import com.sun.jdi.InvocationException;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ReflectionClass {
    public void reflect(Object object) throws InvocationTargetException, IllegalAccessException {
        try {
            for (Method method : object.getClass().getDeclaredMethods()) {
                // по заданию необходимо воспроизвести только
                // аннотированные защищенные и аннотированные приватные методы
                if (Modifier.isPublic(method.getModifiers()) || !(method.isAnnotationPresent(RepeatedAnnotation.class))) {
                    continue;
                }

                method.setAccessible(true);
                int counter = method.getAnnotation(RepeatedAnnotation.class).repeatNum();
                for (int i = 0; i < counter; ++i) {
                    String fmt = "%s | method type: %s\n";
                    System.out.format(fmt, (String) method.invoke(object), Modifier.toString(method.getModifiers()));
                }
                method.setAccessible(false);
            }
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Problem in reflection class");
        }

    }
}

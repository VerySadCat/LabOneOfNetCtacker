package injector;

import org.apache.log4j.Logger;
import parser.Parser;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;

public class InjectorLastLab {

    private static final Logger logger = Logger.getLogger(InjectorLastLab.class.getName());
    public <T> void Injector(T object) {
            T obj = null;
            try {
                Class<?> aClass = object.getClass();
                Field[] field = aClass.getDeclaredFields(); // возвращает массив полей
                for (Field f : field) {
                    if (f.isAnnotationPresent(Injector.class)) {
                        f.setAccessible(true);
                        Class cl = Class.forName(classNameSearch(f.getType().getName()));
                        obj = (T) cl;
                        f.set(object, obj);
                    }
                }
            } catch (Exception e) {
                logger.fatal("Injector can't work");
                System.out.println(e);
            }

        }

        private String classNameSearch(String inputFieldType){
            Parser file = new Parser();
            Map<String, String> map = file.readFileAnnotation();
            Iterator<Map.Entry<String, String>> itr = map.entrySet().iterator();
            boolean flag = true;
            String nameOfClass = null;
            while (itr.hasNext() && flag) {
                Map.Entry<String, String> next = itr.next();
                String n = next.getValue();
                if (n.equals(inputFieldType)) {
                    nameOfClass = next.getKey();
                    flag = false;
                }
            }
            return nameOfClass;
        }
    }


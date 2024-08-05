package kz.segizbay;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main( String[] args ) throws Exception {
        System.out.println(prepareCreateTableSQL(User.class));
    }

    //CREATE TABLE cats (id INTEGER, name TEXT);
    private static String prepareCreateTableSQL(Class cl){
        if (!cl.isAnnotationPresent(AppTable.class)){
            throw new IllegalArgumentException("Класс не предназначен для генерации create table");
        }
        Map<Class, String> typeMap = new HashMap<Class, String>();
        typeMap.put(String.class, "TEXT");
        typeMap.put(int.class, "INTEGER");
        //CREATE TABLE
        StringBuilder builder = new StringBuilder("CREATE TABLE ");
        // CREATE TABLE cats (
        builder.append(((AppTable)cl.getAnnotation(AppTable.class)).title())
                .append(" (");

        Field[] fields = cl.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(AppField.class)){
                builder.append(field.getName()).append(" ").append(typeMap.get(field.getType())).append(", ");
            }
        }
        // CREATE TABLE cats(id INTEGER, name TEXT,
        builder.setLength(builder.length() - 2);
        // CREATE TABLE cats(id INTEGER, name TEXT
        builder.append(");");
        return builder.toString();
    }
}

package com.moonlight.algorithm.assist.helper;

import javassist.*;

import java.lang.reflect.Field;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName HelperFactory
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/6/26 14:09
 * @Version V1.0
 **/
public class HelperFactory {
    private static final Map<Class<?>, AbstractHelper> helperCacheMap = new HashMap<>();


    public static AbstractHelper getEntityHelper(Class<?> entityClass) throws Exception {
        if (entityClass == null) {
            return null;
        }

        AbstractHelper helper = helperCacheMap.get(entityClass);

        if (helper != null) {
            return helper;
        }

        /* 使用 Javassist 动态生成 Java 字节码 */

        // 1.获取类池
        ClassPool pool = ClassPool.getDefault();
        pool.appendSystemPath();
        // 2.导入相关类
        // 此处后续会生成如下代码：
        // import java.sql.ResultSet
        // import com.moonlight.algorithm.assist.entity.User
        pool.importPackage(ResultSet.class.getName());
        pool.importPackage(entityClass.getName());
        // 3.获取一个ctClass对象
        // 所谓的CtClass 就是指一个Class，CtClass 就是指 compile-time class
        CtClass abstractHelperClass = pool.getCtClass(AbstractHelper.class.getName());
        // 4.动态创建一个类，此处将会生成如下类：
        // public class UserHelper extends AbstractHelper { ... }
        String helperImplClazzName = entityClass.getName() + "Helper";
        CtClass helperClass = pool.makeClass(helperImplClazzName, abstractHelperClass);
        // 5.为动态创建的类创建构造器，此处会生成如下方法：
        // public UserHelper() {}
        CtConstructor constructor = new CtConstructor(new CtClass[0], helperClass);
        // 5.1.设置方法体
        constructor.setBody("{}");
        // 5.2.添加默认构造器
        helperClass.addConstructor(constructor);
        // 6.拼接实现方法
        StringBuilder createMethodStr = new StringBuilder();
        createMethodStr.append("public Object create(java.sql.ResultSet rs) throws Exception {\n");
        createMethodStr.append(entityClass.getName())
                .append(" obj = new ")
                .append(entityClass.getName())
                .append("();\n");
        // 6.1.获取类的字段，并进行拼接
        Field[] fields = entityClass.getDeclaredFields();
        for (Field field : fields) {
            if (field == null) {
                continue;
            }
            CastColumn castColumn = field.getAnnotation(CastColumn.class);
            if (castColumn == null) {
                continue;
            }
            String colName = castColumn.name();
            String setMethodName = castColumn.setMethodName();

            if (field.getType() == Integer.TYPE) {
                // 生成如下代码 :
                // obj.setId(rs.getInt("id"));
                createMethodStr.append("obj.")
                        .append(setMethodName)
                        .append("(")
                        .append("rs.getInt(\"")
                        .append(colName)
                        .append("\"));\n");
            } else if (field.getType().equals(String.class)) {
                // 生成如下代码 :
                // obj.setName(rs.getString("name"));
                createMethodStr.append("obj.")
                        .append(setMethodName)
                        .append("(")
                        .append("rs.getString(\"")
                        .append(colName)
                        .append("\"));\n");
            } else {
                System.out.println("未知类型，处理不了。");
            }

        }

        createMethodStr.append("return obj;\n");
        createMethodStr.append("}");

        // 6.2.创建方法
        CtMethod cm = CtNewMethod.make(createMethodStr.toString(), helperClass);
        // 6.3.设置方法
        helperClass.addMethod(cm);
        //helperClass.writeFile("D:\moonlight\java");
        // 7.获取类Class，并获取实例，设置到缓存中
        Class<?> javaClazz = helperClass.toClass();

        helper = (AbstractHelper) javaClazz.newInstance();

        helperCacheMap.put(entityClass, helper);

        return helper;
    }

}

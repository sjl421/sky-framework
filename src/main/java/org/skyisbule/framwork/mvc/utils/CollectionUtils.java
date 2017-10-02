package org.skyisbule.framwork.mvc.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skyisbule on 2017/10/1.
 */
public class CollectionUtils {
    public static <T> List<T> arrayToList(T[] arr)
    {
        List<T> list=new ArrayList<T>();
        for(T t:arr)
        {
            list.add(t);
        }
        return list;
    }

    public static List<String> classArrToStringList(Class<?>[] classArr)
    {
        List<String> list=new ArrayList<String>();
        for(Class<?> clazz:classArr)
        {
            list.add(clazz.getName());
        }
        return list;
    }
}

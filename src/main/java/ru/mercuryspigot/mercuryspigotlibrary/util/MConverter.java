package ru.mercuryspigot.mercuryspigotlibrary.util;

import java.lang.reflect.Array;
import java.util.List;

public class MConverter {

    public static <T> T[] listToArray(List<T> l, Class<T> type) {
        if (l == null) return null;
        try {
            T[] arr = (T[]) Array.newInstance(type, l.size());
            for (int i = 0; i < l.size(); i++) arr[i] = l.get(i);
            return arr;
        }
        catch (Exception e) {
            return null;
        }
    }
}

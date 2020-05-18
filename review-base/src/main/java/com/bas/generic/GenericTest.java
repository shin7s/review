package com.bas.generic;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 泛型
 * extends
 * super
 */
public class GenericTest {

    public static <T extends Number & Comparable<? super T>> T min(T[] values) {
        if (values == null) return null;
        T m = values[0];
        for (int i = 1; i < values.length; i++) {
            if ((m.compareTo(values[i]) > 0)) {
                m = values[i];
            }
        }
        return m;
        //Optional<T> min = Stream.of(values).min(new Comparator<T>() {
        //    @Override
        //    public int compare(T o1, T o2) {
        //        return 1;
        //    }
        //});
        //return min.isPresent() ? min.get() : null;
    }

    public static <T extends Number & Comparable<? super T>> T min(List<T> values) {
        T a = null;

        return a;
    }

    public static void main(String[] args) {
        System.out.println(GenericTest.min(new Integer[] {1, 2, 3}));
        System.out.println(GenericTest.min(new Double[] {1.2, 2.3, -3.3}));
    }
}

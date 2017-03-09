package com.alex.generics.comparable;

import java.util.Arrays;
import java.util.List;

import static com.alex.generics.comparable.Maximum.max;

public final class Test {
    public static void main(String[] args) {
        Apple a1 = new Apple(1);
        Apple a2 = new Apple(2);
        Orange o3 = new Orange(3);
        Orange o4 = new Orange(4);

        List<Apple> apples = Arrays.asList(a1, a2);
        assert max(apples).equals(a2);
        System.out.println(max(apples));

        List<Orange> oranges = Arrays.asList(o3, o4);
        assert max(oranges).equals(o4);
        System.out.println(max(oranges));
        final Orange max = max(oranges);

        List<Fruit> mixed = Arrays.asList(a1, o3);
        assert max(mixed).equals(o3);
        System.out.println(max(mixed));

        System.out.printf("max val: %d\n", Integer.MAX_VALUE);
        System.out.printf("max val + 1: %d\n", Integer.MAX_VALUE + 1);

        char a = 65;
        System.out.printf("a is %c\n", a);
        a = 778;
        System.out.printf("a is %c\n", a);
    }
}

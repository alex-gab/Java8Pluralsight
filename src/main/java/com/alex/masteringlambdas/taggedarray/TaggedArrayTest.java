package com.alex.masteringlambdas.taggedarray;

public final class TaggedArrayTest {
    public static void main(String[] args) {
        final TaggedArray<Integer> taggedArray =
                new TaggedArray<>(
                        new Integer[]{1, 2, 3, 4},
                        new String[]{"first", "second", "third", "fourth"});
        taggedArray.stream().forEachOrdered(System.out::println);
    }
}

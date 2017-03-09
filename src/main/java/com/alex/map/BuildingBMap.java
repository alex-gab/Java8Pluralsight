package com.alex.map;

import com.alex.dataandtime.DataAndTime;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SuppressWarnings({"Duplicates", "ConstantConditions"})
public final class BuildingBMap {
    public static void main(String[] args) {
        final ArrayList<Person> persons = new ArrayList<>();

        final URL resource = DataAndTime.class.getClassLoader().getResource("peopleAgeSex.txt");
        try (final BufferedReader reader =
                     new BufferedReader(
                             new InputStreamReader(new FileInputStream(resource.getFile())));
             final Stream<String> stream = reader.lines()) {
            stream.map(
                    line -> {
                        final String[] s = line.split(" ");
                        final String name = s[0].trim();
                        final int age = Integer.parseInt(s[1]);
                        final String sex = s[2].trim();
                        Person p = new Person(name, age, sex);
                        persons.add(p);
                        return p;
                    }
            ).forEach(System.out::println);
        } catch (IOException e) {
            System.out.println(e);
        }

        final List<Person> list1 = persons.subList(1, 10);
        final List<Person> list2 = persons.subList(10, persons.size());

        final Map<Integer, List<Person>> map1 = mapByAge(list1);
        System.out.println("map1");
        map1.forEach((age, list) -> System.out.println(age + " -> " + list));

        final Map<Integer, List<Person>> map2 = mapByAge(list2);
        System.out.println("map2");
        map2.forEach((age, list) -> System.out.println(age + " -> " + list));

        map2.entrySet().forEach(
                entry ->
                        map1.merge(
                                entry.getKey(),
                                entry.getValue(),
                                (l1, l2) -> {
                                    l2.addAll(l1);
                                    return l2;
                                })
        );
        System.out.println("map1 merged");
        map1.forEach((age, list) -> System.out.println(age + " -> " + list));

    }

    private static Map<Integer, List<Person>> mapByAge(List<Person> list1) {
        return list1.stream().collect(Collectors.groupingBy(Person::getAge));
    }
}

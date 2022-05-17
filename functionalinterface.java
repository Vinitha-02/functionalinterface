import java.util.function.Consumer;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import java.util.*;

public class functionalinterface {
    public static void main(String args[]) {
        System.out.println("Using CONSUMER INTERFACES");
        Consumer<Integer> display = n -> System.out.println(n);
        display.accept(10);
        List<Integer> al = new ArrayList<Integer>();
        al.add(1);
        al.add(5);
        al.add(2);
        al.add(7);
        al.add(8);
        Consumer<List<Integer>> modify = m -> {
            for (int i = 0; i < al.size(); i++)
                al.set(i, 2 * al.get(i));
        };
        Consumer<List<Integer>> dl = a -> al.stream().forEach(y -> System.out.print(y + " "));
        dl.accept(al);
        modify.accept(al);
        dl.accept(al);
        System.out.println("Using BICONSUMER INTERFACES");
        List<Integer> al1 = new ArrayList<Integer>();
        al1.add(2);
        al1.add(10);
        al1.add(4);
        al1.add(14);
        al1.add(16);
        BiConsumer<List<Integer>, List<Integer>> dis = (list1, list2) -> al.stream()
                .forEach(k -> System.out.println(k + " "));
        System.out.println();
        al1.stream().forEach(k -> System.out.println(k + " "));
        dis.accept(al, al1);

        BiConsumer<List<Integer>, List<Integer>> equals = (list1, list2) -> {
            if (list1.size() != list2.size()) {
                System.out.println("False");
            } else {
                for (int i = 0; i < list1.size(); i++)
                    if (list1.get(i) != list2.get(i)) {
                        System.out.println("False");
                        // return;
                    }
                System.out.println("True");
            }
        };
        equals.accept(al, al1);
        System.out.println("Using BIFUNCTION INTERFACES");
        Map<Integer, String> map = new HashMap<>();

        map.put(1, "Olivia");
        map.put(2, "Noah");
        map.put(3, "John");
        map.put(4, "Alex");
        map.put(5, "Emma");
        map.put(6, "Amelia");
        map.put(7, "Noah");
        BiFunction<Integer, String, String> f = (key, value) -> "[Key=" + key + ", " + value + "("
                + Collections.frequency(map.values(), value) + ")]";
        map.forEach((k, v) -> System.out.println(f.apply(k, v)));

    };
}

import org.apache.commons.collections.CollectionUtils;

import java.util.HashSet;
import java.util.Set;

import static org.apache.commons.collections.CollectionUtils.*;

public class Test {

    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);

        HashSet<Integer> res1 = new HashSet<>();
        HashSet<Integer> res2 = new HashSet<>();
        HashSet<Integer> res3 = new HashSet<>();
        HashSet<Integer> res4 = new HashSet<>();

//1234 3456
        res1.addAll(intersection(set1, set2));
        System.out.println("intersection");//
        set1.forEach(System.out::print);
        System.out.println();
        res2.addAll(subtract(set1, set2));
        System.out.println("subtract");
        set2.forEach(System.out::print);
        System.out.println();
        res3.addAll(union(set1, set2));
        System.out.println("union");//все по одному разу и похуй
        res3.forEach(System.out::print);
        System.out.println();
        res4.addAll(disjunction(set1, set2));
        System.out.println("disjunction"); //все что не повторяются
        res4.forEach(System.out::print);
        System.out.println();

    }
}

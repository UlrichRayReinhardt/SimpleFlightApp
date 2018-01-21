import org.apache.commons.collections.CollectionUtils;

public class Merge {

    //сформувати набір L, включивши в нього по одному разу елементи, які входять хоча б в один з наборів L1 і L2.
    public static Suite onlyUnique(Suite one, Suite two) {
        Suite res = new Suite();
        res.addAll(CollectionUtils.union(one, two));
        return res;
    }

    //сформувати набір L, включивши в нього по одному разу елементи, які входять одночасно в обидва набори L1 і L2.
    public static Suite withRepeated(Suite one, Suite two) {
        Suite res = new Suite();
        res.addAll(CollectionUtils.intersection(one, two));
        return res;
    }

    // об'єднати два упорядкованих набори L1 і L2 в один впорядкований набір L (впорядкування за Вашим бажанням).
    public static Suite newSorted(String name, Suite one, Suite two) {
        Suite newSuite = new Suite(name);
        newSuite.add(one);
        newSuite.add(two);
        newSuite.sortByProperty("id");
        return newSuite;
    }
}

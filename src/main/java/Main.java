public class Main {
    public static void main(String[] args) {
        Flight f1 = new Flight("LR_4868", Company.American, "London", "Riga", AirPlane.AIRBUS_A320, 1254.6, 56.4);
        Flight f2 = new Flight("TM_4687", Company.Delta, "Tokyo", "Minsk", AirPlane.BOEING_747, 767.6, 88.4);
        Flight f3 = new Flight("NS_2121", Company.American, "NY", "Singapour", AirPlane.BOEING_737, 707.1, 54.4);
        Flight f4 = new Flight("KT_4846", Company.Hawaian, "Kyiv", "Tokyo", AirPlane.BOEING_777, 123.4, 23.4);
        Flight f5 = new Flight("TV_3231", Company.JetBlue, "Tel Aviv", "Vinnitsa", AirPlane.AIRBUS_A320, 123.4, 23.4);
        Flight f10 = new Flight("BB_1234", Company.British, "Beijing", "Boston", AirPlane.AIRBUS_A320, 98.6, 56.4);
        Flight f11 = new Flight("TM_8418", Company.British, "Tokyo", "Bratislava", AirPlane.BOEING_747, 89.6, 88.4);
        Flight f12 = new Flight("NS_4687", Company.American, "NY", "NY", AirPlane.BOEING_737, 327.1, 56.4);
        Flight f13 = new Flight("KT_6569", Company.Ukrainian, "Budapest", "Tel Aviv", AirPlane.BOEING_777, 656.4, 23.4);
        Flight f14 = new Flight("TV_8447", Company.Hawaian, "Boston", "Paris", AirPlane.BOEING_747, 193.4, 23.4);

        Suite all = new Suite("all", f1, f2, f3, f4, f5, f10, f11, f12, f13, f14);

        Suite mySuite1 = new Suite("mySuite1", f1, f3, f4, f5);
        Suite mySuite2 = new Suite("mySuite2", f1, f3, f4, f12);
        Printer.print(mySuite1);
        Printer.print(mySuite2);

        System.out.println(all.contains(f1));
        System.out.println(mySuite2.contains(f11));
        System.out.println(mySuite1.containsAll(mySuite2));

        Suite s1 = Merge.newSorted("s1", mySuite1, mySuite2);
        Printer.print(s1, "new suite contains both and sorted");
        Suite s2 = Merge.onlyUnique(mySuite1, mySuite2);//1 3 4 5 12
        Printer.print(s2, "//входять хоча б в один з наборів L1 і L2 | total 5");

        Suite s4 = Merge.withRepeated(mySuite1, mySuite2);
        Printer.print(s4, "// входять одночасно в обидва набори L1 і L2. | total 3");

        Printer.print(mySuite2,"with f1,f3,f4");
        Printer.print(mySuite2);
        Printer.print(mySuite2,"with f1,f2,f3 + f5");
        Printer.print(mySuite2);

        Suite mySuite3 = new Suite("mySuite3", f3, f4);
        Printer.print(mySuite3, "with f3,f4");
        Printer.print(mySuite3);
        mySuite3.add(mySuite2);
        Printer.print(mySuite3, "|suite2 was added to end of suite3");
        Printer.print(mySuite3);
       all.contains(mySuite2);


        all.sortByProperty("ticketPrice");
        Printer.print(all,"sorted by ticket price");

        all.sortByProperty("distance");
        Printer.print(all, "sorted by distance");

        all.sortByProperty("company","ticketPrice");
        Printer.print(all, "sorted by company and ticket price");

        all.sortByProperty("distance","airPlane");
        Printer.print(all, "sorted by distance, airPlane");
        all.removeById("F1");
        Printer.print(all);
        all.removeByCompany("Ukrainian");
        Printer.print(all);
    }

}


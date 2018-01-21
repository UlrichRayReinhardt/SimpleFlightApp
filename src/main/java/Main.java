public class Main {
    public static void main(String[] args) {
        Flight f1 = new Flight("F1", Company.American, "London", "Riga", AirPlane.AIRBUS_A320, 1254.6, 56.4);
        Flight f2 = new Flight("F2", Company.Delta, "Tokyo", "Minsk", AirPlane.BOEING_747, 767.6, 88.4);
        Flight f3 = new Flight("F3", Company.American, "NY", "Singapour", AirPlane.BOEING_737, 707.1, 54.4);
        Flight f4 = new Flight("F4", Company.Ukrainian, "Kyiv", "Tokyo", AirPlane.BOEING_777, 123.4, 23.4);
        Flight f5 = new Flight("F5", Company.Ukrainian, "Tel Aviv", "Vinnitsa", AirPlane.AIRBUS_A320, 123.4, 23.4);

/*
        Flight f1 = new Flight("KL_1234", Company.American, "London", "Riga", AirPlane.AIRBUS_A320, 1254.6, 56.4);
        Flight f2 = new Flight("TM_8418", Company.Delta, "Tokyo", "Minsk", AirPlane.BOEING_747, 767.6, 88.4);
        Flight f3 = new Flight("NS_4687", Company.American, "NY", "Singapour", AirPlane.BOEING_737, 707.1, 54.4);
        Flight f4 = new Flight("KT_6569", Company.Ukrainian, "Kyiv", "Tokyo", AirPlane.BOEING_777, 123.4, 23.4);
        Flight f5 = new Flight("TV_8447", Company.Ukrainian, "Tel Aviv", "Vinnitsa", AirPlane.AIRBUS_A320, 123.4, 23.4);
*/
        Suite all = new Suite("all", f1, f2, f3, f4, f5);
        Suite emptySuite = new Suite("empty");

        Suite mySuite2 = new Suite("mySuite2", f1, f3, f4);
        /*Printer.print(mySuite2,"with f1,f3,f4");
        Printer.print(mySuite2);
       */
        mySuite2.add(f5);
        //Printer.print(mySuite2,"with f1,f2,f3 + f5");
        //Printer.print(mySuite2);

        Suite mySuite3 = new Suite("mySuite3", f3, f4);
        /*Printer.print(mySuite3, "with f3,f4");
        Printer.print(mySuite3);
*/
        mySuite3.add(mySuite2);
  /*      Printer.print(mySuite3, "|suite2 was added to end of suite3");
        Printer.print(mySuite3);
*/
/*        all.sortByProperty("ticketPrice");
        Printer.print(all,"sorted by ticket price");

        all.sortByProperty("distance");
        Printer.print(all, "sorted by distance");

        all.sortByProperty("company","ticketPrice");
        Printer.print(all, "sorted by company and ticket price");

        all.sortByProperty("distance","airPlane");
        Printer.print(all, "sorted by distance, airPlane");*/
/*
        all.removeById("F1");
        Printer.print(all);
        all.removeByCompany("Ukrainian");
        Printer.print(all);
*/

    }



    //Printer.print(mySuite3);


}


public class EnumDemo2 {
    public static void main(String args[]) {
        Apple ap;
        System.out.println("Here are all Apple constants:");
        
        Apple []allApples = Apple.values(); //array of enum constants
        for (Apple a : allApples) {
            System.out.println(a);
        }




        // use valueOf()
        ap = Apple.valueOf("Winesap"); // always take string
        System.out.println("ap contains " + ap);

        Apple obj = Apple.Winesap;
        System.out.println(obj.getClass().getName());
        System.out.println("ap contains " + obj);
    }
}

class xyz {
    int x;
    xyz(int x) {
        this.x = x;
    }
    public String toString() {
        return "x = " + x;
    }
}

public class ForEachTest {
    public static void main(String[] args) {
        int numbers[] = {1, 2, 3, 4, 5};

        for (int x : numbers) {
            //System.out.print(x + " ");
            x = x * 10; //no change in value of x in numbers? WHy? Since 'x' is Premitive type so call by value occuring
            System.out.print(x + " ");
        }
        System.out.println();
        for (int x : numbers) 
            System.out.print(x + " ");
            System.out.println();

        int numbers2[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        for (int[] x : numbers2) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println("");
        }

        
        xyz[] arr = {new xyz(1), new xyz(2), new xyz(3)};
        for (xyz x : arr) {
            System.out.println(x);
        }
        
        for (xyz x : arr) {
            x.x=100;
        }
        for (xyz x : arr) {
            System.out.println(x);
        }




    }
}

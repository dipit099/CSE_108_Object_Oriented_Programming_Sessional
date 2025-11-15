package collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayListDemo2 {

    public static void main(String args[]) {
        // create an array list
        List<Integer> al = new ArrayList<>();
        System.out.println("Initial size of al: " + al.size());
       
        al.add(10);
        al.add(20);
        al.add(30);
        al.add(40);
        al.add(50);

        // foreach iterate
        for (Integer i : al) {
            System.out.print(i + " ");
        }
        System.out.println();

        al.remove(2); // remove using index
        al.remove(Integer.valueOf(20)); // returns object----remove using value

        // convert to array
        Integer ia[] = new Integer[al.size()];
        al.toArray(ia);
        
        for (int i = 0; i < ia.length; i++) {  // length
            System.out.print(ia[i] + " ");
        }
        
        System.out.println();

        // convert array to list
        List<Integer> alist = Arrays.asList(ia);
        //Arrays.sort(alist);

       // int array[]= {1,2,3,4,5};
        //  convert array to list
        //List<Integer> alist2 = Arrays.asList(array);//error
        
       
        for (Integer i : alist) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
package charstream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

class BufferedReaderDemo {
    public static void main(String args[]) throws Exception {
        Reader fr = new FileReader("C:\\Users\\UseR\\OneDrive - BUET\\Coding 1-1\\Java\\src10 IO\\test.txt");
        BufferedReader br = new BufferedReader(fr);
        int lineNumber=0;
        while (true) {
            String s = br.readLine();   //read full line
            if (s == null)
                break;
            System.out.println(s);
            /*lineNumber++;
            String[] test = s.split(" ");
            for(String temp : test)
            {
                if(temp.equals("Bangladesh"))
                {
                    System.out.println("Found at line number "+lineNumber);
                    return;
                }
            }*/
        }
        br.close();
        fr.close();

    }
}
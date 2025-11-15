package charstream;

import java.io.*;

class BufferedWriterDemo {
    public static void main(String args[]) throws Exception {
        FileReader fr = new FileReader("C:\\Users\\UseR\\OneDrive - BUET\\Coding 1-1\\Java\\src10 IO\\test.txt");
        BufferedReader br = new BufferedReader(fr);  //Buffered

        FileWriter fw = new FileWriter("C:\\Users\\UseR\\OneDrive - BUET\\Coding 1-1\\Java\\src10 IO\\test2.txt");
        BufferedWriter bw = new BufferedWriter(fw);

        while (true) {
            String s = br.readLine();
            if (s == null)
                break;
            if(s.contains("Bangladesh"))
            {
                System.out.println("Found Bangladesh");
            }
            bw.write(s);
            bw.newLine();  // IMPORTANT to add new line
        }
        bw.close();
        fw.close();
        br.close();
        fr.close();
    }
}
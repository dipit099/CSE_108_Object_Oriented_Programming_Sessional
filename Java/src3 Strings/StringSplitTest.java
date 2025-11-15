import java.util.StringTokenizer;
public class StringSplitTest {
    public static void main(String[] args) {
        String test = "abc,,def,123,";
        String[] out = test.split(",",0);
        System.out.println(out.length);
        for (int i = 0; i < out.length; i++) {
            System.out.println(out[i]);
        }

        // String.split() does produce empty tokens, but StringTokenizer doesn't
        
        String t = new String("abc,,def,123");
        StringTokenizer tokens = new StringTokenizer(t, ",");
        System.out.println(tokens.countTokens());
        while (tokens.hasMoreTokens()) {
            System.out.println(tokens.nextToken());
        }
        
    }
}

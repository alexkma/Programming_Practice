import java.io.*;
import java.nio.charset.Charset;

/**
 * Created by Alex on 4/24/2015.
 */
public class GnuPrivacyGuard {

    public static void obscureFile(String commandSeq, File file) {
        char[][] arr = new char[64][64];

        Charset encoding = Charset.defaultCharset();
        try {
            InputStream in = new FileInputStream(file);
            Reader reader = new InputStreamReader(in, encoding);
            BufferedReader buffer = new BufferedReader(reader);

            int r;
//            while ((r = buffer.read()) != -1) {
//                char ch = (char) r;
//
//            }
            while (buffer.readLine() != null) {
                int i = 0;
//                buffer.read
//                char[i][]
            }

        }
        catch (IOException e) {
            e.printStackTrace();
        }


//        for (int i = 0; i < commandSeq.length(); i++) {
//            String lowerCase = commandSeq.toLowerCase();
//
//            if (lowerCase.charAt(i) == 'v') {
//
//            }
//            else if (lowerCase.charAt(i) == 'h') {
//
//            }
//            else if (lowerCase.charAt(i) == 'r') {
//
//            }
//        }
    }

    public static void main (String[] args) {
        File f = new File("test.txt");
        obscureFile("blah", f);
    }
}

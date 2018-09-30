import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

public class Generator {
    public static void main(String[] args) {
        generate();
    }

    public static void generate(){
        Random random = new Random();
        int length = random.nextInt(20);
        String strDirectoy = "./" + generateRandomString(length);
        boolean success = (
                new File(strDirectoy)).mkdir();
        if (success) {
            System.out.println("Directory: "
                    + strDirectoy + " created");
        }
        String path = strDirectoy + "/the-file-name.txt";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(path, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        writer.close();
    }

    public static String generateRandomString(int length){
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}

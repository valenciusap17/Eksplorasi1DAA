import java.io.PrintWriter;
import java.io.IOException;
import java.util.Random;

public class generate {
    public static void main(String[] args) throws IOException {
        Random random = new Random();

        PrintWriter out = new PrintWriter("reversed20000.txt");
        int current = 100000;
        for (int i = 1; i <= 20000; i++) {
            int r = random.nextInt(10);
            current -= r;
            out.println(current);
        }
        out.close();
    }
}

package level;



import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class RandomNum {
    public static void main(String[] args) {
        String map = "";

        try {
            Random random = new Random();
            for (int i = 0; i < 38; i++){
                String line = "";
                for (int j = 0; j < 50; j++) {
                    line = line + " " + random.nextInt(1);
                }
                map = map + line.trim() + "\n";
            }
            File out = new File("/home/jaba/My/randomDb/Tanks/res/level.lvl");
            FileWriter fw = new FileWriter(out);
            BufferedWriter writer = new BufferedWriter(fw);
            writer.write(map);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(0);
        }

    }

}







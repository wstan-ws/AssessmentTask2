package word;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {

        File directory = new File(args[0]);

        WordDistribution wd = new WordDistribution();

        for (File file : directory.listFiles()) {
            wd.parse(file);
        }

        wd.print();
    }
}
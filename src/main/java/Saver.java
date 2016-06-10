import java.io.*;

/**
 * Created by ragvalod on 10.06.16.
 */
public class Saver {
    private String name;
    private String data;
    private static int partCount = 0;
    private static boolean isLast = false;


    public Saver(String name, String data, boolean isLast) {
        this.name = name;
        this.data = data;
        Saver.isLast = (Saver.isLast || isLast);
        partCount = Integer.valueOf(name);

    }

    public void savePart() {
        try {
            File file = new File("../work/" + name);
            FileWriter fileWriter = new FileWriter(file);
            if (file.canWrite()) {
                fileWriter.write(data);
                fileWriter.flush();
                fileWriter.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (isLast) {
            try {
                makeFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void makeFile() throws Exception {
        File dir = new File("../work/");
        File[] files = dir.listFiles();
        System.out.println("dir contain " + files.length + " files");
        if (files.length == partCount) {
            File finalFile = new File("../work/Final");
            FileWriter fileWriter = new FileWriter(finalFile);
            BufferedReader reader;
            for (File file : files) {
                reader = new BufferedReader(new FileReader(file));
                fileWriter.write(reader.readLine());
                reader.close();
            }
            fileWriter.flush();
            fileWriter.close();
        }
    }
}

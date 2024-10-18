import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public static ArrayList<String> readFile (String fileName) throws IOException {
        String contents = Files.readString(Path.of(fileName), StandardCharsets.UTF_8);
        Scanner sc = new Scanner(contents);
        ArrayList<String> dataSets = new ArrayList<>();
        sc.nextLine();

        while (sc.hasNextLine()) {

            dataSets.add(sc.nextLine());

//            String line = sc.nextLine();
//            String[] data = line.split(",");
//            DataSet dataset = new DataSet(data[0], data[1], data[2], data[3], data[4]);
//            dataSets.add(dataset);
        }

        sc.close();

        return dataSets;
    }

    // Will return a long array in the following format:
    // {count of white people, count of asian people, count of hispanic people, count of black people, count of males, count of females}

    public long [] getData (String ethnicityFile, String genderFile) throws IOException {
        ArrayList<String> DataEth = readFile(ethnicityFile),
                DataGen = readFile(genderFile);

        long femaleCount = DataGen.stream()
                .filter(s -> s.toLowerCase().contains("female"))
                .count();

        long maleCount = DataGen.stream()
                .filter(s -> s.toLowerCase().contains("male"))
                .count() - femaleCount;

        return new long[]{
                DataEth.stream()
                        .filter(s -> s.contains("white"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.contains("asian"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.contains("hispanic"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.contains("black"))
                        .count(),
                maleCount,
                femaleCount
        };
    }

    public ArrayList<Long> getArrayListCC() throws IOException {

        ArrayList<Long> dataSets = new ArrayList<>();

        for (long l : this.getCCData()) {
            dataSets.add(l);
        }
        return dataSets;

    }

    public long[] getCCData () throws IOException {
        return getData("src\\cc_ethnic_final.csv", "src\\cc_gender_final.csv");

    }

    public long[] getSBData () throws IOException {
        return getData("src\\sb_ethnic_final.csv", "src\\sb_gender_final.csv");
    }

}

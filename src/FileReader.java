import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader {

    public ArrayList<DataSet> readFile (String fileName) throws IOException {
        String contents = Files.readString(Path.of(fileName), StandardCharsets.UTF_8);
        Scanner sc = new Scanner(contents);
        ArrayList<DataSet> dataSets = new ArrayList<>();
        sc.nextLine();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            String[] data = line.split(",");
            DataSet dataset = new DataSet(data[0], data[1], data[2], data[3], data[4]);
            dataSets.add(dataset);
        }

        sc.close();

        return dataSets;
    }

    // Will return a long array in the following format:
    // {count of white people, count of asian people, count of hispanic people, count of black people, count of males, count of females}

    public long [] getData (String ethnicityFile, String genderFile) throws IOException {
        ArrayList<DataSet> DataEth = readFile(ethnicityFile),
                DataGen = readFile(genderFile);

        return new long[]{
                DataEth.stream()
                        .filter(s -> s.ethnicity_or_gender().equals("white"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.ethnicity_or_gender().equals("asian"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.ethnicity_or_gender().equals("hispanic"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.ethnicity_or_gender().equals("black"))
                        .count(),
                DataGen.stream()
                        .filter(s -> s.ethnicity_or_gender().equals("male"))
                        .count(),
                DataGen.stream()
                        .filter(s -> s.ethnicity_or_gender().equals("female"))
                        .count()
        };
    }

    public long[] getCCData () throws IOException {
        return getData("src\\cc_ethnic_final.csv", "src\\cc_gender_final.csv");

    }

    public long[] getSBData () throws IOException {
        return getData("src\\sb_ethnic_final.csv", "src\\sb_gender_final.csv");
    }
}

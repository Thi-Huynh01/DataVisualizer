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

        while (sc.hasNextLine())
            dataSets.add(sc.nextLine());

        sc.close();

        return dataSets;
    }

    // Will return a long array in the following format:
    // {count of white people, count of asian people, count of hispanic people, count of black people, count of males, count of females}

    public long [] parseData (String ethnicityFile, String genderFile) throws IOException {
        ArrayList<String> DataEth = readFile(ethnicityFile),
                DataGen = readFile(genderFile);

        long femaleCount = DataGen.stream()
                .filter(s -> s.toLowerCase().contains("female"))
                .count();

        /* Using a stream to count male would also count 'female', so subtracting the 'female' count from the male count
         was the solution I came up with. */

        long maleCount = (DataGen.stream()
                .filter(s -> s.toLowerCase().contains("male"))
                .count()) - femaleCount;

        return new long[]{
                DataEth.stream()
                        .filter(s -> s.contains("white"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.contains("hispanic"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.contains("black"))
                        .count(),
                DataEth.stream()
                        .filter(s -> s.contains("asian"))
                        .count(),
                maleCount,
                femaleCount
        };
    }

    // Returns ArrayList for the sole purpose of turning it into a two-dimensional Array (Object [][])
    // Using a two-dimensional array was the best way I could find to use to make a JTable.
    public ArrayList<String> getArrayList() throws IOException {

        ArrayList<String> ccEth = readFile("src\\cc_ethnic_final.csv"),
        ccGen = readFile("src\\cc_gender_final.csv"),
        sbEth = readFile("src\\sb_ethnic_final.csv"),
        sbGen = readFile("src\\sb_gender_final.csv");

        ArrayList<String> combinedDataSets = new ArrayList<>();

        // Add California City Council data
        combinedDataSets.addAll(ccEth);
        combinedDataSets.addAll(ccGen);

        // Add California School Board data
        combinedDataSets.addAll(sbEth);
        combinedDataSets.addAll(sbGen);

        return combinedDataSets;

    }

    public long[] getAllData () throws IOException {
        long[] cc = parseData("src\\cc_ethnic_final.csv", "src\\cc_gender_final.csv"),
               sb = parseData("src\\sb_ethnic_final.csv", "src\\sb_gender_final.csv"),
               combined = new long[cc.length];
        
        for (int i = 0; i < cc.length; i++) {
            combined[i] = cc[i] + sb[i];
        }

        return combined;

    }

}

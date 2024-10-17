import java.util.ArrayList;
import java.io.IOException;
import java.util.Objects;

// The CSV files are downloaded from this link
// https://dataverse.harvard.edu/dataset.xhtml?persistentId=doi:10.7910/DVN/MSPV1Y

public class Main {
    public static void main(String[] args) throws IOException {

        // Ethnicity Data Sets
        ArrayList<DataSet> cc_ethnicity = FileReader.readFile("src\\cc_ethnic_final.csv");
        ArrayList<DataSet> sb_ethnicity = FileReader.readFile("src\\sb_ethnic_final.csv");

        // Gender Data Sets
        ArrayList<DataSet>cc_gender = FileReader.readFile("src\\cc_gender_final.csv");
        ArrayList<DataSet>sb_gender = FileReader.readFile("src\\sb_gender_final.csv");

        long [] cc_eth_count = getEthnicityCount(cc_ethnicity);
        long [] sb_eth_count = getEthnicityCount(sb_ethnicity);

    }

    public static long[] getEthnicityCount (ArrayList<DataSet> ethnicity_file) {


        long white_count = 0, asian_count = 0, hispanic_count = 0, black_count = 0;

         white_count = ethnicity_file.stream()
                .filter(s -> s.ethnicity_or_gender().equals("white"))
                .count();
         asian_count = ethnicity_file.stream()
                .filter(s -> s.ethnicity_or_gender().equals("asian"))
                .count();
         hispanic_count = ethnicity_file.stream()
                .filter(s -> s.ethnicity_or_gender().equals("hispanic"))
                .count();
         black_count = ethnicity_file.stream()
                 .filter(s -> s.ethnicity_or_gender().equals("black"))
                 .count();

        return new long[]{white_count, asian_count, hispanic_count, black_count};
    }

}

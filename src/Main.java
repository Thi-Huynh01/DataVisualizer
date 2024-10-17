import java.util.ArrayList;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;

// The CSV files are downloaded from this link
// https://dataverse.harvard.edu/dataset.xhtml?persistentId=doi:10.7910/DVN/MSPV1Y

public class Main {
    public static void main(String[] args) throws IOException {

        FileReader f = new FileReader();
        for (long num : f.getCCData()) {
            System.out.println(num);
        }
        System.out.println();
        for (long sb : f.getSBData()) {
            System.out.println(sb);
        }

    }



}

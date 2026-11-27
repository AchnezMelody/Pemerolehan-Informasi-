package MainPackage;

import SourcePackage.InvertedIndexBasic;
import SourcePackage.ReadFileCorpus;

public class MainInvertedIndex {

    public static void main(String[] args) {
        String path = "Koleksi";

        ReadFileCorpus reader = new ReadFileCorpus(path);
        InvertedIndexBasic cobaList = reader.loadIndex();

        // Cetak hasil inverted index
        System.out.println(cobaList);
    }
}
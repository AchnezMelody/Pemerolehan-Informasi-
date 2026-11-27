package MainPackage;

import SourcePackage.InvertedIndexBasic;
import SourcePackage.CollectionReader;

public class MainInvertedIndex {

    public static void main(String[] args) {
        String path = "Koleksi";

        CollectionReader reader = new CollectionReader(path);
        InvertedIndexBasic cobaList = reader.loadIndex();

        // Cetak hasil inverted index
        System.out.println(cobaList);
    }
}
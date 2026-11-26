package MainPackage;

import SourcePackage.InvertedIndexBasic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class MainInvertedIndex {

    public static void main(String[] args) {

        InvertedIndexBasic cobaList = new InvertedIndexBasic();

        // Path direktori koleksi (sesuaikan)
        String path = "./Koleksi";
        File dir = new File(path);

        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();

            if (files != null) {
                // Urutkan file agar konsisten (doc8.txt, doc9.txt, ...)
                Arrays.sort(files);

                for (String fileName : files) {
                    File currentFile = new File(dir, fileName);

                    // Hanya proses file (bukan folder)
                    if (currentFile.isFile()) {

                        // Ambil docId = nama file tanpa ekstensi (opsional)
                        // Kalau mau tetap pakai "doc8.txt", hapus baris di bawah
                        String docId = fileName.replaceFirst("\\.[^.]+$", "");

                        try (Scanner input = new Scanner(currentFile)) {
                            while (input.hasNextLine()) {
                                String line = input.nextLine();

                                // Tokenisasi per baris
                                StringTokenizer tokens = new StringTokenizer(line);

                                while (tokens.hasMoreTokens()) {
                                    String token = tokens.nextToken();

                                    // Normalisasi sederhana: lowercase
                                    token = token.toLowerCase();

                                    // === INI PENGGANTI cobaList.add manual ===
                                    cobaList.add(token, docId);
                                }
                            }
                        } catch (FileNotFoundException e) {
                            System.err.println("File tidak ditemukan: " + fileName);
                        }
                    }
                }
            } else {
                System.err.println("Gagal membaca isi direktori.");
            }
        } else {
            System.out.println("Direktori " + path + " tidak ditemukan.");
        }

        // Cetak hasil inverted index
        System.out.println(cobaList);
    }
}
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

        // Karakter pemisah yang diubah menjadi spasi sebelum tokenisasi: - dan /
        String regexPemisahSpasi = "[-/]";

        // Sisa tanda baca yang dihapus dari token: ! " & ' ( ) * , . : @
        String regexHapusTandaBaca = "[!\"&'()*,. :@]";

        // Path direktori koleksi (sesuaikan)
        String path = "../Koleksi";
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

                                // 1. Lowercase dan ubah '-' serta '/' menjadi spasi
                                String normalizedLine = line.toLowerCase().replaceAll(regexPemisahSpasi, " ");

                                // 2. Tokenisasi per baris berdasarkan spasi/whitespace
                                StringTokenizer tokens = new StringTokenizer(normalizedLine);

                                while (tokens.hasMoreTokens()) {
                                    // 3. Hapus tanda baca lain pada token
                                    String token = tokens.nextToken().replaceAll(regexHapusTandaBaca, "");

                                    // Hindari memasukkan token kosong
                                    if (!token.isEmpty()) {
                                        cobaList.add(token, docId);
                                    }
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
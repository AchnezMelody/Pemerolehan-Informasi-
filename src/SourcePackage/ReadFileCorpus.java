package SourcePackage;

import SourcePackage.InvertedIndexBasic;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class ReadFileCorpus {

    // Karakter pemisah yang diubah menjadi spasi sebelum tokenisasi: - dan /
    private static final String REGEX_PEMISAH_SPASI = "[-/]";

    // Sisa tanda baca yang dihapus dari token: ! " & ' ( ) * , . : @
    private static final String REGEX_HAPUS_TANDA_BACA = "[!\"&'()*,. :@]";

    private final String folderPath;

    public ReadFileCorpus(String folderPath) {
        this.folderPath = folderPath;
    }

    public InvertedIndexBasic loadIndex() {
        InvertedIndexBasic index = new InvertedIndexBasic();
        File dir = new File(folderPath);

        if (dir.exists() && dir.isDirectory()) {
            String[] files = dir.list();

            if (files != null) {
                // Urutkan file agar konsisten (doc8.txt, doc9.txt, ...)
                Arrays.sort(files);

                for (String fileName : files) {
                    File currentFile = new File(dir, fileName);

                    // Hanya proses file (bukan folder)
                    if (currentFile.isFile()) {
                        // Ambil docId = nama file tanpa ekstensi
                        String docId = fileName.replaceFirst("\\.[^.]+$", "");
                        processFile(currentFile, docId, index);
                    }
                }
            } else {
                System.err.println("Gagal membaca isi direktori.");
            }
        } else {
            System.out.println("Direktori " + folderPath + " tidak ditemukan.");
        }

        return index;
    }

    private void processFile(File file, String docId, InvertedIndexBasic index) {
        try (Scanner input = new Scanner(file)) {
            while (input.hasNextLine()) {
                String line = input.nextLine();

                // 1. Lowercase dan ubah '-' serta '/' menjadi spasi
                String normalizedLine = line.toLowerCase().replaceAll(REGEX_PEMISAH_SPASI, " ");

                // 2. Tokenisasi per baris berdasarkan spasi/whitespace
                StringTokenizer tokens = new StringTokenizer(normalizedLine);

                while (tokens.hasMoreTokens()) {
                    // 3. Hapus tanda baca lain pada token
                    String token = tokens.nextToken().replaceAll(REGEX_HAPUS_TANDA_BACA, "");

                    // Hindari memasukkan token kosong
                    if (!token.isEmpty()) {
                        index.add(token, docId);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File tidak ditemukan: " + file.getName());
        }
    }
}
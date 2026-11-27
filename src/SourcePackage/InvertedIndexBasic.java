package SourcePackage;

import java.util.LinkedList;

public class InvertedIndexBasic {

    private LinkedListOrderedUnique<Term> termList;

    public InvertedIndexBasic() {
        termList = new LinkedListOrderedUnique<Term>();
    }

    public LinkedListOrderedUnique getTermList() {
        return termList;
    }

    public void add(String pTerm, String pDocument) {

        // cari pTerm dalam Term list
        Term vTerm = termList.get(new Term(pTerm));
        // Jika term belum ada
        if (vTerm == null) {
            // Buat simpul Term list
            Term oTerm = new Term(pTerm);
            // tambahkan simpul document ke documentList dari oTerm
            oTerm.addDocument(pDocument);
            // Tambahkan term object oTerm baru pertama ke termList;
            termList.addSort(oTerm);
        } // Jika term sudah ada
        else {
            // tambahkan simpul document ke documentList dari pTerm
            vTerm.addDocument(pDocument);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Term t : termList) {          // LinkedList sudah Iterable
            sb.append(t.toString()).append("\n");
        }
        return sb.toString();
    }

    public void searchAnd(String query) {
        if (query == null || query.trim().isEmpty()) {
            System.out.println("Keyword kosong.");
            return;
        }

        String[] keywords = query.toLowerCase().split("[^a-z0-9]+");
        LinkedList<String> hasilDokumen = null;

        for (String key : keywords) {
            if (key.isEmpty()) {
                continue;
            }

            Term found = termList.get(new Term(key));
            if (found == null) {
                System.out.println("Tidak ada dokumen yang memuat semua keyword: \"" + query + "\"");
                return;
            }

            // Ambil daftar nama dokumen untuk term saat ini
//            LinkedList<String> docsSaatIni = new LinkedList<>();
            LinkedList<String> docsSaatIni = new LinkedList<String>();
            for (Document d : found.getDocumentList()) {
                docsSaatIni.add(d.getDocument());
            }

            if (hasilDokumen == null) {
                hasilDokumen = new LinkedList<String>(docsSaatIni);
            } else {
                // Simpan hanya dokumen yang ada di kedua daftar (irisan / AND)
                hasilDokumen.retainAll(docsSaatIni);
            }
        }

        if (hasilDokumen == null || hasilDokumen.isEmpty()) {
            System.out.println("Tidak ada dokumen yang cocok untuk \"" + query + "\".");
        } else {
            System.out.println("Dokumen yang memuat semua keyword \"" + query + "\": " + hasilDokumen);
        }
    }
}



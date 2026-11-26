package SourcePackage;

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

}

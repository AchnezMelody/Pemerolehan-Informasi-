package SourcePackage;

public class Term implements Comparable<Term> {

    protected String term;
    protected LinkedListOrderedUnique<Document> documentList;

    public Term(String inTerm) {
        term = inTerm;
        // Buat document list
        documentList = new LinkedListOrderedUnique<Document>();

    }

    public void addDocument(String doc) {
        Document existingDoc = documentList.get(new Document(doc));
        if (existingDoc == null) {
            documentList.addSort(new Document(doc));
        }
    }

    public String getTerm() {
        return term;
    }

    public LinkedListOrderedUnique<Document> getDocumentList() {
        return documentList;
    }

    public int compareTo(Term o) {
        return term.compareTo(o.term);
    }

    @Override
    public String toString() {
        String temp = term + " => ";
        temp = temp + documentList.toString();
        return temp;
    }

}

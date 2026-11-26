package SourcePackage;

public class Document implements Comparable<Document> {

    protected String document;

    public Document() {
    }

    public Document(String inDocument) {
        document = inDocument;
    }

    public String getDocument() {
        return document;
    }

    public int compareTo(Document o) {
        return document.compareTo(o.document);
    }

    public String toString() {
        return document;
    }

}

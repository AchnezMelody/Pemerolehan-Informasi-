/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package id.ac.usd.ti.wawan.ir;

/**
 *
 * @author wawan
 */
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
    public String toString(){
        return termList.toString();
    }

}

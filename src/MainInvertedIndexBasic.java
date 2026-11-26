
import id.ac.usd.ti.wawan.ir.Term;
import id.ac.usd.ti.wawan.ir.InvertedIndexBasic;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author basis28
 */
public class MainInvertedIndexBasic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        InvertedIndexBasic cobaList;
        
        cobaList = new InvertedIndexBasic();
        
        cobaList.add("hari", "doc1");
        cobaList.add("pada", "doc3");
        cobaList.add("hari", "doc2");
        cobaList.add("minggu", "doc2");
        cobaList.add("hari", "doc1");

        System.out.println(cobaList);
        System.out.println(cobaList);
        System.out.println(cobaList);

//       System.out.println("");
//        cobaList.searchTerm("pada hari minggu");
        
    }

}

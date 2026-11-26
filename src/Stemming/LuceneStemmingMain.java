/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Stemming;

/**
 *
 * @author HP
 */
import org.apache.lucene.analysis.id.IndonesianStemmer;
public class LuceneStemmingMain {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        IndonesianStemmer stemmer = new IndonesianStemmer();
        
        String term = "mengatur";
        char[] chars = term.toCharArray();
        int len = stemmer.stem(chars, chars.length, true);
        String stem = new String(chars, 0, len);
        System.out.println(stem);
    }
    
    
    
}

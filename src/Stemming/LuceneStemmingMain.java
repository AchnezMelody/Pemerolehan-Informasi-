package Stemming;

import org.apache.lucene.analysis.id.IndonesianStemmer;
public class LuceneStemmingMain {
    public static void main(String[] args) {
        
        IndonesianStemmer stemmer = new IndonesianStemmer();
        
        String term = "mengatur";
        char[] chars = term.toCharArray();
        int len = stemmer.stem(chars, chars.length, true);
        String stem = new String(chars, 0, len);
        System.out.println(stem);
    }
    
    
    
}

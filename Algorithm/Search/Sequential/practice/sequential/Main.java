package sorting.search.sequential;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        SequentialSearch s= new SequentialSearch();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int finder=Integer.valueOf(br.readLine());
        int res=0;

        s.makeRdn(100,10);
        System.out.println(s.seqSearch(finder));
    }
}

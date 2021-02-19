package B.B2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;

    static void init(InputStream input) {
        reader = new BufferedReader(
                new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }

    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            tokenizer = new StringTokenizer(
                    reader.readLine() );
        }
        return tokenizer.nextToken();
    }

    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }

    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}

class item{
    int v;
    int w;
    item(int value,int weight){
        this.v = value;
        this.w = weight;
    }
}
class pseudo_array{
    int[] arr;
    pseudo_array(int N){
        arr = new int[N+1];
    }
}
public class B2{
    public static int min(int a,int b){
        if (a < b){
            return a;
        }
        else return b;
    }
    public static int knapSack(int N, item arr[], int W){
        int[][] D = new int[N+1][10000+1];
        D[0][0] = 0;
        int p = -1;
        for(int i=0;i<=N;i++){
            for(int j=1;j<=10000;j++){
                D[i][j] = 999999999;
            }
        }
        for(int i = 1; i<=N; i++){
            for(int j = 0; j<=10000; j++){
                if(j>=arr[i-1].v){
                    D[i][j] = min(arr[i-1].w+ D[i-1][j-(arr[i-1].v)],D[i-1][j]);
//                    if(D[i][j] <= W){
//                        if(arr[i-1].w + D[i-1][j-(arr[i-1].v)] > D[i-1][j]){
//                            p = p + arr[i-1].v;
//                        }
//                    }
                }
                else{
                    D[i][j] = D[i-1][j];
//                    if(D[i][j] <= W) {
//                        p = max(p, D[i][j]);
//                    }
                }
            }
        }
//        for(int i = 0; i<= N; i++){
//            for(int j = 0; j<= 20; j++){
//                System.out.print("[" + i+ "," + j+ "] " + D[i][j] + " ");
//            }
//            System.out.println("");
//        }
        for(int j=0;j<=10000;j++){
            if(D[N][j] <= W){
                p = j;
            }
        }
        return p;
    }
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        int N = Reader.nextInt();
        int W = Reader.nextInt();
        item[] arr = new item[N];
        for(int i = 0; i<N; i++){
            int value = Reader.nextInt();
            int weight  = Reader.nextInt();
            arr[i] = new item(value,weight);
        }
        System.out.println(knapSack(N,arr,W));


    }
}



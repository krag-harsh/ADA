package A2;


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
public class A2{
    public static long max(long a,long b){
        if (a > b){
            return a;
        }
        else return b;
    }
    public static long knapSack(int N, item arr[], int W){
        long[][] D = new long[N+1][W+1];
        D[0][0] = 0;
        for(int i = 1; i<=W; i++){
            D[1][i] = arr[0].v;
        }
        //D[1][1] = arr[0].v;

        for(int i = 2; i<=N; i++){
            for(int j = 1; j<=W; j++){
                D[i][j] = max(arr[i - 1].v + D[i - 2][j - 1], D[i - 1][j]);
            }
        }
//        for(int i = 0; i<=N; i++){
//            for(int j = 0; j<=W; j++){
//                System.out.print(D[i][j]+ " ");
//            }
//            System.out.println("");
//        }
        return D[N][W];
    }
    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        int N = Reader.nextInt();
        int W = Reader.nextInt();
        item[] arr = new item[N];
        for(int i = 0; i<N; i++){
            int value = Reader.nextInt();
            arr[i] = new item(value,1);
        }
        System.out.println(knapSack(N,arr,W));


    }
}



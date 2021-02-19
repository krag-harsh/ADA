package B;
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
public class B{
     public static int max(int a,int b){
        if (a > b){
            return a;
        }
        else return b;
    }
    public static int knapSack(int N,item arr[], int W){
        int[][] D = new int[N+1][W+1];
        D[0][0] = 0;
        for(int i = 1; i<=N; i++){
            for(int j = 1; j<=W; j++){
                if(j>=arr[i-1].w){
                    D[i][j] = max(arr[i-1].v + D[i-1][j-(arr[i-1].w)],D[i-1][j]);
                }
                else{
                    D[i][j] = D[i-1][j];
                }
            }
        }
        return D[N][W];
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


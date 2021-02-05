import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.*;

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

class CompareX implements Comparator<Point> {

    @Override
    public int compare(Point o1, Point o2) {
        return o1.x - o2.x;
    }
}
class CompareY implements Comparator<Point>{
    @Override
    public int compare(Point o1,Point o2){
        return o1.y - o2.y;
    }
}
class Point{
    int x,y;
    Point(int x,int y){
        this.x = x;
        this.y = y;
    }
}
public class q2b {
    static double dist(Point a, Point b)
    {
        return Math.sqrt( (a.x-b.x)(a.x-b.x) + (a.y-b.y)(a.y-b.y) );
    }

    static double Perimeter(Point a, Point b, Point c)
    {
        return dist(a,b)+dist(b,c)+dist(c,a);
    }
    static double bruteForce(Point[] Poles,int l,int r){
        double peri = Double.MAX_VALUE;
        for(int i=l;i<=r;i++){
            for(int j=i+1;j<=r;j++){
                for(int k=j+1;k<=r;k++){
                    peri = Math.min(peri, Perimeter(Poles[i], Poles[j], Poles[k]));
                }
            }
        }
//        int m = (l+r)/2;
//        peri = Math.min(peri,Perimeter(Poles[l],Poles[m],Poles[r]));
        return peri;
    }

    static double minPerimeter(Point[] PolesX,int l,int r){
//        if((r-l) == 2){
//            return bruteForce(PolesX,l,r);
//        }
//        if((r-l) < 2)
//            return Double.MAX_VALUE;

        if(r-l<=5){
            return bruteForce(PolesX,l,r);
        }
        double peri;
        int m = (r+l)/2;
        double p1 = minPerimeter(PolesX,l,m);
        double p2 = minPerimeter(PolesX,m+1,r);
        peri = Math.min(p1,p2);
        ArrayList<Point> splitArray = new ArrayList<>();
        double tempP;
        for(int i =l;i<=r;i++){

            tempP = Math.abs(PolesX[m].x - PolesX[i].x);
            if (tempP <= (peri)) {
                splitArray.add(PolesX[i]);
            }

        }
        splitArray.sort(new CompareY());
        for(int i=0;i<splitArray.size();i++){
            for(int j=i+1; j<splitArray.size() && (splitArray.get(j).y - splitArray.get(i).y)<=peri;j++){
                for(int k=j+1; k<splitArray.size() && (splitArray.get(k).y - splitArray.get(j).y)<=peri;k++){
                    peri = Math.min(peri,Perimeter(splitArray.get(i),splitArray.get(j),splitArray.get(k)));
                }
            }
        }
        return peri;
    }

    public static void main(String[] args) throws IOException{
        Reader.init(System.in);
        int N = Reader.nextInt();
        Point[] PolesX = new Point[N];
        int x;int y;
        for(int k=0;k<N;k++){
            x = Reader.nextInt();
            y = Reader.nextInt();
            Point currP = new Point(x,y);
            PolesX[k] = currP;
        }
        Arrays.sort(PolesX,new CompareX());
        // System.out.println("X");
//        for(int k=0;k<N;k++){
//            System.out.print("(" + PolesX[k].x + "," + PolesX[k].y + ") ");
//        }
//        System.out.println("Y");
//        for(int k=0;k<N;k++){
//            System.out.print("(" + PolesY[k].x + "," + PolesY[k].y + ") ");
//        }
        System.out.println(minPerimeter(PolesX,0,N-1));
    }
}
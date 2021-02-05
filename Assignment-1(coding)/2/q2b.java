import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.lang.Math;

class Pointcl
{
    int x,y;
    Pointcl(int xx, int yy)
    {
        x=xx;
        y=yy;
    }
}
public class q2b {

    static void comparex(Pointcl[] arr)
    {
        Arrays.sort(arr, Comparator.comparingInt(p -> p.x));
    }

    static void comparey(Pointcl[] arr)
    {
        Arrays.sort(arr, new Comparator<Pointcl>() {
            @Override public int compare(Pointcl p1, Pointcl p2)
            {
                return p1.y - p2.y;
            }
        });
    }

    static double distTwoP(Pointcl a, Pointcl b)
    {
        return Math.sqrt( (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y) );
    }

    static double thPdist(Pointcl a, Pointcl b, Pointcl c)
    {
        return distTwoP(a,b)+distTwoP(b,c)+distTwoP(c,a);
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        Pointcl[] parr = new Pointcl[N];

        for(int t=0;t<N;t++)
        {
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            parr[t]= new Pointcl(a1,a2);
        }

        comparex(parr);

        double finalAns=1000000000000.0,c;

        for(int i=0;i<N;i++)
        {
            int win=Math.min(N-i,16);
            for(int j=1;j<win;j++)
            {
                for(int k=j+1;k<win;k++)
                {
                    c=thPdist(parr[i],parr[i+j], parr[i+k]);
                    finalAns= Math.min(c,finalAns);
                }
            }
        }

        comparey(parr);
        for(int i=0;i<N;i++)
        {
            int win=Math.min(N-i,16);
            for(int j=1;j<win;j++)
            {
                for(int k=j+1;k<win;k++)
                {
                    c=thPdist(parr[i],parr[i+j], parr[i+k]);
                    finalAns= Math.min(c,finalAns);
                }
            }
        }

        System.out.println(finalAns);

    }
}

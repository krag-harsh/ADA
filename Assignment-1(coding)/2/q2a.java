import java.util.Scanner;
import java.lang.Math;

class point
{
    int x,y;
    point(int xx, int yy)
    {
        x=xx;
        y=yy;
    }
}
public class q2a {

    static double distTwoP(point a, point b)
    {
        return Math.sqrt( (a.x-b.x)*(a.x-b.x) + (a.y-b.y)*(a.y-b.y) );
    }

    static double thPdist(point a, point b, point c)
    {
        return distTwoP(a,b)+distTwoP(b,c)+distTwoP(c,a);
    }


    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        point[] parr = new point[N];

        for(int t=0;t<N;t++)
        {
            int a1 = in.nextInt();
            int a2 = in.nextInt();
            parr[t]= new point(a1,a2);
        }


        double finalAns=100000000000.0,c;
//        System.out.println(finalAns);

        for(int i=0;i<N;i++)
        {
            int win=Math.min(N-i,N);
            for(int j=1;j<N;j++)
            {
                for(int k=2;k<N;k++)
                {
                    if(i!=j && j!=k && i!=k)
                    {
                        c=thPdist(parr[i],parr[j], parr[k]);
                        finalAns= Math.min(c,finalAns);
                    }
                }
            }
        }

        System.out.println(finalAns);

    }
}

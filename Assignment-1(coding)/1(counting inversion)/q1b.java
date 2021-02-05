import java.util.HashMap;
import java.util.Scanner;

public class q1b
{
    private static long mergeArr(int[] arr,int l, int m, int r)
    {

        int[] left= new int[m-l+1];
        int[] right= new int[r-m];

        for(int i=0;i< left.length;i++)
            left[i]=arr[l+i];

        for(int i=0;i< right.length;i++)
            right[i]=arr[m+i+1];

        int i=0,j=0,k=l;
        long count=0;
        while (i<left.length && j<right.length)
        {
            if (left[i]<=right[j])
            {
                arr[k]=left[i];
                i++;
            }
            else
            {
                arr[k]=right[j];
                count+=m+1-l-i;
                j++;
            }
            k++;
        }

        while(i< left.length)
        {
            arr[k] = left[i];
            i++;
            k++;
        }
        while (j < right.length)
        {
            arr[k] = right[j];
            j++;
            k++;
        }
        return count;
    }

    private static long countingInv(int[] arr, int l, int r)
    {
        long left, right, returnedval;
        int m=(l+r)/2;
        if(l<r)
        {
            left= countingInv(arr,l,m);
            right= countingInv(arr,m + 1,r);
            returnedval= mergeArr(arr,l,m,r);
        }
        else
            return 0;
        return left+right+returnedval;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        for(int t=0;t<T;t++)
        {
            int N = in.nextInt();
            int[] p = new int[N];
            int[] a1 = new int[N];
            int[] a2 = new int[N];
            HashMap<Integer, Integer> temp = new HashMap<>();

            for(int n=0;n<N;n++)
                a1[n] = in.nextInt();

            for(int n=0;n<N;n++)
            {
                a2[n]=in.nextInt();
                temp.put(a2[n],n);
            }

            for(int n=0;n<N;n++)
            {
                p[n]=temp.get(a1[n]);
                // System.out.print(p[n] +" ");
            }


            long finalans=countingInv(p, 0,p.length - 1);
            System.out.println(finalans);
        }
    }
}

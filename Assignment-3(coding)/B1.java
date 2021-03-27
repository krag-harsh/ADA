package B1;
import java.util.Scanner;

public class B1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int B =  scan.nextInt();

        int p = 0;
        int a;
        int b;
        for(int i = 0; i<n; i++){
            a = scan.nextInt();
            b = scan.nextInt();
            int temp = a*B*B + b*B;
            if(temp > p)
                p = temp;
        }

        System.out.println(p);
    }
}

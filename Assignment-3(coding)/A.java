package Atry3;

import java.util.Scanner;

public class A {
    public static int findTower(int arr[],int mid, int n, int  k){
        int currentTower = arr[0];
        int result = 1;
        for(int  i = 1; i<n; i++){
            if(arr[i] - currentTower == mid){
                currentTower = arr[i];
                result++;

            }
            else if(arr[i] - currentTower > mid){
                currentTower = arr[i];
                result++;
            }
        }
        return result;
    }
    public static int MinimumDistance(int arr[],int n, int k){
        int left = 0; int right = arr[n-1];
        int output = -1;
        while(left<right){
            int mid = (left+right)/2;
            int minTower = findTower(arr,mid,n,k);
            //System.out.println(minTower);
            if(minTower == k){
                //System.out.println("inside");
                output = Math.max(output,mid);
                left = mid+1;
            }
            else if(minTower > k){
                output = Math.max(output,mid);
                left = mid+1;
            }
            else{
                right = mid;
            }
        }
        return output;
    }
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt(); int k = scan.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = scan.nextInt();
        }
        System.out.println(MinimumDistance(arr,n,k));
    }
}

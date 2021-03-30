package B2try5;

import java.util.*;

class item{
    long a,b,profit;
    int invested;
    item(long a, long b,int invest,long profit){
        this.a = a;
        this.b = b;
        this.invested = invest;
        this.profit = profit;
    }

}
class MaxHeap {
    public item[] array;
    public int length;
    public int getSize(){
        return length;
    }
    public MaxHeap(int size) {
        this.length = 0;
        array = new item[size+1];
    }
    public void MaxHeapify(int index) {
        int left_child = 2 * index;
        int right_child = 2 * index + 1;
        int smallest = index;
        if (left_child <= length && left_child > 0) {
            if (array[left_child].profit > array[smallest].profit) {
                smallest = left_child;
            }
        }
        if (right_child <= length && right_child > 0) {
            if (array[right_child].profit > array[smallest].profit) {
                smallest = right_child;
            }
        }
        if (smallest != index) {
            item temp = array[smallest];
            array[smallest] = array[index];
            array[index] = temp;
            MaxHeapify(smallest);
        }
    }
    public item delete_maximum() {
        if (length == 0) {
            return null;
        }
        item minimum = array[1];
        array[1] = array[length];
        length--;
        MaxHeapify(1);
        return minimum;
    }
    public item getMaximum(){
        if(length == 0){
            return null;
        }
        return array[1];
    }
    public void heapify_with_parent(int index)
    {
        int parent = index / 2;
        while (index > 1 && array[parent].profit < array[index].profit)
        {
            item temp = array[parent];
            array[parent] = array[index];
            array[index] = temp;
            index = index / 2;
            parent = index / 2;
        }
    }
    public void insert(item value)
    {
        length++;
        array[length] = value;
        heapify_with_parent(length);
    }
}

public class B2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        int B = scan.nextInt();
        long a,b;
        ArrayList<item> Items = new ArrayList<>();
        MaxHeap heap = new MaxHeap(n);
        for(int i = 0; i<n ; i++){
            a = scan.nextInt();
            b = scan.nextInt();
            Items.add(new item(a,b,0,a+b));
            if(a+b>0) {
                heap.insert(Items.get(i));
            }
        }
        long finalOutput = 0;
        while(B>0 && heap.getSize()>0){
            item temp = heap.delete_maximum();
            temp.invested++;
            temp.profit = 2*temp.a*temp.invested + temp.a + temp.b;
            if(temp.profit > 0){
                heap.insert(temp);
            }
            B--;
        }

        for(int i=0; i<n; i++){
            item temp = Items.get(i);
            finalOutput += temp.a*temp.invested*temp.invested + temp.b*temp.invested;
        }

        System.out.println(finalOutput);
    }
}

package heap;

public class MaxPQ{
    private Integer[] heap;
    private int n;

    public MaxPQ(int capacity){
        this.heap = new Integer[capacity];
        this.n = 0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void resize(int capacity){
        Integer[] temp = new Integer[capacity];
        for(int i = 0; i < n; i++){
            temp[i] = heap[i];
        }
        heap = temp;
    }

    public void insert(int x){
        if(n == heap.length - 1){
            resize(2 * heap.length);
        }

        n++;
        heap[n] = x;
        swim(n);
    }

    private void swim(int k){
        while(k > 1 && heap[k/2] < heap[k]){
            int temp = heap[k/2];
            heap[k/2] = heap[k];
            heap[k] = temp;
            k /= 2;
        }
    }

    public void printHeap(){
        for(Integer i : heap){
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public int deleteMax(){
        int max = heap[1];
        swap(1, n);
        heap[n] = null;
        n--;
        sink(1);
        if(n > 0 && (n == (heap.length - 1)/ 4)){
            resize(heap.length/2);
        }
        return max;
    }

    private void sink(int k){
        while( 2 * k <= n){
            int i = 2 * k;
            if(i > n && heap[i] < heap[i + 1]){
                i++;
            }
            if(heap[k] >= heap[i]){
                break;
            }
            swap(i,k);
            k = i;
        }
    }

    private void swap(int a, int b){
        int temp = heap[a];
        heap[a] = heap[b];
        heap[b] = temp;
    }


    public static void main(String[] args) {
        MaxPQ pq = new MaxPQ(10);
        pq.insert(9);
        pq.insert(3);
        pq.insert(6);
        pq.insert(2);
        pq.insert(1);
        pq.insert(5);
        pq.insert(4);
        pq.insert(10);

        System.out.println(pq.size());
        System.out.println(pq.isEmpty());
        pq.printHeap();

        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());
        System.out.println(pq.deleteMax());

        pq.printHeap();
    }

}

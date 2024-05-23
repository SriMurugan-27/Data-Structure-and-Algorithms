package hash;

public class HashTable {
    private HashNode[] buckets;
    private int numOfBuckets;
    private int size;

    public HashTable(int capacity){
        this.numOfBuckets = capacity;
        this.buckets = new HashNode[capacity];
    }

    private class HashNode{
        private Integer key;
        private String value;
        private HashNode next;

        public HashNode(Integer key, String value){
            this.key = key;
            this.value = value;
        }

    }

    private int getBucketKey(Integer key){
        return key % numOfBuckets;
    }

    public void put(Integer key, String value){
        int bucket = getBucketKey(key);
        HashNode head = buckets[bucket];

        while(head != null){
            if(head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }

        size++;
        head = buckets[bucket];
        HashNode newNode = new HashNode(key, value);
        newNode.next = head;
        buckets[bucket] = newNode;
    }

    public String get(Integer key){
        int bucket = getBucketKey(key);
        HashNode head = buckets[bucket];

        while(head != null){
            if(head.key.equals(key)){
                return head.value;
            }
            head = head.next;
        }

        return null;
    }


    public String remove(Integer key){
        int bucket = getBucketKey(key);
        HashNode head = buckets[bucket];
        HashNode previous = null;

        while(head != null){
            if(head.key.equals(key)){
                break;
            }
            previous = head;
            head = head.next;
        }

        if(head == null) return null;
        size--;
        if(previous != null){
            previous.next = head.next;
        }else{
            buckets[bucket] = head.next;
        }

        return head.value;
    }
    public void printBucket(Integer key){
        int bucket = getBucketKey(key);
        HashNode current = buckets[bucket];

        while(current != null){
            System.out.print(current.value + "-->");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable(10);
        ht.put(5, "John");
        ht.put(1, "Tom");
        ht.put(10, "James");
        ht.put(26, "Tina");
        ht.put(99, "Sana");
        ht.put(105, "Mary");

        ht.printBucket(5);

        System.out.println(ht.get(10));
        System.out.println(ht.get(5));

        System.out.println(ht.remove(99));
        System.out.println(ht.remove(105));

        System.out.println(ht.get(99));
        System.out.println(ht.get(105));
    }
}

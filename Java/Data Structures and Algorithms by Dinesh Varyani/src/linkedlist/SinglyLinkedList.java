package linkedlist;

public class SinglyLinkedList {

    private ListNode head;
    private class ListNode{
        private int data;
        private ListNode next;

        public ListNode(int value){
            this.data = value;
            this.next = null;
        }
    }

    public void display(){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public void createLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
    }

    public int size(){
        ListNode temp = head;
        int count = 0;
        while(temp != null){
            count++;
            temp = temp.next;
        }
        return count;
    }

    public void insertFirst(int value){
        if(head == null){
            head = new ListNode(value);
            return;
        }

        ListNode node = new ListNode(value);
        node.next = head;
        head = node;
    }

    public void insertLast(int value){
        if(head == null){
            head = new ListNode(value);
            return;
        }

        ListNode current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = new ListNode(value);
    }

    public void insertPosition(int value, int position){
        ListNode newNode = new ListNode(value);
        if(position == 1){
            newNode.next = head;
            head = newNode;
        }else{
            int count = 1;
            ListNode previous = head;
            while(count < position - 1){
                count++;
                previous = previous.next;
            }
            ListNode current = previous.next;
            previous.next = newNode;
            newNode.next = current;
        }
    }

    public ListNode deleteFirst(){
        if(head == null){
            return null;
        }
        ListNode node = head;
        head = node.next;
        node.next = null;
        return node;
    }

    public ListNode deleteLast(){
        if(head == null){
            return null;
        }

        ListNode current = head;
        ListNode previous = null;
        while(current.next != null){
            previous = current;
            current = current.next;
        }
        previous.next = current.next;
        return current;
    }

    public ListNode deleteAt(int position){
        ListNode temp = head;
        if(position == 1){
            head = head.next;
        }else{
            int count = 1;
            while(count < position - 1){
                count++;
                temp = temp.next;
            }
            ListNode current = temp.next;
            temp.next = current.next;
            current.next = null;
        }
        return temp;
    }

    public boolean search(int value){
        ListNode current = head;
        while(current != null){
            if(current.data == value){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void reverse(){
        ListNode previous = null;
        ListNode current = head;
        ListNode next = null;

        while(current != null){
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        head = previous;
    }

    public ListNode findNthNode(int n){
        ListNode mainPointer = head;
        ListNode refPointer = head;

        int count = 0;
        while(count < n){
            refPointer = refPointer.next;
            count++;
        }
        while (refPointer != null){
            refPointer = refPointer.next;
            mainPointer = mainPointer.next;
        }

        return mainPointer;
    }

    public void removeDuplicates(){
        ListNode current = head;
        while(current != null && current.next != null){
            if(current.data == current.next.data){
                current.next = current.next.next;
            }
            current = current.next;
        }
    }

    public void insertNode(int value){
        ListNode newNode = new ListNode(value);
        ListNode current = head;
        ListNode previous = null;

        while(current != null && current.data < newNode.data){
            previous = current;
            current = current.next;
        }

        newNode.next = current;
        previous.next = newNode;
    }

    public void removeKey(int key){
        if(head == null){
            return;
        }

        ListNode current = head;
        ListNode previous = null;
        while (current != null && current.data != key){
            previous = current;
            current = current.next;
        }
        if(current == null) return;
        previous.next = current.next;

    }

    public void createLoopLinkedList(){
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);

        head = first;
        first.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = third;  //Loopped LinkedList
    }

    public boolean findLoop(){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return true;
            }
        }

        return false;
    }

    public ListNode findStartNode(){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return getStartNode(slow);
            }
        }

        return null;
    }

    private ListNode getStartNode(ListNode slow){
        ListNode temp = head;
        while(slow != temp){
            slow = slow.next;
            temp = temp.next;
        }
        return temp;
    }

    public void removeLoop(){
        ListNode slow = head;
        ListNode fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                remove(slow);
                return;
            }
        }
    }

    private void remove(ListNode slow){
        ListNode temp = head;
        while(slow.next != temp.next){
            slow = slow.next;
            temp = temp.next;
        }
        slow.next = null;
    }

    public ListNode[] createTwoLinkedList(){
        ListNode one = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode eight = new ListNode(3);

        one.next = four;
        four.next = eight;

        ListNode three = new ListNode(5);
        ListNode six = new ListNode(6);
        ListNode seven = new ListNode(4);

        three.next = six;
        six.next = seven;

        return new ListNode[] { one, three };
    }

    public void display(ListNode head){
        ListNode temp = head;
        while(temp != null){
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("null");
    }
    public ListNode merge(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (a != null && b != null){
            if(a.data <= b.data){
                tail.next = a;
                a = a.next;
            }else{
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }

        if(a == null){
            tail.next = b;
        }else{
            tail.next = a;
        }

        return dummy.next;
    }

    public ListNode addLinkedList(ListNode a, ListNode b){
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        int carry = 0;

        while(a != null || b != null){
            int x = (a != null) ? a.data : 0;
            int y = (b != null) ? b.data : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            tail.next = new ListNode(sum % 10);
            tail = tail.next;
            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }

        if(carry > 0){
            tail.next = new ListNode(carry);
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.createLinkedList();
        sll.display();

        /* Length of the LinkedList */
        System.out.println(sll.size());

        /* Insert at the Beginning */
        sll.insertFirst(0);
        sll.insertFirst(-1);
        sll.display();

        /* Insert at the end */
        sll.insertLast(7);
        sll.insertLast(8);
        sll.display();

        /* Insert at specific position */
        sll.insertPosition(5, 5);
        sll.display();

        /* Delete first Node */
        System.out.println(sll.deleteFirst().data);
        sll.display();

        /* Delete Last Node */
        System.out.println(sll.deleteLast().data);
        sll.display();

        /* Delete at specific position */
        System.out.println(sll.deleteAt(4).data);
        sll.display();

        /* Search a element in a LinkedList */
        System.out.println(sll.search(-1));
        System.out.println(sll.search(4));

        /* Reverse a LinkedList */
        sll.reverse();
        sll.display();

        /* Find the nth node from a LinkedList */
        System.out.println(sll.findNthNode(3).data);
        sll.reverse();

        /* Remove Duplicates in LinkedList */
        sll.insertFirst(0);
        sll.insertPosition(2, 4);
        sll.display();
        sll.removeDuplicates();
        sll.display();

        /* Insert a Node in a Sorted LinkedList */
        sll.insertNode(8);
        sll.insertNode(3);
        sll.display();

        /* Remove a Given Key from a LinkedList */
        sll.removeKey(3);
        sll.display();

        /* Floyd's Cycle Detection */
        sll.createLoopLinkedList();
        System.out.println(sll.findLoop());

        /* Find the starting point of the Loop */
        System.out.println(sll.findStartNode().data);

        /* Remove Loop in LinkedList */
        sll.createLoopLinkedList();
        sll.removeLoop();
        sll.display();

        /* Merge LinkedList */
        ListNode[] list = sll.createTwoLinkedList();
        ListNode result = sll.merge(list[0], list[1]);
        sll.display(result);

        /* Adding Two Sorted List */
        ListNode[] list1 = sll.createTwoLinkedList();
        ListNode ans = sll.addLinkedList(list1[0], list1[1]);
        sll.display(ans);
    }

}

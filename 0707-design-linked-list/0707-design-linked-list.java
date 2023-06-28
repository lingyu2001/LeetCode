class ListNode {
    int val;
    ListNode next;
    ListNode () {}
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
    ListNode(int val) {
        this.val = val;
    }
}
class MyLinkedList {
    int size;
    ListNode head;
    public MyLinkedList() {
        size = 0;
        head = new ListNode(0,null);
    }

    public int get(int index) {
        if (index >= size) return -1;
        ListNode p = head;
        for(int i = 0; i <= index;i++) {
            p = p.next;
        }
        return p.val;
    }

    public void addAtHead(int val) {
        ListNode newNode = new ListNode(val, head.next);
        head.next = newNode;
        size++;
    }

    public void addAtTail(int val) {
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new ListNode(val);
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) return;
        if (index == size) {
            addAtTail(val);
            return;
        }
        ListNode p = head;
        for(int i = 0; i < index; i++) {
            p = p.next;
        }
        ListNode newNode = new ListNode(val, p.next);
        p.next = newNode;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index >= size) return;
        ListNode p = head;
        for(int i = 0; i < index; i++) {
            p = p.next;
        }
        p.next = p.next.next;
        size--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */
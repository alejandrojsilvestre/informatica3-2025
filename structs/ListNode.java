package structs;

public class ListNode<T> {
    T data;
    ListNode<T> next;

    ListNode(T data) {
        this.data = data;
        this.next = null;
    }   
}

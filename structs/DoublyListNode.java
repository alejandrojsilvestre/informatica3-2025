package structs;

class DoublyListNode<T> {
    T data;
    DoublyListNode<T> prev;
    DoublyListNode<T> next;

    DoublyListNode(T data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

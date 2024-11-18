import java.util.NoSuchElementException;

public class MyLinkedList<E> {
    private Node head;
    private int numNodes;

    public MyLinkedList() {
        head = null;
        numNodes = 0;
    }

    //Them phan tu vao danh sach tai vi tri chi muc
    public void add(int index, E element) {
        if (index < 0 || index > numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        if (index == 0) {
            addFirst(element);
        } else if (index == numNodes) {
            addLast(element);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node newNode = new Node(element);
            newNode.next = current.next;
            current.next = newNode;
            numNodes++;
        }
    }

    //Them phan tu vao dau danh sach
    public void addFirst(E element) {
        Node newNode = new Node(element);
        newNode.next = head;
        head = newNode;
        numNodes++;
    }

    //Them phan tu vao cuoi danh sach
    public void addLast(E element) {
        if (head == null) {
            addFirst(element);
        } else {
            Node currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            Node newNode = new Node(element);
            currentNode.next = newNode;
            numNodes++;
        }
    }

    //Xoa phan tu tai chi muc
    public E remove(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node removedNode;
        if (index == 0) {
            removedNode = head;
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            removedNode = current.next;
            current.next = current.next.next;
        }
        numNodes--;
        return (E) removedNode.getData();
    }

    //Xoa phan tu theo gia tri
    public boolean remove(Object element) {
        if (head == null) {
            return false;
        }
        if (head.getData().equals(element)) {
            head = head.next;
            numNodes--;
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.getData().equals(element)) {
                current.next = current.next.next;
                numNodes--;
                return true;
            }
            current = current.next;
        }
        return false;
    }

    //Tra ve kich thuoc cua danh sach
    public int size() {
        return numNodes;
    }

    //Sao chep danh sach
    public MyLinkedList<E> clone() {
        MyLinkedList<E> cloneList = new MyLinkedList<>();
        Node currentNode = head;
        while (currentNode != null) {
            cloneList.addLast((E) currentNode.getData());
            currentNode = currentNode.next;
        }
        return cloneList;
    }

    //Kiem tra xem phan tu co ton tai trong danh sach khong
    public boolean contains(E o) {
        Node currentNode = head;
        while (currentNode != null) {
            if (currentNode.getData().equals(o)) {
                return true;
            }
            currentNode = currentNode.next;
        }
        return false;
    }

    //Tim chi muc cua phan tu trong danh sach
    public int indexOf(E o) {
        Node currentNode = head;
        int index = 0;
        while (currentNode != null) {
            if (currentNode.getData().equals(o)) {
                return index;
            }
            currentNode = currentNode.next;
            index++;
        }
        return -1; //Khong tim thay phan tu
    }

    //Them phan tu vao cuoi danh sach
    public boolean add(E element) {
        addLast(element);
        return true;
    }

    //Lay phan tu tai chi muc
    public E get(int index) {
        if (index < 0 || index >= numNodes) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return (E) currentNode.getData();
    }
    //Lay phan tu dau tien
    public E getFirst() {
        if(head == null) {
            throw new NoSuchElementException("List Empty!");
        }
        return (E) head.getData();
    }
    //Lay phan tu cuoi cung
    public E getLast() {
        if(head == null) {
            throw new NoSuchElementException("List Empty!");
        }
        Node currentNode = head;
        while (currentNode.next != null) {
            currentNode = currentNode.next;
        }
        return (E) currentNode.getData();
    }
    //Xoa tat ca phan tu
    public void clear(){
        head = null;
        numNodes = 0;
    }

}

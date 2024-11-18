import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        //Them phan tu vao danh sach
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        //In ra so luong phan tu
        System.out.println("Size of list: " + list.size());
        //Lay phan tu tai chi muc 2
        System.out.println("Element at index 2: " + list.get(2));
        //Kiem tra danh sach co chua phan tu 30 khong
        System.out.println("Contain 30: " + list.contains(30));
        System.out.println("Contain 100: " + list.contains(100));
        //Tim chi muc cua phan tu 40
        System.out.println("Index of 40: " + list.indexOf(40));
        //Them phan tu vao dau danh sach
        list.addFirst(5);
        System.out.println("First element after add first: " + list.getFirst());
        //Them phan tu vao cuoi danh sach
        list.addLast(60);
        System.out.println("Last element after add last: " + list.getLast());
        //Xoa phan tu tai chi muc 1
        System.out.println("Removed element: " + list.remove(1));
        System.out.println("Size of list after remove: " + list.size());
        //Xoa phan tu voi gia tri 40
        System.out.println("Remove 40: " + list.remove((Integer)40));
        //Sao chep danh sach
        MyLinkedList<Integer> cloneList = list.clone();
        System.out.println("Clone list size: " + cloneList.size());
        //Lay phan tu dau tien va cuoi cung
        System.out.println("First element: " + cloneList.getFirst());//5
        System.out.println("Last element: " + cloneList.getLast());//60
        //Xoa tat ca phan tu
        list.clear();
        System.out.println("Size of list after clear: " + list.size());
    }
}
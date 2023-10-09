import java.util.Scanner;
class DoubleLinkedList {
    int length;
    Node head;
    Node tail;
   // 链表节点定义
    class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
   // 初始化链表
        DoubleLinkedList() {
        length = 0;
        head = new Node(-1); // 头结点数据为-1
        tail = null;
    }
   // 尾插法插入元素
    void insert(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            // 如果尾节点为空，则链表为空
            head.next = newNode;
            newNode.prev = head;
            tail = newNode;
        } else {
            // 如果链表不为空，则直接在尾节点后插入新元素
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }
    // 从头至尾输出
    void printFromHead() {
        Node currentNode = head.next;
        while (currentNode != null) {
            System.out.print(currentNode.data + " ");
            currentNode = currentNode.next;
        }
        System.out.println();
    }
    // 从尾到头输出
    void printFromTail() {
        Node currentNode = tail;
        while (currentNode != null) {
            if (currentNode.data != -1) { // 判断当前节点是否为头结点
            System.out.print(currentNode.data + " ");
        }
        currentNode = currentNode.prev;
    }
    System.out.println();
}
 // 升序插入元素，使得插入值x后，新表依旧为升序
    void insertInOrder(int data) {
        Node newNode = new Node(data);
        Node currentNode = head.next;
        while (currentNode != null && currentNode.data < data) {
            currentNode = currentNode.next;
        }
        if (currentNode == null) {
            // 新元素应该插入到链表尾部
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            // 在currentNode节点前插入新元素
            Node prevNode = currentNode.prev;
            newNode.next = currentNode;
            currentNode.prev = newNode;
            prevNode.next = newNode;
            newNode.prev = prevNode;
        }
        length++;
    }
    public static void main(String[] args) {
        DoubleLinkedList list = new DoubleLinkedList();
        Scanner scanner = new Scanner(System.in);
       // 用尾插法创建链表
        System.out.print("请输入链表长度：");
        int n = scanner.nextInt();
        System.out.println("请输入" + n + "个数字：");
        for (int i = 0; i < n; i++) {
            int data = scanner.nextInt();
            list.insert(data);
        }
        System.out.print("从头至尾输出：");
        list.printFromHead();
        System.out.print("从尾到头输出：");
        list.printFromTail();
        // 升序插入元素
        System.out.print("请输入要插入的数字：");
        int x = scanner.nextInt();
        list.insertInOrder(x);
        System.out.print("插入" + x + "后的链表，从头至尾输出：");
        list.printFromHead();
    }
}

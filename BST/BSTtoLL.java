package BST;
/*Problem statement
Given a BST, convert it into a sorted linked list. You have to return the head of LL.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
1<=n<=10^5
Note:
In case if you are facing any issue to solve this problem, please prefer to use the helper function.
Sample Input 1:
8 5 10 2 6 -1 -1 -1 -1 -1 7 -1 -1


Sample Output 1:
2 5 6 7 8 10 */


class PassNode<T> {
    T head;
    T tail;
}

class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
    }
}

class LinkedListNode<T> {
    T data;
    LinkedListNode<T> next;

    public LinkedListNode(T data) {
        this.data = data;
    }
}




public class BSTtoLL {
    public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
        PassNode<LinkedListNode<Integer>> passNode = constructLinkedListHelper(root);
        return passNode.head;
    }

    public static PassNode<LinkedListNode<Integer>> constructLinkedListHelper(BinaryTreeNode<Integer> root) {
        if (root == null) {
            return new PassNode<LinkedListNode<Integer>>();
        }

        if (root.left == null && root.right == null) {
            PassNode<LinkedListNode<Integer>> passNode = new PassNode<LinkedListNode<Integer>>();
            passNode.head = new LinkedListNode<Integer>(root.data);
            passNode.tail = passNode.head;
            return passNode;
        }

        PassNode<LinkedListNode<Integer>> passNodeLeft = constructLinkedListHelper(root.left);
        PassNode<LinkedListNode<Integer>> passNodeRight = constructLinkedListHelper(root.right);
        PassNode<LinkedListNode<Integer>> passNode = new PassNode<LinkedListNode<Integer>>();
        LinkedListNode<Integer> newNode = new LinkedListNode<Integer>(root.data);

        if (passNodeLeft.head != null) {
            passNode.head = passNodeLeft.head;
            passNodeLeft.tail.next = newNode;
        } else {
            passNode.head = newNode;
        }

        passNode.tail = (passNodeRight.tail != null) ? passNodeRight.tail : newNode;

        if (passNodeRight.head != null) {
            newNode.next = passNodeRight.head;
        }

        return passNode;
    }

    public static void main(String[] args) {
        // Sample Binary Tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        // Constructing linked list from Binary Tree
        LinkedListNode<Integer> head = constructLinkedList(root);

        // Printing the linked list
        System.out.println("Linked List from Binary Tree:");
        printLinkedList(head);
    }

    public static void printLinkedList(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

}

package BSTAdvance;

public class BinaryTreeNode<T> {
    T data;
    BinaryTreeNode<T> left;
    BinaryTreeNode<T> right;

    public BinaryTreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    public static void main(String[] args) {
        // Creating a simple binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
        root.left = new BinaryTreeNode<>(2);
        root.right = new BinaryTreeNode<>(3);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(5);
        root.right.left = new BinaryTreeNode<>(6);
        root.right.right = new BinaryTreeNode<>(7);

        System.out.println("Root: " + root.data);
        System.out.println("Left child of root: " + root.left.data);
        System.out.println("Right child of root: " + root.right.data);
        System.out.println("Left-Left child of root: " + root.left.left.data);
        System.out.println("Left-Right child of root: " + root.left.right.data);
        System.out.println("Right-Left child of root: " + root.right.left.data);
        System.out.println("Right-Right child of root: " + root.right.right.data);
    }
}

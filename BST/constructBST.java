package BST;
/*Problem statement
Given a sorted integer array A of size n, which contains all unique elements. You need to construct a balanced BST from this input array. Return the root of constructed BST.

Note: If array size is even, take first mid as root.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 second
Sample Input 1:
7
1 2 3 4 5 6 7
Sample Output 1:
4 2 1 3 6 5 7  */
public class constructBST {
    public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n) {
        return SortedArrayToBSTHelper(arr, 0, n - 1);
    }

    public static BinaryTreeNode<Integer> SortedArrayToBSTHelper(int[] arr, int si, int ei) {
        if (si > ei)
            return null;

        int mid = (si + ei) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(arr[mid]);

        root.left = SortedArrayToBSTHelper(arr, si, mid - 1);
        root.right = SortedArrayToBSTHelper(arr, mid + 1, ei);
        return root;
    }

    public static void main(String[] args) {
        // Sample input array
        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        int n = arr.length;

        // Constructing BST from sorted array
        BinaryTreeNode<Integer> root = SortedArrayToBST(arr, n);

        System.out.println("In-order traversal of constructed BST:");
        printInOrder(root);
    }

    public static void printInOrder(BinaryTreeNode<Integer> root) {
        if (root != null) {
            printInOrder(root.left);
            System.out.print(root.data + " ");
            printInOrder(root.right);
        }
    }
}

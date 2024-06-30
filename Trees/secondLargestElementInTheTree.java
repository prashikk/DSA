package Trees;
/*Problem statement
Given a generic tree, find and return the node with second largest value in given tree. Return NULL if no node with required value is present.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
40 */
public class secondLargestElementInTheTree {
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root) {
        if (root == null || root.children.isEmpty()) {
            return null;
        }

        TreeNode<Integer> firstLargest = new TreeNode<>(Integer.MIN_VALUE);
        TreeNode<Integer> secondLargest = new TreeNode<>(Integer.MIN_VALUE);

        findSecondLargestUtil(root, firstLargest, secondLargest);

        return secondLargest.data != Integer.MIN_VALUE ? secondLargest : null;
    }

    private static void findSecondLargestUtil(TreeNode<Integer> root, TreeNode<Integer> firstLargest,
            TreeNode<Integer> secondLargest) {
        if (root == null)
            return;

        // Update firstLargest and secondLargest based on current node's data
        if (root.data > firstLargest.data) {
            secondLargest.data = firstLargest.data; // Update secondLargest with previous firstLargest
            firstLargest.data = root.data; // Update firstLargest with current node's data
        } else if (root.data > secondLargest.data && root.data < firstLargest.data) {
            secondLargest.data = root.data; // Update secondLargest if current node's data is greater than secondLargest but less than firstLargest
        }

        // Recursively traverse children
        for (TreeNode<Integer> child : root.children) {
            findSecondLargestUtil(child, firstLargest, secondLargest);
        }
    }

    public static void main(String[] args) {
        // Sample Input 1
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> node1 = new TreeNode<>(20);
        TreeNode<Integer> node2 = new TreeNode<>(30);
        TreeNode<Integer> node3 = new TreeNode<>(40);
        TreeNode<Integer> node4 = new TreeNode<>(40);
        TreeNode<Integer> node5 = new TreeNode<>(50);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node3.children.add(node4);
        node3.children.add(node5);

        TreeNode<Integer> secondLargestNode = findSecondLargest(root);
        if (secondLargestNode != null) {
            System.out.println("Sample Output 1: " + secondLargestNode.data); // Expected Output: 40
        } else {
            System.out.println("Sample Output 1: NULL");
        }
    }

}

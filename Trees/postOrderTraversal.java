package Trees;
/*Problem statement
Given a generic tree, print the post-order traversal of given tree.

The post-order traversal is: visit child nodes first and then root node.


For the given tree, the post order traversal will be 40 50 20 30 40 10
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 sec
Sample Input 1:
10 3 20 30 40 2 400 50 0 0 0 0 
Sample Output 1:
400 50 20 30 40 10
Explanation
For 10 , total 3 children are there : 20 30 40
For  20, total 2 children are there : 400 50
So, the output will be 400 50 20 30 40 10 */
public class postOrderTraversal {
    public static void printPostOrder(TreeNode<Integer> root){
		 	if(root==null) {
			return;
		}
		for(int i=0;i<root.children.size();i++) {
			printPostOrder(root.children.get(i));
		}
		System.out.print(root.data+" ");
	}
    public static void main(String[] args) {
        // Sample Input 1: 10 3 20 30 40 2 400 50 0 0 0 0
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(20);
        TreeNode<Integer> node3 = new TreeNode<>(30);
        TreeNode<Integer> node4 = new TreeNode<>(40);
        TreeNode<Integer> node5 = new TreeNode<>(2);
        TreeNode<Integer> node6 = new TreeNode<>(400);
        TreeNode<Integer> node7 = new TreeNode<>(50);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node1.children.add(node4);
        node1.children.add(node5);
        node2.children.add(node6);
        node2.children.add(node7);

        System.out.println("Post-order traversal:");
        printPostOrder(root); // Expected Output: 400 50 20 30 40 10
    }
}

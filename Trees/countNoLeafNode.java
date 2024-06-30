package Trees;
/*Problem statement
Given a generic tree, count and return the number of leaf nodes present in the given tree. A node is said to be a leaf node if it's not having any child


Leaf nodes in the given tree are 40, 50, 30, 40. So the answer for this is 4.
Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
4 */
public class countNoLeafNode {
    public static int countLeafNodes(TreeNode<Integer> root){

		// Write your code here
			if(root==null) {
			return 0;
		}
		int count=0;
		if(root.children.size()==0) {
			count++;
			
		}
		
		for(int i=0;i<root.children.size();i++) {
			
				count+=countLeafNodes(root.children.get(i));
			
		}
		return count;

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

        int leafNodeCount = countLeafNodes(root);
        System.out.println("Sample Output 1: " + leafNodeCount); // Expected Output: 4
    }

}

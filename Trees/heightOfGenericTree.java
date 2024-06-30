package Trees;
/*Problem statement
Given a generic tree, find and return the height of given tree. The height of a tree is defined as the longest distance from root node to any of the leaf node. Assume the height of a tree with a single node is 1.

Detailed explanation ( Input/output format, Notes, Images )
Constraints:
Time Limit: 1 sec
Sample Input 1:
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1:
3 */
public class heightOfGenericTree {
    public static int getHeight(TreeNode<Integer> root){
		 	if(root==null) {
			return 0;
		}
		int max=1;
		for(int i=0;i<root.children.size();i++) {
			int numchild =1+getHeight(root.children.get(i));
			if(max<numchild) {
				max=numchild;
			}
		}
		return max;
	}
    public static void main(String[] args) {
        // Sample Input 1
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> node1 = new TreeNode<>(3);
        TreeNode<Integer> node2 = new TreeNode<>(20);
        TreeNode<Integer> node3 = new TreeNode<>(30);
        TreeNode<Integer> node4 = new TreeNode<>(40);
        TreeNode<Integer> node5 = new TreeNode<>(2);
        TreeNode<Integer> node6 = new TreeNode<>(40);
        TreeNode<Integer> node7 = new TreeNode<>(50);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node1.children.add(node4);
        node1.children.add(node5);
        node2.children.add(node6);
        node2.children.add(node7);

        int height = getHeight(root);
        System.out.println("Height of the tree: " + height); // Output: 3
    }
}

package Trees;
/*Problem statement
Given a generic tree and an integer n. Find and return the node with next larger element in the Tree i.e. find a node with value just greater than n.

Return NULL if no node is present with value greater than n.


Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
18
10 3 20 30 40 2 40 50 0 0 0 0 
Representation of Input


Sample Output 1 :
20
Explanation
In the given tree, the value which is just greater than 18 is 20.
Sample Input 2 :
21
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
30 */
public class nextLargerElement {
    public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
		
		// Write your code here
		   if(root == null) return null;
        TreeNode<Integer> nextLargerNode = null;
        if(root.data > n) nextLargerNode = root;
        
        for(int i = 0; i < root.children.size(); i++) {
            TreeNode<Integer> nextLargerInChild = findNextLargerNode(root.children.get(i), n);
            if(nextLargerInChild != null) {
                if(nextLargerNode == null || nextLargerInChild.data < nextLargerNode.data) {
                    nextLargerNode = nextLargerInChild;
                }
            }
        }
        return nextLargerNode;

	}
    public static void main(String[] args) {
        // Sample Input 1
        int n1 = 18;
        TreeNode<Integer> root1 = new TreeNode<>(10);
        TreeNode<Integer> node1_1 = new TreeNode<>(20);
        TreeNode<Integer> node1_2 = new TreeNode<>(30);
        TreeNode<Integer> node1_3 = new TreeNode<>(40);
        TreeNode<Integer> node1_4 = new TreeNode<>(40);
        TreeNode<Integer> node1_5 = new TreeNode<>(50);

        root1.children.add(node1_1);
        root1.children.add(node1_2);
        root1.children.add(node1_3);
        node1_3.children.add(node1_4);
        node1_3.children.add(node1_5);

        TreeNode<Integer> result1 = findNextLargerNode(root1, n1);
        System.out.println("Sample Output 1: " + (result1 != null ? result1.data : "NULL")); // Expected Output: 20

        // Sample Input 2
        int n2 = 21;
        TreeNode<Integer> root2 = new TreeNode<>(10);
        TreeNode<Integer> node2_1 = new TreeNode<>(20);
        TreeNode<Integer> node2_2 = new TreeNode<>(30);
        TreeNode<Integer> node2_3 = new TreeNode<>(40);
        TreeNode<Integer> node2_4 = new TreeNode<>(40);
        TreeNode<Integer> node2_5 = new TreeNode<>(50);

        root2.children.add(node2_1);
        root2.children.add(node2_2);
        root2.children.add(node2_3);
        node2_3.children.add(node2_4);
        node2_3.children.add(node2_5);

        TreeNode<Integer> result2 = findNextLargerNode(root2, n2);
        System.out.println("Sample Output 2: " + (result2 != null ? result2.data : "NULL")); // Expected Output: 30
    }
}

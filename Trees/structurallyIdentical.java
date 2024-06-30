package Trees;
/*Problem statement
Given two Generic trees, return true if they are structurally identical i.e. they are made of nodes with the same values arranged in the same way.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
10 3 20 30 40 2 40 50 0 0 0 0
Sample Output 1 :
true
Explanation
If we draw the tree for the above inputs, both the trees will look like this. So the answer for this is true.


Sample Input 2 :
10 3 20 30 40 2 40 50 0 0 0 0 
10 3 2 30 40 2 40 50 0 0 0 0
Sample Output 2:
false */
public class structurallyIdentical {
    public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){

		// Write your code here
		  if(root1 == null && root2 == null) return true;
		if(root1 == null || root2 == null) return false;       
        if(!root1.data.equals(root2.data)) return false;
        if(root1.children.size() != root2.children.size()) return false;
        
        for(int i = 0; i < root1.children.size(); i++) {
            if(!checkIdentical(root1.children.get(i), root2.children.get(i))) {
                return false;
            }
        }
        return true;
	}

    public static void main(String[] args) {
        // Sample Input 1
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

        boolean result1 = checkIdentical(root1, root2);
        System.out.println("Sample Output 1: " + result1); // Expected Output: true

        // Sample Input 2
        TreeNode<Integer> root3 = new TreeNode<>(10);
        TreeNode<Integer> node3_1 = new TreeNode<>(20);
        TreeNode<Integer> node3_2 = new TreeNode<>(30);
        TreeNode<Integer> node3_3 = new TreeNode<>(40);
        TreeNode<Integer> node3_4 = new TreeNode<>(40);
        TreeNode<Integer> node3_5 = new TreeNode<>(50);

        root3.children.add(node3_1);
        root3.children.add(node3_2);
        root3.children.add(node3_3);
        node3_3.children.add(node3_4);
        node3_3.children.add(node3_5);

        TreeNode<Integer> root4 = new TreeNode<>(10);
        TreeNode<Integer> node4_1 = new TreeNode<>(20);
        TreeNode<Integer> node4_2 = new TreeNode<>(30);
        TreeNode<Integer> node4_3 = new TreeNode<>(2); // Different node data
        TreeNode<Integer> node4_4 = new TreeNode<>(40);
        TreeNode<Integer> node4_5 = new TreeNode<>(50);

        root4.children.add(node4_1);
        root4.children.add(node4_2);
        root4.children.add(node4_3);
        node4_3.children.add(node4_4);
        node4_3.children.add(node4_5);

        boolean result2 = checkIdentical(root3, root4);
        System.out.println("Sample Output 2: " + result2); // Expected Output: false
    }
}

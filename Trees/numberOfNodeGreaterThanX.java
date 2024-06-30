package Trees;
/*Problem statement
Given a tree and an integer x, find and return number of Nodes which are greater than x.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
35 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 1 :
3
Explanation
Since x=35, the elements which are greater than 35 are 40, 40, 50, so the output for this is 3.
Sample Input 2 :
10 10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output 2:
5
Explanation
Since x=10, the elements which are greater than 10 are 20, 30, 40,  40, 50, so the output for this is 5. */
public class numberOfNodeGreaterThanX {
    public static int numNodeGreater(TreeNode<Integer> root,int x){

		// Write your code here	
      if(root == null)
            return 0;
        
        int count = 0;
        if(root.data > x)
        {
            count++;
        }
    	for(TreeNode<Integer> node : root.children)
            count += numNodeGreater(node, x);
        return count;

	}
    public static void main(String[] args) {
        // Sample Input 1
        TreeNode<Integer> root1 = new TreeNode<>(35);
        TreeNode<Integer> node1_1 = new TreeNode<>(10);
        TreeNode<Integer> node1_2 = new TreeNode<>(3);
        TreeNode<Integer> node1_3 = new TreeNode<>(20);
        TreeNode<Integer> node1_4 = new TreeNode<>(30);
        TreeNode<Integer> node1_5 = new TreeNode<>(40);
        TreeNode<Integer> node1_6 = new TreeNode<>(2);
        TreeNode<Integer> node1_7 = new TreeNode<>(40);
        TreeNode<Integer> node1_8 = new TreeNode<>(50);

        root1.children.add(node1_1);
        root1.children.add(node1_2);
        root1.children.add(node1_3);
        root1.children.add(node1_4);
        root1.children.add(node1_5);
        node1_2.children.add(node1_6);
        node1_5.children.add(node1_7);
        node1_5.children.add(node1_8);

        int x1 = 35;
        int result1 = numNodeGreater(root1, x1);
        System.out.println("Number of nodes greater than " + x1 + ": " + result1); // Output: 3

        // Sample Input 2
        TreeNode<Integer> root2 = new TreeNode<>(10);
        TreeNode<Integer> node2_1 = new TreeNode<>(10);
        TreeNode<Integer> node2_2 = new TreeNode<>(3);
        TreeNode<Integer> node2_3 = new TreeNode<>(20);
        TreeNode<Integer> node2_4 = new TreeNode<>(30);
        TreeNode<Integer> node2_5 = new TreeNode<>(40);
        TreeNode<Integer> node2_6 = new TreeNode<>(2);
        TreeNode<Integer> node2_7 = new TreeNode<>(40);
        TreeNode<Integer> node2_8 = new TreeNode<>(50);

        root2.children.add(node2_1);
        root2.children.add(node2_2);
        root2.children.add(node2_3);
        root2.children.add(node2_4);
        root2.children.add(node2_5);
        node2_2.children.add(node2_6);
        node2_5.children.add(node2_7);
        node2_5.children.add(node2_8);

        int x2 = 10;
        int result2 = numNodeGreater(root2, x2);
        System.out.println("Number of nodes greater than " + x2 + ": " + result2); // Output: 5
    }
}

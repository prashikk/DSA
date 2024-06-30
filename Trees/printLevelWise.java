package Trees;
import java.util.*;;
/*Problem statement
Given a generic tree, print the input tree in level wise order. That is, print the elements at same level in one line (separated by space). Print different levels in different lines.



The output for the above tree should be 
10
20 30 40
40 50
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
10
20 30 40 
40 50 */
public class printLevelWise {
    public static void printLevelWise(TreeNode<Integer> root){
		/* Your class should be named Solution 
 		 * Don't write main(). 
		 * Don't read input, it is passed as function argument. 
		 * Print output and don't return it. 
		 * Taking input is handled automatically. 
		 */
		 Queue<TreeNode<Integer>> q = new LinkedList<>();
        if(root == null)
            return;
        q.add(root);
        q.add(null);
        
        while(!q.isEmpty()){
            TreeNode<Integer> node = q.poll();
            if(node != null)
            {
                System.out.print(node.data + " ");
                for(int i=0; i<node.children.size(); i++)
                    q.add(node.children.get(i));
            }
            else{
                System.out.println();
                if(!q.isEmpty())
                    q.add(null);
            }
        }

	}
    public static void main(String[] args) {
        // Creating a sample tree as per the given input
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> node20 = new TreeNode<>(20);
        TreeNode<Integer> node30 = new TreeNode<>(30);
        TreeNode<Integer> node40 = new TreeNode<>(40);
        TreeNode<Integer> node40_1 = new TreeNode<>(40); // Another node with value 40
        TreeNode<Integer> node50 = new TreeNode<>(50);
        
        root.children.add(node20);
        root.children.add(node30);
        root.children.add(node40);
        
        node20.children.add(node40_1); // Adding children to node20
        node20.children.add(node50);
        
        // Print the tree level-wise
        printLevelWise(root);
    }

}

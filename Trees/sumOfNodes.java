package Trees;
/*Problem statement
Given a generic tree, count and return the sum of all nodes present in the given tree.



For the above tree , total sum of all nodes is 10 + 30 + 50 + 25 + 5 + 45 + 56 + 34 = 225
Detailed explanation ( Input/output format, Notes, Images )
Sample Input :
10 3 20 30 40 2 40 50 0 0 0 0 
Sample Output :
190
Explananation
For 10, 3 children are there : 20, 30, 40
For 20. 2 children are there : 40, 50
For 30, 40, 40, 50 no child is there , so the answer for this is 10+20+30+40+40+50 = 190 */
public class sumOfNodes {
    
	public static int sumOfAllNode(TreeNode<Integer> root){
		int sum=0;
		
		if(root==null) {
			return 0;
		}
		
		for(int i=0;i<root.children.size();i++) {
			sum+=sumOfAllNode(root.children.get(i));
		}
		return root.data+sum;
	}

      
    public static void main(String[] args) {
        // Creating a sample tree as per the given input
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> node20 = new TreeNode<>(20);
        TreeNode<Integer> node30 = new TreeNode<>(30);
        TreeNode<Integer> node40 = new TreeNode<>(40);
        TreeNode<Integer> node50 = new TreeNode<>(50);
        
        root.children.add(node20);
        root.children.add(node30);
        root.children.add(node40);
        
        node20.children.add(new TreeNode<>(40));
        node20.children.add(new TreeNode<>(50));
        
        // Calculate sum of all nodes
        int totalSum = sumOfAllNode(root);
        
        // Print the result
        System.out.println("Sum of all nodes: " + totalSum);
    }
}

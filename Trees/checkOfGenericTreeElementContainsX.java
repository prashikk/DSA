package Trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*Problem statement
Given a generic tree and an integer x, check if x is present in the given tree or not. Return true if x is present, return false otherwise.

Input format :

Line 1 : Integer x

Line 2 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : true or false

Sample Input 1 :
40
10 3 20 30 40 2 40 50 0 0 0 0 

Sample Output 1 :
true
Explanation
Since, 40 is present in the given tree, so the answer will be true.
Sample Input 2 :
4
10 3 20 30 40 2 40 50 0 0 0 0 

Sample Output 2:
false
Explanation
Since, 4 is not present in the given tree, so the answer is false. */
public class checkOfGenericTreeElementContainsX {
    
	public static boolean checkIfContainsX(TreeNode<Integer> root, int x){

		// Write your code here
		if(root==null) {
			return false;
		}
	
		if(root.data==x) {
			return true;
		}
		for(int i=0;i<root.children.size();i++) {
			if(checkIfContainsX(root.children.get(i),x)) {
				return true;
			}
			
		}
		return false;

	}
    public static void main(String[] args) {
        // Sample Input 1: 40 10 3 20 30 40 2 40 50 0 0 0 0 
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(); // Read the element to search
        TreeNode<Integer> root = takeInputLevelWise(); // Read the tree in level order
        
        boolean result = checkIfContainsX(root, x);
        System.out.println(result); // Output: true or false
    }

    // Helper method to take input in level order and construct the tree
    public static TreeNode<Integer> takeInputLevelWise() {
        Scanner sc = new Scanner(System.in);
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        
        // Read the root node
        int rootData = sc.nextInt();
        TreeNode<Integer> root = new TreeNode<>(rootData);
        queue.add(root);
        
        while(!queue.isEmpty()) {
            TreeNode<Integer> frontNode = queue.poll();
            
            int numChildren = sc.nextInt();
            
            for(int i = 0; i < numChildren; i++) {
                int childData = sc.nextInt();
                TreeNode<Integer> childNode = new TreeNode<>(childData);
                frontNode.children.add(childNode);
                queue.add(childNode);
            }
        }
        
        return root;
    }


}

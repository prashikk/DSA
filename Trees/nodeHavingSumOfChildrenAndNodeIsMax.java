package Trees;
/*Problem statement
Given a tree, find and return the node for which sum of data of all children and the node itself is maximum. In the sum, data of node itself and data of immediate children is to be taken.

Input format :

Line 1 : Elements in level order form separated by space (as per done in class). Order is -

Root_data, n (No_Of_Child_Of_Root), n children, and so on for every element

Output format : Node with maximum sum.

Sample Input 1 :
5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
Representation of input


Sample Output 1 :
1
Explanation
Sum of node 1 and it's child (15) is maximum among all the nodes, so the output for this is 1. */


class Pair {
    TreeNode<Integer> node;
    int xSum;
}


public class nodeHavingSumOfChildrenAndNodeIsMax {
    public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		// Write your code here
if(root == null) return null;
        Pair ans = helper(root);
        return ans.node;

	}
	 public static Pair helper(TreeNode<Integer> root) {
        Pair ans = new Pair();
        ans.node = root;
        int sum = root.data;
        for(int i = 0; i < root.children.size(); i++) {
            sum += root.children.get(i).data;
        }
        ans.xSum = sum;

        for(int i = 0; i < root.children.size(); i++) {
            Pair smallAns = helper(root.children.get(i));
            if(smallAns.xSum > ans.xSum) {
                ans.xSum = smallAns.xSum;
                ans.node = smallAns.node;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        // Sample Input 1: 5 3 1 2 3 1 15 2 4 5 1 6 0 0 0 0
        TreeNode<Integer> root = new TreeNode<>(5);
        TreeNode<Integer> node1 = new TreeNode<>(1);
        TreeNode<Integer> node2 = new TreeNode<>(15);
        TreeNode<Integer> node3 = new TreeNode<>(2);
        TreeNode<Integer> node4 = new TreeNode<>(3);
        TreeNode<Integer> node5 = new TreeNode<>(4);
        TreeNode<Integer> node6 = new TreeNode<>(5);
        TreeNode<Integer> node7 = new TreeNode<>(1);
        TreeNode<Integer> node8 = new TreeNode<>(6);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node1.children.add(node4);
        node1.children.add(node5);
        node1.children.add(node6);
        node2.children.add(node7);
        node2.children.add(node8);

        TreeNode<Integer> resultNode = maxSumNode(root);
        if(resultNode != null)
            System.out.println(resultNode.data); // Output: Node with maximum sum
    }
}

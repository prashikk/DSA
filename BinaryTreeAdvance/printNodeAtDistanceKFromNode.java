package BinaryTreeAdvance;
/*Problem statement
You are given a Binary Tree of type integer, a integer value of target node's data, and an integer value K.

Print the data of all nodes that have a distance K from the target node. The order in which they would be printed will not matter.

Example:
For a given input tree(refer to the image below):
1. Target Node: 5
2. K = 2
alt txt

Starting from the target node 5, the nodes at distance K are 7 4 and 1.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
1 <= N <= 10^5
Where N is the total number of nodes in the binary tree.
1 ≤ data of node ≤ 10^9
1 ≤ target ≤ 10^9

Time Limit: 1 sec
Sample Input 1:
5 6 10 2 3 -1 -1 -1 -1 -1 9 -1 -1
3 1
Sample Output 1:
9
6
Sample Input 2:
1 2 3 4 5 6 7 -1 -1 -1 -1 -1 -1 -1 -1
3 3
Sample Output 2:
4
5 */
public class printNodeAtDistanceKFromNode {
    private static int print(BinaryTreeNode<Integer> root, int node, int k)
    {
        //If tree is empty return -1
        if (root==null)
            return -1;
        
        int rootData=root.data;
        if (rootData==node)
        {
            printNodesAtDistanceK(root, k);
            return 0;
        }
        
        int leftSubTreeDist=0,rightSubTreeDist=0;
        
        leftSubTreeDist=print(root.left,node,k);
        if (leftSubTreeDist!=-1)
        {
            if(leftSubTreeDist+1==k)
            {
                System.out.println(rootData);
            }
            else
            {
                rightSubTreeDist=k-(leftSubTreeDist+1)-1;
                printNodesAtDistanceK(root.right, rightSubTreeDist);
            }
            return leftSubTreeDist+1;
        }
        
        rightSubTreeDist=print(root.right,node,k);
        if (rightSubTreeDist!=-1)
        {
            if(rightSubTreeDist+1==k)
            {
                System.out.println(rootData);
            }
            else
            {
                leftSubTreeDist=k-(rightSubTreeDist+1)-1;
                printNodesAtDistanceK(root.left, leftSubTreeDist);
            }
            return rightSubTreeDist+1;
        }
        return -1;
    }
    
    private static void printNodesAtDistanceK(BinaryTreeNode<Integer> root, int k)
    {
        if (root==null || k<0)
        	return;
        
        if (k == 0)  
        { 
            System.out.println(root.data); 
            return; 
        }
        
        printNodesAtDistanceK(root.left,k-1);
        printNodesAtDistanceK(root.right,k-1);
    }

	public static void nodesAtDistanceK(BinaryTreeNode<Integer> root, int node, int k) {
	    //Your code goes here
		  print(root,node,k);
	}

    public static void main(String[] args) {
        // Creating a sample binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(20);
        root.left = new BinaryTreeNode<>(8);
        root.right = new BinaryTreeNode<>(22);
        root.left.left = new BinaryTreeNode<>(4);
        root.left.right = new BinaryTreeNode<>(12);
        root.left.right.left = new BinaryTreeNode<>(10);
        root.left.right.right = new BinaryTreeNode<>(14);

        int nodeValue = 8; // Node value to start from
        int distance = 2; // Distance from node to print nodes

        // Calling the function to print nodes at distance k
        nodesAtDistanceK(root, nodeValue, distance);
    }
}

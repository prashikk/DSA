package BinaryTreeAdvance;
/*Problem statement
For a given a Binary Tree of type integer, find and return the minimum and the maximum data values.

Return the output as an object of Pair class, which is already created.

Note:
All the node data will be unique and hence there will always exist a minimum and maximum node data.
Detailed explanation ( Input/output format, Notes, Images )
Constraints:
2 <= N <= 10^5
Where N is the total number of nodes in the binary tree.

Time Limit: 1 sec
Sample Input 1:
8 3 10 1 6 -1 14 -1 -1 4 7 13 -1 -1 -1 -1 -1 -1 -1
Sample Output 1:
1 14
Sample Input 2:
10 20 60 -1 -1 3 50 -1 -1 -1 -1 
Sample Output 2:
3 60 */


//Representation of the Pair Class

class Pair<T, U> {
    T minimum;
    U maximum;

    public Pair(T minimum, U maximum) {
        this.minimum = minimum;
        this.maximum = maximum;
    }

}

public class minumumAndMaximumInBinaryTree {
    private static final minumumAndMaximumInBinaryTree Solution = null;
    private static Pair<Integer,Integer> maxMin=new Pair<Integer,Integer>(Integer.MAX_VALUE,Integer.MIN_VALUE);

    private static void getMinAndMaxHelper(BinaryTreeNode<Integer> root)
    {
        if (root==null)
        {
            return;
        }
        
        int rootData=root.data;
        int maxVal=maxMin.maximum;
        if (rootData>maxVal)
        {
            maxMin.maximum=root.data;
        }
        
        int minVal=maxMin.minimum;
        if (rootData<minVal)
        {
            maxMin.minimum=root.data;
        }
        getMinAndMaxHelper(root.left);
        getMinAndMaxHelper(root.right);
    }
	
	public static Pair<Integer, Integer> getMinAndMax(BinaryTreeNode<Integer> root) {
		//Your code goes here
		  getMinAndMaxHelper(root);
        return maxMin;    
	}
    public static void main(String[] args) {
        // Creating a sample binary tree
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(5);
        root.left = new BinaryTreeNode<>(3);
        root.right = new BinaryTreeNode<>(8);
        root.left.left = new BinaryTreeNode<>(2);
        root.left.right = new BinaryTreeNode<>(4);
        root.right.left = new BinaryTreeNode<>(7);
        root.right.right = new BinaryTreeNode<>(9);

        // Calling the function to get minimum and maximum values
        Pair<Integer, Integer> result = Solution.getMinAndMax(root);

        // Printing the minimum and maximum values
        System.out.println("Minimum value in the tree: " + result.minimum);
        System.out.println("Maximum value in the tree: " + result.maximum);
    }
}

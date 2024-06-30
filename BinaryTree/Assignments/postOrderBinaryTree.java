package BinaryTree.Assignments;

public class postOrderBinaryTree {
    public static void postOrder(BinaryTreeNode<Integer> root) {
		//Your code goes here
			if(root==null) {
			return;
		}
	
	//	System.out.println();
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data+" ");
	}
    public static void main(String[] args) {
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
          root.left = new BinaryTreeNode<>(2);
          root.right = new BinaryTreeNode<>(3);
          root.left.left = new BinaryTreeNode<>(4);
          root.left.right = new BinaryTreeNode<>(5);
          root.right.left = new BinaryTreeNode<>(6);
          root.right.right = new BinaryTreeNode<>(7);
  
          // Performing pre-order traversal
          System.out.print("Pre-order traversal: ");
          postOrder(root);
    }
}

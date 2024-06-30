package Trees;
import java.util.*;;
/*Problem statement
In a given Generic Tree, replace each node with its depth value. You need to just update the data of each node, no need to return or print anything. Depth of a node is defined as the distance of the node from root. You may assume that depth of root node is 0.

Detailed explanation ( Input/output format, Notes, Images )
Sample Input 1 :
10 3 20 30 40 2 40 50 0 0 0 0 
Representation of Input:


Sample Output 1 : (Level wise, each level in new line)
0 
1 1 1 
2 2
Explanation
Since root is 10 , so it's depth is 0
Node 20, 30 , 40 are present at 1st level , so their depth is 1.
Node 40,50 are present at 2nd level, so their depth is 2. */
public class replaceNodeWithDepth {
    public static void replaceWithDepthValue(TreeNode<Integer> root){

        if(root==null)
         {
             return;
         }
         replaceWithDepthValue(root,0);
         
     }
     public static void replaceWithDepthValue(TreeNode<Integer>root,int depth)
     {
         root.data=depth;
         for(TreeNode<Integer>child:root.children)
         {
             replaceWithDepthValue(child,depth+1);
         }
     }

     public static void main(String[] args) {
        // Sample Input 1
        TreeNode<Integer> root = new TreeNode<>(10);
        TreeNode<Integer> node1 = new TreeNode<>(20);
        TreeNode<Integer> node2 = new TreeNode<>(30);
        TreeNode<Integer> node3 = new TreeNode<>(40);
        TreeNode<Integer> node4 = new TreeNode<>(40);
        TreeNode<Integer> node5 = new TreeNode<>(50);

        root.children.add(node1);
        root.children.add(node2);
        root.children.add(node3);
        node3.children.add(node4);
        node3.children.add(node5);

        replaceWithDepthValue(root);
        printLevelWise(root);
    }

    public static void printLevelWise(TreeNode<Integer> root) {
        if (root == null)
            return;

        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);

        while (!queue.isEmpty()) {
            TreeNode<Integer> node = queue.poll();
            if (node != null) {
                System.out.print(node.data + " ");
                for (TreeNode<Integer> child : node.children) {
                    queue.add(child);
                }
            } else {
                System.out.println();
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            }
        }
    }
}

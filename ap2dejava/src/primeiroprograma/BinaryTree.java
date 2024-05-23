// Exercício 1

package primeiroprograma;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTree {
    TreeNode root;

    public BinaryTree() {
        root = null;
    }

    
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    
    private TreeNode insertRecursive(TreeNode root, int key) {
       
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

       
        if (key < root.key)
            root.left = insertRecursive(root.left, key);
       
        else if (key > root.key)
            root.right = insertRecursive(root.right, key);

        return root;
    }

    
    public boolean search(int key) {
        return searchRecursive(root, key);
    }

    
    private boolean searchRecursive(TreeNode root, int key) {
        
        if (root == null || root.key == key)
            return root != null;

        
        if (key < root.key)
            return searchRecursive(root.left, key);
        
        else
            return searchRecursive(root.right, key);
    }

    
    public void inorderTraversal() {
        inorderTraversalRecursive(root);
    }

    
    private void inorderTraversalRecursive(TreeNode root) {
        if (root != null) {
            inorderTraversalRecursive(root.left);
            System.out.print(root.key + " ");
            inorderTraversalRecursive(root.right);
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

       
        tree.insert(5);
        tree.insert(3);
        tree.insert(7);
        tree.insert(2);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        System.out.print("Inorder traversal: ");
        tree.inorderTraversal(); // 
        System.out.println();

        System.out.println("Search 4: " + tree.search(4)); // 
        System.out.println("Search 9: " + tree.search(9)); // 
    }
}



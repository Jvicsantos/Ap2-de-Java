//Exercício 3

package primeiroprograma;

class ExpressionTreeNode {
    char key;
    ExpressionTreeNode left, right;

    public ExpressionTreeNode(char item) {
        key = item;
        left = right = null;
    }
}

public class ExpressionTree {
    private TreeNode root;

    public ExpressionTree() {
        root = null;
    }

    
    public void insert(char key) {
        root = insertRecursive(root, key);
    }

   
    private TreeNode insertRecursive(TreeNode root, char key) {
      
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }

       
        if (key == '(') {
            if (root.left == null) {
                root.left = new TreeNode(key);
                return root.left;
            } else {
                return insertRecursive(root.left, key);
            }
        } else if (key == ')') {
            if (root.right == null) {
                root.right = new TreeNode(key);
                return root.right;
            } else {
                return insertRecursive(root.right, key);
            }
        }

        return root;
    }

  
    public void drawTree() {
        drawTreeRecursive(root, 0);
    }

    private void drawTreeRecursive(TreeNode root, int space) {
        if (root == null) {
            return;
        }
        space += 10;
        drawTreeRecursive(root.right, space);
        System.out.println();
        for (int i = 10; i < space; i++) {
            System.out.print(" ");
        }
        System.out.print(root.key);
        drawTreeRecursive(root.left, space);
    }

    public static void main(String[] args) {
        ExpressionTree tree = new ExpressionTree();

        
        String expression = "(((5+2)*(2-1))/((2+9)+(7-2)-1))*8";
        for (char c : expression.toCharArray()) {
            tree.insert(c);
        }

      
        tree.drawTree();
    }
}

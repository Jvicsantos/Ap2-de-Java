//Exercício 2

package primeiroprograma;
public class ArvoresBinarias {
    private TreeNode root;

    public ArvoresBinarias() {
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


        if (key < root.key)
            root.left = insertRecursive(root.left, key);
        // Ou para a subárvore direita se a chave for maior
        else if (key > root.key)
            root.right = insertRecursive(root.right, key);

        return root;
    }

    public String buildExpression() {
        StringBuilder expression = new StringBuilder();
        buildExpressionRecursive(root, expression);
        return expression.toString();
    }

    private void buildExpressionRecursive(TreeNode root, StringBuilder expression) {
        if (root != null) {
            buildExpressionRecursive(root.left, expression);
            expression.append(root.key);
            buildExpressionRecursive(root.right, expression);
        }
    }

    public int evaluateExpression() {
        return evaluateExpressionRecursive(root);
    }

    private int evaluateExpressionRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (Character.isDigit(root.key)) {
            return root.key - '0';
        }
        int leftValue = evaluateExpressionRecursive(root.left);
        int rightValue = evaluateExpressionRecursive(root.right);

        switch (root.key) {
            case '+':
                return leftValue + rightValue;
            case '-':
                return leftValue - rightValue;
            case '*':
                return leftValue * rightValue;
            case '/':
                return leftValue / rightValue;
            default:
                return 0;
        }
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

    public void makeBTSearch(String expression) {
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                insert(c);
            }
        }
    }

    public void drawExpressionTree() {
        drawExpressionTreeRecursive(root, 0);
    }

    private void drawExpressionTreeRecursive(TreeNode root, int space) {
        if (root == null) {
            return;
        }
        space += 10;
        drawExpressionTreeRecursive(root.right, space);
        System.out.println();
        for (int i = 10; i < space; i++)
            System.out.print(" ");
        System.out.print(root.key + "\n");
        drawExpressionTreeRecursive(root.left, space);
    }

    public void eulerTour() {
        eulerTourRecursive(root);
    }

    private void eulerTourRecursive(TreeNode root) {
        if (root != null) {
            System.out.print(root.key + " ");
            eulerTourRecursive(root.left);
            if (root.left != null || root.right != null) {
                System.out.print(root.key + " ");
            }
            eulerTourRecursive(root.right);
            if (root.left != null || root.right != null) {
                System.out.print(root.key + " ");
            }
        }
    }

    public void printExpression() {
        System.out.println(buildExpression());
    }

    public int countLeftExternalNodes() {
        return countLeftExternalNodesRecursive(root);
    }

    private int countLeftExternalNodesRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countLeftExternalNodesRecursive(root.left) + countLeftExternalNodesRecursive(root.right);
    }

    public int countRightExternalNodes() {
        return countRightExternalNodesRecursive(root);
    }

    private int countRightExternalNodesRecursive(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return countRightExternalNodesRecursive(root.left) + countRightExternalNodesRecursive(root.right);
    }

    public static void main(String[] args) {
        ArvoresBinarias tree = new ArvoresBinarias();

        tree.insert('+');
        tree.insert('*');
        tree.insert('5');
        tree.insert('3');
        tree.insert('8');

        System.out.println("Expressão: " + tree.buildExpression());

        System.out.print("Inorder traversal: ");
        tree.inorderTraversal();
        System.out.println();

        System.out.println("Resultado da avaliação: " + tree.evaluateExpression());

        System.out.println("Árvore de expressão:");
        tree.drawExpressionTree();

        System.out.println("Euler Tour:");
        tree.eulerTour();
        System.out.println();

        System.out.println("Nodos esquerdos externos: " + tree.countLeftExternalNodes());
        System.out.println("Nodos direitos externos: " + tree.countRightExternalNodes());
    }
}


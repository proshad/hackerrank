package com.hacker.datastructure.tree;

/**
 * Created with IntelliJ IDEA.
 * User: Proshad
 * Date: 1/28/17
 * Time: 1:25 PM
 * To change this template use File | Settings | File Templates.
 */
class AVLNode {
    int key, height;
    AVLNode left, right;

    AVLNode(int d) {
        key = d;
        height = 1;
    }
}

class AVLTree {

    AVLNode root;

    // A utility function to get height of the tree
    int height(AVLNode N) {
        if (N == null)
            return -1;

        return N.height;
    }

    // A utility function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    AVLNode rightRotate(AVLNode y) {
        AVLNode x = y.left;
        AVLNode T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    AVLNode leftRotate(AVLNode x) {
        AVLNode y = x.right;
        AVLNode T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get Balance factor of node N
    int getBalance(AVLNode N) {
        if (N == null)
            return 0;

        return height(N.left) - height(N.right);
    }

    AVLNode insert(AVLNode node, int key) {
 
        /* 1.  Perform the normal BST insertion */
        if (node == null)
            return (new AVLNode(key));

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                height(node.right));
 
        /* 3. Get the balance factor of this ancestor
              node to check whether this node became
              unbalanced */
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there
        // are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
 
        /* return the (unchanged) node pointer */
        return node;
    }

    void inOrder(AVLNode root) {
        if (root != null) {
            inOrder(root.left);
            //Visit the node by Printing the node data
            System.out.print(root.key + "(BF=" + getBalance(root) + ")");
            inOrder(root.right);
        }
    }

    void preOrder(AVLNode root) {
        if (root != null) {
            System.out.print(root.key + "(BF=" + getBalance(root) + ")");
            preOrder(root.left);
            preOrder(root.right);
        }
    }


    public static void main(String[] args) {
        AVLTree tree = new AVLTree();
 
        /* Constructing tree given in the above figure */
//        tree.root = tree.insert(tree.root, 10);
//        tree.root = tree.insert(tree.root, 20);
//        tree.root = tree.insert(tree.root, 30);
//        tree.root = tree.insert(tree.root, 40);
//        tree.root = tree.insert(tree.root, 50);
//        tree.root = tree.insert(tree.root, 25);

        tree.root = tree.insert(tree.root, 3);
        tree.root = tree.insert(tree.root, 2);
        tree.root = tree.insert(tree.root, 4);
        tree.root = tree.insert(tree.root, 5);
        tree.root = tree.insert(tree.root, 6);


        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Inorder traversal of constructed  AVL tree is : ");
        tree.inOrder(tree.root);
        System.out.println();
        tree.preOrder(tree.root);
    }
}
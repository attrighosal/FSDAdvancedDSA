package BST;

import TreesAndBinaryTrees.TreeNode;

public class BSTCreation {


    public static TreeNode insertNode(TreeNode root, int value) {
        if (root==null) {
            return new TreeNode(value);
        }
        if (value<root.val) {
            root.left = insertNode(root.left, value);
        }
        else {
            root.right = insertNode(root.right, value);
        }
        return root;
    }

    public static boolean search(TreeNode root, int target) {
        if (root==null) {
            return false;
        }
        if (root.val==target) {
            return true;
        }
        else if(target< root.val) {
            return search(root.left, target);
        }
        else  {
            return search(root.right, target);
        }
    }

    public static TreeNode createBST(int[] input) {
        TreeNode root = new TreeNode(input[0]);

        for (int i=1; i<input.length; i++) {
            insertNode(root, input[i]);
        }

        return root;
    }

    public static void main(String[] args) {
        int[] input = new int[] {4,2,1,3,8,9,11,10};

        TreeNode root = createBST(input);

        insertNode(root, 14);

//        System.out.println(search(root, 14));
        System.out.println(search(root, 7));

    }
}

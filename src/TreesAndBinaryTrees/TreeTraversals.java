package TreesAndBinaryTrees;

import java.util.*;

public class TreeTraversals {

    public static TreeNode create(int[] array, int index) {

        if (index>= array.length) {
            return null;
        }

        TreeNode node = new TreeNode(array[index]);
        node.left = create(array, 2*index+1);
        node.right = create(array, 2*index+2);
        return node;
    }

    public static void inorderTraversal(TreeNode node, List<Integer> ans) {
        if (node!=null) {
            inorderTraversal(node.left, ans);
            ans.add(node.val);
            inorderTraversal(node.right, ans);
        }
    }

    public static void preorderTraversal(TreeNode node, List<Integer> ans) {
        if (node!=null) {
            ans.add(node.val);
            preorderTraversal(node.left, ans);
            preorderTraversal(node.right, ans);
        }
    }

    public static void postorderTraversal(TreeNode node, List<Integer> ans) {
        if (node!=null) {
            postorderTraversal(node.left, ans);
            postorderTraversal(node.right, ans);
            ans.add(node.val);
        }
    }

    public static List<Integer> iterativeInorder(TreeNode root) {

        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }
        while(!stack.isEmpty()) {
            ans.add(stack.peek().val);
            TreeNode node = stack.pop();
            curr = node.right;
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
        }
        return ans;
    }

    public static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new LinkedList<>();

        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> subList = new LinkedList<>();
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                subList.add(node.val);
                if (node.left!=null) {
                    queue.add(node.left);
                }
                if (node.right!=null) {
                    queue.add(node.right);
                }
            }
            ans.add(subList);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,4,5};

        TreeNode root = create(input, 0);

        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        System.out.println("Inorder Traversal : "+inorder);

        List<Integer> preorder = new ArrayList<>();
        preorderTraversal(root, preorder);
        System.out.println("Preorder Traversal : "+preorder);

        List<Integer> postorder = new ArrayList<>();
        postorderTraversal(root, postorder);
        System.out.println("Postorder Traversal : "+postorder);

        System.out.println("Iterative Inorder Traversal : "+iterativeInorder(root));
        System.out.println("Level Order Traversal : "+levelOrderTraversal(root));
    }
}

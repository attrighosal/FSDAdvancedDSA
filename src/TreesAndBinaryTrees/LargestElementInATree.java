package TreesAndBinaryTrees;

public class LargestElementInATree {

    public static TreeNode create(int[] array, int index) {

        if (index>= array.length) {
            return null;
        }

        TreeNode node = new TreeNode(array[index]);
        node.left = create(array, 2*index+1);
        node.right = create(array, 2*index+2);
        return node;
    }

    public static int findLargestNode(TreeNode root) {

        if (root==null) {
            return Integer.MIN_VALUE;
        }

        int max = root.val;
        int left = findLargestNode(root.left);
        int right = findLargestNode(root.right);

        return Math.max(max, Math.max(left, right));
    }


    public static void main(String[] args) {

        int[] input = new int[] {10,22,11,13,14,16};

        TreeNode root = create(input, 0);

        System.out.println(findLargestNode(root));
    }
}

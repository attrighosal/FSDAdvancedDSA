package TreesAndBinaryTrees;

public class TreeCreation {

    public static TreeNode create(int[] array, int index) {

        if (index>= array.length) {
            return null;
        }

        TreeNode node = new TreeNode(array[index]);
        node.left = create(array, 2*index+1);
        node.right = create(array, 2*index+2);
        return node;
    }

    public static void main(String[] args) {
        int[] input = new int[] {1,2,3,4,5,6,7};

        TreeNode root = create(input, 0);
    }
}

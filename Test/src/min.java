public class min {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private class ResultType {
		int singlePath, maxPath;

		ResultType(int singlePath, int maxPath) {
			this.singlePath = singlePath;
			this.maxPath = maxPath;
		}
	}

	private ResultType helper(TreeNode root) {
		if (root == null) {
			return new ResultType(0, Integer.MIN_VALUE);
		}
		// Divide
		ResultType left = helper(root.left);
		ResultType right = helper(root.right);

		// Conquer
		int singlePath = Math.max(left.singlePath, right.singlePath) + root.val;
		singlePath = Math.max(singlePath, 0);

		int maxPath = Math.max(left.maxPath, right.maxPath);
		maxPath = Math.max(maxPath, left.singlePath + right.singlePath
				+ root.val);

		return new ResultType(singlePath, maxPath);
	}
	
	public int maxPathSum(TreeNode root) {
        ResultType result = helper(root);
        return result.maxPath;
    }
	
	public static void main(String[] args)
	{
		TreeNode root = new TreeNode(1);
		TreeNode left1 = new TreeNode(-1);
		TreeNode right1 = new TreeNode(-3);
		TreeNode left12 = new TreeNode(-2);
		TreeNode right12 = new TreeNode(-3);
		TreeNode  left22 = new TreeNode(7);
		TreeNode right22 = new TreeNode(6);
		
		root.left = left1;
		root.right = right1;
		
		left1.left = left12;
		left1.right = right12;
		
		right1.left = left22;
		right1.right = right22;
		
		min s = new min();
		System.out.println(s.maxPathSum(root));
	}
}

/**
 * @author puneet
 *
 */
public class BTUnivalOrNot {
	
	boolean isUnival(BTNode root, int count){
		
		if(root == null)
			return true;
				
		if(isUnival(root.left, count) && isUnival(root.right, count) && ((root.left ==null) || (root.data == root.left.data)) &&
				((root.right == null) || (root.data == root.right.data))){
		
				count++;
				return true;
		}
		
		return false;
	}
	public static void main(String[] args) {
		
		BTUnivalOrNot uni = new BTUnivalOrNot();
		BTNode root = new BTNode(12);
		
		root.left = new BTNode(12);
		root.right = new BTNode(14);
		root.left.left = new BTNode(12);
		root.left.right = new BTNode(12);
		
		System.out.println(uni.isUnival(root,0));
	}

}

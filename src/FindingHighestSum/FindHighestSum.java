package FindingHighestSum;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FindHighestSum {

	/* list to hold highest path values */
	public static List<Integer> pathNodeValues = new ArrayList<>();

	/* int to hold sum of list values */
	public static int highestSum = 0;

	public static Random randomNum = new Random();

	/**
	 * Find highest possible path sum.
	 *
	 * @param Node the node
	 * @return int of highest possible path sum
	 */

	public static int findSum(Node node) {
		
		if (node == null) {
			return 0;
		}

		int belowChild = findSum(node.moveDown);
		int rightChild = findSum(node.moveRight);

		if (belowChild >= rightChild) {
			return belowChild + node.value;
		} else {
			return rightChild + node.value;
		}
		
	}

	/**
	 * Creates the highest sum path
	 *
	 * @param Node node
	 * @param int  highest possible path sum
	 * @return true, if pathSum - pathValues equals 0
	 */

	public static boolean createPath(Node node, int pathSum) {
		
		if (pathSum == 0) {
			return true;
		}
		
		if (node == null) {
			return false;
		}
		
		boolean moveRight = createPath(node.moveRight, pathSum - node.value);
		boolean moveDown = createPath(node.moveDown, pathSum - node.value);

		if (moveRight || moveDown) {
			pathNodeValues.add(node.value);
		}

		return moveRight || moveDown;
		
	}

	/**
	 * Prints the values of highest sum path.
	 *
	 * @param pathNodeValues list of highest path node values
	 */
	public static void printPath(List<Integer> pathNodeValues) {

		for (int i = pathNodeValues.size() - 1; i >= 0; i--) {
			if (i == 0) {
				highestSum += pathNodeValues.get(i);
				System.out.print(pathNodeValues.get(i));
			} else {
				highestSum += pathNodeValues.get(i);
				System.out.print(pathNodeValues.get(i) + "--> ");
			}
		}
		
		System.out.println("\n" + "Highest Path Sum: " + highestSum);

	}

	public static void main(String[] args) {

		/* create tree from 4*3 grid */
		Node root = null;

		/* Tree Level 1 */
		root = new Node(1);

		/* Tree Level 2 */
		root.moveRight = new Node(4);
		root.moveDown = new Node(3);

		/* Tree Level 3 */
		root.moveRight.moveDown = new Node(1);
		root.moveRight.moveRight = new Node(2);
		root.moveDown.moveDown = new Node(2);
		root.moveDown.moveRight = new Node(1);

		/* Tree Level 4 */
		root.moveRight.moveDown.moveDown = new Node(6);
		root.moveRight.moveDown.moveRight = new Node(8);
		root.moveRight.moveRight.moveRight = new Node(6);
		root.moveRight.moveRight.moveDown = new Node(8);
		root.moveDown.moveDown.moveRight = new Node(6);
		root.moveDown.moveRight.moveDown = new Node(6);
		root.moveDown.moveRight.moveRight = new Node(8);

		/* Tree Level 5 */
		root.moveRight.moveDown.moveDown.moveRight = new Node(5);
		root.moveRight.moveDown.moveRight.moveRight = new Node(3);
		root.moveRight.moveDown.moveRight.moveDown = new Node(5);
		root.moveRight.moveRight.moveRight.moveDown = new Node(3);
		root.moveRight.moveRight.moveDown.moveRight = new Node(3);
		root.moveRight.moveRight.moveDown.moveDown = new Node(5);
		root.moveDown.moveDown.moveRight.moveRight = new Node(5);
		root.moveDown.moveRight.moveDown.moveRight = new Node(5);
		root.moveDown.moveRight.moveRight.moveRight = new Node(3);
		root.moveDown.moveRight.moveRight.moveDown = new Node(5);

		/* Tree Level 6 */
		root.moveRight.moveDown.moveDown.moveRight.moveRight = new Node(4);
		root.moveRight.moveDown.moveRight.moveRight.moveDown = new Node(4);
		root.moveRight.moveDown.moveRight.moveDown.moveRight = new Node(4);
		root.moveRight.moveRight.moveRight.moveDown.moveDown = new Node(4);
		root.moveRight.moveRight.moveDown.moveRight.moveDown = new Node(4);
		root.moveRight.moveRight.moveDown.moveDown.moveRight = new Node(4);
		root.moveDown.moveDown.moveRight.moveRight.moveRight = new Node(4);
		root.moveDown.moveRight.moveDown.moveRight.moveRight = new Node(4);
		root.moveDown.moveRight.moveRight.moveRight.moveDown = new Node(4);
		root.moveDown.moveRight.moveRight.moveDown.moveRight = new Node(4);

		createPath(root, findSum(root));
		printPath(pathNodeValues);

		System.out.println("Tree was built from the following number board: " 
							+ "\n" 
							+ "1, 4, 2, 6" 
							+ "\n"
							+ "3, 1, 8, 3" 
							+ "\n" 
							+ "2, 6, 5, 4");
		
	}

}

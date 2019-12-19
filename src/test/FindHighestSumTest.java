package test;

import static org.junit.Assert.*;

import org.junit.Test;

import FindingHighestSum.FindHighestSum;
import FindingHighestSum.Node;

public class FindHighestSumTest {
	
	@Test
	public void findHighSumInTwoByThreeBoardShouldReturnCorrectSum() {
		
		Node root = new Node(6);
		
		root.moveRight = new Node(4);
		root.moveDown = new Node(7);
		
		root.moveRight.moveDown = new Node(3);
		root.moveRight.moveRight = new Node(9);
		root.moveDown.moveRight = new Node(3);
		
		root.moveRight.moveDown.moveRight = new Node(5);
		root.moveRight.moveRight.moveDown = new Node(5);
		root.moveDown.moveRight.moveRight = new Node(5);
		
		int expectedSum = 24;
		int actualSum = FindHighestSum.findSum(root);
		assertEquals(expectedSum, actualSum);
		
	}
	
	@Test
	public void createPathWithValidSumShouldReturnTrue() {
		
		int pathSum = 24;
		
		Node root = new Node(6);
		
		root.moveRight = new Node(4);
		root.moveDown = new Node(7);
		
		root.moveRight.moveDown = new Node(3);
		root.moveRight.moveRight = new Node(9);
		root.moveDown.moveRight = new Node(3);
		
		root.moveRight.moveDown.moveRight = new Node(5);
		root.moveRight.moveRight.moveDown = new Node(5);
		root.moveDown.moveRight.moveRight = new Node(5);
		
		boolean expectedBool = true;
		boolean actualBool = FindHighestSum.createPath(root, pathSum);
		
		assertEquals(expectedBool, actualBool);
		
	}
	
}

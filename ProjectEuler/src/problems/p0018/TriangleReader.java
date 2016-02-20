package problems.p0018;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TriangleReader {
	
	private String path;
	
	public TriangleReader(String path)	{
		this.path = path;
	}
	
	public Node getTriangle(){
		List<List<Integer>> listRepresentation = readLines();
		Node root = new Node(listRepresentation.get(0).get(0));
		setTree(root, listRepresentation, 1, 0);
		return root;
	}
	
	private void setTree(Node root, List<List<Integer>> listRep, int depth, int width)	{
		if (depth < listRep.size())	{
			root.setLeft(new Node(listRep.get(depth).get(width)));
			root.setRight(new Node(listRep.get(depth).get(width + 1)));
			setTree(root.getLeft(), listRep, depth +1, width);
			setTree(root.getRight(), listRep, depth + 1, width + 1);
		}
	}
	
//	public static void main(String[] args) {
//		TriangleReader reader = new TriangleReader("src/problems/p0018/triangle.txt");
//		System.out.println(reader.readLines());
//		Node root = reader.getTriangle();
//		System.out.println(root.getLeft().getLeft().getLeft().getRight().getValue());
//	}
	
	private List<List<Integer>> readLines()	{
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			while(reader.ready())	{
				String[] numberarray = reader.readLine().split(" ");
				List<Integer> numberlist = new ArrayList<Integer>();
				for (String s : numberarray)	{
					numberlist.add(new Integer(s));
				}
				result.add(numberlist);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String getPath()	{
		return this.path;
	}
	
	public class Node	{
		
		private int value;
		private Node left;
		private Node right;
		
		public Node(int value)	{
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
		public void setValue(int value) {
			this.value = value;
		}
		public Node getLeft() {
			return left;
		}
		public void setLeft(Node left) {
			this.left = left;
		}
		public Node getRight() {
			return right;
		}
		public void setRight(Node right) {
			this.right = right;
		}
		
	}
	
}

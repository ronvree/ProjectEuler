package problems.p0018;

import java.util.ArrayList;
import java.util.List;

import problems.p0018.TriangleReader.Node;

/*
 * Description was added separately, as it contains pictures
 */

public class MaximumPathSumI {
	
	private static final String PATH = "src/problems/p0018/triangle.txt";
	
	public static void main(String[] args) {
		TriangleReader reader = new TriangleReader(PATH);
		Node root = reader.getTriangle();
		
		MaximumPathSumI sum = new MaximumPathSumI();
		Search search = sum.new GreedySearch();
		System.out.println(search.getMaxPathValue(root));
	}
	
	public abstract class Search	{
		public abstract int getMaxPathValue(Node root);
	}
	
	public class GreedySearch extends Search	{

		@Override
		public int getMaxPathValue(Node root) {
			List<Node> endnodes = new ArrayList<Node>();
			List<Node> open = new ArrayList<Node>();
			open.add(root);
			while(open.size() > 0)	{
				Node best = getBest(open);
				open.remove(best);
				if (best.getLeft() == null && best.getRight() == null)	{
					endnodes.add(best);
				} else {
					for (Node node : new Node[]{best.getLeft(), best.getRight()})	{
						node.setValue(node.getValue() + best.getValue());
						open.add(node);
					}
				}
			}
			return getBest(endnodes).getValue();
		}
		
		private Node getBest(List<Node> nodes)	{
			int bestVal = nodes.get(0).getValue();
			Node bestNode = nodes.get(0);
			for (Node node : nodes)	{
				if (node.getValue() > bestVal)	{
					bestNode = node;
					bestVal = bestNode.getValue();
				}
			}
			return bestNode;
		}
		
	}
	
}

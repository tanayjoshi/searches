//GRAPH SEARCH


package search;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

@SuppressWarnings("unused")

public class TreeSearch implements Search {

	private Frontier front;
	private int numNode = 0;
	
	public TreeSearch(Frontier f)
	{
			front = f;
	}
	
	public Node result(Node root, GoalTest test) 
	{	
		front.addNode(root);
		Iterator<? extends Action> iter;
		Action thisAction;
		while(!(front.isEmpty()))
			{	Node current = front.removeNode();
				if(test.isGoal(current.state))
					{
					return current;
					}
				iter=current.state.getApplicableActions().iterator();
				while (iter.hasNext())
				{	thisAction=iter.next();
				
					front.addNode(new Node(current,thisAction,current.state.getActionResult(thisAction), 0));
					numNode += 1;
				}
			
			}	
		return null;
	}

	public int NodeGen()
	{
		return numNode;
	}
}









//GRAPH SEARCH


package search;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;
import java.util.HashSet;

@SuppressWarnings("unused")
public class GraphSearch implements Search {

	private Frontier front;
	//private int flag=0;
	
	public GraphSearch(Frontier f)
	{
			front = f;
	}
	
	private int numNode = 0;
	
	public Node result(Node root, GoalTest test) 
	{	
		front.addNode(root);
		Set<State> exploredSet = new HashSet<State>();
		Set<State> expfron = new HashSet<State>();
		Iterator<? extends Action> iter;
		expfron.add(root.state);
		Action thisAction;
		while(!(front.isEmpty()))
			{	Node current = front.removeNode();
				
				if(test.isGoal(current.state))
					{
					return current;
					}
					exploredSet.add(current.state);
					iter=current.state.getApplicableActions().iterator();

				while (iter.hasNext())
				{	thisAction=iter.next();
					Node newNode = (new Node(current,thisAction,current.state.getActionResult(thisAction), 0));
					State newState = newNode.state;
					
					
					
					if(!(exploredSet.contains(newState) || expfron.contains(newState)))
						{
						front.addNode(newNode);
						expfron.add(newNode.state);
						numNode += 1;
						}
				}
			
			}	
		return null;
	}
	
	public int NodeGen()
	{
		return numNode;
	}

}








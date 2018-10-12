package search;

import java.util.Iterator;

public class IterativeDeepeningTreeSearch implements Search {
	
	private Frontier front = new DepthFirstFrontier();	
	private int numNode = 0;
	public int dep = 0, max=0,n=0;
	int oldnumNode = -1;
	
	
		
		public Node result(Node root, GoalTest test) 
		{
			Iterator<? extends Action> iter;
			Action thisAction;
			while (this.NodeGen() != oldnumNode)
			{	max += 1;
				oldnumNode = this.NodeGen();
				front.addNode(root);

				while(!(front.isEmpty()))
					{	Node current = front.removeNode();
						if(test.isGoal(current.state))
							{
							return current;
							}
						iter=current.state.getApplicableActions().iterator();
						if(current.depth != max)
						{
							while (iter.hasNext())
							{	thisAction=iter.next();
								front.addNode(new Node(current,thisAction,current.state.getActionResult(thisAction),current.depth+1));
								numNode += 1;
						}
				
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



/*if (dep == max || numNode > (2^dep ))
{	max += 1;
	dep=0;
	numNode=1;
	front.clearFrontier();
	front.addNode(root2);
}*/
package jason.datastructure.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AjacentGraph  extends Graph{
	

	public ArrayList<LinkedList<Edge>> ajacentList=new ArrayList<>();
	
	public void initGraph() {
		for (int i=0; i<vertices.verticesArray.size(); i++) {
			ajacentList.add(new LinkedList<Edge>());
		}
	}
	public void addEdge(String from, String to, int distance) {
		Vertex fromVertex=vertices.getVertexByName(from);
		Vertex toVertex=vertices.getVertexByName(to);
		Edge edge=new Edge(fromVertex.index, toVertex.index, distance);
		ajacentList.get(fromVertex.index).add(edge);
	}
	
	public void addEdge(int from, int to) {
		Edge edge=new Edge(from, to, 1);
		ajacentList.get(from).add(edge);
	}
	 
	@Override
	public List<Edge> getEdges(int index) {
		return ajacentList.get(index);
	}
	
	public  AjacentGraph transpose(){
		
		 AjacentGraph t=new  AjacentGraph();
		 t.vertices=this.vertices;
		 t.initGraph();
		 this.ajacentList.stream().flatMap(edges->edges.stream()).forEach(edge->t.addEdge(edge.to, edge.from));
		 return t;
	}
	
	
}

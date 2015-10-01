

class Graph
    {
public static void main(String[] args)
     {
ShortPath inputData = new ShortPath();
inputData.addNode('A'); // 0 (START)
inputData.addNode('B'); // 1
inputData.addNode('C'); // 2
inputData.addNode('D'); // 3
inputData.addNode('E'); // 4
inputData.addNode('F'); // 5
inputData.addEdge(0, 5, 10); // AF 10
inputData.addEdge(0, 1, 50); // AB 50
inputData.addEdge(0, 2, 30); // AC 30
inputData.addEdge(0, 3,100); // AD 100
inputData.addEdge(3, 2, 20); // DB 20
inputData.addEdge(3, 2, 50); // DC 50
inputData.addEdge(4, 3, 15); // ED 15
inputData.addEdge(4, 5, 15); // EF 15
inputData.addEdge(5, 3, 10); // FD 10
System.out.println("Found shortes path:  ");
inputData.path();  //display results
System.out.println();
    } }


class DistPar // to be stored in Graph array 
  { //
      public int dis; // dis from START to this node
      public int nodeParent; // current parent of this node
      public DistPar(int pv, int d) // constructor
{
dis = d;
nodeParent = pv;
}}

class Node
    {
public char nodeLetter; // nodeLetter (alphabetic letter)
public boolean connected; //it there or not

public Node(char lab)
  {
nodeLetter = lab;
connected = false;
  }
}


     

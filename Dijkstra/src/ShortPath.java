class ShortPath
{
private final int maxNoNodes = 20;
private final int inf = 1000000;  //some large number representing inf
private Node nodeList[]; // list of nodes stored in array
private int adjMatrix[][]; // adjacency matrix 2D array
private int nodeNumber; // current node number
private int howManyNodesInGraph; // number of nodes in tree
private DistPar shPathArray[]; // array for shortest path data
private int currentNode; // current node
private int fromStarttoCurrent; // dis to currentNode

public ShortPath()
    {
       nodeList = new Node[maxNoNodes];   // adjacency matrix
       adjMatrix = new int[maxNoNodes][maxNoNodes];
      
for(int j=0; j<maxNoNodes; j++) // set adjacency
        for(int k=0; k<maxNoNodes; k++) // matrix
        adjMatrix[j][k] = inf; // to infinity
        shPathArray = new DistPar[maxNoNodes]; // shortest paths
    }    




public void addNode(char lab)  //populating array with Nodes
    {
    nodeList[nodeNumber++] = new Node(lab);
    }




public void addEdge(int start, int end, int weight) //data of the edge 
    {
adjMatrix[start][end] = weight; // (watch directions of the path)
    }



public void path() // find all shortest paths
    {
    int startNode = 0; // start at node 0(A)
    nodeList[startNode].connected = true;
    howManyNodesInGraph = 1; // put it in graph
    
// transfer value of distances from adjMatrix to shPathArray
  for(int j=0; j<nodeNumber; j++)
    {
        int tempDist = adjMatrix[startNode][j];
        shPathArray[j] = new DistPar(startNode, tempDist);
    }
            //ALL NODES IN ARRAY
while(howManyNodesInGraph < nodeNumber) //condition to find unreachable node
    {
                int indexMin = getMin(); // get minimum from shPathArray
                int minDist = shPathArray[indexMin].dis;
                if(minDist == inf) // if all infinite
            {
                        System.out.println("There is unreacheable node");
                        break; // shPathArray is complete
            }

    else
            
            {
               currentNode = indexMin; // restet current node to index O 
               fromStarttoCurrent = shPathArray[indexMin].dis;
                // minimum dis from startNode is
                // to currentNode, and is fromStarttoCurrent
            }  // put current node in tree
        nodeList[currentNode].connected = true;
        howManyNodesInGraph++;
        adjust_sPath(); // update shPathArray[] array
    }

        displayPaths(); //display paths
        howManyNodesInGraph = 0; // reset
        
     for(int j=0; j<nodeNumber; j++)
        {nodeList[j].connected = false;}
   }




private int getMin() // get entry from shPathArray
    { // with minimum distance
        int minDist = inf; // assume minimum
        int indexMin = 0;
        for(int j=1; j<nodeNumber; j++) // for each node,
      { // if it’s in tree and

          if( !nodeList[j].connected && // smaller than old one
            shPathArray[j].dis < minDist )
          {
            minDist = shPathArray[j].dis;
            indexMin = j; // minimum=j(update)
          }
      } 
    return indexMin; // return indexMin
    }






public void adjust_sPath()
    {
// adjust values in shortest-path array shPathArray
        int column = 1; // start for 2nd node and dont touch A
        while(column < nodeNumber) // go across columns
      {
// if this column’s node already in tree, skip it
        if( nodeList[column].connected )
            {
                column++;
                continue;
            }
// calculate dis for one shPathArray entry
// get edge from currentNode to column
int currentTostart = adjMatrix[currentNode][column];// add dis from start
int startToEnd = fromStarttoCurrent + currentTostart;//dis of current entry
int sPathDist = shPathArray[column].dis;//compare dis from A to current entry

            if(startToEnd < sPathDist) // if shorter,
            { // update shPathArray
               shPathArray[column].nodeParent = currentNode;
               shPathArray[column].dis = startToEnd;
            }
            column++;
       }
    } 



public void displayPaths()    
        {
for(int j=0; j<nodeNumber; j++) // display contents of shPathArray[]
      {
      System.out.print(nodeList[j].nodeLetter + "=");
        if(shPathArray[j].dis == inf)
            System.out.print("inf");
        else
            System.out.print(shPathArray[j].dis);
        char parent = nodeList[ shPathArray[j].nodeParent ].nodeLetter;
            System.out.print("(" +parent + ")  \n");
      }
            System.out.println("");
        }} 
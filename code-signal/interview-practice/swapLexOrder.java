class Algo{
    
    private Boolean[] visited;
    private String inputString;
    private List< List<Integer> > adjencyList;
    
    public Algo(List< List<Integer> > adjencyList, String str){
        this.visited = new Boolean[str.length()];
        this.adjencyList = adjencyList;
        this.inputString = str;
    }
    
    private TreeSet<Integer> getConnectedAreaFromVertex(int vIndex){
        Queue<Integer> q = new LinkedList<>();
        q.add(vIndex);
        TreeSet<Integer> result = new TreeSet<Integer>();
        
        while (!q.isEmpty()){
            int currentVertex = q.peek();
            result.add(currentVertex);
            visited[currentVertex] = true;
            List<Integer> adVertices = adjencyList.get(currentVertex);
            for (Integer adVertex : adVertices){
                if (!visited[adVertex]){
                    q.add(adVertex);
                }
            }
           
            q.remove();
        }
        return result;
    }
    
    public List<TreeSet<Integer>> getConnectedAreas(){
        for (int i = 0; i < inputString.length(); ++i ){
            visited[i] = false;
        }
        List<TreeSet<Integer>> connectedAreas = new ArrayList<>();
        for (int i = 0; i < inputString.length(); ++i ){
            if (!visited[i]){
                TreeSet<Integer> connectedSet = getConnectedAreaFromVertex(i);
                if (connectedSet.size() > 1){
                    connectedAreas.add(connectedSet);
                }
            }
        }
        return connectedAreas;
    }
    
    public String sortOrder(List<TreeSet<Integer>> listConnectedAreas){
        StringBuilder builder = new StringBuilder();
        builder.append(inputString);
        for (TreeSet<Integer> areas: listConnectedAreas){
            
            List<Character> listChar = new ArrayList<>();
            for(Integer vertex : areas){
                listChar.add(inputString.charAt(vertex));
            } 
            Collections.sort(listChar, Collections.reverseOrder()); 
            int count = 0;
            for(Integer vertex : areas){
                builder.replace(vertex, vertex+1, listChar.get(count++).toString());
            }
        }
        return builder.toString();
    }
    
}

String swapLexOrder(String str, int[][] pairs) {
    
    List< List<Integer> > adjencyList = new ArrayList<>();
    for (int i =0; i < str.length(); i++) {
        adjencyList.add(new ArrayList<>());
    }
    
    for (int i=0; i< pairs.length; ++i){
        int point1 = pairs[i][0]-1;
        int point2 = pairs[i][1]-1;
        adjencyList.get(point1).add(point2);
        adjencyList.get(point2).add(point1);
    }
    Algo algo = new Algo(adjencyList, str);
    List<TreeSet<Integer>> listSet = algo.getConnectedAreas();
    return algo.sortOrder(listSet);
}

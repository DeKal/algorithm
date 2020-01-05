int differentSquares(int[][] a) {
    Set<String> hash_Set = new HashSet<String>(); 
    int row = a.length;
    int col = a[0].length;
    for (int i =0; i< row-1; ++ i){
        for (int j=0; j<col-1; ++j)
        {
            String square = Integer.toString(a[i][j]) + Integer.toString(a[i][j+1]) 
                + Integer.toString(a[i+1][j+1]) + Integer.toString(a[i+1][j]);
            hash_Set.add(square);
        }
    }
    return hash_Set.size();
}
int possibleSums(int[] coins, int[] quantity) {
    Set<Integer>[] sets = new Set[coins.length];
    for (int i=0; i < coins.length; ++i){
        sets[i] = new HashSet<Integer>();
        for (int j=0; j<=quantity[i]; ++j)
            sets[i].add(coins[i]*j);
    }
    Set<Integer> resultSet = new HashSet<Integer>(sets[0]);
    for (int i=1; i < coins.length; ++i){
        Set<Integer> tmpSet = new HashSet<Integer>(resultSet);
        for (Integer num1 : sets[i]) {
            for (Integer num2 : tmpSet) {
                resultSet.add(num1 + num2);
            }
        }
    }
    return resultSet.size()-1;
}
String findProfession(int level, int pos) {
    int[] posByLevel = new int[level + 1];
    posByLevel[level] = pos;
    for (int i = level - 1; i > 0; --i){
        posByLevel[i] = posByLevel[i + 1]/2 + posByLevel[i + 1]%2;
    }
    boolean isDoc = false;
    for (int i = 2 ; i <= level; ++i){
        if ((isDoc && posByLevel[i] == posByLevel[i-1]*2-1) || (!isDoc && posByLevel[i] == posByLevel[i-1]*2))
            isDoc = true;
        else 
            isDoc = false;
    }

    return isDoc ? "Doctor" : "Engineer";
    
}
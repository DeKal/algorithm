#define NOT_IN_STACK 0
#define IN_STACK 1
#define MAXN 11

bool stringsRearrangement(std::vector<std::string> a) {
    bool c[11][11] = {0};
    for (int i=0; i<a.size(); ++i){
        for (int j= i+1; j<a.size(); ++j)
            if (checkSimilar(a[i], a[j])){
                c[i][j] = true;
                c[j][i] = c[i][j];
            }
    }
    return check(c, a.size());
}

bool checkSimilar(string a, string b){
    int diff = 0;
    for (int i =0; i <a.size(); ++i){
        if (a[i] != b[i]){
            ++diff;
        }
            
    }
    if (diff == 1) return true;
    return false;
}

bool check(bool adj[][MAXN], int n){
        int label[MAXN];
        for(int i=0; i<n; i++)
            label[i]=NOT_IN_STACK;
        for(int i=0; i<n; i++){
            label[i]=IN_STACK;
            if(dfs(i, adj, label, 1, n))
                return true;
            label[i]=NOT_IN_STACK;
        }
        return false;
}


bool dfs(int v, bool adj[][MAXN], int label[MAXN], int instack_count, int n){
        if(instack_count == n)
            return true;
        for(int i=0; i<n; i++)
            if(adj[v][i] && label[i] == NOT_IN_STACK){
                label[i]=IN_STACK;
                if(dfs(i, adj, label, instack_count+1, n))
                    return true;
                label[i]=NOT_IN_STACK;
            }
        return false;
}
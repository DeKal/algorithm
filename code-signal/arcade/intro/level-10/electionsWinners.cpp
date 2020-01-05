int electionsWinners(std::vector<int> votes, int k) {
    int max = votes[0];
    
    for (int i = 1; i< votes.size(); ++i){
        if (votes[i] > max)
            max = votes[i];
    }
    int count = 0;
    int maxCount = 0;
    for (int i = 0; i< votes.size(); ++i){
        if (votes[i] + k > max)
            count++;
        if (votes[i] == max)
            maxCount++;
    }
    
    if (k==0 && maxCount ==1) return 1;
    return count;
}
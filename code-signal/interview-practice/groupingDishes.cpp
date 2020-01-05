std::vector<std::vector<std::string>> groupingDishes(std::vector<std::vector<std::string>> dishes) {
    map<string , vector<string>> resMap;
    
    int row = dishes.size();
    
    for (int i=0; i<row; ++i){
        int col = dishes[i].size();
        for (int j=1; j<col; ++j){
            map<string , vector<string>>::iterator it = resMap.find(dishes[i][j]);
            if (it != resMap.end()){
                (it->second).push_back(dishes[i][0]);
            }
            else{
                vector<string> tmp;
                tmp.push_back(dishes[i][0]);
                resMap[dishes[i][j]] = tmp;
            }
        }
    }
    vector<std::vector<std::string>> res;
    for (map<string , vector<string>>::iterator it=resMap.begin(); it!=resMap.end(); ++it){
        if ((it->second).size() > 1){
            std::vector<std::string> ingredient;
            ingredient.push_back(it->first);
            std::sort ((it->second).begin(), (it->second).end()); 
            ingredient.insert(ingredient.end(), (it->second).begin(), (it->second).end());
            res.push_back(ingredient);

        }
    }
    return res;   
}
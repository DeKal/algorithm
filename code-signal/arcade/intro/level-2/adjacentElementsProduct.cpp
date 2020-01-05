int adjacentElementsProduct(std::vector<int> a) {
    int max = -100000000000000;
    for (int i = 0; i < a.size()-1; ++ i){
          if (a[i] * a[i+1] > max)
              max = a[i] * a[i+1];
    }
    
    return max;
}
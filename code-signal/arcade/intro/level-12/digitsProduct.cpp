int digitsProduct(int product) {
    if (product < 10)
        return product ?: 10;
    
   string res = "";
    
    for (int i = 9; i > 1; i--) {
        while (product % i == 0) {
            product /= i;
            res = char('0' + i) + res;
        }
    }
    return product == 1 ? std::stoi(res) : -1;
}
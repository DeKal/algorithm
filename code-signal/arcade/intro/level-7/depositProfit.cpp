int depositProfit(int deposit, int rate, int threshold) {
    int y = 0;
    double money = deposit;
    while (money < threshold ){
        money += money*(rate/100.0);
        y++;
    }
    return y;
}
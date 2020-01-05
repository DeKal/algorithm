int centuryFromYear(int year) {
    return year%100 != 0 ? year/100 + 1 : year/100; 
}

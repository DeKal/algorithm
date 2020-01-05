int sumUpNumbers(String s) {
    String newS = "";
    for (int i=0; i<s.length(); ++i){
        char a = s.charAt(i);
        if (isDigit(a))
            newS+=a;
        else
            newS+=" ";
    }
    String[] parts = newS.split(" ");
    int sum = 0; 
    for (String part:parts)
    if (part.length()>0){
        sum += Integer.parseInt(part);
    }
    return sum;
}
boolean isDigit(char a){
    return ('0' <=a && a <= '9');
}
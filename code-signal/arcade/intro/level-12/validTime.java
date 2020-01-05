boolean validTime(String time) {
    String[] parts = time.split(":");
    return isIn24(parts[0]) && isIn60(parts[1]);
}

boolean isIn24(String a){
    int h = Integer.parseInt(a);
    return (0<=h && h<=23);
}

boolean isIn60(String a){
    int m = Integer.parseInt(a);
    return (0<=m && m<=59);
}
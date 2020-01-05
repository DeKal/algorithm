boolean isMAC48Address(String inputString) {
    String[] parts = inputString.split("-");
    if (inputString.length() != 17) return false;
    if (parts.length != 6) return false;
    
    for (String part : parts){
        if (part.length() !=2) return false;
        if ( !isHexNumber(part.charAt(0)) || !isHexNumber(part.charAt(1)) )
            return false;
    }
    return true;
}

boolean isHexNumber(char c){
    return ('0'<=c && c<='9') || ('A' <=c && c<='F');
}
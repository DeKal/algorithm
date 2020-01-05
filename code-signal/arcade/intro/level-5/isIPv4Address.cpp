boolean isIPv4Address(String inputString) {
    String[] parts = inputString.split("\\.");
    if (parts.length != 4 ) return false;
    for ( String part: parts){
        if (part.length() ==0) return false;
        int tmp= 0;
        try{
                
            tmp= Integer.parseInt(part);
        }catch(Exception e){
            return false;
        }
        
        if (tmp < 0  || tmp>255)
            return false;
    }
    return true;
}
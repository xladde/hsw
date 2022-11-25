public static int factorial(int n){
    if(n < 0) { return 0; }
    else if(n == 0) { return 1; }
    else { 
        int result = n * factorial(n-1); 
        return result;
    }
    
}
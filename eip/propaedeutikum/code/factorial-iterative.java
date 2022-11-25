public static int factorial(int n) {
    if(n < 0){return 0;}
    else if(n == 0) { return 1; }
    else {
        for(int i = (n-1); i >=1; i--){
            n = n*i;
        }
        return n;
    }
}
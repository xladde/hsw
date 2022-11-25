public class Test {
    public static void main(String[] args){
        int a = 5;
        int b = Factorial.iterative(a);
        int c = Factorial.recursive(a);
        System.out.println("iterativ: " + b);
        System.out.println("rekursiv: " + b);
    }
}
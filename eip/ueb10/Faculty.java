public class Faculty
{
  public static int facultyIterative(int num)
  {
    int result = 1;
    if(num > 1)
    {
      result = 1
      for(int i = 1; i < = num; i++) result *= i;
    } else result = 1;
    return result;
  }
  
  public static int facultyRecursive(int num)
  {
    if(num > 1) return num * facultyRecursive(num-1);
    else return 1;
  }
  
  public static void main(String[] args)
  {
    int[] test = {0,1,2,3,4,5};
    for(int i = 0; i < test.length; i++)
    {
      System.out.println("Faculty (iterative) of "+test[i]+" = "+facultyIterative(test[i]));
      System.out.println("Faculty (recursive) of "+test[i]+" = "+facultyRecursive(test[i]));
    }
  }
}
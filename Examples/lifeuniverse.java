import java.util.Scanner;

class HelloWorld{
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    while(true){
      int n = input.nextInt();
      if(n!=42){
        System.out.println(n);
      }
      else{
        break;
      }
    }
  }
}

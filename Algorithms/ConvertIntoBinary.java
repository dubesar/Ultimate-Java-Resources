public class ConvertIntoBinary {
    public static void main(String [] args) {
        System.out.println("Algorithms to convert an integer into a binary");
        System.out.println("Exemple : ");
        System.out.print("5 into binary is ");
        printConvertIntoBinary(5);
        System.out.println("");
        System.out.print("985 into binary is ");
        printConvertIntoBinary(985);

    }

    public static void printConvertIntoBinary(int n) {
        if(n==0){
            System.out.print("0");
        }else if(n==1){
            System.out.print("1");
        }else{
            printConvertIntoBinary(n/2);
            System.out.print(n%2);
        }
    }
}
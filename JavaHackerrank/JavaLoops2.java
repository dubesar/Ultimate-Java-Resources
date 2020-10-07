class JavaLoops2{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int q=in.nextInt();
        for(int i=0;i<q;i++){
            
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            for(int t=0;t<n;t++) {
                a=a+b;
                System.out.print(a + " ");
                b*=2;
            }
            System.out.println();
        }
        in.close();
    }
}

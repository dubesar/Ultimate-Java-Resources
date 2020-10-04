//I HAVE TO CREATE AN ARTIFICIAL INTELLIGENCE TALK

import java.util.*; 
import java.io.*;
class Talk
{
    public static void msg()
    {
        System.out.println("Enter anything...:D."); 
        System.out.println("Enter 'end' to quit."); 
        System.out.println("Enter 'clear' to clearscreen."); 
        System.out.println("Enter 'rules' to display them."); 
        System.out.println("Enter 'time' to display time."); 
        System.out.println("Enter 'length' to check sentence length."); 
    }
public static void main(String args[])throws Exception
{
    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    {  
        int c=1;
        try
        {
            while(c!=100)
            {
                System.out.println("Loading....."+c+"%");
                Thread.sleep(10);
                System.out.print("\f");
                c++;
            }
            if(c==100)
            {
                System.out.printf("WELCOME TO THE AI USER INTERFACE - MADE BY AVIRAL SRIVASTAVA\n");
                System.out.printf("I AM YOUR PERSONAL COUNSELLOR,ASSISTANT, DOCTTOR OR FRIEND\n");
                System.out.printf("TELL ME YOUR NAME AND ALL YOUR PROBLEMS...\n");
            }
        }catch(Exception e)
        {
        }
        String s; 
        msg();

        do
        { 
            s = br.readLine(); 
            if(s.equals("good"))
                System.out.println("\f Thank you sir!!"); 
            else if(s.equals("how are you"))
            System.out.println("\f I am always fine. :D"); 

            else if(s.equals("bye"))
                 s="end"; 
                 else if(s.equals("exit"))
                s="end"; 
                else if(s.equals("clear"))
                System.out.println("\f"); 
                else if(s.startsWith("okay")||s.startsWith("tell")||s.startsWith("speak")||s.startsWith("what"))
                System.out.println("Tell Me About You"); 
                else if(s.equals("info"))
                {
                    System.out.println("\f"+"\nCURRENT DATE AND TIME :\n"+new Date()+"\n"+"\nCREATED BY: AVIRAL SRIVASTAVA"+"\nTHANK YOU FOR USING THIS PROGRAM."+"\nVERSION 1.1"+"\nPRESS ANY KEY TO CONTINUE"); 
                    s = br.readLine(); 
                    if(s=="")
                    {
                        System.out.println("\f"); 
                        msg();
                    }
    
                }
                else if(s.equals("rules"))
                {
                    System.out.println("\f"); 
                    msg(); 
                }
                else if(s.equals("time")) 
                    System.out.println(new Date()+"\n"); 
                    else if(s.equals("fool")||s.equals("idiot")||s.equals("ass")) 
                    System.exit(0);
                    else if(s.equals("length")) 
                    {
                        System.out.println("Now enter the sentence" ); 

                        String a =br.readLine(); 
                        int length = a.length(); 
                        System.out.println("String Length is : "+ length ); 
                    }
                    else
                        System.out.println("I AM LISTNENING.. CARRY ON.. :)"); 
                    
                    }while(!s.equals("end")); 
                        for(int i=5;i<=0;i--)
                        System.out.println("Good bye"); 
                    }
                }
            }

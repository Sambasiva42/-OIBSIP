import java.util.Scanner;
public class ATM 
{
   static int checkbalance(int arr[],int id)
   {
     return arr[id];
   }
  static  int deposit(int amount,int arr[],int id)
   {
    arr[id]=arr[id]+amount; 
    return arr[id];
   }
  static int transaction(int amt,int arr[],int id)
  {
    arr[id]=arr[id]-amt;
    if(arr[id]<0)
    {
       System.out.println("Insufficient balance");
       arr[id]=arr[id]+amt;
       return 0;
      } 
    else
    {
    return amt;
    }
  }
  public static void main(String [] args)
  {
    int choice,amount,id;
    int arr[]=new int[10];
     for(int i=0;i<9;i++)
     {
    arr[i]=2500;
     }
     do
     {
     Scanner sc1=new Scanner(System.in);
     System.out.println("enter id:");
        id=sc1.nextInt();
      
       if(id>9)
       {
         System.out.println("Renter your id under 9:");
           id=sc1.nextInt();
       }
   do
     {
         Scanner sc=new Scanner(System.in);
            
         System.out.println("Mainmenu");
         System.out.println("1:Check Balance");
         System.out.println("2:Deposit");
         System.out.println("3:Withdraw");
         System.out.println("4:Exit");
         System.out.println("Enter your choice:");
         choice=sc.nextInt();
         switch(choice)
         {
         case 1:  amount=checkbalance(arr,id);
                  System.out.println("Amount==>"+amount);
                  break;
         case 2:  System.out.println("Enter amount to deposit:");
                  int dp=sc.nextInt();
                amount=deposit(dp,arr,id);
                  System.out.println("Amount==>"+amount);
                  break;
         case 3: System.out.println("Enter amount to taken:");
               int amt=sc.nextInt();
                amount=transaction(amt,arr,id);
                  System.out.println("Withdrawn Amount==>"+amount);

                   break;
         case 4:System.exit(0);
                  break;
                 
         }
     }while(choice<4);
    }while(id<9);
   }
}
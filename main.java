import java.util.Scanner;

public class main {
	
	public static void main(String[] args) {
		
		float balance = 2500.75f;
		Scanner sc = new Scanner(System.in);
		int choice;
		int count = 0;
		int successfully=0;

		while (count < 3) {
			System.out.println("Please enter the pin: ");
			int pin = sc.nextInt();

			if (pin==1234) {
				break;
			}
			else{
				System.out.println("wrong password try again.");
				count++;
				if(count==3){
					System.out.println("Your account has been locked.");
					sc.close();
					return;
				}
			}
		}

		
		System.out.println("========= ATM =========");
		System.out.println("1. Check Balance\n2.. Deposit\n3 .Withdraw\n4. show Acc Status\n5. Exit");
		System.out.println("=======================");
		System.out.print("Enter your choice: ");
                choice = sc.nextInt();
		
				if(choice==1){
					if (balance==0){System.out.println("Warning:Your account is empty.");}
					System.out.println("Your balance is: "+balance);
				}
				else if(choice==2){
					System.out.print("Enter amount to deposit: ");
					float deposit = sc.nextFloat();
					if (deposit<0) {
						System.out.println("invalid amount");
					}else{
					balance += deposit;
					System.out.println("Amount deposited successfully. New balance: "+balance);
					successfully++;
					}
				}
				else if(choice==3){
					System.out.print("Enter amount to withdraw: ");
					float withdraw = sc.nextFloat();
					if (withdraw==0){
						System.out.println("Transaction cancelled.");
						sc.close();
						return ;
					}
					if(withdraw <= balance &&withdraw>0){
						balance -= withdraw;
						System.out.println("Amount withdrawn successfully. New balance: "+balance);
						if (balance==0){System.out.println("Warning:Your account is empty.");}
						successfully++;
					}else{
						System.out.println("Insufficient balance.");
					}
				}
				else if(choice==4){
					if(balance>=5000){System.out.println("Account Status:VIP Customer");}
					else if(balance>1000&&balance<5000){System.out.println("Account Status:Regular Customer");}
					else{System.out.println("Account Status:Low Balance");}

				}
				else if(choice==5){
					System.out.println("Successful Transactions: " + successfully);
					System.out.println("Thank you for using the ATM. Goodbye!");
					sc.close();
					
				}
				else{
					System.out.println("Invalid choice. Please try again.");
				}
			}
		
	}

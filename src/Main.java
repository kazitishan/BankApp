import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("What is your name? ");
        String name = s.nextLine();
        System.out.print("What is your pin? ");
        String pin = s.nextLine();
        System.out.print("What is the name of your bagel shop? ");
        String shopName = s.nextLine();
        System.out.print("How many bagels are in your shop? ");
        int inventory = s.nextInt();
        System.out.print("What is the price of each bagel? ");
        int bagelPrice = s.nextInt();
        BankApp bankApp = new BankApp(name, pin, shopName, inventory, bagelPrice);
        while (bankApp.isQuit() == false){
            System.out.println(bankApp.menu());
            int choice = s.nextInt();
            bankApp.menuChoice(choice);
        }

    }
}


import java.util.Scanner;

public class BankApp {
    private String name;
    private String pin;
    private String shopName;
    private int inventory;
    private int bagelPrice;
    private boolean quit;
    private Bank bank;
    private CreditCard card1;
    private CreditCard card2 = new CreditCard("", "");
    private BagelShop shop;


    public BankApp(String name, String pin, String shopName, int inventory, int bagelPrice){
        this.name = name;
        this.pin = pin;
        this.shopName = shopName;
        this.inventory = inventory;
        this.bagelPrice = bagelPrice;
        quit = false;
        bank = new Bank();
        card1 = new CreditCard(name, pin);
        shop = new BagelShop(name, inventory, bagelPrice, bank);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getShopName() {
        return shopName;
    }

    public void setShopName(String shopName) {
        this.shopName = shopName;
    }

    public int getInventory() {
        return inventory;
    }

    public void setInventory(int inventory) {
        this.inventory = inventory;
    }

    public int getBagelPrice() {
        return bagelPrice;
    }

    public void setBagelPrice(int bagelPrice) {
        this.bagelPrice = bagelPrice;
    }

    public boolean isQuit() {
        return quit;
    }

    public void setQuit(boolean quit) {
        this.quit = quit;
    }

    public String menu(){
        String menu =  "What would you like to do...\n1. Purchase a bagel\n2. Return a bagel\n3. Make a payment on a credit card\n4. Compare credit card balances\n5. Deposit profits into the bank as the bagel shop owner\n6. Check inventory as the bagel shop owner\n7. Quit\n";
        if (card2.getAccountHolder().equals("")) menu += "8. Open a second credit card\n";
        return menu;
    }

    public void menuChoice(int num){
        Scanner s = new Scanner(System.in);
        if (num == 1){
            int chosenCard = 1;
            // if there is a second card
            if (!card2.getAccountHolder().equals("")) {
                System.out.print("What card would you like to pay with // type 1 for card 1, type 2 for card 2: ");
                chosenCard = s.nextInt();
            }
            System.out.print("How many bagels would you like to purchase: ");
            int amount = s.nextInt();
            System.out.print("Enter your pin to confirm the purchase: ");
            String inputtedPin = s.nextLine();
            if (chosenCard == 1){
                if (shop.payForBagels(card1, amount, inputtedPin)) System.out.println("Purchase Successful");
                else System.out.println("Wrong pin");
            }
            if (chosenCard == 2){
                if (shop.payForBagels(card2, amount, inputtedPin)) System.out.println("Purchase Successful");
                else System.out.println("Wrong pin");
            }
        }
        else if (num == 2){
            int chosenCard = 1;
            // if there is a second card
            if (!card2.getAccountHolder().equals("")) {
                System.out.print("What card would you like to return with // type 1 for card 1, type 2 for card 2: ");
                chosenCard = s.nextInt();
            }
            System.out.print("How many bagels would you like to return: ");
            int amount = s.nextInt();
            System.out.print("Enter your pin to confirm the return: ");
            String inputtedPin = s.nextLine();
            if (chosenCard == 1){
                if (shop.returnBagels(card1, amount, inputtedPin)) System.out.println("Return Successful");
                else System.out.println("Wrong pin");
            }
            if (chosenCard == 2){
                if (shop.returnBagels(card2, amount, inputtedPin)) System.out.println("Return Successful");
                else System.out.println("Wrong pin");
            }
        }
        else if (num == 3){
            int chosenCard = 1;
            // if there is a second card
            if (!card2.getAccountHolder().equals("")) {
                System.out.print("What card would you like to make a payment on // type 1 for card 1, type 2 for card 2: ");
                chosenCard = s.nextInt();
            }
            System.out.print("How much would you like to pay: ");
            int amount = s.nextInt();
            if (chosenCard == 1){
                bank.makePayment(card1, amount);
                System.out.println(card1.toString());
            }
            if (chosenCard == 2){
                bank.makePayment(card2, amount);
                System.out.println(card2.toString());
            }
        }
        else if (num == 4){
            // if there is a second card
            if (!card2.getAccountHolder().equals("")){
                System.out.println(card1.toString());
                System.out.println(card2.toString());
            }
            else{
                System.out.println(card1.toString());
            }
        }
        else if (num == 5){
            shop.depositProfits();
            System.out.println(bank.toString());
        }
        else if (num == 6){
            System.out.println(shop.toString());
        }
        else if (num == 7){
            System.out.print("You decided to quit!");
            quit = true;
        }
        else if (num == 8){
            System.out.print("What would like the name under this card be: ");
            String card2Name = s.nextLine();
            System.out.print("What would like the pin for this card be: ");
            String card2Pin = s.nextLine();
            card2.setAccountHolder(card2Name);
            card2.setPersonalPIN(card2Pin);
            System.out.println(card2.toString());
        }
    }

}
import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;
    private final Scanner scanner;

    public CoffeeMachine(int water, int milk, int beans, int cups, int money) {
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.money = money;
        this.scanner = new Scanner(System.in);
    }

    public boolean processAction() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
        String action = scanner.nextLine();
        System.out.println();

        switch (action) {
            case "buy":
                this.processBuying();
                break;
            case "fill":
                this.fillMachine();
                break;
            case "take":
                this.takeMoney();
                break;
            case "remaining":
                this.printMachineIngredients();
                break;
            case "exit":
                return false;
        }
        return true;
    }

    private void processBuying() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String buying = scanner.nextLine();
        if (!buying.equals("back")) {
            this.buyCoffee(Integer.parseInt(buying));
        }
    }

    private void fillMachine() {
        System.out.print("Write how many ml of water do you want to add: \n" +
                "> ");
        water += scanner.nextInt();

        System.out.print("Write how many ml of milk do you want to add: \n" +
                "> ");
        milk += scanner.nextInt();

        System.out.print("Write how many grams of coffee beans do you want to add: \n" +
                "> ");
        beans += scanner.nextInt();

        System.out.print("Write how many disposable cups of coffee do you want to add: \n" +
                "> ");
        cups += scanner.nextInt();

        scanner.nextLine();
    }

    private void takeMoney() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private void printMachineIngredients() {
        System.out.println("The coffee machine has:\n" +
                water + " of water\n" +
                milk + " of milk\n" +
                beans + " of coffee beans\n" +
                cups + " of disposable cups\n" +
                money + " of money");
    }

    private void buyCoffee(int coffeeNumber) {
        int needWater;
        int needMilk;
        int needBeans;
        int price;

        switch (coffeeNumber) {
            case 1:
                needWater = 250;
                needMilk = 0;
                needBeans = 16;
                price = 4;
                break;
            case 2:
                needWater = 350;
                needMilk = 75;
                needBeans = 20;
                price = 7;
                break;
            case 3:
                needWater = 200;
                needMilk = 100;
                needBeans = 12;
                price = 6;
                break;
            default:
                return;
        }

        if (possibleToMake(needWater, needMilk, needBeans)) {
            System.out.println("I have enough resources, making you a coffee!");
            water -= needWater;
            milk -= needMilk;
            beans -= needBeans;
            cups -= 1;
            money += price;
        }
    }

    private boolean possibleToMake(int needWater, int needMilk, int needBeans) {
        if (water < needWater) {
            System.out.println("Sorry, not enough water!");
            return false;
        } else if (milk < needMilk) {
            System.out.println("Sorry, not enough milk!");
            return false;
        } else if (beans < needBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return false;
        } else if (cups < 1) {
            System.out.println("Sorry, not enough disposable cups!");
            return false;
        }
        return true;
    }
}
public class Main {
    public static void main(String[] args) {
        boolean status = true;
        CoffeeMachine machine = new CoffeeMachine(400, 540, 120, 9, 550);

        while (status) {
            status = machine.processAction();
            System.out.println();
        }
    }
}


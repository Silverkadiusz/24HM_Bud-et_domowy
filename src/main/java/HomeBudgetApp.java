import java.util.Scanner;

public class HomeBudgetApp {

    public static void main(String[] args) {

        final BudgetDao DAO = new BudgetDao();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opcje: ");
            System.out.println("1. Add transaction");
            System.out.println("2. Transaction modification");
            System.out.println("3. Deleting a transaction");
            System.out.println("4. View all revenues");
            System.out.println("5. View all expenses");
            System.out.println("0. Koniec");

            String userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    TransactionSave.main(new String[0]);
                    break;
                case "2":
                    TransactionUpdate.main(new String[0]);
                    break;
                case "3":
                    TransactionDelete.main(new String[0]);
                    break;
                case "4":
                    DAO.viewAllRevenuess();
                    break;
                case "5":
                    DAO.viewAllExpenses();
                    return;
                case"0":
                    return;
                default:
                    System.out.println("Błędny wybór");


            }
        }
    }



}


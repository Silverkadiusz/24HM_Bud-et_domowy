import java.util.Scanner;

public class TransactionUpdate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Select transaction to update: ");
        long id = sc.nextLong();
        sc.nextLine();

        System.out.println("Type of transaction (income or expenditure): ");
        String type = sc.nextLine();

        System.out.println("Description: ");
        String description = sc.nextLine();

        System.out.println("Amount: ");
        int amount = sc.nextInt();
        sc.nextLine();

        System.out.println("Date: ");
        String date = sc.nextLine();

        Transaction transaction = new Transaction(id, type, description, amount, date);

        BudgetDao budgetDao = new BudgetDao();
        budgetDao.update(transaction);

    }
}

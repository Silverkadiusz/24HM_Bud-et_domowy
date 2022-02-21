import java.util.Scanner;

public class TransactionDelete {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Id number: ");
        int id = scanner.nextInt();
        scanner.nextLine();

        BudgetDao budgetDao = new BudgetDao();
        budgetDao.deleteById(id);
        System.out.println("Delete");

    }
}

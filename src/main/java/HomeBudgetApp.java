import java.util.Scanner;

public class HomeBudgetApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Opcje: ");
            System.out.println("1. Add transaction");
            System.out.println("2. Transaction modification");
            System.out.println("3. Deleting a transaction");
            System.out.println("4. View all revenues");
            System.out.println("0. View all expenses");

            String userInput = scanner.nextLine();

            /* switch (userInput) {
                case "1":
                    LibrarySave.main(new String[0]);
                    break;
                case "2":
                    LibraryRead.main(new String[0]);
                    break;
                case "3":
                    LibraryUpdate.main(new String[0]);
                    break;
                case "4":
                    LibraryDelete.main(new String[0]);
                    break;
                case "0":
                    return;
                default:
                    System.out.println("Błędny wybór");
*/

        }
    }
}


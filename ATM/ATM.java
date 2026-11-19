import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int CORRECT_PIN = 1234;
        final int MAX_ATTEMPTS = 3;

        // ---------- 1) Authentication (while loop) ----------
        int attempts = 0;
        boolean loggedIn = false;

        while (attempts < MAX_ATTEMPTS) {
            System.out.print("Enter PIN: ");
            int pin = sc.nextInt();

            if (pin == CORRECT_PIN) {
                loggedIn = true;
                break;
            }
            attempts++;
            System.out.println("Wrong PIN. Attempts left: " + (MAX_ATTEMPTS - attempts));
        }

        if (!loggedIn) {
            System.out.println("Too many failed attempts. Card blocked.");
            sc.close();
            return;
        }

        System.out.println("Login successful!");

        // ---------- 2) Data ----------
        double balance = 0;
        String[] history = new String[100]; // transaction history array
        int count = 0;                      // number of saved transactions

        // ---------- 3) Main menu (while loop) ----------
        boolean running = true;
        while (running) {
            System.out.println("\n===== ATM MENU =====");
            System.out.println("1. Check balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View transactions");
            System.out.println("5. Exit");
            System.out.print("Choose: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Balance: " + balance);
                    break;

                case 2:
                    System.out.print("Deposit amount: ");
                    double dep = sc.nextDouble();
                    if (dep <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (count >= history.length) {
                        System.out.println("History is full.");
                    } else {
                        balance += dep;
                        history[count++] = "Deposit: +" + dep;
                        System.out.println("Deposit done.");
                    }
                    break;

                case 3:
                    System.out.print("Withdraw amount: ");
                    double w = sc.nextDouble();
                    if (w <= 0) {
                        System.out.println("Invalid amount.");
                    } else if (w > balance) {
                        System.out.println("Error: insufficient balance!");
                    } else if (count >= history.length) {
                        System.out.println("History is full.");
                    } else {
                        balance -= w;
                        history[count++] = "Withdraw: -" + w;
                        System.out.println("Withdrawal done.");
                    }
                    break;

                case 4:
                    if (count == 0) {
                        System.out.println("No transactions yet.");
                    } else {
                        System.out.println("--- Transaction History ---");
                        for (int i = 0; i < count; i++) {
                            System.out.println((i + 1) + ". " + history[i]);
                        }
                    }
                    break;

                case 5:
                    running = false;
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
        }
        sc.close();
    }
}

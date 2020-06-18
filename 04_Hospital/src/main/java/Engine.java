import javax.persistence.EntityManager;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.util.Scanner;

public class Engine implements Runnable {
    private final EntityManager entityManager;
    private BufferedReader scanner;

    public Engine(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void run() {
        scanner = new BufferedReader(new InputStreamReader(System.in));
        String firstName = null;
        String lastName = null;
        String address = null;
        String email = null;
        String birthDate = null;
        LocalDate date = null;
        String picture = null;
        boolean hasInsurance = false;
        String visit = null;
        LocalDate visitDate = null;
        String comment = null;
        String diagnoseName = null;
        String diagnoseComment = null;
        String medicamentName = null;

        try {
            System.out.println("Please enter first name of patient:");
            firstName = scanner.readLine();
            checkIfEmpty(firstName);

            System.out.println("Please enter last name of patient:");
            lastName = scanner.readLine().trim();
            checkIfEmpty(lastName);

            System.out.println("Please enter address of patient:");
            address = scanner.readLine().trim();
            checkIfEmpty(address);

            System.out.println("Please enter email of patient:");
            email = scanner.readLine().trim();
            checkIfEmpty(email);
            checkIfEmail(email);

            System.out.println("Please enter birth date of patient (example: 2002(Y)-01(M)-01(D)):");
            birthDate = scanner.readLine().trim();
            date = LocalDate.parse(birthDate);

            System.out.println("Please enter of picture(string) patient:");
            picture = scanner.readLine().trim();
            checkIfEmpty(picture);

            System.out.println("The patient has insurance(true/false): ");
            String input = scanner.readLine();
            checkIfEmpty(input);
            hasInsurance = Boolean.parseBoolean(input);
            System.out.println("Patient data is okay! Proceeding...");

            System.out.println("Enter visitation date(example: 2002(Y)-01(M)-01(D)):");
            visit = scanner.readLine().trim();
            visitDate = LocalDate.parse(visit);
            System.out.println("Enter comment:");
            comment = scanner.readLine().trim();
            System.out.println("Visitation data is okay! Proceeding...");

            System.out.println("Enter diagnose name:");
            diagnoseName = scanner.readLine().trim();
            System.out.println("Enter comment:");
            diagnoseComment = scanner.readLine().trim();
            System.out.println("Diagnose data is okay! Proceeding...");

            System.out.println("Enter medicament name:");
            medicamentName = scanner.readLine().trim();
        } catch (IllegalArgumentException | IOException e) {
            System.out.println(e.getMessage());
        }

        try {
            Patient user = new Patient(firstName, lastName,
                    address, email, date, picture, hasInsurance);
            Visitation visitation = new Visitation(visitDate, comment);
            Diagnose diagnose = new Diagnose(diagnoseName, diagnoseComment);
            Medicament medicament = new Medicament(medicamentName);

            this.entityManager.getTransaction().begin();
            this.entityManager.merge(user);
            this.entityManager.merge(visitation);
            this.entityManager.merge(diagnose);
            this.entityManager.merge(medicament);
            this.entityManager.flush();
            this.entityManager.getTransaction().commit();
            System.out.println("All data is ready! Good Job!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void checkIfEmail(String email) {
        if (!email.contains("@")){
            throw new IllegalArgumentException("Email must include @!");
        }
    }

    private void checkIfEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input is incorrect!");
        }
    }
}

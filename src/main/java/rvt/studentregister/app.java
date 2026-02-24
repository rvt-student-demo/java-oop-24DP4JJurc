package rvt.studentregister;

import java.time.LocalDateTime;
import java.util.Scanner;

public class app {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        registrs registrs = new registrs();

        while (true) {
            System.out.println("\nIzvelies darbibu:");
            System.out.println("register | show | remove | edit | exit");
            String choice = sc.nextLine().trim().toLowerCase();

            try {
                switch (choice) {

                    case "register":
                        System.out.print("Vards: ");
                        String vards = sc.nextLine().trim();
                        Validatori.parbaudiVardu(vards);

                        System.out.print("Uzvards: ");
                        String uzvards = sc.nextLine().trim();
                        Validatori.parbaudiVardu(uzvards);

                        System.out.print("E-pasts: ");
                        String epasts = sc.nextLine().trim();
                        Validatori.parbaudiEpastu(epasts);

                        System.out.print("Personas kods (######-#####): ");
                        String pk = sc.nextLine().trim();
                        Validatori.parbaudiPersonasKodu(pk);

                        String datums = LocalDateTime.now().toString();

                        Students s = new Students(vards, uzvards, epasts, pk, datums);
                        registrs.pievienotStudentu(s);

                        System.out.println("Students veiksmigi registrets!");
                        break;

                    case "show":
                        registrs.paraditStudentus();
                        break;

                    case "remove":
                        System.out.print("Ievadi personas kodu: ");
                        String pkRemove = sc.nextLine().trim();
                        registrs.dzestStudentu(pkRemove);
                        break;

                    case "edit":
                        System.out.print("Ievadi personas kodu: ");
                        String pkEdit = sc.nextLine().trim();
                        registrs.redigetStudentu(pkEdit, sc);
                        break;

                    case "exit":
                        System.out.println("Programma aptureta.");
                        sc.close();
                        return;

                    default:
                        System.out.println("Nepareiza izvele!");
                }

            } catch (Exception e) {
                System.out.println("Kluda: " + e.getMessage());
            }
        }
    }
}

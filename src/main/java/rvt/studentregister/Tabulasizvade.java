package rvt.studentregister;

import java.util.List;

public class Tabulasizvade {

    public static void drukat(List<Students> studenti) {

        System.out.println("+------------+------------+----------------------+---------------+---------------------+");
        System.out.printf("| %-10s | %-10s | %-20s | %-13s | %-19s |\n",
                "Vārds", "Uzvārds", "E-pasts", "PK", "Datums");
        System.out.println("+------------+------------+----------------------+---------------+---------------------+");

        for (Students s : studenti) {
            System.out.printf("| %-10s | %-10s | %-20s | %-13s | %-19s |\n",
                    s.getVards(),
                    s.getUzvards(),
                    s.getEpasts(),
                    s.getPersonasKods(),
                    s.getRegistracijasDatums());
        }

        System.out.println("+------------+------------+----------------------+---------------+---------------------+");
    }
}


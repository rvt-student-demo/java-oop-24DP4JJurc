package rvt.studentregister;

import java.util.List;
import java.util.Scanner;

public class registrs {

    private List<Students> studenti;

    public registrs() {
        studenti = Failuapstrade.nolasit();
    }

    public void pievienotStudentu(Students s) throws Exception {

        for (Students st : studenti) {
            if (st.getPersonasKods().equals(s.getPersonasKods())) {
                throw new Exception("Personas kods jau eksistē!");
            }
            if (st.getEpasts().equals(s.getEpasts())) {
                throw new Exception("E-pasts jau aizņemts!");
            }
        }

        studenti.add(s);
        Failuapstrade.saglabat(studenti);
    }

    public void paraditStudentus() {
        Tabulasizvade.drukat(studenti);
    }

    public void dzestStudentu(String pk) throws Exception {
        boolean removed = studenti.removeIf(s -> s.getPersonasKods().equals(pk));

        if (!removed) {
            throw new Exception("Students nav atrasts!");
        }

        Failuapstrade.saglabat(studenti);
        System.out.println("Students dzēsts!");
    }

    public void redigetStudentu(String pk, Scanner sc) throws Exception {

        for (Students s : studenti) {
            if (s.getPersonasKods().equals(pk)) {

                System.out.print("Jauns e-pasts: ");
                String epasts = sc.nextLine().trim();
                Validatori.parbaudiEpastu(epasts);

                s.setEpasts(epasts);

                Failuapstrade.saglabat(studenti);
                System.out.println("Dati atjaunināti!");
                return;
            }
        }

        throw new Exception("Students nav atrasts!");
    }
}

package rvt.studentregister;

import java.io.*;
import java.util.*;

public class Failuapstrade {

    private static final String FILE = "studenti.csv";

    public static List<Students> nolasit() {

        List<Students> saraksts = new ArrayList<>();
        File f = new File(FILE);

        if (!f.exists()) {
            return saraksts;
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {
            String line;
            while ((line = br.readLine()) != null) {
                saraksts.add(Students.fromCSV(line));
            }
        } catch (IOException e) {
            System.out.println("Kļūda lasot failu!");
        }

        return saraksts;
    }

    public static void saglabat(List<Students> studenti) {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(FILE))) {
            for (Students s : studenti) {
                bw.write(s.toCSV());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Kļūda saglabājot failu!");
        }
    }
}



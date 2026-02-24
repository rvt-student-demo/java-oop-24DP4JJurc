package rvt.studentregister;

import java.util.regex.Pattern;


public class Validatori {

   
    private static final Pattern VARDS_UZVARDS =
            Pattern.compile("^[A-Za-z]{3,}$");

   
    private static final Pattern EPASTS =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$");

  
    private static final Pattern PERSONAS_KODS =
            Pattern.compile("^\\d{6}-\\d{5}$");
 
    public static void parbaudiVardu(String vards) {
        if (vards == null || vards.trim().isEmpty())
            throw new Ievadeskluda("Vards nedrikst but tukss.");

        if (!VARDS_UZVARDS.matcher(vards.trim()).matches())
            throw new Ievadeskluda("Vards: tikai burti, min 3 simboli.");
    }

    public static void parbaudiUzvardu(String uzvards) {
        if (uzvards == null || uzvards.trim().isEmpty())
            throw new Ievadeskluda("Uzvards nedrikst but tukss.");

        if (!VARDS_UZVARDS.matcher(uzvards.trim()).matches())
            throw new Ievadeskluda("Uzvards: tikai burti, min 3 simboli.");
    }

    public static void parbaudiEpastu(String epasts) {
        if (epasts == null || epasts.trim().isEmpty())
            throw new Ievadeskluda("Epasts nedrikst but tukss.");

        if (!EPASTS.matcher(epasts.trim()).matches())
            throw new Ievadeskluda("Nederigs epasta formats.");
    }

    public static void parbaudiPersonasKodu(String personasKods) {
        if (personasKods == null || personasKods.trim().isEmpty())
            throw new Ievadeskluda("Personas kods nedrikst but tukss.");

        if (!PERSONAS_KODS.matcher(personasKods.trim()).matches())
            throw new Ievadeskluda(
                    "Nederigs personas koda formats. Piemers: 010101-12345");
    }
}
    


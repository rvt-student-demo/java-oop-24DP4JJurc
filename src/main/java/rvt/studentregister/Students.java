package rvt.studentregister;


    public class Students {

        private String vards;
        private String uzvards;
        private String epasts;
        private String personasKods;
        private String registracijasDatums;
    
        public Students(String vards, String uzvards, String epasts,
                        String personasKods, String registracijasDatums) {
            this.vards = vards;
            this.uzvards = uzvards;
            this.epasts = epasts;
            this.personasKods = personasKods;
            this.registracijasDatums = registracijasDatums; 
        }
    
        public String toCSV() {
            return String.join(",", vards, uzvards, epasts, personasKods, registracijasDatums);
        }
    
        public static Students fromCSV(String line) {
            String[] d = line.split(",");
            return new Students(d[0], d[1], d[2], d[3], d[4]);
        }
    
        public String getVards() { return vards; }
        public String getUzvards() { return uzvards; }
        public String getEpasts() { return epasts; }
        public String getPersonasKods() { return personasKods; }
        public String getRegistracijasDatums() { return registracijasDatums; }
    
        public void setEpasts(String epasts) { this.epasts = epasts; }
    }
    


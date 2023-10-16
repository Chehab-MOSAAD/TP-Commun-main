package Réservations;

public class ReservationRestaurant extends Reservation {
    private int numTable;
    private int numService;
    
    public ReservationRestaurant(int jour, int mois, int numTable, int numService) {
        super(jour, mois);
        this.numTable = numTable;
        this.numService = numService;
    }
    
    public String toString() {
        String service;
        if (numService == 1) {
            service = "premier service";
        } else {
            service = "deuxieme service";
        }
        return "Le " + jour + "/" + mois + " : table n:" + numTable + " pour le " + service + ".";
    }
}

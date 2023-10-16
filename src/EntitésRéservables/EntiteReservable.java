package EntitésRéservables;

import java.time.LocalDate;

import Calendrier.CalendrierAnnuel;
import Réservations.Reservation;

public abstract class EntiteReservable {
    private int numero;
    private CalendrierAnnuel carnetReservation;

    public EntiteReservable(int numero) {
        this.numero = numero;
        this.carnetReservation = new CalendrierAnnuel();
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public int converteurDay(LocalDate date) {
        return date.getDayOfMonth();
    }
  
    public int converteurMonth(LocalDate date) {
        return date.getMonthValue();
    }
    
    public boolean estLibre(Formulaire formulaire) {
        LocalDate date = formulaire.getDateReservation();
        return carnetReservation.estLibre(converteurDay(date), converteurMonth(date));
    }

    public abstract boolean compatible(Formulaire formulaire);

    public abstract Reservation reserver(Formulaire formulaire);
}

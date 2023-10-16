package EntitésRéservables;

public abstract class Formulaire {
    protected int dateReservation;
    protected int moisReservation;
    private static int compteur = 0;
    private int identificationEntite;

    public Formulaire(int dateReservation, int moisReservation) {
        this.dateReservation = dateReservation;
        this.moisReservation = moisReservation;
        this.identificationEntite = compteur++;
    }

    public int getDateReservation() {
        return dateReservation;
    }

    public int getMoisReservation() {
        return moisReservation;
    }

    public int getIdentificationEntite() {
        return identificationEntite;
    }

    public void setIdentificationEntite(int identificationEntite) {
        this.identificationEntite = identificationEntite;
    }
}

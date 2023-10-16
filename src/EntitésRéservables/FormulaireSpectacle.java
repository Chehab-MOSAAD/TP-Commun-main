package EntitésRéservables;

import java.time.LocalDate;

public class FormulaireSpectacle extends Formulaire {
    private int numeroPlace;
    private int numeroZone;

    public FormulaireSpectacle(LocalDate dateReservation, int moisReservation, int numeroZone) {
        super(dateReservation, moisReservation);
        this.numeroZone = numeroZone;
    }

    public int getNumeroPlace() {
        return numeroPlace;
    }

    public void setNumeroPlace(int numeroPlace) {
        this.numeroPlace = numeroPlace;
    }

    public int getNumeroZone() {
        return numeroZone;
    }
}

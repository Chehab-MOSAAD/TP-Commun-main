package EntitésRéservables;

import java.time.LocalDate;

public class FormulaireRestaurant extends Formulaire {
    private int nombrePersonnes;
    private int numeroTable;
    private int numeroService;
    private int numEntiteReservee;

    public FormulaireRestaurant(int dateReservation, int moisReservation, int nombrePersonnes, int numeroService) {
        super(dateReservation, moisReservation);
        this.nombrePersonnes = nombrePersonnes;
        this.numeroService = numeroService;
    }

    public int getNombrePersonnes() {
        return nombrePersonnes;
    }

    public int getNumeroTable() {
        return numeroTable;
    }

    public void setNumeroTable(int numeroTable) {
        this.numeroTable = numeroTable;
    }

    public int getNumeroService() {
        return numeroService;
    }

    public int getNumEntiteReservee() {
        return numEntiteReservee;
    }

    public void setNumEntiteReservee(int numEntiteReservee) {
        this.numEntiteReservee = numEntiteReservee;
    }
}

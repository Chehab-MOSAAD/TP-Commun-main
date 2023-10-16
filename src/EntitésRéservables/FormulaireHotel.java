package EntitésRéservables;

import java.time.LocalDate;

public class FormulaireHotel extends Formulaire {
    private int nombreLitSimple;
    private int nombreLitDouble;
    private int numeroChambre;

    public FormulaireHotel(LocalDate dateReservation, int moisReservation, int nombreLitSimple, int nombreLitDouble) {
        super(dateReservation, moisReservation);
        this.nombreLitSimple = nombreLitSimple;
        this.nombreLitDouble = nombreLitDouble;
    }

    public int getNombreLitSimple() {
        return nombreLitSimple;
    }

    public int getNombreLitDouble() {
        return nombreLitDouble;
    }

    public int getNumeroChambre() {
        return numeroChambre;
    }

    public void setNumeroChambre(int numeroChambre) {
        this.numeroChambre = numeroChambre;
    }
}

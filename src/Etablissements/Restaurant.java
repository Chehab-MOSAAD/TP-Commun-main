package Etablissements;

import java.util.ArrayList;

import Calendrier.CalendrierAnnuel;
import CentraleRéservation.CentraleReservation;
import EntitésRéservables.EntiteReservable;
import EntitésRéservables.Formulaire;
import EntitésRéservables.FormulaireRestaurant;
import Réservations.ReservationRestaurant;

public class Restaurant {
    private CentraleReservation centrale;
    private ArrayList<Table> tables;

    public Restaurant() {
        this.centrale = new CentraleReservation(null);
        this.tables = new ArrayList<Table>();
    }

    public void ajouterTable(int nbChaises) {
        Table table = new Table(nbChaises);
        int numero = centrale.ajouterEntite(table);
        table.setNumero(numero);
        tables.add(table);
    }

    public int[] donnerPossibilites(FormulaireRestaurant formulaire) {
        return centrale.donnerPossibilites(formulaire);
    }

    public ReservationRestaurant reserver(int numeroTable, FormulaireRestaurant formulaire) {
        Table table = tables.get(numeroTable - 1);
        int[] possibilites = centrale.donnerPossibilites(formulaire);
        if (possibilites[numeroTable - 1] != 0) {
            ReservationRestaurant reservation = new ReservationRestaurant(table, formulaire);
            calendrierAnnuel(table, formulaire).reserver(formulaire.getDate(), possibilites[numeroTable - 1]);
            return reservation;
        }
        return null;
    }

    private CalendrierAnnuel calendrierTable(Table table, FormulaireRestaurant formulaire) {
        if (formulaire.getHeure() == HeureService.PREMIER_SERVICE) {
            return table.getCalendrier();
        } else {
            return table.getCalendrierDeuxiemeService();
        }
    }

    private class Table extends EntiteReservable {
        private int nbChaises;
        private CalendrierAnnuel calendrierDeuxiemeService;

        public Table(int nbChaises) {
            super();
            this.nbChaises = nbChaises;
            this.calendrierDeuxiemeService = new CalendrierAnnuel();
        }

        public int getNbChaises() {
            return nbChaises;
        }

        public CalendrierAnnuel getCalendrierDeuxiemeService() {
            return calendrierDeuxiemeService;
        }

        @Override
        public boolean estCompatible(Formulaire formulaire) {
            if (formulaire instanceof FormulaireRestaurant) {
                FormulaireRestaurant formulaireRestaurant = (FormulaireRestaurant) formulaire;
                if (this.getNbChaises() < formulaireRestaurant.getNbConvives() ||
                    this.getNbChaises() > formulaireRestaurant.getNbConvives() + 1) {
                    return false;
                }
                HeureService heureService = formulaireRestaurant.getHeure();
                CalendrierAnnuel calendrierTable = calendrierAnnuel(this, formulaireRestaurant);
                return calendrierTable.estLibre(formulaire.getDate(), heureService);
            }
            return false;
        }
    }
}


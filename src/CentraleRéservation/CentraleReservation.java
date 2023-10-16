package CentraleRéservation;

import EntitésRéservables.EntiteReservable;
import EntitésRéservables.Formulaire;
import Réservations.Reservation;

public class CentraleReservation {
    
    private EntiteReservable[] entitesAReserver;
    private int nbEntites;

    public CentraleReservation(EntiteReservable[] entitesAReserver) {
        this.entitesAReserver = entitesAReserver;
        this.nbEntites = 0;
    }

    public int ajouterEntite(EntiteReservable entite) {
        entite.setNumero(++this.nbEntites);
        this.entitesAReserver[nbEntites-1] = entite;
        return entite.getNumero();
    }

    public int[] donnerPossibilites(Formulaire formulaire) {
        int[] possibilites = new int[nbEntites];
        for (int i = 0; i < nbEntites; i++) {
            if (entitesAReserver[i].estLibre(formulaire)) {
                possibilites[i] = entitesAReserver[i].getNumero();
            }
        }
        return possibilites;
    }

    public Reservation reserver(int numeroEntite, Formulaire formulaire) {
        if (numeroEntite > 0 && numeroEntite <= nbEntites) {
            EntiteReservable entiteAReserver = entitesAReserver[numeroEntite-1];
            if (entiteAReserver.compatible(formulaire)) {
                formulaire.setIdentificationEntite(entiteAReserver.getNumero());
                return entiteAReserver.reserver(formulaire);
            }
        }
        return null;
    }
}

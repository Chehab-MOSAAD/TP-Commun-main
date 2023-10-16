package control;

import EntitésRéservables.FormulaireRestaurant;
import Réservations.Reservation;
import Réservations.ReservationRestaurant;
import model.Client;

public class ControlReserverTable {

	
	public int[] trouverPossibilite(int jour, int mois, int nombrePersonnes,int numService) {
		FormulaireRestaurant formulaire = //A COMPLETER;
		boolean formulaireEnregistrer = false;
		int numeroFormulaire = -1;
			
		for (int i = 0; i < formulaires.length && !formulaireEnregistrer; i++) {
			if (formulaires[i] == null) {
					formulaires[i] = formulaire;
					formulaireEnregistrer = true;
					numeroFormulaire = i;
				}
			}
			
		int[] possibilites = //A COMPLETER;
			
		int[] retour = new int[possibilites.length + 1];
		retour[0] = numeroFormulaire;
		for (int i = 1; i < possibilites.length + 1; i++) {
			retour[i] = possibilites[i - 1];
			}
		return retour;
	}
			
	public void reserver(int numClient, int numProposition, int numeroFormulaire) {
		FormulaireRestaurant formulaireRestaurant = formulaires[numeroFormulaire];
		formulaires[numeroFormulaire] = null;
		Reservation reservation = restaurant.reserver(numProposition, formulaireRestaurant);
		if (reservation instanceof ReservationRestaurant) {
			ReservationRestaurant reservationRestaurant = (ReservationRestaurant) reservation;
			Client client = //A COMPLETER;
			//A COMPLETER;
		}
	}
}

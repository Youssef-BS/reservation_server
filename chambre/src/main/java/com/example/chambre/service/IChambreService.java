package tn.esprit.tpfoyer.service;
import tn.esprit.tpfoyer.entity.Chambre;
import java.util.*;

public interface IChambreService {

    public List<Chambre> getAllChambres();
    public Chambre getChambreById(Long chId);
    public Chambre addChambre(Chambre c);
    public void removeChambreById (Long chId);
    public Chambre updateChambre(Chambre c);

    // Removed the method as it is no longer needed
    // Chambre findChambreByEtudiantCin(Long cin);
}

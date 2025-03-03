package tn.esprit.tpfoyer.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.IChambreService;

import java.util.List;

@Tag(name="Gestion de chambre")
@RestController
@RequestMapping("/chambre")
public class ChambreRestController {

    @Autowired
    private IChambreService chambreService;

    // http://localhost:8089/tpfoyer/chambre/get-all-chambres
    @Operation(description="recuperer toutes les chambres de bd")
    @GetMapping("/get-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.getAllChambres();
        return listChambres;
    }

    // http://localhost:8089/tpfoyer/chambre/get-chambre/8
    @Operation(description="recuperer les chambres by id")
    @GetMapping("/get-chambre/{chid}")
    public Chambre getChambre(@PathVariable("chid") Long chId) {
        Chambre chambre = chambreService.getChambreById(chId);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @Operation(description="ajouter des chambres ")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chid}
    @Operation(description="supprimer les chambres by id ")
    @DeleteMapping("/remove-chambre/{chid}")
    public void removeChambre(@PathVariable("chid") Long chId) {
        chambreService.removeChambreById(chId);
    }

    // http://localhost:8089/tpfoyer/chambre/update-chambre
    @Operation(description="modifier les chambres ")
    @PutMapping("/update-chambre")
    public Chambre updateChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.updateChambre(c);
        return chambre;
    }

  /*  // http://localhost:8089/tpfoyer/chambre/get-chambre-by-etudiant-cin/12345678
    @Operation(description="Trouver la chambre d'un étudiant donné par son CIN")
    @GetMapping("/get-chambre-by-etudiant-cin/{cin}")
    public Chambre getChambreByEtudiantCin(@PathVariable("cin") Long cin) {
        return chambreService.findChambreByEtudiantCin(cin);
    }*/
}

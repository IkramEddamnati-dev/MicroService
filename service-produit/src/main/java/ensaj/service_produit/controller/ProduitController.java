package ensaj.service_produit.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ensaj.service_produit.dto.ProduitRequest;
import ensaj.service_produit.dto.ProduitResponse;
import ensaj.service_produit.model.Produit;
import ensaj.service_produit.service.ProduitService;

import java.util.List;

@RestController
@RequestMapping("/api/produit")
@RequiredArgsConstructor
public class ProduitController {

    private final ProduitService produitService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduit(@RequestBody ProduitRequest produitRequest) {
        this.produitService.createProduit(produitRequest);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ProduitResponse> getAllProduit() {
        return this.produitService.getAllProduit();
    }

    private ProduitResponse mapToProduitResponse(Produit produit) {
        return ProduitResponse.builder()
                .id(produit.getId())
                .libelle(produit.getLibelle())
                .prix(produit.getPrix())
                .description(produit.getDescription())
                .build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduit(
            @PathVariable String id,
            @RequestBody ProduitRequest produitRequest) {
        produitService.updateProduit(id, produitRequest);
        return ResponseEntity.ok("Produit mis à jour avec succès !");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduit(@PathVariable String id) {
        produitService.deleteProduit(id);
        return ResponseEntity.ok("Produit supprimé avec succès !");
    }
    @GetMapping("/{id}")
@ResponseStatus(HttpStatus.OK)
public ProduitResponse getProduitById(@PathVariable String id) {
    return produitService.getProduitById(id);
}

}

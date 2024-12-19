package ensaj.service_produit.service;

import ensaj.service_produit.dto.ProduitRequest;
import ensaj.service_produit.dto.ProduitResponse;
import ensaj.service_produit.model.Produit;
import ensaj.service_produit.repository.ProduitRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ProduitService {
    private final ProduitRepository produitRepository;

    // Méthode pour créer un produit
    public void createProduit(ProduitRequest produitRequest) {
        Produit produit = Produit.builder()
                .libelle(produitRequest.getLibelle())
                .prix(produitRequest.getPrix())
                .description(produitRequest.getDescription())
                .build();
        produitRepository.save(produit);
        log.info("Le produit {} est enregistré", produit.getId());
    }

    // Méthode pour récupérer tous les produits
    public List<ProduitResponse> getAllProduit() {
        List<Produit> produits = produitRepository.findAll();
        return produits.stream()
                .map(this::mapToProduitResponse)
                .collect(Collectors.toList());
    }

    // Méthode pour mapper un Produit vers un ProduitResponse
    private ProduitResponse mapToProduitResponse(Produit produit) {
        return ProduitResponse.builder()
                .id(produit.getId())
                .libelle(produit.getLibelle())
                .prix(produit.getPrix())
                .description(produit.getDescription())
                .build();
    }
    public void updateProduit(String id, ProduitRequest produitRequest) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit avec l'id " + id + " non trouvé"));
        produit.setLibelle(produitRequest.getLibelle());
        produit.setPrix(produitRequest.getPrix());
        produit.setDescription(produitRequest.getDescription());
        produitRepository.save(produit);
    }
    public void deleteProduit(String id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit avec l'id " + id + " non trouvé"));
        produitRepository.delete(produit);
    }
    public ProduitResponse getProduitById(String id) {
        Produit produit = produitRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produit non trouvé"));
        return mapToProduitResponse(produit);
    }
    
        
}

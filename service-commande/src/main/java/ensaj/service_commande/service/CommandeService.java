package ensaj.service_commande.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import ensaj.service_commande.dto.CatalogueReponse;
import ensaj.service_commande.dto.CommandeLigneArticleDto;
import ensaj.service_commande.dto.CommandeRequest;
import ensaj.service_commande.model.ArticleLigneCommande;
import ensaj.service_commande.model.Commande;
import ensaj.service_commande.repository.CommandeRepository;
import jakarta.transaction.Transactional;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
@Service
@RequiredArgsConstructor
@Transactional
public class CommandeService {
    private final CommandeRepository commandeRepository;
    private final WebClient webClient;

    public void établirCommande(CommandeRequest commandeRequest){
        Commande commande = new Commande() ;
        commande.setNumCommande(UUID.randomUUID().toString());
        // mapping de articleLigneCommandeDto vers ArticleLigneCommande
        List<ArticleLigneCommande> articleLigneCommande=
       commandeRequest.getCommandeLigneArticleDtos()
        .stream()
        .map(this::mapToDto)
        .toList();
        commande.setArticleLigneCommande(articleLigneCommande);
        // récupérer les article de la ligne de commande
        List<String> skuCodes = commande.getArticleLigneCommande()
        .stream()
        .map(ArticleLigneCommande::getSkucode)
        .toList();
        // appeller le service catalogue pour vérifier l'éxistance de produit
        CatalogueReponse[] catalogueReponsesArray =webClient.get()
        .uri("http://localhost:8082/api/catalogue",
        uriBuilder ->
       uriBuilder.queryParam("skuCode",skuCodes).build()
        )
        .retrieve()
        .bodyToMono(CatalogueReponse[].class)
        .block();
        boolean tousProduitEnStock= Arrays.stream(catalogueReponsesArray).
        allMatch(CatalogueReponse::getEstEnStock);
        if(tousProduitEnStock){
        commandeRepository.save(commande);
        }
        else {
        throw new IllegalArgumentException("Produit n'existe pas en stocke");
        }
       }
    // Méthode pour mapper un DTO en entité ArticleLigneCommande
    private ArticleLigneCommande mapToDto(CommandeLigneArticleDto articleLigneCommandeDto) {
        ArticleLigneCommande articleLigneCommande = new ArticleLigneCommande();
        articleLigneCommande.setId(articleLigneCommandeDto.getId());
        articleLigneCommande.setPrix(articleLigneCommandeDto.getPrix());
        articleLigneCommande.setSkucode(articleLigneCommandeDto.getSkucode());
        articleLigneCommande.setQuantité(articleLigneCommandeDto.getQuantité());
        return articleLigneCommande;
    }
}

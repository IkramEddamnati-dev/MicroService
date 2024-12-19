package ensaj.service_catalogue.controller;

import lombok.*;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ensaj.service_catalogue.dto.CatalogueReponse;
import ensaj.service_catalogue.service.CatalogueService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/catalogue")
public class CatalogueController {
    private final CatalogueService catalogueService;
    //exemple de requettes http qui vont etre utilisées
    // http://localhost:8082/api/commande/ sku-code=iphone13&skucode=iphone14,
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<CatalogueReponse> estEnStocke(@RequestParam List <String> skuCode) {
    return catalogueService.estEnStocke(skuCode);
    }
   
   
}

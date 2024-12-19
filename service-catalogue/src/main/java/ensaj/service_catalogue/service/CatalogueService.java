package ensaj.service_catalogue.service;

import lombok.*;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ensaj.service_catalogue.dto.CatalogueReponse;
import ensaj.service_catalogue.repository.CatalogueRepository;
@RequiredArgsConstructor
@Service
public class CatalogueService {
    private final CatalogueRepository catalogueRepository;

    @Transactional(readOnly = true)
    public List<CatalogueReponse> estEnStocke(List<String> skuCode) {
        return catalogueRepository.findBySkuCodeIn(skuCode).stream()
            .map(catalogue ->
                CatalogueReponse.builder()
                    .skuCode(catalogue.getSkuCode())
                    .estEnStock(catalogue.getQuantité() > 0)
                    .build()
            )
            .toList();
    }
}

package ensaj.service_catalogue.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ensaj.service_catalogue.model.Catalogue;

import java.util.List;
import java.util.Optional;

public interface CatalogueRepository extends JpaRepository<Catalogue, Long> {
    List<Catalogue> findBySkuCodeIn(List<String> skuCode);
}

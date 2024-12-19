package ensaj.service_produit.repository;

import ensaj.service_produit.model.Produit;
import org.springframework.data.mongodb.repository.MongoRepository;
public interface ProduitRepository extends MongoRepository<Produit, String> {
}
package ensaj.service_produit.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
// une classe DTO pour les requetes du client
public class ProduitRequest {
@Id
private String id;
private String libelle;
private String description;
private Double prix;
}

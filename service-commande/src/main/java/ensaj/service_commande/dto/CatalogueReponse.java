package ensaj.service_commande.dto;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatalogueReponse {
 private String skuCode;
 private Boolean estEnStock;
}

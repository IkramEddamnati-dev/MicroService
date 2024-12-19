package ensaj.service_catalogue.dto;

import lombok.*;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CatalogueReponse {
 private String skuCode;
 private Boolean estEnStock;
}
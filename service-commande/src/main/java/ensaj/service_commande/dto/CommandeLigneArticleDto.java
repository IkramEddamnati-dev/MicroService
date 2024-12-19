package ensaj.service_commande.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommandeLigneArticleDto {
    private Long id;
    private String skucode;
    private BigDecimal prix;
    private Integer quantité;
}
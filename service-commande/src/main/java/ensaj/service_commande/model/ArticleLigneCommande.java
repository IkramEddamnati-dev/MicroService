package ensaj.service_commande.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;

@Entity
@Table(name = "t_article_commande")
@Data
public class ArticleLigneCommande {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // Stok keeping Unit (unité de gestion des stocks):.
    private String skucode;
    private BigDecimal prix;
    private Integer quantité;
}
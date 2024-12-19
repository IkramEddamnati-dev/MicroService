package ensaj.service_commande.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "t_commande")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Commande {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String NumCommande;
    @OneToMany(cascade = CascadeType.ALL)
    private List<ArticleLigneCommande> articleLigneCommande;
}
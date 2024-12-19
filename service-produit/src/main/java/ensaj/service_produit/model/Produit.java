package ensaj.service_produit.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Document(value = "produit")
public class Produit {
@Id
private String id;
private String libelle;
private String description;
private double prix;
}
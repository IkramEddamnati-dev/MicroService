package ensaj.service_produit;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import ensaj.service_produit.dto.ProduitRequest;
import ensaj.service_produit.model.Produit;
import ensaj.service_produit.repository.ProduitRepository;

@SpringBootTest
@AutoConfigureMockMvc // Permet la configuration automatique de MockMvc
class ServiceProduitApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ProduitRepository produitRepository;

    @Autowired
    private ObjectMapper objectMapper;
	@Test
void shouldCreateProduit() throws Exception {
ProduitRequest produitRequest=ProduitRequest.builder()
.libelle("TV")
.description("Télévision")
.prix(Double.valueOf("5000"))
.build();
String
produitRequestString=objectMapper.writeValueAsString(produitRequest);
// tester le post du controller
mockMvc.perform(MockMvcRequestBuilders.post("/api/produit")
.contentType(MediaType.APPLICATION_JSON)
.content(produitRequestString))
.andExpect(status().isCreated());
}
    @Test
    void shouldGetProduitById() throws Exception {
        
        // 2. Envoyer une requête GET pour récupérer le produit
        mockMvc.perform(MockMvcRequestBuilders.get("/api/produit/{id}", "1")
                .contentType(MediaType.APPLICATION_JSON))
                // 3. Vérifier la réponse
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value("1"))
                .andExpect(jsonPath("$.libelle").value("TV"))
                .andExpect(jsonPath("$.description").value("Télévision"))
                .andExpect(jsonPath("$.prix").value(5000.0));
    }
}

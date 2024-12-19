package ensaj.service_commande.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ensaj.service_commande.model.Commande;

public interface CommandeRepository extends JpaRepository<Commande, Long> {
}

package ensaj.service_catalogue;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import ensaj.service_catalogue.model.Catalogue;
import ensaj.service_catalogue.repository.CatalogueRepository;

@SpringBootApplication
public class ServiceCatalogueApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceCatalogueApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(CatalogueRepository catalogueRepository) {
		return args -> {
			Catalogue catalogue1 = new Catalogue();
			catalogue1.setSkuCode("iphone_13");
			catalogue1.setQuantité(100);
			Catalogue catalogue2 = new Catalogue();
			catalogue2.setSkuCode("iphone_13");
			catalogue2.setQuantité(0);
			catalogueRepository.save(catalogue1);
			catalogueRepository.save(catalogue2);
		};
	}

}

package ensaj.service_commande.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import ensaj.service_commande.dto.CommandeRequest;
import ensaj.service_commande.service.CommandeService;

@RestController
@RequestMapping("api/commande")
@RequiredArgsConstructor
public class CommandeController {
    private final CommandeService commandeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String établirCommande(@RequestBody CommandeRequest commandeRequest) {
        commandeService.établirCommande(commandeRequest);
        return "la commande établie avec succé";
    }
}
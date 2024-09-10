package org.example.cep;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CepController {

    @Autowired
    private ViaCepService viaCepService;

    @GetMapping("/buscar-cep")
    public String buscarCep(@RequestParam("cep") String cep, Model model) {
        Endereco endereco = viaCepService.buscarEnderecoPorCep(cep);
        if (endereco == null) {
            model.addAttribute("erro", "CEP inválido ou não encontrado. Verifique e tente novamente.");
        } else {
            model.addAttribute("endereco", endereco);
        }
        return "resultado";
    }
}

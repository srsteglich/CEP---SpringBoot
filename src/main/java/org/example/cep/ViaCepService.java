package org.example.cep;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
@Service
public class ViaCepService {

    private static final String URL = "https://viacep.com.br/ws/{cep}/json/";

    public Endereco buscarEnderecoPorCep(String cep) {

        if (cep.length() != 9) {
            return null;
        }
        RestTemplate restTemplate = new RestTemplate();
        try {
            Endereco endereco = restTemplate.getForObject(URL, Endereco.class, cep);
            if (endereco != null && endereco.getCep() != null) {
                return endereco;
            }
        } catch (RestClientException e) {

        }
        return null;
    }
}

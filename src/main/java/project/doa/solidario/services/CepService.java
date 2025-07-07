package project.doa.solidario.services;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.doa.solidario.configuration.ViaCepResponse;


@Service
public class CepService {

    private final RestTemplate restTemplate = new RestTemplate();

    public ViaCepResponse buscarEnderecoPorCep(String cep) {
        String url = String.format("https://viacep.com.br/ws/%s/json/", cep);
        return restTemplate.getForObject(url, ViaCepResponse.class);
    }
}

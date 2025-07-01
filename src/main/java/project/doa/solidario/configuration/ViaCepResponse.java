package project.doa.solidario.configuration;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ViaCepResponse {
    @JsonProperty("logradouro")
    private String logradouro;

    @JsonProperty("localidade")
    private String localidade;

    @JsonProperty("uf")
    private String uf;

    public String getLogradouro() { return logradouro; }
    public String getLocalidade() { return localidade; }
    public String getUf() { return uf; }
}

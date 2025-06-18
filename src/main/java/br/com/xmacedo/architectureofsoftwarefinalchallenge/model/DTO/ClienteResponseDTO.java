package br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "DTO para respostas contendo informações completas do cliente")
public class ClienteResponseDTO {
    @Schema(description = "Identificador único do cliente",
            example = "1")
    private Long id;

    @Schema(description = "Nome completo do cliente",
            example = "João da Silva")
    private String nome;

    @Schema(description = "Email do cliente",
            example = "joao.silva@email.com")
    private String email;

    @Schema(description = "CPF do cliente",
            example = "***456789**")
    private String cpf;

    @Schema(description = "Telefone do cliente",
            example = "(11) 99988-7766")
    private String telefone;

    @Schema(description = "Endereço (logradouro) do cliente",
            example = "Rua das Flores")
    private String endereco;

    @Schema(description = "Número do endereço",
            example = "123")
    private String numero;

    @Schema(description = "Complemento do endereço (pode ser null se não informado)",
            example = "Apto 42, Bloco B")
    private String complemento;

    @Schema(description = "Bairro onde o cliente reside",
            example = "Jardim Primavera")
    private String bairro;

    @Schema(description = "Cidade onde o cliente reside",
            example = "São Paulo")
    private String cidade;

    @Schema(description = "Estado (UF) onde o cliente reside",
            example = "SP")
    private String estado;

    @Schema(description = "CEP formatado do endereço do cliente",
            example = "01234-567")
    private String cep;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    public String toString() {
        return "ClienteResponseDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone="
                + telefone + ", endereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento
                + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
    }
}

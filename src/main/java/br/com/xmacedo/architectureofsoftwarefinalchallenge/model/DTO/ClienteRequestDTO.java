package br.com.xmacedo.architectureofsoftwarefinalchallenge.model.DTO;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Schema(description = "DTO para requisições de criação/atualização de cliente")
public class ClienteRequestDTO {

    private Long id;

    @Schema(description = "Nome completo do cliente",
            example = "João da Silva",
            required = true)
    @NotBlank(message = "O nome não pode estar em branco")
    @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String nome;

    @Schema(description = "Email do cliente",
            example = "joao.silva@email.com",
            required = true)
    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Email inválido")
    private String email;

    @Schema(description = "CPF do cliente (apenas números)",
            example = "12345678900",
            pattern = "^\\d{11}$",
            required = true)
    @NotBlank(message = "O CPF não pode estar em branco")
    @Pattern(regexp = "^\\d{11}$", message = "CPF deve conter 11 dígitos numéricos")
    private String cpf;

    @Schema(description = "Telefone do cliente (apenas números)",
            example = "11999887766",
            pattern = "^\\d{10,11}$")
    @Pattern(regexp = "^\\d{10,11}$", message = "Telefone deve ter 10 ou 11 dígitos numéricos")
    private String telefone;

    @Schema(description = "Endereço (logradouro) do cliente",
            example = "Rua das Flores",
            required = true)
    @NotBlank(message = "O endereço não pode estar em branco")
    @Size(max = 100, message = "O endereço deve ter no máximo 100 caracteres")
    private String endereco;

    @Schema(description = "Número do endereço",
            example = "123",
            required = true)
    @NotBlank(message = "O número não pode estar em branco")
    @Size(max = 10, message = "O número deve ter no máximo 10 caracteres")
    private String numero;

    @Schema(description = "Complemento do endereço",
            example = "Apto 42, Bloco B")
    @Size(max = 50, message = "O complemento deve ter no máximo 50 caracteres")
    private String complemento;

    @Schema(description = "Bairro",
            example = "Jardim Primavera",
            required = true)
    @NotBlank(message = "O bairro não pode estar em branco")
    @Size(max = 50, message = "O bairro deve ter no máximo 50 caracteres")
    private String bairro;

    @Schema(description = "Cidade",
            example = "São Paulo",
            required = true)
    @NotBlank(message = "A cidade não pode estar em branco")
    @Size(max = 50, message = "A cidade deve ter no máximo 50 caracteres")
    private String cidade;

    @Schema(description = "Estado (UF)",
            example = "SP",
            required = true)
    @NotBlank(message = "O estado não pode estar em branco")
    @Pattern(regexp = "^[A-Z]{2}$", message = "O estado deve ser uma UF válida com 2 letras maiúsculas")
    private String estado;

    @Schema(description = "CEP (apenas números)",
            example = "01234567",
            pattern = "^\\d{8}$",
            required = true)
    @NotBlank(message = "O CEP não pode estar em branco")
    @Pattern(regexp = "^\\d{8}$", message = "CEP deve conter 8 dígitos numéricos")
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

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String toString() {
        return "ClienteRequestDTO [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", telefone="
                + telefone + ", endereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento
                + ", bairro=" + bairro + ", cidade=" + cidade + ", estado=" + estado + ", cep=" + cep + "]";
    }
}

package arquiteturawebAC1.AC1.Model;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinTable;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
@Entity
public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty (message = "O Nome do Aluno não pode estar em branco")
    @Size(min = 1, max = 200, message = "O titulo deve ter entre 1 a 200 caracteres")
    private String nome;
    @NotEmpty (message = "O Email do Aluno não pode estar em branco")
    @Email
    private String email;
    @NotEmpty (message = "O RA do Aluno não pode estar em branco")
    private String RA;
    @NotEmpty (message = "O Numero de celular do Aluno não pode estar em branco")
    private String numeroCel;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinTable(name = "aluno_curso", joinColumns = @jakarta.persistence.JoinColumn(name = "aluno_id"),inverseJoinColumns = @jakarta.persistence.JoinColumn(name = "curso_id"))
    @JsonIgnore
    private Curso curso;

    public Aluno() {
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRA() {
        return RA;
    }

    public void setRA(String RA) {
        this.RA = RA;
    }

    public String getNumeroCel() {
        return numeroCel;
    }

    public void setNumeroCel(String numeroCel) {
        this.numeroCel = numeroCel;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", RA='" + RA + '\'' +
                ", numeroCel='" + numeroCel + '\'' +
                ", curso=" + curso +
                '}';
    }
}
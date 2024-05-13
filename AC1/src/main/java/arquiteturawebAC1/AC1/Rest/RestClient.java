package arquiteturawebAC1.AC1.Rest;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import arquiteturawebAC1.AC1.Model.Aluno;

public class RestClient {

    private final String baseUrl = "http://localhost:8080/api/alunos"; 

    private final RestTemplate restTemplate = new RestTemplate();

    
    public void listarAlunos() {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl, String.class);
        System.out.println("Lista de Alunos: " + response.getBody());
    }

   
    public void buscarAlunoPorId(Long id) {
        ResponseEntity<String> response = restTemplate.getForEntity(baseUrl + "/" + id, String.class);
        System.out.println("Aluno encontrado: " + response.getBody());
    }

    
    public void adicionarAluno(Aluno aluno) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Aluno> request = new HttpEntity<>(aluno, headers);
        ResponseEntity<Aluno> response = restTemplate.postForEntity(baseUrl, request, Aluno.class);
        System.out.println("Aluno adicionado: " + response.getBody());
    }

    
    public void atualizarAluno(Long id, Aluno alunoAtualizado) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Aluno> request = new HttpEntity<>(alunoAtualizado, headers);
        restTemplate.put(baseUrl + "/" + id, request);
        System.out.println("Aluno atualizado com sucesso.");
    }

    
    public void deletarAluno(Long id) {
        restTemplate.delete(baseUrl + "/" + id);
        System.out.println("Aluno deletado com sucesso.");
    }
}

package arquiteturawebAC1.AC1.Rest;

import org.springframework.http.*;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.*;

import java.io.IOException;

import arquiteturawebAC1.AC1.Model.*;
public class RestClientExample {

    public static void main(String[] args) {
        
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.setErrorHandler(new ResponseErrorHandler() {
            @Override
            public boolean hasError(ClientHttpResponse response) throws IOException {
                return false;
            }

            @Override
            public void handleError(ClientHttpResponse response) throws IOException {
                HttpStatus status = (HttpStatus) response.getStatusCode();
                String body = new String(response.getBody().readAllBytes());
                System.out.println("Status: " + status);
                System.out.println("Response: " + body);
            }
        });

        
        Aluno aluno = new Aluno();
        aluno.setNome("Exemplo");
        aluno.setEmail("exemplo@email.com");
        aluno.setRA("123456");
        aluno.setNumeroCel("123456789");

        
        String url = "http://localhost:8080/api/alunos";

        
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Aluno> request = new HttpEntity<>(aluno, headers);

        
        ResponseEntity<Aluno> response = restTemplate.postForEntity(url, request, Aluno.class);

        
        if (response.getStatusCode() == HttpStatus.CREATED) {
            System.out.println("Aluno criado com sucesso!");
        } else {
            System.out.println("Falha ao criar aluno. Status: " + response.getStatusCode());
        }
    }
}

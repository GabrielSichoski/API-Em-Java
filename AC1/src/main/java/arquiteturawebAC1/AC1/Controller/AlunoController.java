package arquiteturawebAC1.AC1.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import arquiteturawebAC1.AC1.Model.Aluno;

import arquiteturawebAC1.AC1.Service.AlunoService;

import java.util.List;


@RestController
@RequestMapping("/api/alunos")
public class AlunoController {

    
    @Autowired
    private AlunoService alunoService;

    @GetMapping("/")
    public ResponseEntity<List<Aluno>> listarTodosAlunos() {
        List<Aluno> alunos = alunoService.listarTodos();
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Aluno> buscarAlunoPorId(@PathVariable Long id) {
        Aluno aluno = alunoService.buscarPorId(id);
        return ResponseEntity.ok().body(aluno);
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorNome(@PathVariable String nome) {
        List<Aluno> alunos = alunoService.buscarPorNome(nome);
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorEmail(@PathVariable String email) {
        List<Aluno> alunos = alunoService.buscarPorEmail(email);
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/NumeroCel/{NumeroCel}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorNumeroCel(@PathVariable String NumeroCel) {
        List<Aluno> alunos = alunoService.buscarPorNumeroCel(NumeroCel);
        return ResponseEntity.ok().body(alunos);
    }

    @GetMapping("/ra/{ra}")
    public ResponseEntity<List<Aluno>> buscarAlunosPorRA(@PathVariable String ra) {
        List<Aluno> alunos = alunoService.buscarPorRA(ra);
        return ResponseEntity.ok().body(alunos);
    }

    @PostMapping("/")
    public ResponseEntity<Aluno> adicionarAluno(@RequestBody Aluno aluno) {
        Aluno novoAluno = alunoService.salvar(aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<Aluno> atualizarAluno(@PathVariable(value = "id") Long id, @RequestBody Aluno alunoAtualizado) {
        Aluno aluno = alunoService.atualizar(id, alunoAtualizado);
        return ResponseEntity.ok().body(aluno);
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> deletarAluno(@PathVariable(value = "id") Long id) {
        alunoService.deletar(id);
        return ResponseEntity.ok().build();
    }
    @PostMapping("/registrar/{idAluno}/{idCurso}")
    public ResponseEntity<String> registrarAlunoEmCurso(@PathVariable Long idAluno, @PathVariable Long idCurso) {
    try {
        alunoService.registrarAlunoEmCurso(idAluno, idCurso);
        return ResponseEntity.ok("Aluno registrado no curso com sucesso.");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao registrar aluno no curso: " + e.getMessage());
    }
}
}
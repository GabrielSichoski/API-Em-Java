package arquiteturawebAC1.AC1.Controller;

import arquiteturawebAC1.AC1.Model.Curso;
import arquiteturawebAC1.AC1.Model.Aluno;
import arquiteturawebAC1.AC1.Service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping("/")
    public ResponseEntity<Curso> criarCurso(@RequestBody Curso curso) {
        Curso novoCurso = cursoService.criarCurso(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurso);
    }

    @GetMapping("/")
    public ResponseEntity<List<Curso>> listarCursos() {
        List<Curso> cursos = cursoService.listarCursos();
        return ResponseEntity.ok().body(cursos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> buscarCursoPorId(@PathVariable Long id) {
        Curso curso = cursoService.buscarCursoPorId(id);
        return ResponseEntity.ok().body(curso);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curso> atualizarCurso(@PathVariable Long id, @RequestBody Curso cursoAtualizado) {
        Curso curso = cursoService.atualizarCurso(id, cursoAtualizado);
        return ResponseEntity.ok().body(curso);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarCurso(@PathVariable Long id) {
        cursoService.deletarCurso(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/alunos")
    public ResponseEntity<List<Aluno>> buscarAlunosDoCurso(@PathVariable Long id) {
        List<Aluno> alunos = cursoService.buscarAlunosDoCurso(id);
        return ResponseEntity.ok().body(alunos);
    }
    @PostMapping("/{id}/alunos")  
    public ResponseEntity<Aluno> registrarAlunoNoCurso(@PathVariable Long idCurso, @PathVariable Long aluno) {
        Aluno novoAluno = cursoService.registrarAlunoNoCurso(idCurso, aluno);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoAluno);
    }
}
package arquiteturawebAC1.AC1.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import arquiteturawebAC1.AC1.Model.Aluno;
import arquiteturawebAC1.AC1.Model.Curso;
import arquiteturawebAC1.AC1.Repository.AlunoRepository;
import arquiteturawebAC1.AC1.Repository.CursoRepository;

@Service
public class AlunoServiceImpl implements AlunoService {   
        @Autowired
        private AlunoRepository alunoRepository;

        @Autowired
    private CursoRepository cursoRepository;
    
        public List<Aluno> listarTodos() {
            return alunoRepository.findAll();
        }
    
        public Aluno buscarPorId(Long id) {
            return alunoRepository.findById(id).orElseThrow(() -> new RuntimeException("Aluno não encontrado com o ID: " + id));
        }
    
        public List<Aluno> buscarPorNome(String nome) {
            return alunoRepository.findByNomeContainingIgnoreCase(nome);
        }
    
        public List<Aluno> buscarPorEmail(String email) {
            return alunoRepository.findByEmail(email);
        }
    
        public List<Aluno> buscarPorNumeroCel(String numeroCel) {
            return alunoRepository.findByNumeroCel(numeroCel);
        }
    
        public List<Aluno> buscarPorRA(String ra) {
            return alunoRepository.findByRA(ra);
        }
    
        public Aluno salvar(Aluno aluno) {
            return alunoRepository.save(aluno);
        }
    
        public Aluno atualizar(Long id, Aluno alunoAtualizado) {
            Aluno aluno = buscarPorId(id);
            aluno.setNome(alunoAtualizado.getNome());
            aluno.setEmail(alunoAtualizado.getEmail());
            aluno.setRA(alunoAtualizado.getRA());
            aluno.setNumeroCel(alunoAtualizado.getNumeroCel());
            return alunoRepository.save(aluno);
        }
    
        public void deletar(Long id) {
            alunoRepository.deleteById(id);
        }
        public void registrarAlunoEmCurso(Long idAluno, Long idCurso) {
            Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
            Curso curso = cursoRepository.findById(idCurso).orElseThrow(() -> new RuntimeException("Curso não encontrado"));
    
            aluno.setCurso(curso);
            alunoRepository.save(aluno);
        }
    }
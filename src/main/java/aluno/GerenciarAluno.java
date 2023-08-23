package aluno;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class GerenciarAluno {

	private EntityManagerFactory emf;
	private EntityManager em;
	
	public GerenciarAluno() {
		emf = Persistence.createEntityManagerFactory("xuxu");
		em = emf.createEntityManager();
	}
	
	public void fechar() {
		em.close();
		emf.close();
	}
	
	public Aluno findById(int id) {
		return em.find(Aluno.class, id);
	}
	
	public void cadastrar(Aluno aluno) {
		em.getTransaction().begin();
		em.persist(aluno);
		em.getTransaction().commit();
	}
	
	public void atualizar(Aluno aluno) {
		em.getTransaction().begin();
		em.merge(aluno);
		em.getTransaction().commit();
	}
	
	public void remover(Aluno aluno) {
		em.getTransaction().begin();
		em.remove(aluno);
		em.getTransaction().commit();
	}
	
	public List<Aluno> listar(){
		String consultaHQL = "from Aluno";
		Query queryHQL = em.createQuery(consultaHQL);
		List<Aluno> alunos = queryHQL.getResultList();

		return alunos;
	}
}

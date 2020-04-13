import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import br.net.mirantecnology.dao.PessoaDAO;
import br.net.mirantecnology.model.Fisica;
import br.net.mirantecnology.model.Juridica;
import br.net.mirantecnology.model.Pessoa;
import br.net.mirantecnology.model.Telefone;
import br.net.mirantecnology.model.TipoPessoa;
import br.net.mirantecnology.model.TipoTelefone;

public class TestCrud {

	public static void main(String[] args) {
		Telefone celular = new Telefone("083","988388487", TipoTelefone.CELULAR);
		Telefone residencial = new Telefone("083","33418786", TipoTelefone.FIXO);
		List<Telefone> telefones = new ArrayList<Telefone>();
		telefones.add(celular);
		telefones.add(residencial);
		Pessoa pFisica = new Fisica("Arnaldo de Sena Santos",TipoPessoa.FISICA,telefones,"69804427400",new Date(),"Olivia Maria de Sena Santos","Adjacy Gomes dos Santos");
		PessoaDAO dao = PessoaDAO.getInstance();
		Pessoa pJuridica = new Juridica("Mirante Tecnologia", TipoPessoa.JURIDICA, telefones, "1023456000134");
		//dao.persist(pFisica);
		System.out.println("Pessoa Fisica");
		dao.persist(pJuridica);
		System.out.println("Pessoa Juridica");

	}

}

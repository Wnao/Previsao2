package br.usjt.hellospringboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.usjt.hellospringboot.model.Previsao;
import br.usjt.hellospringboot.model.Calculadora;
import br.usjt.hellospringboot.repository.PrevisaoRepository;


@Service
public class PrevisaoService {
	@Autowired
	private PrevisaoRepository previsaoRepo;
	
	@Autowired
	private Calculadora calculadora;
	
	public void salvar(Previsao previsao) {
		previsaoRepo.save(previsao);
	}
	
	public List<Previsao> listarTodos() {
		List<Previsao> previsoes = previsaoRepo.findAll();
		for (Previsao previsao : previsoes) {
			previsao.setMediaFinal(calculadora.calculaMedia(previsao.getMax(),
					previsao.getMin()));
		}
		return previsoes;
	}
}
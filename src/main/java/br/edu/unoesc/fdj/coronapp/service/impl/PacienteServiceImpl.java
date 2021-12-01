package br.edu.unoesc.fdj.coronapp.service.impl;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

import br.edu.unoesc.fdj.coronapp.model.Paciente;
import br.edu.unoesc.fdj.coronapp.repository.PacienteRepository;
import br.edu.unoesc.fdj.coronapp.service.PacienteService;

@Stateless
@ApplicationScoped
public class PacienteServiceImpl implements PacienteService {
	@Inject
	private PacienteRepository pacienteRepository;

	@Override
	public void salvar(Paciente paciente) {
		pacienteRepository.save(paciente);
	}

	@Override
	public void excluir(Paciente paciente) {
		pacienteRepository.delete(paciente);
	}

	@Override
	public List<Paciente> listar() {
		return pacienteRepository.findAll();
	}

	@Override
	public Paciente listarPorCPF(Long cpf) {
		return pacienteRepository.findByCpf(cpf);
	}

	@Override
	public List<Paciente> listarPorResultado(Double resultado) {
		return pacienteRepository.findByResultado(resultado);
	}

	@Override
	public List<Paciente> listarPorSexo(String sexo) {
		return pacienteRepository.porSexo(sexo);
	}
}

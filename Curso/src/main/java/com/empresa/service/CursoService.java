package com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.entites.Curso;
import com.empresa.repository.CursoRepository;

@Service
public class CursoService {

	private final CursoRepository cursoRepository;
	
	@Autowired
	public CursoService(CursoRepository cursoRepository) {
		this.cursoRepository = cursoRepository;
	}
	public List<Curso> buscaTodosCursos(){
		return cursoRepository.findAll();
	}
	
	public Curso buscaCursoId(Long id) {
		Optional <Curso> Curso = cursoRepository.findById(id);
		return Curso.orElse(null);
	}
	
	public Curso salvaCurso(Curso Curso) {
		return cursoRepository.save(Curso);
	}
	public Curso alterarCurso(Long id, Curso alterarU) {
		Optional <Curso> existeCurso = cursoRepository.findById(id);
		if(existeCurso.isPresent()) {
			alterarU.setId(id);
			return cursoRepository.save(alterarU);
		}
		return null;
	}
	public boolean apagarCurso(Long id) {
		Optional <Curso> existeCurso = cursoRepository.findById(id);
		if (existeCurso.isPresent()) {
			cursoRepository.deleteById(id);
			return true;
		}
		return false;
	}




}

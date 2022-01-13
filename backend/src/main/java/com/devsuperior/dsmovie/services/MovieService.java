package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.repositories.MovieRepository;

@Service
public class MovieService {      
	
	
	@Autowired
	private MovieRepository repository; 						//Para fazer a consulta no banco 
	
	
	@Transactional(readOnly = true)
	public Page<MovieDTO> findAll(Pageable pageable){ 			//vai listar por páginas
		Page<Movie> result = repository.findAll(pageable); 		//retorno do result é uma pagina de Movie entidade
		Page<MovieDTO> page = result.map(x -> new MovieDTO(x)); //converte para MovieDTO
		return page;
	}
	
	
	@Transactional(readOnly = true)
	public MovieDTO findById (Long id){ 			
		Movie result = repository.findById(id).get(); 		//precisa do get() pois o findById retorna um objeto Optional onde Movie está	
		MovieDTO dto = new MovieDTO(result);
		return dto;
	}
	
	

}

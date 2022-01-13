package com.devsuperior.dsmovie.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dsmovie.dto.MovieDTO;
import com.devsuperior.dsmovie.dto.ScoreDTO;
import com.devsuperior.dsmovie.entities.Movie;
import com.devsuperior.dsmovie.entities.Score;
import com.devsuperior.dsmovie.entities.User;
import com.devsuperior.dsmovie.repositories.MovieRepository;
import com.devsuperior.dsmovie.repositories.ScoreRepository;
import com.devsuperior.dsmovie.repositories.UserRepository;

@Service
public class ScoreService {      
	
	
	@Autowired
	private MovieRepository movieRepository; 	
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ScoreRepository scoreRepository;
	
	
	@Transactional
	public MovieDTO saveScore (ScoreDTO dto) {
		
		User user = userRepository.findByEmail(dto.getEmail()); //Recuperar usuário do banco de dados pelo email
		if(user == null) {										//Se o usuário não existir, insira no banco
			user = new User();
			user.setEmail(dto.getEmail());
			user = userRepository.saveAndFlush(user);                                  
		}
		
		Movie movie = movieRepository.findById(dto.getMovieId()).get();
		
		Score score = new Score();
		score.setMovie(movie);
		score.setUser(user);
		score.setValue(dto.getScore());
		
		
		score = scoreRepository.saveAndFlush(score);   			//Salvar a avaliação do usuário para o dado filme
		
		double sum = 0.0;
		for (Score s : movie.getScores()) {
			sum = sum + s.getValue();                          //percorre a lista de scores e acumula a soma dos valores
		}
		
		double avg = sum / movie.getScores().size();		//média dos scores
		
		
		//salvar avaliação média e quantidade de avaliações
		movie.setScore(avg);
		movie.setCount(movie.getScores().size());
		
		movie = movieRepository.save(movie);
		
		return new MovieDTO(movie);
	}
}

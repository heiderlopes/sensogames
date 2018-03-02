package br.com.heiderlopes.sensogame.service;

import br.com.heiderlopes.sensogame.model.Game;
import br.com.heiderlopes.sensogame.repository.GameRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    private GameRepository gameRepository;


    public List<Game> findAllOrderByPontuacaoGeralDesc() {
        return gameRepository.findAllByOrderByPontuacaoGeralAsc();
    }

    public List<Game> findByNomeContaining(String nome) {
        if (nome == null) {
            return gameRepository.findAll();
        } else {
            return gameRepository.findByNomeIgnoreCaseContaining(nome);
        }
    }

    public void votar(Game game) {
        Game gameNoBanco = gameRepository.findById(game.getId()).get();

        Integer pontuacaoUsabilidade = getPontuacao(game.getPontuacaoUsabilidade()) + getPontuacao(gameNoBanco.getPontuacaoUsabilidade());
        Integer pontuacaoRoteiro = getPontuacao(game.getPontuacaoRoteiro()) + getPontuacao(gameNoBanco.getPontuacaoRoteiro());
        Integer pontuacaoGrafico = getPontuacao(game.getPontuacaoGrafico()) + getPontuacao(gameNoBanco.getPontuacaoGrafico());
        Integer pontuacaoGeral = getPontuacao(game.getPontuacaoGeral()) + getPontuacao(gameNoBanco.getPontuacaoGeral());


        game.setPontuacaoUsabilidade(pontuacaoUsabilidade / 2);
        game.setPontuacaoRoteiro(pontuacaoRoteiro / 2);
        game.setPontuacaoGrafico(pontuacaoGrafico / 2);
        game.setPontuacaoGeral(pontuacaoGeral / 2);

        gameRepository.save(game);
    }

    private Integer getPontuacao(Integer pontuacao) {
        if (pontuacao == null) {
            return 5;
        } else {
            return pontuacao;
        }
    }

    public void salvar(Game game) {

        game.setPontuacaoGeral(null);
        game.setPontuacaoGrafico(null);
        game.setPontuacaoRoteiro(null);
        game.setPontuacaoUsabilidade(null);

        gameRepository.save(game);
    }

    public void apagarTodos() {
        gameRepository.deleteAll();
    }
}

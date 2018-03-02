package br.com.heiderlopes.sensogame.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Game {

    @Id
    private String id;
    private String nome;
    private String urlGame;
    private Integer pontuacaoUsabilidade;
    private Integer pontuacaoGrafico;
    private Integer pontuacaoRoteiro;
    private Integer pontuacaoGeral;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getUrlGame() {
        return urlGame;
    }

    public void setUrlGame(String urlGame) {
        this.urlGame = urlGame;
    }

    public Integer getPontuacaoUsabilidade() {
        return pontuacaoUsabilidade;
    }

    public void setPontuacaoUsabilidade(Integer pontuacaoUsabilidade) {
        this.pontuacaoUsabilidade = pontuacaoUsabilidade;
    }

    public Integer getPontuacaoGrafico() {
        return pontuacaoGrafico;
    }

    public void setPontuacaoGrafico(Integer pontuacaoGrafico) {
        this.pontuacaoGrafico = pontuacaoGrafico;
    }

    public Integer getPontuacaoRoteiro() {
        return pontuacaoRoteiro;
    }

    public void setPontuacaoRoteiro(Integer pontuacaoRoteiro) {
        this.pontuacaoRoteiro = pontuacaoRoteiro;
    }

    public Integer getPontuacaoGeral() {
        return pontuacaoGeral;
    }

    public void setPontuacaoGeral(Integer pontuacaoGeral) {
        this.pontuacaoGeral = pontuacaoGeral;
    }
}

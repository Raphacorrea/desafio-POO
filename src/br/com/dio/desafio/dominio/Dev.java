package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;

public class Dev {
    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
//como so add uma vez no mesmo curso e na mesma mentoria, a escolha de SET se encaixa melhor

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        //peguei todos os conteudos do bootcamp e colocquei em conteudo inscritos
        bootcamp.getDevsInscritos().add(this);
        //peguei todos os devs e coloquei no bootcamp
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        //deste conteudosInscritos eu pego o primeiro
        if (conteudo.isPresent()) {//se existir
            this.conteudosConcluidos.add(conteudo.get());//coloco dentro do set de conteudos concluidos
            this.conteudosInscritos.remove(conteudo.get());//removo do set de conteudo inscritos
        } else {//caso nao tenho mais cursos
            System.err.println("Você não está matriculado em nenhum conteúdo ");
        }
    }
        public double calcularTotalXp() {
            return this.conteudosConcluidos
                    .stream()//usei stream api peguei cada conteudo do set de conteudos
                    .mapToDouble(Conteudo::calcularXp)//peguei o xp de cada conteudo
                    .sum();//e somei

        }

        public String getNome () {
            return nome;
        }

        public void setNome (String nome){
            this.nome = nome;
        }

        public Set<Conteudo> getConteudosInscritos () {
            return conteudosInscritos;
        }

        public void setConteudosInscritos (Set < Conteudo > conteudosInscritos) {
            this.conteudosInscritos = conteudosInscritos;
        }

        public Set<Conteudo> getConteudosConcluidos () {
            return conteudosConcluidos;
        }

        public void setConteudosConcluidos (Set < Conteudo > conteudosConcluidos) {
            this.conteudosConcluidos = conteudosConcluidos;
        }

        @Override
        public boolean equals (Object o){
            if (this == o) return true;
            if (!(o instanceof Dev)) return false;
            Dev dev = (Dev) o;
            return Objects.equals(getNome(), dev.getNome()) && Objects.equals(getConteudosInscritos(), dev.getConteudosInscritos()) && Objects.equals(getConteudosConcluidos(), dev.getConteudosConcluidos());
        }

        @Override
        public int hashCode () {
            return Objects.hash(getNome(), getConteudosInscritos(), getConteudosConcluidos());
        }
    }

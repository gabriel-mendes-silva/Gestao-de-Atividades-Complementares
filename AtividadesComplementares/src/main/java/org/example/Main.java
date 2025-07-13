package org.example;

import Model.*;
import Sessao.SessaoAtual;
import View.MenuPrincipal;
import View.MenuNovoRequerimento;

import java.text.ParseException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        Modalidade ensino = new Modalidade("Ensino", 40.0);
        AtividadeComplementar e1 = new AtividadeBuilder()
                .descricao("Disciplinas cursadas com aproveitamento, não previstas no curriculo do curso.")
                .modalidade(ensino)
                .horaPorAtividade(new HoraPorAtividade("Conforme documento comprobatório*"))
                .documentacao(new Documentacao("Certificado ou declaração de conclusão"))
                .limiteMaximo(80)
                .build();
        AtividadeComplementar e2 = new AtividadeBuilder()
                .descricao("Semana acadêmica dos cursos, quando não obrigatória.")
                .modalidade(ensino)
                .horaPorAtividade(new HoraPorAtividade("Conforme documento comprobatório*"))
                .documentacao(new Documentacao("Certificado ou declaração de participação"))
                .limiteMaximo(40)
                .build();

        Modalidade pesquisa = new Modalidade("Pesquisa e Inovação", 40.0);
        AtividadeComplementar p1 = new AtividadeBuilder()
                .descricao("Participação em programa ou projeto de pesquisa relacionados à área.")
                .modalidade(pesquisa)
                .horaPorAtividade(new HoraPorAtividade("Conforme documento comprobatório*"))
                .documentacao(new Documentacao("Declaração de participação"))
                .limiteMaximo(60)
                .build();
        AtividadeComplementar p2 = new AtividadeBuilder()
                .descricao("Livro na área afim.")
                .modalidade(pesquisa)
                .horaPorAtividade(new HoraPorAtividade("50 por item"))
                .documentacao(new Documentacao("Cópia da ficha catalográfica"))
                .limiteMaximo(80)
                .build();

        Aluno aluno = new Aluno("Gabriel","202410004733");
        Requerimento req = new Requerimento("22322224",aluno);

        req.adicionarAtividade(new AtividadeDeclarada(e1,"https://docs.google.com/document/d/1kSav-UXmZEFopwscycWXxm8R7VBv0SkPJmUgvKisR3E/edit?usp=sharing",30,req));
        req.adicionarAtividade(new AtividadeDeclarada(p2,"https://docs.google.com/document/d/1kSav-UXmZEFopwscycWXxm8R7VBv0SkPJmUgvKisR3E/edit?usp=sharing",40,req));

        RequerimentoValidado requerimentoValidado = new RequerimentoValidado(req, "Junior, o Validador");
        requerimentoValidado.validar();

        ValidacaoPorModalidade validacaoPorModalidade = new ValidacaoPorModalidade(requerimentoValidado);
        validacaoPorModalidade.validar();

        System.out.println("Validação por Modalidade");
        System.out.println("Ensino: " + validacaoPorModalidade.modalidadeEhValida(ensino));
        System.out.println("Pesquisa: " +validacaoPorModalidade.modalidadeEhValida(pesquisa));

        System.out.println(validacaoPorModalidade.violations());

        SessaoAtual sessaoAtual = new SessaoAtual();

        MenuNovoRequerimento menuNovoRequerimento = new MenuNovoRequerimento("Novo requerimento",sessaoAtual);

        MenuPrincipal menuPrincipal = new MenuPrincipal("Página Inicial",sessaoAtual);
        menuPrincipal.adicionarItemMenu(menuNovoRequerimento,"1");
        menuPrincipal.exibir();



    }
}
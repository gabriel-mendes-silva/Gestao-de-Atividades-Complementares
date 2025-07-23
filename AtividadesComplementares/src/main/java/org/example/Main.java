package org.example;

import Controller.NovoRequerimentoController;
import Model.*;
import Repositorio.AlunoPg;
import Sessao.SessaoAtual;
import View.MenuNovaAtividade;
import View.MenuPrincipal;
import View.MenuNovoRequerimento;
import View.MenuRequerimento;

import java.text.ParseException;
import org.postgresql.ds.PGSimpleDataSource;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ParseException {

        /*
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


        System.out.println("\nComo a aplicação deve aperecer, quando operada desde o início");
        SessaoAtual sessaoAtual = new SessaoAtual();
        NovoRequerimentoController novoRequerimentoController = new NovoRequerimentoController();
        MenuNovaAtividade menuNovaAtividade = new MenuNovaAtividade("Declarar Atividade Complementar", novoRequerimentoController);
        MenuRequerimento menuRequerimento = new MenuRequerimento("Iniciar Requerimento",novoRequerimentoController);
        menuRequerimento.adicionarItemMenu(menuNovaAtividade,"1");
        MenuNovoRequerimento menuNovoRequerimento = new MenuNovoRequerimento("Novo requerimento",novoRequerimentoController);
        menuNovoRequerimento.adicionarItemMenu(menuRequerimento,"1");
        MenuPrincipal menuPrincipal = new MenuPrincipal("Página Inicial");
        menuPrincipal.adicionarItemMenu(menuNovoRequerimento,"1");
        menuPrincipal.exibir();

        */

        PGSimpleDataSource pgSimpleDataSource = new PGSimpleDataSource();
        pgSimpleDataSource.setServerNames(new String[]{"localhost"});
        pgSimpleDataSource.setPortNumbers(new int[]{5432});
        pgSimpleDataSource.setDatabaseName("AtividadesComplementares");
        pgSimpleDataSource.setUser(System.getenv("DB_USER"));
        pgSimpleDataSource.setPassword(System.getenv("DB_PASSWORD"));


        Aluno aluno = new Aluno("Gabriel Matos Mendes da Silva","202410004733");
        AlunoPg alunoPg = new AlunoPg(pgSimpleDataSource);

        System.out.println(alunoPg.buscarPorId(7).nome());
        System.out.println(alunoPg.buscarPorId(7).matricula());



    }
}
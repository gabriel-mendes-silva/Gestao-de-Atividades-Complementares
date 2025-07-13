# 🛠️ Atividade Projeto de Sistemas

---

## 🎯 Objetivo

Este repositório tem como objetivo desenvolver um projeto para suprir as necessidades do câmpus com relação aos requerimentos de atividades complementares, que atualmente são feitos de modo manual individualmente devido à falta de um sistema que automatize os processos.

---
## 🗒️​ Diagramas UML

Diagrama contendo o Menu que possui a Padrão de Projeto Composite.

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/a099fd4545506a23ecca177483e7a3f7198db1ed/Menu..PNG)

Diagrama contendo o Padrão de Projeto Builder.

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/a75ff40c24360b416cad3a6cd63218b9617004fc/Builder.PNG)

Diagrama contendo o Padrão de Projeto Specification e o Padrão de Projeto Null Object.

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/f1dddf9b9594a8bd6811877bebb1cc9339873008/Nulo%20e%20Composite.PNG)

Diagrama contendo o Padrão de Projeto Strategy.

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/f1dddf9b9594a8bd6811877bebb1cc9339873008/Strategy.PNG)

Diagrama contendo todas as conexões das classes.

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/450e0f9a02cdc4b2a0f1caa49a6d629b68f17835/Geralzao.PNG)

---

## 📦 Estrutura do Projeto

O projeto está organizado por classes que utilizam alguns padrões de projetos que foram contextualizados durante as aulas de Projeto de Sistemas.

Diante deste contexto foram utilizados os padrões a seguir:



### 🧱 Builder

Para diminuir o número de informações no construtor e deixar o algoritmo visualmente menos poluído optamos por utilizar o padrão builder para fazer apenas a chamada das etapas necessárias.

 ![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/bd9876c26efb77bdaea0dcc6c4b8fcadf0aeb3dc/Builder.png).



### 🧮 Specification

Para utilizar filtros dentro do projeto, como por exemplo, filtrar as horas de uma modalidade específica, optamos pela escolha do padrão specification de modo que se verifique quais objetos satisfazem o filtro.

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/231b52e9eb2afce1d3645d21a6a7d8dda47661f2/Specification.png).


### 🚫 Null Object

Utilizado conjuntamente com o Design Pattern Specification, retornando um objeto nulo.

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/231b52e9eb2afce1d3645d21a6a7d8dda47661f2/Null%20Object.png).


### 🔁 Strategy

Para tornar as classes do projeto intercambiáveis, optamos pelo Design Pattern Strategy, por meio da utilização de interfaces e classes que as implementam.


![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/231b52e9eb2afce1d3645d21a6a7d8dda47661f2/Strategy1.png).

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/231b52e9eb2afce1d3645d21a6a7d8dda47661f2/Strategy2.png).

### 🧩 Composite

Para fazer o menu de interação com o usuário, se fez necessário a utilização do padrão Composite, onde um menu possui submenus, que vão compondo outros menus.

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/231b52e9eb2afce1d3645d21a6a7d8dda47661f2/Composite.png).

![Image Alt](https://github.com/gabriel-mendes-silva/Gestao-de-Atividades-Complementares/blob/231b52e9eb2afce1d3645d21a6a7d8dda47661f2/Composite2.png).

---

## 📖 Instruções de Uso

O algoritmo é utilizado por meio de um menu console com opções.


# 🛠️ Atividade Projeto de Sistemas

---

## 🎯 Objetivo

Este repositório tem como objetivo desenvolver um projeto para suprir as necessidades do câmpus com relação aos requerimentos de atividades complementares, que atualmente são feitos de modo manual individualmente devido à falta de um sistema que automatize os processos.

---

## 📦 Estrutura do Projeto

O projeto está organizado por classes que utilizam alguns padrões de projetos que foram contextualizados durante as aulas de Projeto de Sistemas.

Diante deste contexto foram utilizados os padrões a seguir:



### 🧱 Builder

Para diminuir o número de informações no construtor e deixar o algoritmo visualmente menos poluído optamos por utilizar o padrão builder para fazer apenas a chamada das etapas necessárias.

---

### 🧮 Specification

Para utilizar filtros dentro do projeto, como por exemplo, filtrar as horas de uma modalidade específica, optamos pela escolha do padrão specification de modo que se verifique quais objetos satisfazem o filtro.

---

### 🚫 Null Object

Utilizado conjuntamente com o Design Pattern Specification, retornando um objeto nulo.

---

### 🔁 Strategy

Para tornar as classes do projeto intercambiáveis, optamos pelo Design Pattern Strategy, por meio da utilização de interfaces e classes que as implementam.

---

### 🧩 Composite

Para fazer o menu de interação com o usuário, se fez necessário a utilização do padrão Composite, onde um menu possui submenus, que vão compondo outros menus.

---

## 📖 Instruções de Uso

O algoritmo é utilizado por meio de um menu console com opções.


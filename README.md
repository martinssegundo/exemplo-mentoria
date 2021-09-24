# Exemplo de código incremental para Servidor Programadores Java

## Até o momento implementado:
 * /capeao/savar - Api responsavel por expor a forma de salvar um campeão
 * Serviço com as regras de negocio de salvar campão (não invoca nada de salvar)



# JEDI VS SITH


## Descrição
Este exemplo tem como objetivo implementar um back-end java com ecossistema spring e ORM, disponibilizando também um banco embarcado para os testes e exposição de API's REST para comunicação, tetaremos também aplicar conceitos como TDD baseando os testes em JUnit e mock's com Mockito.

## O Projeto
Este projeto será a implementação de um Jogo de Star Wars, onde os participantes poderão criar um personagem Jedi ou Sith e poderão treina-los e evoluir os personagens, além de conta com um sistema de batalhas onde 2 personagens poderão duelar e verificar quem é o mias forte e evoluir a cada vitória.

## Cadastro de personagens 
O personagem será criado com base nas seguintes especificações:

* Nome do personagem;
* E-mail;
* Cor do Sabre
* Atributos:
* HP
* Força Física
* Mental
* Previsão (Capacidade de prever ataques)
* Habilidades com o Sabre de Luz
* Afinidade com a força

### Atributos iniciais Jedi
* HP                                                -> 100
* Força Física 							    -> 5
* Mental 									    -> 10
* Previsão 									    -> 5
* Habilidades com Sabre de Luz  -> 5
* Afinidade com a força                -> 5

### Atributos iniciais Sith
* HP                                                -> 150
* Força Física								    -> 10
* Mental 									    -> 5
* Previsão 									    -> 5
* Habilidades com Sabre de Luz  -> 5
* Afinidade com a força               -> 5

## Dos Itens
Nesse jogo os usuários da força podem ter seus itens para aumentar os atributos, estes equipamentos estão divididos em 3 categorias comuns, raros e ultra raros.

### Itens
* Sabres de Luz
* Cristais da força
* Cristais de cura

### Sabres de Luz: 
Este item aumenta Força física e Habilidade com Sabre de Luz nas proporções abaixo:
* Comum: 10%
* Raro: 20%
* Ultra raro: 50%


### Cristais da força: 
Este item aumenta Previsão e Afinidade com a força nas proporções abaixo:
* Comum: 10%
* Raro: 20%
* Ultra raro: 50%


### Cristais de cura: 
Este item aumenta HP nas proporções abaixo:
* Comum: 10%
* Raro: 20%
* Ultra raro: 50%

### Cristais de cura: 
Este item aumenta HP nas proporções abaixo:
* Comum: 10%
* Raro: 20%
* Ultra raro: 50%

### Como conseguir os itens
Os itens são recebidos da seguinte maneira:
Quando um jogador ganhar um duelo ele vai randomicamente ganhar uma recompensa que pode ser um item ou nenhum dos itens, a proporção estará distribuída da seguinte maneira:
Comuns: 30%
Raros: 10%
Ultra raros: 1%


## Duelo
Os personagens perão procurar por combates aleatoriamente e com base nos atributos eles duelarão e o resulta será dado com o seguinte calculo:

Dano de ataque = (Força Física + Habilidades com Sabre de Luz + Mental) * Afinidade com a força 
Defesa =  (Força Física + Previsão) * Afinidade com a força 

Dano = Dano de ataque - Defesa

O dano é diminuído do HP e quando o HP chegar a ZERO um o que tiver HP restante é o vencedor.


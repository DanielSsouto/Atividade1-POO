Trabalho desenvolvido por:
Daniel da Silva Souto - 11320807
Gabriel Passarelli - 11218480
___________________________________________________________________________________________________________

Esclarecimentos sobre o jogo para o usuário:

Controles de jogo: 
- R: Reinicia o jogo
- Up/Down: move a galinha entre as pistas.
- A dificuldade deve ser inserida na main.

Jogabilidade: 
- O objetivo é completar 30 fases, com 3 chances de erro. Se a galinha morrer mais do que 3 vezes, 
o jogo é reiniciado.
- O jogo tem 3 níveis, sendo da fase 0-9 o nível 1, da fase 10-19 fase o nível 2, e da fase 20-30 
o nível 3. No nível 2, os carros se movem com o dobro da velocidade do nível 1, e no 3, eles piscam.
- Os carros se movem a diferentes velocidades. Aumentar o valor da dificuldade na main significa es-
colher um conjunto de carros com padroes de velocidade mais desafiadores.

Detalhes:

Contador de vidas: Mostra no canto superior da tela, em formato de galinhas, a quantidade de vidas faltantes.

Contador de fases: Mostra na parte superior da tela a fase atual.

Carros piscando: A partir da fase 20, se o carro estiver um intervalo aleatorio, ele some da tela para di-
ficultar a percepção do jogador.

___________________________________________________________________________________________________________

Esclarecimentos sobre a implementação:

Classe Desenhar:
- É sabido que o método "desenhar" dessa classe é o responsável por desenhar na tela de jogo um dado elemento. 
Para tornar mais agradável a movimentação dos elementos na tela, criamos um grid da tela mais refinado do que a-
quele naturalmente sugerido pelas células de asfalto. Em nossa implementação, cada célula é dividida na horizon-
tal em um número de partes igual ao número de redesenhos por segundo; na vertical, o número de linhas possíveis 
para setar a posição de um elemento continua sendo o número de células na vertical.

Classe Posicao:
- Uma alteracao foi feita no metodo de verificar se dois elementos estão na mesma posicao, devido à alteracao feita
na classe desenhar.

Classe fase: 
- Os elementos da tela estão guardados durante a execução do jogo em um objeto da classe Fase. Essa classe define 
qual o conjunto de elementos que deverá ser mostrado para o usuário (note que esse conjunto varia, se o usuário 
define um valor diferente para a dificuldade), e também é a responsãvel por fazer o controle do número de vidas da 
galinha, assim como do nível atual. 

Classe Carro:
- Um objeto da classe carro fica completamente definido através das variáveis: "cor", "padraoDeVelocidade" (que defi-
ne a maneira como o carro se movimentará na tela), e "sentido" (que define se ele anda da esquerda para a direita, ou
vice-versa).
- A velocidade de um carro corresponde ao número de colunas que ele avança na tela por redesenho. Ela está guardada 
em uma variável privada da classe, e seu comportamento durante o jogo é definido pela variável "padrao de velocida-
de", passada como parâmetro para o construtor da classe. A velocidade é sempre uma fração cujo denominador é exata-
mente a taxa de redesenhos por segundo da tela. Isso é feito para se deixar fluido o movimento dos carros. Além dis-
so, os carros têm taxas de variação da velocidade (aceleração) quadráticas, senoidais, lineares, constantes, e ale-
atórias. De modo geral, a velocidade atual (ou seja, o número de colunas que iremos avançar nesse redesenho) é a ve-
locidade anterior mais a aceleração anterior.




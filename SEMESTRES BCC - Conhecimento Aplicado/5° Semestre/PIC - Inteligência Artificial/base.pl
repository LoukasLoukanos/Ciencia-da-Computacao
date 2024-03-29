% → para ler a base de dados base_conhecimento.pl:  ?- consult('C:/Users/eipi1/Downloads/base_conhecimento.pl').
% → para fazer consultas (atenção aspas símples.):  |: 'O que é internet?' ou → ?- recupera_resposta('O que é internet?', R).

% Definição de predicados com dois argumentos para bases de dados
:- dynamic tecnologia/2.
:- dynamic rede_de_computadores/2.
:- discontiguous rede_de_computadores/2.
:- dynamic equipamento_de_rede/2.
:- dynamic topologia_de_rede/2.
:- dynamic tecnologia/2.
:- dynamic protocolo/2.


%______________Base de Dados I______________
tecnologia('O que é internet?', 'A internet é uma rede de computadores global que interconecta redes menores em todo o mundo. É uma rede aberta e descentralizada que permite o compartilhamento de informações e recursos em todo o mundo.').
tecnologia('O que é Radiofrequência?', 'Radiofrequência é a faixa de frequência das ondas eletromagnéticas que oscilam de 3 kHz a 300 GHz, muito empregada em tecnologias de comunicação sem fio como rádio, televisão, telefonia móvel, redes sem fio e até sistemas de satélite.').
tecnologia('O que é Correio eletrônico?', 'O Correio Eletrônico, também conhecido como E-mail, é um serviço de comunicação eletrônica que permite a troca de mensagens entre usuários conectados à internet.').
rede_de_computadores('O que é uma rede de computadores?', 'Uma rede de computadores é um grupo de dispositivos interconectados que permitem a troca de informações e recursos.').
rede_de_computadores('Qual a classificação de redes?', 'As redes podem ser classificadas em PAN (rede de área pessoal), LAN (rede de área local), MAN (rede de área metropolitana), WAN (rede de área ampla) e WLAN (rede de área local sem fio).').
rede_de_computadores('O que é uma LAN?', 'Uma LAN (Local Area Network) é uma rede de computadores interconectada a dispositivos em uma área geográfica limitada, como de empresa, casa ou de um prédio.').
rede_de_computadores('O que é uma MAN?', 'Uma MAN (Metropolitan Area Network) é uma rede de computadores que interconecta dispositivos em uma área geográfica maior do que uma LAN, mas menor do que uma WAN, como uma cidade ou um campus universitário.').
rede_de_computadores('O que é uma WAN?', 'Uma WAN (Wide Area Network) é uma rede de computadores que interconecta dispositivos em uma área geográfica extensa, como um país ou mesmo o mundo inteiro.').
equipamento_de_rede('O que é um roteador?', 'Um roteador é um dispositivo de rede que encaminha pacotes de dados entre diferentes redes.').
equipamento_de_rede('O que é uma placa de rede?', 'Uma placa de rede, também conhecida como placa de interface de rede, é um componente de hardware responsável por conectar um computador a uma rede.').
equipamento_de_rede('O que é um Modem?', 'Um modem é um dispositivo que converte sinais digitais em analógicos e vice-versa, permitindo que você conecte seu computador a uma rede de Internet por meio de linhas telefônicas, cabos ou fibra ótica.').
equipamento_de_rede('O que é um repetidor?', 'Um repetidor é um dispositivo de rede que amplifica e retransmite sinais de rede para estender o alcance da rede.').
equipamento_de_rede('O que é um Switch?', 'Um switch é um dispositivo de rede que conecta vários dispositivos em uma rede local (LAN) e encaminha pacotes de dados entre eles.').
equipamento_de_rede('O que é um Cabo coaxial?', 'O cabo coaxial é um tipo de cabo de transmissão utilizado para transmitir sinais elétricos de alta frequência. Ele é composto por um fio central condutor, um isolante dielétrico, uma malha metálica e uma capa protetora.').
equipamento_de_rede('O que é um Cabo de par trançado?', 'O cabo de par trançado é um tipo de cabo utilizado para transmitir sinais elétricos de baixa frequência. Ele é composto por dois fios de cobre trançados entre si, o que ajuda a reduzir interferências eletromagnéticas.').
equipamento_de_rede('O que é a Fibra óptica?', 'A fibra óptica é um tipo de cabo utilizado para transmitir sinais de luz em vez de sinais elétricos. Ela é composta por um núcleo de vidro ou plástico, revestido por uma camada de material reflexivo, e protegida por uma capa externa, permitindo a transmissão de informações a longas distâncias e com altas taxas de transferência de dados.').
topologia_de_rede('O que são Topologias de redes?', 'Topologia de rede é a maneira como os dispositivos de uma rede são interconectados. Existem muitas topologias de redes e cada topologia possui suas vantagens e desvantagens para cada contexto.').
topologia_de_rede('O que é uma Topologia Parcialmente Ligada?', 'Na Topologia Parcialmente Ligada, alguns dispositivos são conectados a vários outros dispositivos, enquanto outros são conectados apenas a um ou a nenhum dispositivo, permitindo maior flexibilidade na rede, bem como redundância para evitar falhas. Devido ao maior número de conexões, a configuração e manutenção da rede podem ser mais complexas.').
topologia_de_rede('O que é uma Topologia em Barramento?', 'Uma topologia em barramento é um tipo de rede em que todos os dispositivos são conectados a um cabo único que é denominado de barramento. Cada dispositivo recebe todas as mensagens que são enviadas pela rede, e somente o destinatário correto processa a mensagem. Essa topologia é mais adequada para redes pequenas e simples, mas pode ter problemas de desempenho quando muitos dispositivos estão conectados ao barramento.').
topologia_de_rede('O que é uma Topologia Ponto a Ponto?', 'Uma topologia ponto a ponto é aquela em que dois dispositivos estão conectados diretamente um ao outro, sem a necessidade de um terceiro dispositivo intermediário. A comunicação ocorre somente entre os dois dispositivos conectados, o que aumenta a segurança e diminui a latência da rede. No entanto, essa topologia tem a limitação de que cada dispositivo só pode se comunicar com um outro dispositivo por vez.').
topologia_de_rede('O que é uma Topologia Multiponto?', 'Topologia Multiponto é uma rede na qual vários dispositivos estão conectados a um único ponto central e vários dispositivos compartilham a mesma conexão, o que permite que dados sejam transmitidos de forma eficiente entre vários dispositivos na rede. No entanto, essa topologia tem a desvantagem de ser menos segura e confiável do que outras topologias, pois uma falha no ponto central pode interromper toda a comunicação na rede.').
topologia_de_rede('O que é uma Topologia em Estrela?', 'Uma topologia em estrela é um tipo de rede em que todos os dispositivos são conectados a um único ponto central, conhecido como hub ou switch. Cada dispositivo se comunica com o hub para enviar e receber dados, e o hub é responsável por gerenciar o fluxo de dados na rede. Essa topologia é amplamente utilizada em redes de computadores devido ao alto grau de confiabilidade e segurança na transmissão de dados, além de possuir facilidade de instalação, manutenção e expansão, .').


%______________Base de Dados II______________
rede_de_computadores('O que é Endereçamento na ethernet e quais são os seus serviços?', 'O endereçamento na Ethernet é utilizado para identificar os dispositivos conectatos em uma rede. O endereço físico na Ethernet, conhecido como endereço MAC, é gravado em cada adaptador de rede e é usado para direcionar o tráfego para o dispositivo correto na rede. Os serviços de endereçamento na Ethernet incluem o ARP (Address Resolution Protocol) e o RARP (Reverse Address Resolution Protocol).').
rede_de_computadores('O que é Metro Ethernet?', 'Metro Ethernet é uma tecnologia de rede que proporciona a transmissão de dados em velocidades de até 10 Gbps entre diversos locais geograficamente dispersos em uma cidade ou área metropolitana.').
rede_de_computadores('O que é Ethernet?', 'Ethernet é o padrão de rede de computadores que emprega características físicas, elétricas e especificações de comunicação para transmissão de dados entre dispositivos em uma rede de forma cabeada.').
rede_de_computadores('O que é Padrão Gigabit Ethernet?', 'Gigabit Ethernet é uma tecnologia de rede que permite taxas de transferência de dados de até 1 gigabit por segundo (Gbps). Ele usa cabos de cobre ou fibra óptica para transmitir dados entre dispositivos em uma rede').
rede_de_computadores('O que é camada de rede?', 'A camada de rede é uma das camadas do modelo OSI (Open Systems Interconnection) e é responsável por rotear pacotes entre redes diferentes. Ela lida com o endereçamento lógico e o roteamento dos pacotes na rede.').
protocolo('O que é um Protocolo MAC?', 'MAC (Media Access Control) é um protocolo que define como dispositivos em uma rede compartilham o meio de comunicação. O endereço MAC é um identificador exclusivo que é atribuído a cada dispositivo e, em uma rede, pode ser usado para direcionar o tráfego para o dispositivo correto na rede.').
protocolo('O que é o protocolo TCP/IP?', 'TCP/IP é o conjunto de protocolos de comunicação padrão utilizado para conectar dispositivos em uma rede de computadores. Ele define como os dados são transmitidos pela rede e como os dispositivos se comunicam uns com os outros. O TCP/IP é composto por várias camadas, incluindo a camada de aplicação, a camada de transporte, a camada de internet e a camada de acesso à rede.').
protocolo('Quais são os protocolos que constituem o TCP?', 'Os protocolos que constituem o TCP são o IP, o ARP e o ICMP').
protocolo('O que é IGRP?', 'IGRP significa Interior Gateway Routing Protocol, que é um protocolo de roteamento utilizado para trocar informações de roteamento em uma rede de área local (LAN) ou rede de área ampla (WAN). Foi desenvolvido pela Cisco e é considerado um protocolo de roteamento de vetor de distância, o que significa que os roteadores compartilham informações de roteamento sobre sua distância para outras redes com seus vizinhos de roteamento.').
protocolo('O que é EIGRP?', 'EIGRP (Enhanced Interior Gateway Routing Protocol) é um protocolo de roteamento proprietário da Cisco que é uma evolução do IGRP (Interior Gateway Routing Protocol). Ele é projetado para fornecer roteamento eficiente em redes de grande porte, utilizando algoritmos avançados de roteamento e balanceamento de carga.').
protocolo('O que é SMTP?', 'SMTP é a sigla para "Simple Mail Transfer Protocol". É um protocolo de comunicação usado para enviar e receber e-mails na internet. Ele possui a responsabilidade de encaminhar as mensagens de e-mail do remetente para o servidor de e-mail do destinatário. Além disso, o SMTP também verifica se o destinatário está disponível para receber a mensagem e garante que ela seja entregue corretamente.').
protocolo('O que é Telnet?', 'Telnet é um protocolo de rede que permite que um usuário se conecte a outro computador na rede e execute comandos controlando esse computador. É frequentemente usado para administrar servidores remotamente.').
protocolo('O que é FTP?', 'FTP significa File Transfer Protocol, ou Protocolo de Transferência de Arquivos. É um protocolo utilizado para transferir arquivos entre computadores em uma rede TCP/IP.').
protocolo('O que é http?', 'O protocolo HTTP (Hypertext Transfer Protocol) é um protocolo de comunicação utilizado na internet para a transferência de dados em redes de computadores. Ele é responsável por permitir que os clientes (geralmente navegadores) se comuniquem com os servidores web e solicitem conteúdo, como páginas da web, imagens e arquivos de áudio e vídeo.').
protocolo('O que é IPv4?', 'IPv4 é um protocolo da camada de rede do modelo OSI que é amplamente utilizado na Internet e em redes privadas. Ele fornece um endereço único para cada dispositivo conectado a uma rede IPv4 e permite que os pacotes de dados sejam roteados entre redes diferentes.').
protocolo('O que é ICMP?', 'O ICMP (Internet Control Message Protocol) é um protocolo da camada de rede do modelo OSI que é usado para relatar erros e outras informações relacionadas ao envio de pacotes IP na rede. Ele é frequentemente usado por ferramentas de diagnóstico de rede, como o ping, para testar a conectividade entre dispositivos de rede e identificar problemas de rede.').


% _______Para recuperar respostas das bases de dados_______
:- dynamic recupera_resposta/2.

recupera_resposta(Pergunta, Resposta) :- tecnologia(Pergunta, Resposta).
recupera_resposta(Pergunta, Resposta) :- rede_de_computadores(Pergunta, Resposta).
recupera_resposta(Pergunta, Resposta) :- equipamento_de_rede(Pergunta, Resposta).
recupera_resposta(Pergunta, Resposta) :- topologia_de_rede(Pergunta, Resposta).
recupera_resposta(Pergunta, Resposta) :- tecnologia(Pergunta, Resposta).
recupera_resposta(Pergunta, Resposta) :- protocolo(Pergunta, Resposta).


%_______Interação_______
:- initialization(conversar).
conversar :-
    write('Olá, posso ajudar?'), nl,
    loop.

loop :-
    read(Pergunta),
    recupera_resposta(Pergunta, Resposta),
    write(Resposta), nl, nl,
    write('Posso ser útil em algo mais?'), nl,
    loop.













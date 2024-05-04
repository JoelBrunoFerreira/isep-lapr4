### Contribuição de cada elemento: ###

* **1100719**_Fábio Borges - 25%
* **1191843**_Joel Ferreira - 25%
* **1221715**_Jorge Cruz - 25%
* **1221722**_Victor Salgado - 25%
---
### Funcionalidades implementadas e respectiva percentagem funcional: ###
• Utilizar processos, sinais, pipes e funções exec: 
**100%**

• Um processo filho para monitorizar periodicamente um diretório de entrada para novos ficheiros:
**100%**

• Quando novos arquivos são detectados, é enviado um sinal ao processo pai: **100%**

• Ao receber um sinal, o processo pai distribui os novos ficheiros a um número fixo de processos filhos: **100%**

• Cada processo filho cria um subdiretorio com o a referencia da proposta de emprego, e outro subdiretorio com o email do candidato: **100%**

• Cada processo filho move todos os ficheiros relacionados com um candidato específico, para diretório criado: **100%**

• Os processos filhos não terminam a menos que sejam especificamente terminados pelo processo pai. **100%**

• Quando todos os arquivos para todos os candidatos são movidos, o processo pai gerar um ficheiro de relatório no diretório de saída: **100%**

• O relatório lista para cada candidato, o nome do subdiretório de saída (oferta de emprego), o subdiretório da candidatura, e o número de ficheiros movidos: **100%**

• Para encerrar a aplicação, o processo pai deve lidar com o sinal SIGINT: **100%**

• Ao receber o SIGINT, o processo pai termina todos os filhos primeiro e a si depois: **100%**

• Os nomes dos diretórios de entrada e saída, o número de filhos trabalhadores, o intervalo de tempo para verificação periódica de novos arquivos, etc., são configuráveis: **100%**

• A configuração é alcançada através de parâmetros de entrada fornecidos: **100%**

• Ou a configuração pode ser alcançada lendo um ficheiro de configuração: **100%**

• Testes unitários e de integração: **25%**

---
### Diagrama ###
![us2001_flow.svg](docs%2Fus2001_flow.svg)
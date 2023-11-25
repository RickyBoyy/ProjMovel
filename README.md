# ProjMovel


## Q-Rity

### Enquadramento do Projeto 
#### Código QR: 
O projeto visa desenvolver uma aplicação móvel para melhorar a segurança no acesso a áreas autorizadas, substituindo cartões por códigos QR. O código QR é preferido devido à sua versatilidade e facilidade de leitura por aplicativos móveis. Para evitar perda de dados e erros de leitura, os dados são redundantes no código QR, tornando-o adequado para aplicações críticas, como na indústria médica. Além disso, o código QR é rápido de ler devido à sua natureza bidimensional, não exigindo alinhamento preciso. Isso o torna eficaz em situações que exigem velocidade de resposta.

#### Aplicativo de Scan (Scanner): 
"Aplicativos de Scan" são programas que simplificam a leitura de diferentes tipos de códigos ou informações de várias fontes. Eles são usados para ler códigos QR, digitalizar documentos para melhorar sua qualidade, realizar o reconhecimento de texto (OCR) para converter texto impresso em texto digital editável e até mesmo identificar objetos e marcas de realidade para aplicativos de Realidade Aumentada (AR). Na área de segurança, esses aplicativos são usados para verificar, autorizar e autenticar o acesso a sistemas ou áreas com base em informações específicas.

### Objetivos da Aplicação 
Com a nossa aplicação, nós pretendemos em facilitar a entrada rápida e útil em áreas físicas, sem que a pessoa em causa se preocupe com cartões ou com leitores lentos e inefetivos. Desejamos obter: 

#### Melhorar a Eficiência Operacional: 
Melhorar a circulação no dia-a-dia das empresas mais movimentadas e com um maior número de funcionários. 

#### Reduzir Custos:
Para evitar os custos na produção e renovação de cartões, a aplicação permite a interrupção no uso de cartões no geral. 

#### Cumprir com normas e regulamentos: 
Assegurar que a organização está confortável consoante á segurança de informação. (Especialmente a empresas que necessitam cumprir requisitos específicos de segurança) 
 
#### Proteção de dados: 
Evitar “leaks” de informação e perda de cartões para garantir um ambiente de confiança entre os clientes e os funcionários. 

#### Analise de Segurança: 
Analisar as configurações do sistema para garantir que estejam alinhadas com as melhores práticas de segurança e impedir possibilidades de exploração

### Público-Alvo
Com este projeto, nós planeamos em chamar a atenção de empresas que estão disponíveis a melhorar a sua segurança, ou então seguir um caminho mais digital do que o comum. A nossa aplicação tem como intenção ficar livre para todos os tipos de empresas, pois acreditamos que como se trata de uma questão de segurança, não devíamos limitar-nos a um público específico.  

Não só destinado a empresas que estejam interessadas em segurança, como a empresas que querem melhorar a eficiência na circulação dos funcionários, pois em determinados casos o acesso rápido e prático é essencial. 

### Ferramentas Existentes 
#### Photomath
#### QR Code Reader
#### ShopSavvy
#### Goodreads


## Dicionário de base dados

### Utlizador
#### utilizador_id: identificador principal de utilizadores
#### utilizador_name: nome do utilizador (possivel futura mudança para uint devido a ser o numero de trabalhador da empresa)
#### utiliza_password: password de um respetivo utilizador (atualmente int devido a ser um numero de entrada na empresa ou algo assim)

### Cargo
#### cargo_id: identificador principal dos cargos
#### cargo_name: o nome do cargo

### Limited_Access
#### limited_access_id: identificador principal para os intervalos de tempo 
#### limited_access_in: data de entrada(incluindo horas)
#### limited_access_ou: data de saida(incluindo horas)

### Door
#### door_id: identificador principal das portas
#### door_name: nome da porta
#### door_area_id: foreign key que conecta a area_id da Areas

### Areas
#### area_id: identificador principal das areas
#### area_name: nome da area

### Mapping
#### map_id: identificador da principal da combinação entre utilizador, cargo e limited_access
#### user_id: foreign key que conecta a utilizador_id do Utilizador
#### cargo_id: foreign key  que conecta a cargo_id da Cargo
#### limited_access_id: foreign key que conecta a limited_access_id da Limited_Access

### Area_Connector
#### mapping_id: foreign key que conecta a mapping_id da Mapping
#### area_id: foreign key que conecta a area_id da Areas

### Log_Recorder
#### user_id: foreign key que conecta a utilizador_id da Utilizador
#### door_id: foreign key que conecta a door_id da Door
#### log_time: o tempo recordado do uso da porta

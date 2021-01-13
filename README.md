# Store-Microservice-System

# Microservices com Spring Cloud: Registry, Config Server e Distributed Tracing

# Anotações de aula

# MÓDULO 1
    1. Qual a solução a ser implementada no curso
        - Teremos três microsserviços: Fornecedor, Loja e Transportador
    2. Uma apresentação da modelagem focado em DDD (Domain Driven Design)
    3. Quebraremos o domínio em contextos menores (bounded context)
        - Um microsserviço é a implementação de um contexto
    4. O uso do Postman como cliente HTTP
    5. A criação do microsserviço Loja usando Spring Boot

# MÓDULO 2
    1. A integração entre microsserviços com RestTemplate
        - O RestTemplate do Spring permite chamadas HTTP de alto nível
    2. Um introdução ao Service discovery e Service registry
        - Service registry é um servidor central, onde todos os microsserviços ficam cadastrados (nome e IP/porta)
        - Service discovery é um mecanismo de descoberta do IP do microsserviço pelo nome
        - Dessa forma, nenhum microsserviço fica acoplado ao outro pelo IP/porta
    3. A implementação do service registry através do Eureka Server
    4. Como registrar da Loja e do Fornecedor no Eureka Server
    5. A resolução do IP/porta através do nome do microsserviço nas requisições

# MÓDULO 3
    1. Que um servidor de configuração é o lugar central para definir as configurações dos serviços
    2. Que todas as configurações dos microsserviços devem ficar externalizadas e centralizadas
    3. Que o Spring Config Server é uma implementação do servidor do projeto Spring Cloud
    4. Sobre a integração dos microsserviços com o servidor de configuração
        - Para tal, devemos configurar o nome do microsserviço, profile e URL do Config Server
    5. Que existem várias formas de definir um repositório de configurações, entre elas o GitHub e o local

# MÓDULO 4
    1. Que o Client Side Load Balancing (CSLB) é o cliente HTTP que decide qual microsserviço recebe a requisição
        - Isto é importante, pois pode ter várias instâncias do mesmo serviço no ar
        - A configuração do CSLB é feita a partir da anotação @LoadBalanced, na criação do RestTemplate
        - Como implementação do CSLB, usamos um projeto chamado Ribbon, que faz parte do Spring Cloud Netflix
    2. Para descobrir quais clientes existem, podemos injetar a interface DiscoveryClient
    3. Como alternativa ao RestTemplate, podemos usar o Spring Feign, que já usa o Ribbon para CSLB
    4. O Spring Feign exige apenas uma interface, com a definição e mapeamento dos métodos que executarão a requisição
        - Toda a implementação da interface é gerada pelo Spring Feign

# MÓDULO 5
    1. Como se trata de uma arquitetura distribuída, temos logs distribuídos
        - Ou seja, cada microsserviço (e instância dele) possui o seu log
        - Isso dificulta o acompanhamento e rastreabilidade das requisições
    2. Para unificar os logs, precisamos de agregadores de log
        - Como implementação de um agregador, usamos o Papertrail, um agregador como serviço
    3. Usamos a biblioteca Logback para gerar e enviar os logs ao agregador
        - O Logback possui um appender, que possibilita o envio dos logs
    4. Para acompanhar uma transação nos logs, usamos uma correlation-id
        - A correltation-id é um identificador da transação, que é passada de requisição pra requisição
        - Dessa forma, podemos entender quais requisições fazem parte da mesma transação
    5. A biblioteca Spring Sleuth, que é usada para gerar a correlation-id
# SOAP Service with DDD & Clean Architecture

Aplicação Java Spring Boot que **produz e consome serviços SOAP**, seguindo os princípios de **Domain-Driven Design (DDD)**, **SOLID** e **Clean Code**.

---

## 📋 Índice

- [Funcionalidades](#-funcionalidades)
- [Pré-requisitos](#-pré-requisitos)
- [Instalação](#-instalação)
- [Uso](#-uso)
- [Estrutura do Projeto](#-estrutura-do-projeto)
- [Testes](#-testes)
- [Tecnologias](#-tecnologias)
- [Contribuição](#-contribuição)

---

## 🚀 Funcionalidades

- **Produção de serviços SOAP** com endpoints para consulta de pedidos.
- **Consumo de serviços SOAP externos** (ex: pagamentos).
- Organização em camadas seguindo **DDD** (Domain-Driven Design).
- Mapeamento de objetos com **MapStruct**.
- Testes unitários e de integração com **JUnit 5**.
- Conversão automática de XSD para classes Java via **JAXB**.

---

## 📦 Pré-requisitos

- Java 17+
- Maven 3.8+
- IDE (IntelliJ, Eclipse, VS Code)
- Postman ou SoapUI (para testar requisições SOAP)

---

## 🔧 Instalação

1. **Clone o repositório**:
   ```bash
   git clone https://github.com/MadsonAlan/JavaSoap.git
   ```

2. **Gere as classes JAXB a partir do XSD**:
   ```bash
   mvn clean compile
   ```

3. **Execute a aplicação**:
   ```bash
   mvn spring-boot:run
   ```

---

## 🛠 Uso

### Acessando o WSDL
Após iniciar a aplicação, o WSDL estará disponível em:  
`http://localhost:8080/ws/orders.wsdl`

### Exemplo de Requisição SOAP (Postman/SoapUI)
**Endpoint**: `http://localhost:8080/ws`  
**Corpo da requisição**:
```xml
<soapenv:Envelope xmlns:soapenv="http://schemas.xmlsoap.org/javasoap/envelope/"
                  xmlns:ord="http://example.com/order">
    <soapenv:Header/>
    <soapenv:Body>
        <ord:OrderRequest>
            <ord:id>1</ord:id>
        </ord:OrderRequest>
    </soapenv:Body>
</soapenv:Envelope>
```

**Resposta esperada**:
```xml
<SOAP-ENV:Envelope xmlns:SOAP-ENV="http://schemas.xmlsoap.org/javasoap/envelope/">
    <SOAP-ENV:Header/>
    <SOAP-ENV:Body>
        <ns2:OrderResponse xmlns:ns2="http://example.com/order">
            <ns2:order>
                <ns2:id>1</ns2:id>
                <ns2:product>Notebook Gamer</ns2:product>
                <ns2:price>4500.00</ns2:price>
                <ns2:status>PROCESSING</ns2:status>
            </ns2:order>
        </ns2:OrderResponse>
    </SOAP-ENV:Body>
</SOAP-ENV:Envelope>
```

### Consumindo um Serviço Externo
O cliente SOAP para pagamentos está configurado em `PaymentClient`.  
Exemplo de chamada:
```java
@Autowired
private PaymentClient paymentClient;

public void processPayment(Order order) {
    paymentClient.processPayment(order);
}
```

---

## 🏗 Estrutura do Projeto

```
src/
├── main/
│   ├── java/
│   │   └── com/example/javasoap/
│   │       ├── domain/               # Camada de Domínio (Entidades, Regras de Negócio)
│   │       ├── application/          # Casos de Uso e Orquestração
│   │       └── infrastructure/       # Implementações Concretas
│   │           ├── soap/
│   │           │   ├── producer/     # Endpoints SOAP
│   │           │   └── consumer/     # Clientes SOAP
│   │           └── persistence/      # Repositórios (JPA, InMemory)
│   └── resources/
│       └── xsd/                      # Definições de Schema XML
```

---

## 🧪 Testes

- **Testes Unitários** (Domínio e Lógica):
  ```bash
  mvn test
  ```

- **Testes de Integração** (Endpoints SOAP):  
  Verifique a classe `OrderEndpointIntegrationTest`.

---

## 🛠 Tecnologias

- **Java 17**
- **Spring Boot 3.1.5**
- **JAXB** (XML Binding)
- **MapStruct** (Mapeamento de Objetos)
- **Lombok** (Redução de Boilerplate)
- **JUnit 5** (Testes)
- **Maven** (Gerenciamento de Dependências)

![Java](https://img.shields.io/badge/Java-17-%23ED8B00?logo=java)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-3.1.5-%236DB33F?logo=spring)

---

## 🤝 Contribuição

1. Faça um fork do projeto.
2. Crie uma branch: `git checkout -b feature/nova-funcionalidade`.
3. Commit suas mudanças: `git commit -m 'Adiciona nova funcionalidade'`.
4. Push para a branch: `git push origin feature/nova-funcionalidade`.
5. Abra um Pull Request.

---

Feito com ❤️ por [Madson Alan](https://github.com/MadsonAlan).  

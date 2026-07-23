# Java: Consumindo API, Gravando Arquivos e Lidando com Erros — Alura

Exercícios e projetos do curso de consumo de APIs REST da formação Desenvolvimento Back-End Java da escola Alura. Progressão prática desde requisições HTTP simples até uma aplicação de terminal completa: consumo de APIs públicas com `HttpClient`, serialização/desserialização JSON com Gson, tratamento de exceções (nativas e customizadas) e gravação de arquivos em disco.

## Estrutura do Projeto

```
src/br/com/devfred/
├── aula1/              # Requisições HTTP com HttpClient e leitura de resposta bruta
│   ├── desafio1/
│   ├── desafio2/
│   └── desafio3/
├── aula2/              # Desserialização de JSON em objetos Java com Gson
│   ├── desafio1/
│   ├── desafio2/
│   └── desafio3/
├── aula3/              # Tratamento de exceções nativas e customizadas
│   ├── desafio1/
│   ├── desafio2/
│   └── desafio3/
├── aula4/              # Gravação de arquivos e serialização de objetos em JSON
│   ├── desafio1/
│   ├── desafio2_3/
│   └── desafio4/
└── aula5/
    └── desafiofinal/   # Projeto final: busca de endereços via API ViaCEP
```

As aulas 2, 3 e 4 organizam os desafios com entidade em subpacotes `desafioNN/entities/` e, quando há exceção customizada, `desafioNN/exception/`. O `desafiofinal` possui estrutura própria em camadas: `app/`, `config/`, `exception/`, `integration/`, `model/`, `parser/`, `repository/`, `service/` e `view/`.

## Conteúdo por Aula

### Aula 1 — Consumo de API REST

Primeiro contato com `HttpClient`: requisições GET a APIs públicas e impressão da resposta JSON bruta.

| Arquivo | O que faz |
|---|---|
| `BuscadorLivros.java` | Busca livros por título na API do Google Books |
| `CotacaoCriptoMoeda.java` | Consulta cotação de criptomoedas (USD/BRL) na API CoinGecko |
| `BuscaReceita.java` | Busca receitas por nome do prato na API TheMealDB |

### Aula 2 — Desserialização JSON com Gson

Conversão de JSON em objetos Java (records), incluindo objetos aninhados e o comportamento do parser diante de entradas mal-formadas.

| Desafio | Entidade | O que pratica |
|---|---|---|
| 01 | `Pessoa` | Desserialização básica de JSON em record com Gson |
| 02 | `Pessoa` | Comportamento do parser do Gson na leitura de JSON mal-formado |
| 03 | `Livro` + `Editora` | Desserialização de objeto aninhado (`Livro` contém `Editora`) |

### Aula 3 — Tratamento de Exceções

`try/catch/finally` com exceção nativa, exceções customizadas e tratamento de erros de API.

| Desafio | Entidade / Exceção | O que pratica |
|---|---|---|
| 01 | — | `try/catch/finally` com `ArithmeticException` (divisão por zero) |
| 02 | `Usuario` / `SenhaInvalidaException` | Exceção customizada lançada na validação da senha no construtor |
| 03 | `Usuario`, `Repositorio` / `ErroConsultaGitHubException` | Consulta a repositórios públicos do GitHub, tratamento de status 404 com exceção customizada |

### Aula 4 — Gravação de Arquivos e Serialização JSON

Escrita de arquivos com `FileWriter` e serialização de objetos Java em JSON com Gson, com e sem *pretty printing*.

| Desafio | Entidade | O que pratica |
|---|---|---|
| 01 | — | Escrita de arquivo texto com `FileWriter` |
| 02 e 03 | `Titulo` | Serialização Gson comparando saída com e sem *pretty printing* |
| 04 | `Veiculo` | Serialização Gson com *pretty printing* |

### Projeto Final — Busca de CEP (`aula5/desafiofinal`)

Aplicação de terminal que consulta a API pública ViaCEP para buscar endereços por CEP ou por logradouro (UF, cidade e rua), grava o resultado em arquivo JSON e trata os principais cenários de erro (CEP inválido, CEP não encontrado, logradouro inválido, falha de configuração).

**Fluxo entre camadas:**

```
TerminalView (view)
  └── BuscadorCepService (service)
        ├── ViaCepClient (integration)          — requisições HTTP à API ViaCEP
        ├── ConversonJson (parser)               — JSON ↔ ViaCepDto ↔ Endereco
        └── EscritorArquivoEndereco (repository) — grava o Endereco em arquivo JSON
```

**Demais componentes:**

| Classe | Pacote | Responsabilidade |
|---|---|---|
| `ConfigurationLoader` | `config` | Carrega `application.properties` (URL base, timeouts, diretório de saída) |
| `ViaCepDto` | `integration` | Representa o JSON retornado pela API ViaCEP |
| `Cep` | `model` | Record com validação de formato (8 dígitos) no construtor compacto |
| `Logradouro` | `model` | Record com validação de UF, cidade e rua no construtor compacto |
| `Endereco` | `model` | Modelo de domínio usado na gravação em arquivo |
| `CepInvalidoException`, `CepNaoEncontradoException`, `LogradouroInvalidoException`, `FalhaConfiguracaoException` | `exception` | Exceções customizadas para cada cenário de erro da aplicação |
| `Main` | `app` | Monta as dependências e inicia o loop do terminal |

O projeto demonstra na prática: consumo de API REST com `HttpClient`, desserialização/serialização JSON com Gson, validação de dados via construtores compactos de records, exceções customizadas por cenário de erro, gravação de arquivos em disco e separação de responsabilidades em camadas (view, service, integration, parser, repository, model, config, exception).

## Requisitos

- Java 23
- Maven (gerenciamento de dependências, ver `pom.xml`)
- Gson 2.14.0
- IntelliJ IDEA (projeto configurado com `.iml`)
- Conexão com internet (consumo das APIs Google Books, CoinGecko, TheMealDB, GitHub e ViaCEP)
- Chave de API do Google Books (necessária no desafio 1 da aula 1)

## Contexto

Quarto curso da carreira **Desenvolvimento Back-End Java** da Alura, na sequência dos cursos de fundamentos da linguagem e orientação a objetos. Avança para consumo de APIs REST, manipulação de JSON, tratamento de exceções e gravação de arquivos, consolidados no projeto final de busca de endereços via ViaCEP.

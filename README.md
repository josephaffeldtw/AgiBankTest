# AgiBank-Test

# Linguagem
- Java 11

# Motodologia
- TDD

# Regras de Negócio
- Leitura:
    - Só ira ler uma linha do arquivo se estiver com os dados no formato certo:
        - Vendedor: 001çCPFçNameçSalary;
        - Cliente: 002çCNPJçNameçBusiness Area;
        - Venda: 003çSale IDç[Item ID-Item Quantity-Item Price]çSalesman name;
       
        
- Vendas:
    - Não é possível criar venda sem vendedor;
    - Não é possível criar duas vendas com o mesmo idSale;
    - Quando venda for criada, adiciona valor da venda ao vendedor;
    
    
- Clientes:
    - Não é possível criar dois clientes com o mesmo CNPJ;
   
    
- Vendedores:
    - Não é possível criar dois vendedores com o mesmo CPF;


- Maior venda: 
    - Valor do item: (quantidade_do_item) * (preço_do_item), Exemplo: "1-2-3.5" -> 2 * 3.5 = R$ 7,00;
    - Valor da venda: Soma de todos os itens calculados como o exemplo acima;
   
    
- Pior vendedor:
    - O vendedor que gerou a menor renda a empresa em todas suas vendas é o pior vendedor;

# Iniciar o projeto
- Abra o terminal e clone o repositório na sua máquina:
  git clone https://github.com/josephaffeldtw/AgiBankTest

- Entre na pasta do projeto com sua IDE
- Execute a classe Main no caminho: AgiBankTest/src/AgiBank/Main
- Coloque um arquivo válido(.dat) na pasta %HOMEPATH%/data/in

- O arquivo de saída se encontra em %HOMEPATH%/data/out


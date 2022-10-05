# Challenge_Spring
## Requisitos Obrigatórios 📝

#### 1. Cadastrar uma lista de produtos.
#### 2. Retornar uma lista de todos os produtos disponíveis.
#### 3. Retornar uma lista de produtos filtrados por categoria.
#### 4. Retornar uma lista que permite as seguintes combinações de filtros:

- a. categoria + frete grátis.
- b. frete grátis + avaliação (*)

  Por outro lado, uma vez que se pretende uma boa experiência do usuário no que diz
  respeito à forma de apresentação dos produtos, é necessário que os resultados
  fornecidos pela API possam ser ordenados por qualquer um dos seguintes critérios:
  
#### 5. Alfabético (crescente e decrescente)
#### 6. Preço mais alto
#### 7. Menor preço

### Ao mesmo tempo, é necessária uma API que forneça:
#### 8. Possibilidade de envio de pedido de compra. A partir disso, o preço total da
requisição feita pode ser recebido como resposta.
- Leve em consideração, para cada uma dessas solicitações, os possíveis
"status code" que podem ser retornados.
- Por exemplo:
  - Se um product que não existe for solicitado, retorne o código de
  status correspondente.
  - Se houver um problema com o servidor e a conexão não puder ser
  feita, o código de status correspondente deve ser retornado.
  

## Requisitos Bônus 📝


### A plataforma afirmou que no futuro gostaria de ser capaz de realizar o desenvolvimentodos seguintes requisitos como uma melhoria:

#### 9. Para cada solicitação de compra é necessário realizar o controle de estoquedisponível. Por exemplo: Se forem solicitadas 4 unidades de um product e houverapenas duas, coloque as restrições e avisos correspondentes.

#### 10. Permite a utilização de um “carrinho de compras” onde para cada pedido decompra existe um valor total acumulado e devolvido ao utilizador.
- Por exemplo: Se
  um product de R$ 900 foi enviado em um pedido de compra e outro product de
  R$ 300 foi enviado em outro, devo receber a soma dos dois (R$ 1200) como
  resposta.

### Ao mesmo tempo, sugere o desenvolvimento de uma nova API que permita o seguinte:

#### 11. Cadastre novos clientes. Para isso, devem ser realizados os controles necessários,por exemplo: cliente existente, cliente com dados incompletos, etc.

 - ####  Obs: Defina com sua equipe os atributos de Cliente.

#### 12. Obter uma lista completa de todos os clientes.
#### 13. Obter uma lista de todos os clientes filtrados por Estado.

- Além disso, a plataforma afirmou que concorda em receber sugestões de melhorias dos
  desenvolvedores da solução, portanto os convidamos a incluir todas as melhorias que
  considerem que possam impulsionar o projeto desenvolvido.

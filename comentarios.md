# Comentários - Revisão de 12/06 (fim da Sprint 3)

Todos os comentários referem-se ao código do ramo "master" ou "main". É obrigação do grupo manter o código principal neste ramo. Problemas relatados podem ser:

  - ❕❕  - observações e melhorias
  - ⚠️ - médios. Erros de lógica, regras mal implementadas... Descontos de até 1 ponto.
  - 🚨 - sérios. Regras faltando, problemas de modularidade... Descontos de até 3 pontos.
  - 💣 - graves. Falta de classes, requisitos ignorados ... Descontos de 5 ou mais pontos.

## Revisão

  - ❕❕ Agora acho que podemos substituir este monte de classes de produtos por um enum.
  - ❕❕ chamadas desnecessárias no app, por exemplo: buscarCliente está apenas chamando um método do restaurante. Não precisa estar separado.
  - 🚨 no App: polimorfismo de Cardápio e Cardápio Fechado
  - ⚠️ não temos 'for' no cardápio fechado. Deixe o usuário pedir e o pedido recusa o que não puder ser aceito (exceção)
  - ❕❕ refatorar classes para coleções e streams
  - 🚨 cardápio e cardápio fechado são parte de uma mesma abstração (herança/interface). Isso está prejudicando o app (LSP/OCP)
  - ⚠️ cliente não deve ter set: classe imutável
  - ⚠️ validações no construtor de Item
  - 💣 temos um "CardapioFechado" e um "MenuFechado". O MenuFechado está herdando de Pedido(?) Não consegui entender esta decisão e o diagrama não tem isso. Se houver alguma herança aí, tem que ser de classe abstrata (ou composição de interface)
  - ⚠️ restaurante tem get para todas a listas, o que me parece inútil (e perigoso)
  - 🚨 imprimir mesa de restaurante com inúmeros gets
  - 🚨 buscar cliente não deve ser feito com for nem stream: mapa de clientes
  



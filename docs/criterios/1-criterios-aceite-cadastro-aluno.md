## História de Usuário - Cadastrar Aluno
**QUERO:** Cadastrar um Aluno  
**COMO:** Secretária  
**EU GOSTARIA:**  Receber os dados pessoais do Aluno e armazenar na estrutura de armazenamento da Universidade  

## Cenário Primário  
**A secretária informa os dados pessoais do aluno e envia para cadastro**  
- A mensagem de sucesso é retornada. "Aluno cadastrado com sucesso."  

## Fluxo de Exceções  
**Nome do aluno não informado**  
- A mensagem de falha é retornada. "Nome obrigatório"  

**CPF informado é inválido**  
- A mensagem de falha é retornada. "CPF inválido."  

**CPF duplicado**
- A mensagem de falha é retornada. "Já existe um aluno com o CPF informado."

**Cartão de Crédito não informado**   
- A mensagem de falha é retornada. "Cartão de crédito para cobrança é obrigatório."

#language: pt
Funcionalidade: Realizar login
Como um usuario
Eu quero entrar no sistema
Para vizualizar a area restrita aos usuarios

Cenario: Deve logar no sistema com sucesso
Dado que eu estou na tela de login
Quando informo <usuario> e <senha>
E clico no botao ENTRAR
Entao acesso o sistema

Exemplos:
|usuario|senha|
|"marilia"|"1234"|

Esquema do Cenario: Login Invalido
Dado que eu estou na tela de login
Quando informo <usuario> e <senha>
E clico no botao ENTRAR
Entao a <mensagem> eh exibida

Exemplos:
|usuario|senha|mensagem|
|"12345"|"123"|"Nome de usuário ou senha inválida."|

Esquema do Cenario: Login sem informar dados de entrada
Dado que eu estou na tela de login
Quando informo <usuario> e <senha>
E clico no botao ENTRAR
Entao eh exibida um aviso solicitando dados

Exemplos:
|usuario|senha|
|""|""|

Esquema do Cenario: Login sem informar email
Dado que eu estou na tela de login
Quando informo <usuario> e <senha>
E clico no botao ENTRAR
Entao eh exibida o <aviso> para o campo e-mail

Exemplos:
|usuario|senha|aviso|
|""|"123"|"Insira seu e-mail."|


Esquema do Cenario: Login sem informar Senha
Dado que eu estou na tela de login
Quando informo <usuario> e <senha>
E clico no botao ENTRAR
Entao eh exibida o <aviso> para o campo senha

Exemplos:
|usuario|senha|aviso|
|"aaa"|""|"Insira sua senha."|

Cenario: Login Redes
Dado que eu estou na tela de login
Quando clico no botao <botao>
E informo os dados
Entao acesso o sistema

Exemplos:
|botao|
|"ENTRAR COM FACEBOOK"|
|"ENTRAR COM GOOGLE"|
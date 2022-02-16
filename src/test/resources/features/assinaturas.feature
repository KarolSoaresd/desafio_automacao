#language:pt
#encoding:UTF-8
#Autor: Karoline-Santos

Funcionalidade: Validar tipos de assinatura

  Cenário: Deve escolher plano pra assinatura
    Dado Sou um usuário anônimo
    Quando Estou em uma matéria da home principal
    E Escolho um plano no modal
    E Preencho os campos de nome, e-mail e telefone
    Então Clico no botão Continuar
    E Sou direcionada a página de pagamento da assinatura

  Cenário: Não devo escolher método de pagamento
    Dado Sou um usuário anônimo
    Quando Estou em uma matéria da home principal
    E Escolho um plano no modal
    E Não preencho os campos de nome, e-mail e telefone
    Então Clico no botão Continuar
    E Aparece mensagens que os campos devem ser preenchidos

  Cenário: Não devo ter acesso ao artigo como assinante
    Dado Sou um usuário ex-assinante
    Quando Estou em uma matéria da home principal
    E Clico em Já sou assinante no modal
    E Realizo o login com o e-mail "virtualsabino@estadao.com.br" e a senha "3s7@DA0"
    E clico em Entrar
    Então Não tenho acesso ao artigo e continua as opções de assinatura de planos

  Cenário: Devo ter mensagem de não assinante
    Dado Sou um usuário ex-assinante
    Quando Estou em uma matéria da home principal
    E Clico em Já sou assinante no modal
    E Realizo o login com o e-mail "virtualsabino@estadao.com.br" e a senha "3s7@DA0"
    E clico em Entrar
    E Vou em Meu Perfil
    Então Visualizo a mensagem de que Você ainda não é assinante.

  Cenário: Devo realizar um cadastro
    Dado Sou um usuário anônimo
    Quando Estou em uma matéria da home principal
    E Clico em Entrar no modal
    E Clico em Crie grátis agora!
    E Preencho os campos para cadastro e com o email "jose.araujo@iteris.com.br"
    Então Clico em Cadastrar

# lembrar de sempre alterar o email para um e-mail válido




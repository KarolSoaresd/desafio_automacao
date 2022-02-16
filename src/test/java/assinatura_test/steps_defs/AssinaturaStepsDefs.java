package assinatura_test.steps_defs;

import assinatura_test.web.*;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;

public class AssinaturaStepsDefs {

    AssinaturaPage paginaDeAssinatura;
    PagamentoPage paginaDePagamento;
    CartoesPage paginaDeCartoes;
    LoginPage paginaDeLogin;
    LoginEfetivadoPage paginaDoArtigo;
    MeuPerfilPage paginaMeuPerfil;
    CadastroPage paginaDeCadastro;

    @Dado("Sou um usuário anônimo")
    public void sou_um_usuário_anônimo() {
        this.paginaDeAssinatura = new AssinaturaPage();
    }

    @Quando("Estou em uma matéria da home principal")
    public void seleciono_uma_matéria_na_home_principal() {
        this.paginaDeAssinatura.navegaNaPagina();
    }

    @Quando("Escolho um plano no modal")
    public void escolho_um_plano_no_modal() {
        this.paginaDeAssinatura.navegaNaPagina();
        this.paginaDePagamento = paginaDeAssinatura.escolherAssinatura();
    }

    @Quando("Preencho os campos de nome, e-mail e telefone")
    public void preencho_os_campos_de_nome_e_mail_e_telefone(){
        this.paginaDePagamento.preencherDados
                ("Teste Desafio","karolinesoares071@gmail.com", "11975446023");
    }

    @Então("Clico no botão Continuar")
    public void clico_no_botão_continuar() {
        this.paginaDeCartoes = paginaDePagamento.irParaPagamento();
    }

    @Então("Sou direcionada a página de pagamento da assinatura")
    public void sou_direcionada_a_página_de_pagamento_da_assinatura() {
        Assert.assertTrue(this.paginaDeCartoes.paginaDePagamento());
        Assert.assertTrue(this.paginaDeCartoes.IsPaginaDeCartoes());
        this.paginaDeCartoes.fechar();
    }

    @Quando("Não preencho os campos de nome, e-mail e telefone")
    public void não_preencho_os_campos_de_nome_e_mail_e_telefone() {
        this.paginaDePagamento.preencherDados(" "," "," ");
    }

    @Então("Aparece mensagens que os campos devem ser preenchidos")
    public void aparece_mensagens_que_os_campos_devem_ser_preenchidos() {

        Assert.assertTrue(this.paginaDePagamento.isPaginaPagamento());
        Assert.assertTrue(this.paginaDePagamento.mensagemPaginaPagamento());

        this.paginaDeCartoes.fechar();
    }

    @Dado("Sou um usuário ex-assinante")
    public void sou_um_usuário_ex_assinante() {
        this.paginaDeAssinatura = new AssinaturaPage();
    }

    @Quando("Clico em Já sou assinante no modal")
    public void clico_em_já_sou_assinante_no_modal() {
        this.paginaDeLogin = paginaDeAssinatura.loginAssinantes();
    }

    @Quando("Realizo o login com o e-mail {string} e a senha {string}")
    public void realizo_o_login_com_o_e_mail_e_a_senha(String email, String senha) {
        this.paginaDeLogin.preencherLogin(email, senha);
    }

    @E("clico em Entrar")
    public void clicoEmEntrar() {
        this.paginaDoArtigo = paginaDeLogin.irParaArtigo();
    }

    @Então("Não tenho acesso ao artigo e continua as opções de assinatura de planos")
    public void não_tenho_acesso_ao_artigo_e_continua_as_opções_de_assinatura_de_planos() {
        this.paginaDoArtigo.navegaNaPaginaDeArtigo();

        Assert.assertTrue(this.paginaDoArtigo.isPaginaDeArtigo());
        Assert.assertTrue(this.paginaDoArtigo.paginaDeArtigoTravada());

        this.paginaDoArtigo.fechar();
    }

    @Quando("Vou em Meu Perfil")
    public void vou_em_meu_perfil() {
        this.paginaMeuPerfil = paginaDoArtigo.irParaMeuPerfil();
    }

    @Então("Visualizo a mensagem de que Você ainda não é assinante.")
    public void visualizo_a_mensagem() {

        this.paginaMeuPerfil.navegaNoPerfil();
        Assert.assertTrue(this.paginaMeuPerfil.mensagemDeNaoAssinante());
        Assert.assertTrue(this.paginaMeuPerfil.isPaginaDePerfil());

        this.paginaMeuPerfil.fechar();
    }

    @Quando("Clico em Entrar no modal")
    public void clico_em_entrar_no_modal() {
        this.paginaDeLogin = paginaDeAssinatura.loginAssinantes();
    }

    @Quando("Clico em Crie grátis agora!")
    public void clico_em_crie_grátis_agora() {
        this.paginaDeCadastro = paginaDeLogin.irParaCadastro();
    }

    @Quando("Preencho os campos para cadastro e com o email {string}")
    public void preencho_os_campos_para_cadastro_e_com_o_email(String emailUser) {
        this.paginaDeCadastro.preencherCamposDeCadastros
                ("Teste Desafio", "Zé","11975446000",
                        emailUser, "1234estadao");
    }

    @Então("Clico em Cadastrar")
    public void clico_em_cadastrar() {

        this.paginaDoArtigo = paginaDeCadastro.irCadastradoNoArtigo();
        Assert.assertFalse(this.paginaDoArtigo.isPaginaDeArtigo());

        this.paginaDoArtigo.fechar();
    }
}

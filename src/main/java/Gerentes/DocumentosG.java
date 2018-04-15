/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerentes;

import EJB.DocumentoGenericoBean;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import Entidades.DocumentoGenerico;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author adoniran
 */
@Named(value = "documentosG")
@RequestScoped
public class DocumentosG {

    private DocumentoGenerico doc;

    public DocumentosG() {
    }
    @EJB
    DocumentoGenericoBean bean;

    public void salvarDoc() {
        bean.criar(doc);

        if (doc.getId() != null) {
            addMessage("Cadastrado com sucesso");
        } else {
            addMessage("Não cadastrado");
        }
    }

    public void addMessage(String Mensagem) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, Mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

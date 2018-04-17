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
import java.io.File;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.primefaces.model.UploadedFile;

/**
 *
 * @author adoniran
 */
@Named(value = "documentosG")
@RequestScoped
public class DocumentosG {

    private DocumentoGenerico doc;
    private File file;

    public DocumentosG() {
    }

    public DocumentoGenerico getDoc() {
        return doc;
    }

    public void setDoc(DocumentoGenerico doc) {
        this.doc = doc;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
//    public void setFile(UploadedFile file) {
//        this.file = file;
//    }

    @EJB
    DocumentoGenericoBean bean;

    public void salvarDoc() {
        Boolean test = doc.insertFile(file);
        if (test) {
            bean.criar(doc);

            if (doc.getId() != null) {
                addMessage("Cadastrado com sucesso");
            } else {
                addMessage("Não cadastrado");
            }
        }else{addMessage("Falha ao inserir o arquivo");}
    }

    public void addMessage(String Mensagem) {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, Mensagem, null);
        FacesContext.getCurrentInstance().addMessage(null, message);
    }
}

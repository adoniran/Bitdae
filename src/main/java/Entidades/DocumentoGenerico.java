/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author adoniran
 */
@Entity
//fins de teste iniciais
@Table(name ="TB_Documento_generico")
public class DocumentoGenerico implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="titulo")
    private String titulo;
    @Column(name="resumo")
    private String resumo;
    @Column(name = "file")
    private byte[] file;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DocumentoGenerico)) {
            return false;
        }
        DocumentoGenerico other = (DocumentoGenerico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Titulo:"+titulo+" Resumo:"+resumo;
    }
    public boolean insertFile(File f) {

        try {
//          //converte o objeto file em array de bytes
            InputStream is = new FileInputStream(f);
            byte[] bytes = new byte[(int) f.length()];
            int offset = 0;
            int numRead = 0;
            while (offset < bytes.length
                    && (numRead = is.read(bytes, offset, bytes.length - offset)) >= 0) {
                offset += numRead;
            }

            this.file = bytes;

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return false;
    }

    public File getFile(EntityManager em) {

        File f = null;
        byte[] bytes = this.file;

        //converte o array de bytes em file
        f = new File("/local_a_ser_salvo/" + this.titulo);
        try (FileOutputStream fos = new FileOutputStream(f)) {
            fos.write(bytes);

            return f;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }
}

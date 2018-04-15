/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import Entidades.DocumentoGenerico;
import javax.ejb.EJB;
import javax.ejb.Stateless;


/**
 *
 * @author adoniran
 */
@Stateless
public class DocumentoGenericoBean extends CrudGenerico<DocumentoGenerico>  {
    public DocumentoGenericoBean() {
        super(DocumentoGenerico.class);
    }
    
}

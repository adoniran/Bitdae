/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TestesEjb;

import EJB.DocumentoGenericoBean;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.NamingException;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author adoniran
 */
public class TestesDoc {
    private static EJBContainer container;
    public TestesDoc() {
    }
    
    @BeforeClass
    public static void setUpClass() {
         container = EJBContainer.createEJBContainer();
        assertNotNull(container);
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

     @Test
    public void helloEJBTeste() throws NamingException {
         DocumentoGenericoBean Documento = (DocumentoGenericoBean) container.getContext().lookup("java:global/classes/DocumentoGenericoBean!EJB.DocumentoGenericoBean");
        assertNotNull(Documento);
    }
}
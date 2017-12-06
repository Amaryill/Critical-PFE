package fr.eseo.criticalPfe.java.dao.attribut;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import fr.eseo.criticalPfe.java.model.attributs.Competence;


public class CompetenceDAOTest {
    
    static CompetenceDAO DAO;
    
    @BeforeClass
    public static void beforeClass(){
        DAO = CompetenceDAOImpl.getDAO();
    }
    
    @AfterClass
    public static void afterClass(){
        
    }
    
    @Test
    public void test1(){
        Competence comp = new Competence("nom", "carac", false, false, false, 0, "description");
        Competence newComp = DAO.creer(comp);
        Assert.assertEquals("nom", newComp.getNom());
        Assert.assertTrue(DAO.supprimer(newComp));
        
    }
}

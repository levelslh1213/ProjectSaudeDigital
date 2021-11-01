/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 *
 * @author paulo
 */
public class Disciplina {    
    public ArrayList<String> disciplinas = new ArrayList();
    
    public Disciplina(){
        preencherDisciplinas();
    }
    
    private void preencherDisciplinas(){
        disciplinas.add("Pesq. da Prática em Ciência da Computação I");
        disciplinas.add("Pesq. da Prática em Ciência da Computação II");
        disciplinas.add("Pesq. da Prática em Ciência da Computação III");
    }
    
    
}

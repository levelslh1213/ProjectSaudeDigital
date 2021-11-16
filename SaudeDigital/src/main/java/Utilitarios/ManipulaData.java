/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utilitarios;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author E181
 */
public class ManipulaData {
    public String formatarData(String data) throws Exception {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy"); 
        Date date = formato.parse(data); 
        formato.applyPattern("dd/MM/yyyy"); 
        String dataFormatada = formato.format(date);
        return dataFormatada;
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CorrecionJoins;

import Estructura.ParteCuerpo;

/**
 *
 * @author Bernardo Luscher <b_luscher at hotmail.com>
 */
// actualizado 6/6/2016
public class CorreccionIndice extends CorrecionAbs{
    
    private ParteCuerpo p;
    float indice;
    
    public CorreccionIndice(ParteCuerpo pc, float i){
        this.p = pc;
        this.indice = i;
    }
    
    @Override
    public void corregir() {
        float f = Float.parseFloat(p.getPosY());
        float resul = f + indice;
        p.setPosY(Float.toString(resul));   
    }
    

}

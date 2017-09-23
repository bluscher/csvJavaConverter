
package CorrecionJoins;

import Estructura.ParteCuerpo;

/**
 *
 * @author Bernardo Luscher <b_luscher at hotmail.com>
 */



public class CorreccionPromedio extends CorrecionAbs{
    private ParteCuerpo p1;
    private ParteCuerpo p2;
    
    public CorreccionPromedio(ParteCuerpo pc1,ParteCuerpo pc2){
        this.p1 = pc1;
        this.p2 = pc2;    
    }

    @Override
    public void corregir() {
        float f1 = Float.parseFloat(p1.getPosY());
        float f2 = Float.parseFloat(p2.getPosY());
        float resul = (f1+f2)/2;
        p1.setPosY(Float.toString(resul));        
    }

}

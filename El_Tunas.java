 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.el_tunas;

import baseDatos.Catalogos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author lestu
 */
public class El_Tunas {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        Catalogos catalogo = new Catalogos ();
        catalogo.crearCatalogo();
        
        OrdenProduccion ordenProduccion = new OrdenProduccion();
        System.out.println(ordenProduccion.crearOrdenProduccion());
    }
}

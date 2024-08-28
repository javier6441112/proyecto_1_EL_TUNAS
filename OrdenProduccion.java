/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.el_tunas;

import baseDatos.Catalogos;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author lestu
 */
public class OrdenProduccion {
    
    
    //agrega productos a la oreden de produccion 
    public List<DetalleProducto> agregarProducto (){
        String seguir;
        //poner esto solo el metodo crearorden
        Catalogos catalogo = new Catalogos ();
         List<Producto> productosCatalogo = new ArrayList<>();
        productosCatalogo = catalogo.crearCatalogo();
        List <DetalleProducto> detalleProductos = new ArrayList<>();
//        DetalleProducto detalleProducto = new DetalleProducto();
        Scanner sp = new Scanner (System.in);
        int i = 1;
        do { DetalleProducto detalleProducto = new DetalleProducto();
            System.out.println("_______________________________");
            System.out.println("Producto numero:"+i);
            System.out.println("ingrese el codigo del producto");
            detalleProducto.setCodigo(sp.nextLine());
            System.out.println("el producto es: "+productosCatalogo.get(Integer.parseInt(detalleProducto.getCodigo())).getNombreProducto());
            System.out.println("ingrese el detalle de la personalizacion del producto");
            System.out.println("en dado caso no exista una personalizacion ingrese NA");
            detalleProducto.setDetallePersonalizacion(sp.nextLine());
            if(!detalleProducto.getDetallePersonalizacion().equals("NA")){
                System.out.println("ingrese el precio del producto");
                detalleProducto.setPrecio(sp.nextDouble());
            }else{
                detalleProducto.setPrecio(productosCatalogo.get(Integer.parseInt(detalleProducto.getCodigo())).getPrecio());
            }
            detalleProducto.setEstadoProducto("enProducion");
            detalleProductos.add(detalleProducto);
            i++;
            System.out.println("desea agregar otro producto? si/no");
            seguir = sp.nextLine();
            seguir = sp.nextLine();
            
        }while (seguir.equals("si"));
        return detalleProductos;
    }
    
    
    // al crear la orden de produccion se genera automaticamente la factura para el cliente
    public String crearOrdenProduccion (){
        Factura factura = new Factura();
        List <DetalleProducto> detalleProductos = new ArrayList<>();
        detalleProductos = this.agregarProducto();
        Catalogos catalogo = new Catalogos ();
         List<Producto> productosCatalogo = new ArrayList<>();
        productosCatalogo = catalogo.crearCatalogo();
        factura.CrearFactura(detalleProductos, productosCatalogo);

       return "se creo con exito";
    }

    public OrdenProduccion() {
    }

    
}

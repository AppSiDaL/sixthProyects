/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package code;

import java.io.File;


/**
 *
 * @author appsidal
 */
public class Principal {
    public static void main(String[] args) {
        String ruta ="/home/appsidal/Desktop/GT/sixthProyects/LYA/compilador/src/code/lexer.flex";
        generarLexer(ruta);
    }
    public static void generarLexer(String ruta){
    File archivo = new File(ruta);
    JFlex.Main.generate(archivo);
    }
}
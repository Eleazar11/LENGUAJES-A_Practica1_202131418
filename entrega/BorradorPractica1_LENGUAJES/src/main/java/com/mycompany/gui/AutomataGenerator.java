/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.lexer.Token;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author Eleazr
 */
public class AutomataGenerator {

    public static void generarArchivoDot(Token token, String rutaArchivoDot) {
        StringBuilder dot = new StringBuilder();
        dot.append("digraph finite_state_machine {\n");
        dot.append("    rankdir=LR;\n");
        dot.append("    size=\"8,5\"\n");
        dot.append("    node [shape = doublecircle]; S" + token.getTipo() + ";\n");
        dot.append("    node [shape = circle];\n");

        String lexema = token.getLexema();
        for (int i = 0; i < lexema.length(); i++) {
            dot.append("    S" + i + " -> S" + (i + 1) + " [label=\"" + lexema.charAt(i) + "\"];\n");
        }
        dot.append("    S" + lexema.length() + " [shape=doublecircle];\n");
        dot.append("}\n");

        try (PrintWriter writer = new PrintWriter(rutaArchivoDot)) {
            writer.print(dot.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void generarImagenAutómata(String rutaArchivoDot, String rutaImagen) {
        try {
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpng", rutaArchivoDot, "-o", rutaImagen);
            pb.start().waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.gui;

import com.mycompany.lexer.Token;
import java.util.List;

/**
 *
 * @author Eleazr
 */
public class ReporteTokens {
    public static String generarReporte(List<Token> tokens) {
        StringBuilder reporte = new StringBuilder();
        reporte.append("Reporte de Tokens:\n");
        reporte.append("=====================================\n");
        for (Token token : tokens) {
            reporte.append("Token: ").append(token.getLexema()).append("\n");
            reporte.append("Tipo: ").append(token.getTipo()).append("\n");
            reporte.append("Línea: ").append(token.getLinea()).append("\n");
            reporte.append("Columna: ").append(token.getColumna()).append("\n");
            reporte.append("=====================================\n");
        }
        return reporte.toString();
    }
}
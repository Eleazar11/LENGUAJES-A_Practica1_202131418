/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lexer;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author 3198935960914 - Eleazar Colop
 */
public class TokenColor {
    private static final Map<TokenType, String> colorMap = new HashMap<>();

    static {
        // Colores para operadores aritméticos
        colorMap.put(TokenType.OPERADOR_ARITMETICO_SUMA, "#FF33FF"); // Rosa
        colorMap.put(TokenType.OPERADOR_ARITMETICO_RESTA, "#C19A6B"); // Marrón
        colorMap.put(TokenType.OPERADOR_ARITMETICO_EXPONENTE, "#FCD0B4"); // Naranja claro
        colorMap.put(TokenType.OPERADOR_ARITMETICO_DIVISION, "#B4D941"); // Verde
        colorMap.put(TokenType.OPERADOR_ARITMETICO_MODULO, "#D9AB41"); // Amarillo
        colorMap.put(TokenType.OPERADOR_ARITMETICO_MULTIPLICACION, "#D80073"); // Rojo

        // Colores para operadores relacionales
        colorMap.put(TokenType.OPERADOR_RELACIONAL_IGUAL, "#6A00FF"); // Azul oscuro
        colorMap.put(TokenType.OPERADOR_RELACIONAL_DIFERENTE, "#3F2212"); // Marrón oscuro
        colorMap.put(TokenType.OPERADOR_RELACIONAL_MAYOR, "#D9D411"); // Amarillo
        colorMap.put(TokenType.OPERADOR_RELACIONAL_MENOR, "#D94A41"); // Rojo
        colorMap.put(TokenType.OPERADOR_RELACIONAL_MAYOR_IGUAL, "#E3C800"); // Amarillo
        colorMap.put(TokenType.OPERADOR_RELACIONAL_MENOR_IGUAL, "#F0A30A"); // Naranja

        // Colores para operadores lógicos
        colorMap.put(TokenType.OPERADOR_LOGICO_Y, "#414ED9"); // Azul
        colorMap.put(TokenType.OPERADOR_LOGICO_O, "#41D95D"); // Verde claro
        colorMap.put(TokenType.OPERADOR_LOGICO_NEGACION, "#A741D9"); // Púrpura

        // Colores para operadores de asignación
        colorMap.put(TokenType.OPERADOR_ASIGNACION, "#41D9D4"); // Verde claro
        colorMap.put(TokenType.OPERADOR_ASIGNACION_COMPUESTA, "#FFFFFF"); // Blanco

        // Colores para palabras reservadas
        colorMap.put(TokenType.PALABRA_RESERVADA_MODULE, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_END, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_SUB, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_MAIN, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_DIM, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_AS, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_INTEGER, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_STRING, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_BOOLEAN, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_DOUBLE, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_CHAR, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_CONSOLE_WRITE_LINE, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_CONSOLE_READ_LINE, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_IF, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_ELSE_IF, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_ELSE, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_THEN, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_WHILE, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_DO, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_LOOP, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_FOR, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_TO, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_NEXT, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_FUNCTION, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_RETURN, "#60A917"); // Verde oscuro
        colorMap.put(TokenType.PALABRA_RESERVADA_CONST, "#60A917"); // Verde oscuro

        // Colores para tipos de datos
        colorMap.put(TokenType.TIPO_DATO_ENTERO, "#1BA1E2"); // Azul claro
        colorMap.put(TokenType.TIPO_DATO_DECIMAL, "#FFFF88"); // Amarillo claro
        colorMap.put(TokenType.TIPO_DATO_CADENA, "#E51400"); // Rojo
        colorMap.put(TokenType.TIPO_DATO_BOOLEANO, "#FA6800"); // Naranja
        colorMap.put(TokenType.TIPO_DATO_CARACTER, "#0050EF"); // Azul oscuro

        // Color para token especial de cuadro
        colorMap.put(TokenType.CUADRO_COLOR, "#4fbad4"); // Azul claro

        // Colores para comentarios
        colorMap.put(TokenType.COMENTARIO, "#B3B3B3"); // Gris

        // Colores para signos y símbolos
        colorMap.put(TokenType.PARANTESIS, "#9AD8DB"); // Azul claro
        colorMap.put(TokenType.LLAVES, "#DBD29A"); // Amarillo claro
        colorMap.put(TokenType.CORCHETES, "#DBA49A"); // Naranja claro
        colorMap.put(TokenType.COMA, "#B79ADB"); // Azul claro
        colorMap.put(TokenType.PUNTO, "#9ADBA6"); // Verde claro

        // Color para identificadores
        colorMap.put(TokenType.IDENTIFICADOR, "#FFD300"); // Amarillo

        // Color para desconocido
        colorMap.put(TokenType.DESCONOCIDO, "#000000"); // Negro
    }

    public static String getColor(TokenType tokenType) {
        return colorMap.getOrDefault(tokenType, "#000000"); // Negro por defecto para desconocido
    }
}
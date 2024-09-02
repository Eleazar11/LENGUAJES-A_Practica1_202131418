/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lexer;

/**
 *
 * @author 3198935960914 - Eleazar Colop
 */
public class LexerString {
    private final String input;
    private int position;

    public LexerString(String input, int position) {
        this.input = input;
        this.position = position;
    }

    public Token lex() {
        StringBuilder lexeme = new StringBuilder();
        char currentChar = input.charAt(position);

        // Asegúrate de que el string comienza con una comilla
        if (currentChar != '"') {
            return new Token(TokenType.DESCONOCIDO.toString(), "", 0, 0, TokenColor.getColor(TokenType.DESCONOCIDO));
        }
        lexeme.append(currentChar);
        position++;

        // Leer hasta encontrar la comilla de cierre
        currentChar = input.charAt(position);
        while (currentChar != '"' && position < input.length()) {
            lexeme.append(currentChar);
            position++;
            if (position < input.length()) {
                currentChar = input.charAt(position);
            }
        }

        // Añadir la comilla de cierre
        if (currentChar == '"') {
            lexeme.append(currentChar);
            position++;
        }

        return new Token(TokenType.TIPO_DATO_CADENA.toString(), lexeme.toString(), 0, 0, TokenColor.getColor(TokenType.TIPO_DATO_CADENA));
    }

    public int getPosition() {
        return position;
    }
}
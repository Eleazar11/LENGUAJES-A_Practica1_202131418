/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lexer;

/**
 *
 * @author 3198935960914 - Eleazar Colop
 */
public class LexerNumber {
    private final String input;
    private int position;

    public LexerNumber(String input, int position) {
        this.input = input;
        this.position = position;
    }

    public Token lex() {
        StringBuilder lexeme = new StringBuilder();
        char currentChar = input.charAt(position);

        // Leer números enteros y decimales
        boolean isDecimal = false;
        while (Character.isDigit(currentChar) || (currentChar == '.' && !isDecimal)) {
            if (currentChar == '.') {
                isDecimal = true;
            }
            lexeme.append(currentChar);
            position++;
            if (position < input.length()) {
                currentChar = input.charAt(position);
            } else {
                break;
            }
        }

        TokenType type = isDecimal ? TokenType.TIPO_DATO_DECIMAL : TokenType.TIPO_DATO_ENTERO;
        return new Token(type.toString(), lexeme.toString(), 0, 0, TokenColor.getColor(type));
    }

    public int getPosition() {
        return position;
    }
}
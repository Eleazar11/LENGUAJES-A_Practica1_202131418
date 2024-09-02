/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lexer;

/**
 *
 * @author 3198935960914 - Eleazar Colop
 */
public class LexerIdentifier {
    private final String input;
    private int position;

    public LexerIdentifier(String input, int position) {
        this.input = input;
        this.position = position;
    }

    public Token lex() {
        StringBuilder lexeme = new StringBuilder();
        // Verifica si el primer carácter es una letra
        if (position < input.length() && Character.isLetter(input.charAt(position))) {
            lexeme.append(input.charAt(position));
            position++;
        } else {
            return new Token(TokenType.DESCONOCIDO.toString(), "", position, position, TokenColor.getColor(TokenType.DESCONOCIDO));
        }

        // Continúa agregando caracteres válidos para identificadores
        while (position < input.length() && (Character.isLetterOrDigit(input.charAt(position)) || input.charAt(position) == '_')) {
            lexeme.append(input.charAt(position));
            position++;
        }

        TokenType type = determineTokenType(lexeme.toString());
        return new Token(type.toString(), lexeme.toString(), position - lexeme.length(), position, TokenColor.getColor(type));
    }

    private TokenType determineTokenType(String lexeme) {
        switch (lexeme) {
            case "Module": return TokenType.PALABRA_RESERVADA_MODULE;
            case "End": return TokenType.PALABRA_RESERVADA_END;
            case "Sub": return TokenType.PALABRA_RESERVADA_SUB;
            case "Main": return TokenType.PALABRA_RESERVADA_MAIN;
            case "Dim": return TokenType.PALABRA_RESERVADA_DIM;
            case "As": return TokenType.PALABRA_RESERVADA_AS;
            case "Integer": return TokenType.PALABRA_RESERVADA_INTEGER;
            case "String": return TokenType.PALABRA_RESERVADA_STRING;
            case "Boolean": return TokenType.PALABRA_RESERVADA_BOOLEAN;
            case "Double": return TokenType.PALABRA_RESERVADA_DOUBLE;
            case "Char": return TokenType.PALABRA_RESERVADA_CHAR;
            case "Console.WriteLine": return TokenType.PALABRA_RESERVADA_CONSOLE_WRITE_LINE;
            case "Console.ReadLine": return TokenType.PALABRA_RESERVADA_CONSOLE_READ_LINE;
            case "If": return TokenType.PALABRA_RESERVADA_IF;
            case "ElseIf": return TokenType.PALABRA_RESERVADA_ELSE_IF;
            case "Else": return TokenType.PALABRA_RESERVADA_ELSE;
            case "Then": return TokenType.PALABRA_RESERVADA_THEN;
            case "While": return TokenType.PALABRA_RESERVADA_WHILE;
            case "Do": return TokenType.PALABRA_RESERVADA_DO;
            case "Loop": return TokenType.PALABRA_RESERVADA_LOOP;
            case "For": return TokenType.PALABRA_RESERVADA_FOR;
            case "To": return TokenType.PALABRA_RESERVADA_TO;
            case "Next": return TokenType.PALABRA_RESERVADA_NEXT;
            case "Function": return TokenType.PALABRA_RESERVADA_FUNCTION;
            case "Return": return TokenType.PALABRA_RESERVADA_RETURN;
            case "Const": return TokenType.PALABRA_RESERVADA_CONST;
            case "int": return TokenType.TIPO_DATO_ENTERO;
            case "float": return TokenType.TIPO_DATO_DECIMAL;
            case "string": return TokenType.TIPO_DATO_CADENA;
            case "boolean": return TokenType.TIPO_DATO_BOOLEANO;
            case "char": return TokenType.TIPO_DATO_CARACTER;
            default: return TokenType.IDENTIFICADOR;
        }
    }

    public int getPosition() {
        return position;
    }
}
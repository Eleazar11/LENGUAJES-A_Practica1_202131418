/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.app;

import com.mycompany.lexer.Token;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Eleazr
 */
public class GridCell extends JPanel {
    public GridCell(Token token) {
        this.setBackground(Color.decode(token.getColor()));
        
        JLabel label = new JLabel(token.getLexema());
        label.setForeground(Color.BLACK);
        this.add(label);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
package controller;
import mainGame.*;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Classe qui permet d'afficher le tableau des scores
public class ContrScore implements ActionListener{
    JFrame frame;
    JLabel TableauScore = new JLabel("Tableau des scores");
    JLabel ScoreDisplay=   new JLabel("");

    @Override
    public void actionPerformed(ActionEvent e){
        //Creation d'une nouvelle fenetre qui affiche tous les scores a partir du fihcier score.txt
        frame = new JFrame();
        frame.setTitle("Tableau des scores");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1)); 

        try {
            BufferedReader reader = new BufferedReader(new FileReader("./src/mainGame/score.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                JLabel label = new JLabel(line);
                frame.add(label);
            }
            reader.close();
        } catch (IOException ex) { 
            ex.printStackTrace();
        }

        frame.pack();
        frame.setVisible(true);
    }
    
}

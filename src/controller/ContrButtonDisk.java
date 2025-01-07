package controller;
import mainGame.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color; 
//Classe qui permet de gérer les actions des boutons des tours
public class ContrButtonDisk implements ActionListener{
    Play play;
    Tower tower;
    JFrame frame;
    InterfaceGraphique interfaceGraphique; 
    JLabel alertLabel;

    //Constructeur de la classe Controller.ContrButtonDisk
    public ContrButtonDisk(Play play, Tower tower, JFrame frame, InterfaceGraphique interfaceGraphique, JLabel alertLabel){
        this.play = play;
        this.tower = tower;
        this.frame = frame;
        this.interfaceGraphique = interfaceGraphique;
        this.alertLabel = alertLabel;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (play.getSourceTower() == null) {
            play.setSourceTower(tower);
        } else {
            String message = play.moveDisk(play.getSourceTower().getName(), tower.getName()); // On déplace le disque de la tour source à la tour destination
            play.setSourceTower(null);
            if (message != null) {
                alertLabel.setText(message);
                alertLabel.setForeground(Color.RED);
                return;
            }
            interfaceGraphique.updateGame(play);
        }
    }
}
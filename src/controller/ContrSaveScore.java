package controller;
import mainGame.*;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import java.awt.event.ActionEvent;

//Class qui permet de sauvegarder le score quand on appuie sur le bouton Sauvegarder Le score

public class ContrSaveScore implements ActionListener{
    private Play play;
    private JTextField textField;
    private InterfaceGraphique interfaceGraphique;
    private int nbCoups;

    //Constructeur qui permet de recuperer le play et le contenu de textField
    public ContrSaveScore(Play play, JTextField textField, InterfaceGraphique interfaceGraphique, int nbCoups){
        this.play = play;
        this.textField = textField;
        this.interfaceGraphique = interfaceGraphique;
        this.nbCoups = nbCoups;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String name = textField.getText();  
        try {
            play.writeBestScore(nbCoups, name);
            interfaceGraphique.scoreSaved = 1;
            interfaceGraphique.updateGame(play);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}

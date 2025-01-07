package controller;
import mainGame.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Classe qui permet de gerer le bouton qui permet de reprendre le jeu quand on est en resolution automatique
public class ContrReprendre implements ActionListener{
    InterfaceGraphique interfaceGraphique;
    Play play;
    public ContrReprendre(Play play, InterfaceGraphique interfaceGraphique){
        this.interfaceGraphique = interfaceGraphique;
        this.play = play;
    }
    @Override
    public void actionPerformed(ActionEvent e){
        interfaceGraphique.SolveBool = 0;
        interfaceGraphique.updateGame(play);        
    }
    
}
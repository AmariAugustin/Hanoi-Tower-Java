package controller;
import mainGame.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Classe qui permet de passer à l'étape suivante de la résolution automatique
public class ContrSuivant implements ActionListener{
    Play play;
    InterfaceGraphique interfaceGraphique;
    ArrayList<String> list;
    int i;

    //Constructeur de la classe Controller.ContrSuivant qui prend en paramètre un objet Play, un objet InterfaceGraphique, un entier i qui permet de savoir ou on en est et une liste contenant les mouvements à effectuer
    public ContrSuivant(Play play, InterfaceGraphique interfaceGraphique, int i, ArrayList<String> list){
        this.play = play;
        this.interfaceGraphique = interfaceGraphique;
        this.i = i;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        String s = list.get(i);
        String out = list.get(i+1);
        if (s == "X"){ //On change les lettres en lettres des tours equivalentes pour pouvoir les utiliser dans la fonction moveDisk
            s="A";
        }
        else if (s == "Y"){
            s="B";
        }
        else if (s == "Z"){
            s="C";
        }
        if (out == "X"){
            out="A";
        }
        else if (out == "Y"){
            out="B";
        }
        else if (out == "Z"){
            out="C";
        }
        play.moveDisk(s, out);
        i+=2;
        interfaceGraphique.iAuto = i;
        interfaceGraphique.SolveList = list;
        interfaceGraphique.updateGame(play);
    }
    
}

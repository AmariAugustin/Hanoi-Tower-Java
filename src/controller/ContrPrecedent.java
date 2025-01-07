package controller;
import mainGame.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

//Classe qui permet de gerer le bouton qui permet de revenir en arrière dans la résolution automatique
public class ContrPrecedent implements ActionListener{
    Play play;
    InterfaceGraphique interfaceGraphique;
    ArrayList<String> list;
    int i;

    //Constructeur de la classe Controller.ContrPrecedent
    public ContrPrecedent(Play play, InterfaceGraphique interfaceGraphique, int i, ArrayList<String> list){
        this.play = play;
        this.interfaceGraphique = interfaceGraphique;
        this.i = i;
        this.list = list;
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if (i <= 0){
            return;
        }

        String s = list.get(i);
        String out = list.get(i+1);
        if (s == "X"){
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
        play.moveDisk(out, s);
        i-=2;

        interfaceGraphique.iAuto = i;
        interfaceGraphique.SolveList = list;
        interfaceGraphique.updateGame(play);
    }
    
}

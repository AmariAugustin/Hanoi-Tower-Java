package mainGame;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class Play {
    //Initialisation des variables
    private Tower[] listTower;
    private int nbCoups;
    private int nbDisks;
    private Tower sourceTower;
    private ArrayList<String> MoveForSolveList = new ArrayList<String>();

    //1er constructeur
    public Play(int nbDisk) {
        initGame(nbDisk);
        this.nbDisks = nbDisk;
    }

    //2eme constructeur
    public Play(int nbDisk, Tower[] listTower) {
        this.listTower = listTower;
        this.nbDisks = nbDisk;
    }

    //Methode qui permet de deplacer un disque d'une tour source à une tour destination
    public String moveDisk(String sourceName, String destName) {
        Tower sourceTower = getTowerByName(sourceName);
        Tower destTower = getTowerByName(destName);

        if (sourceTower == null || destTower == null) {
            return "La tour source ou la tour destination n'existe pas.";

        }

        Disk sourceTop = sourceTower.getTopDisk();
        Disk destTop = destTower.getTopDisk();

        if (sourceTop == null) {
            return "La tour source est vide.";
        }

        if (destTop == null || sourceTop.getSize() < destTop.getSize()) {
            destTower.pileUpDisk(sourceTower.pileDownDisk());
            nbCoups++;
        } else {
            return "Le disque de la tour source ne peut pas être placé sur le disque de la tour destination.";
        }
        return null;
    }

    //Methode qui permet de verifier si le jeu est terminé
    public boolean isFinished() {
        if (listTower[0].isEmpty() && (listTower[1].isEmpty() || listTower[2].isEmpty())){
            return true;
        }
        return false;
    }

    //Methode qui permet de sauvegarder les scores dans un fichier txt
    public void writeBestScore(int nbCps, String name) throws IOException {
        String dateS;
        Path path = Paths.get("./src/mainGame/score.txt");
        Date utilDate = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy à HH:mm", Locale.FRANCE);
        dateS = dateFormat.format(utilDate.getTime());
        String line = "Partie avec "+ getNbDisks() + " disques" +" terminée par "+ name +" en " + nbCps + " coups le " + dateS;
        List<String> aLines = Arrays.asList(new String[] {line});
        Files.write(path, aLines, StandardCharsets.UTF_8, StandardOpenOption.APPEND);
    }

    //Methode qui permet d'initialiser le jeu avec un nombre de disques 'nbDisk' et ainsi de les empiler sur la tour A
    public void initGame(int nbDisk) {
        listTower = new Tower[]{new Tower("A"), new Tower("B"), new Tower("C")};
        nbCoups = 0;
        for (int i = nbDisk; i > 0; i--) {
            listTower[0].pileUpDisk(new Disk(i));
        }
    }

    //Methode qui permet d'initialiser le jeu avec un nombre de disques 'nbDisk' et remplir les tours en fonction d'une liste
    public void initGame(int nbDisk, Tower[] listT) {
        listTower = new Tower[]{new Tower("A"), new Tower("B"), new Tower("C")};
        listTower[0] = listT[0];
        listTower[1] = listT[1];
        listTower[2] = listT[2];
        nbCoups = 0;
        for (int i = nbDisk; i > 0; i--) {
            listTower[0].pileUpDisk(new Disk(i));
        }
    }

    //Methode qui permet de resoudre le jeu de hanoi
    public void solveHanoi() {
        int startIndex = 0;
        for (int i = 0; i < listTower.length; i++) {
            if (!listTower[i].getListDisk().isEmpty()) {
                startIndex = i;
                break;
            }
        }

        solveHanoi(nbDisks - startIndex, startIndex, 2, 1);
    }

    //Methode qui permet de resoudre le jeu de hanoi
    private void solveHanoi(int n, int source, int destination, int aux) {
        if (n >= 0) {
            solveHanoi(n - 1, source, aux, destination);
            MoveForSolveList.add(listTower[source].getName());
            MoveForSolveList.add(listTower[destination].getName());
            moveDisk(listTower[source].getName(), listTower[destination].getName());
            solveHanoi(n - 1, aux, destination, source);
        }
    }

    //Methode qui permet de recuperer une tour par son nom
    private Tower getTowerByName(String name) {
        for (Tower tower : listTower) {
            if (tower.getName().equalsIgnoreCase(name)) {
                return tower;
            }
        }
        return null;
    }

    //Methode qui permet de recuperer la liste des tours
    public Tower[] getListTower() {
        return listTower;
    }

    //Methode qui permet de recuperer le nombre de coups
    public int getNbCoups() {
        return nbCoups;
    }

    //Methode qui permet de recuperer le nombre de disques
    public int getNbDisks() {
        return nbDisks;
    }

    //Methode qui permet de recuperer la tour source
    public void setSourceTower(Tower tower) {
        this.sourceTower = tower;
    }

    //Methode qui permet de recuperer la tour source
    public Tower getSourceTower() {
        return this.sourceTower;
    }

    //Methode qui permet de recuperer la liste des mouvements pour resoudre le jeu
    public ArrayList getMoveForSolveList() {
        return MoveForSolveList;
    }

    //Methode qui permet de recuperer une tour par son index
    public Tower getTower(int index) {
        return listTower[index];
    }
}
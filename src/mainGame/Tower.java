package mainGame;

import java.util.ArrayList;


public class Tower {
    //Initialisation des attributs
    private ArrayList<Disk> listDisk = new ArrayList<>();
    private final String name;

    //Constructeur de la classe Tower avec un seul paramètre
    public Tower(String name) {
        this.name = name;
    }

    //Constructeur de la classe Tower avec en plus une liste de disques à empiler
    public Tower(String name, ArrayList listDisk) {
        this.listDisk = listDisk;
        this.name = name;
    }

    //Méthode pour empiler un disque
    public void pileUpDisk(Disk disk) {
        listDisk.add(disk);
    }

    //Méthode pour dépiler un disque
    public Disk pileDownDisk() {
        return listDisk.remove(listDisk.size() - 1);
    }

    //Méthode pour obtenir le disque du dessus
    public Disk getTopDisk() {
        if (listDisk.isEmpty()) {
            return null;
        }
        return listDisk.get(listDisk.size() - 1);
    }

    //Méthode pour vérifier si la tour est vide
    public boolean isEmpty() {
        return listDisk.isEmpty();
    }

    //Méthode pour obtenir la liste des disques
    public ArrayList<Disk> getListDisk() {
        return listDisk;
    }

    //Méthode pour obtenir le nom de la tour
    public String getName() {
        return name;
    }

    //Méthode pour obtenir la taille de la liste des disques
    public int length(){
        return listDisk.size();
    }
}

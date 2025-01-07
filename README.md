
# Les Tours de Hanoï - Java

## Description du Projet

Ce projet consiste à recréer le jeu classique **Les Tours de Hanoï** en **Java** en utilisant la programmation orientée objet (POO) et une interface graphique développée avec **Java AWT** et **Java Swing**. L'application permet à l'utilisateur de jouer, de résoudre automatiquement le jeu, et de sauvegarder ses scores.

---

## Fonctionnalités

### Paramètres de départ
- Une fenêtre initiale permet de choisir le nombre de disques (entre 2 et 10) pour configurer la partie.

### Interface graphique interactive
- **Tours de jeu** :
  - Trois tours représentées par des boutons : "A", "B", et "C".
  - Déplacement intuitif des disques en cliquant sur la tour source puis sur la tour destination.
  - Message d’erreur affiché en rouge si un déplacement est invalide.
- **Autres boutons** :
  - **Recommencer** : redémarre une partie.
  - **Résoudre** : propose une solution automatique pas à pas.
  - **Reprendre** : passe du mode résolution automatique au mode manuel.
- **Barre de menu** :
  - Onglet “Info” contenant le tableau des scores enregistrés.
- **Affichage du nombre de coups** en haut à gauche.

### Écran de fin
- Affiche les informations suivantes :
  - Score, date, et heure de la partie.
  - Indicateur de résolution optimale.
- Permet d’enregistrer le score.

### Tableau des scores
- Accessible via l’onglet "Info" dans la barre de menu.
- Liste les scores enregistrés, incluant :
  - Le nom du joueur.
  - Le nombre de coups.
  - La date et l'heure de la partie.

---

## Installation et Lancement

### Prérequis
- **Java 8** ou version ultérieure doit être installé.

### Étapes d’installation
1. **Cloner le projet** :
   ```bash
   git clone https://github.com/AmariAugustin/Hanoi-Tower-Java.git
   cd Hanoi-Tower-Java
   ```

2. **Compiler les fichiers sources** :
   ```bash
   javac -d bin src/*.java
   ```

3. **Exécuter l’application** :
   ```bash
   java -cp bin Main
   ```

---

## UML

Le projet inclut des diagrammes UML détaillés pour :
- Les relations entre les classes (héritage, composition, associations).
- Les interactions principales entre les objets.

Les diagrammes se trouvent dans le dossier `/uml` du projet.

---

## Aperçus

### Fenêtre de paramétrage
_(Ajoutez ici une capture d’écran illustrant la fenêtre où le nombre de disques est sélectionné.)_

### Jeu en cours
_(Ajoutez ici une capture d’écran montrant l’interface principale avec les disques et les tours.)_

### Tableau des scores
_(Ajoutez ici une capture d’écran du tableau des scores accessible via l’onglet "Info".)_

---

## Auteur

- **Amari Augustin**  
  Année académique : 2023-2024  
  Université : _(Ajoutez ici le nom de votre université si nécessaire.)_

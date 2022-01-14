package com.company;
import java.io.*;
import java.util.zip.*;

public class GameProgress implements Serializable {

    private static final long serialVersionUID = 1L;

    private int health;
    private int weapons;
    private int lvl;
    private double distance;

    public GameProgress(int health, int weapons, int lvl, double distance) {
        this.health = health;
        this.weapons = weapons;
        this.lvl = lvl;
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "GameProgress{" +
                "health=" + health +
                ", weapons=" + weapons +
                ", lvl=" + lvl +
                ", distance=" + distance +
                '}';
    }

    public void saveGames(String folderPath, GameProgress gameProgress) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(folderPath))) {
            oos.writeObject(gameProgress);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void zipFiles(String folderPath, String objectZIP){
        try (ZipOutputStream zout = new ZipOutputStream(new FileOutputStream(folderPath));
             FileInputStream fis = new FileInputStream(objectZIP);){
            ZipEntry entry = new ZipEntry("save3.dat");
            zout.putNextEntry(entry);
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            zout.write(buffer);
            zout.closeEntry();
        } catch(Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class fisier {
   // pt interfata grafica
    public static String listPartition(String path) {

        File partitie = new File(path);
        StringBuilder rezultat = new StringBuilder();


        if (partitie.exists() ||  partitie.isDirectory()) {

            String[] fisiere = partitie.list();


            if (fisiere != null && fisiere.length > 0) {
                for (String item : fisiere) {
                    rezultat.append(item).append("\n");
                }
            } else {
                rezultat.append("Partitia este goala.\n");
            }
        }

        return rezultat.toString();

    }

    public static String Arhivare(String fisier) {

        String zipName = fisier + ".zip";

        byte[] buffer = new byte[1024];

        File zip = new File(zipName);

        try {
            FileInputStream fileIn = new FileInputStream(fisier);
            FileOutputStream fileOut = new FileOutputStream(zipName);
            ZipOutputStream zipIn = new ZipOutputStream(fileOut);

            zipIn.putNextEntry(new ZipEntry(new File(fisier).getName()));

            int nBytes;
            while((nBytes = fileIn.read(buffer)) != -1 ) {
                zipIn.write(buffer , 0 , nBytes);
            }

            zipIn.closeEntry();
            zipIn.close();
            fileIn.close();
            fileOut.close();

            return "Fisier arhivat cu succes :" + zipName;
        } catch (Exception e ){
            return "Erorare la arhivare  " + e.toString();
        }
    }

    public static String Dezarhivare(String zipFilePath , String destDir){
        File dir = new File(destDir);
        if (!dir.exists()) dir.mkdirs();

        try (FileInputStream fis = new FileInputStream(zipFilePath);
             ZipInputStream zis = new ZipInputStream(fis)) {

            ZipEntry entry;

            while ((entry = zis.getNextEntry()) != null) {
                File newFile = new File(destDir + File.separator + entry.getName());

                if (entry.isDirectory()) {
                    newFile.mkdirs();
                    continue;
                }

                new File(newFile.getParent()).mkdirs();

                FileOutputStream fos = new FileOutputStream(newFile);
                byte[] buffer = new byte[1024];
                int len;
                while ((len = zis.read(buffer)) > 0) {
                    fos.write(buffer, 0, len);
                }
                fos.close();
            }

            return "Dezarhivare finalizată în folderul: " + destDir;

        } catch (Exception e) {
            return "Eroare la dezarhivare: " + e.toString();
        }
    }




    // pt afisare in consola

    public static void main(String[] args) {

        File partitie1 = new File("C:\\");

        File partitie2 = new File("F:\\");

        System.out.println("Prima partitie are" + " " + partitie1.getAbsolutePath() + " : ");
        if (partitie1.exists() || partitie1.isDirectory()) {
            String[] fisiere1 = partitie1.list();

            if (fisiere1 != null) {
                for (String item : fisiere1) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Partiția este goala");
            }
        }

        System.out.println("A doua partitie are" + " " + partitie2.getAbsolutePath() + " : ");
        if (partitie2.exists() || partitie1.isDirectory()) {
            String[] fisiere2 = partitie2.list();

            if (fisiere2 != null) {
                for (String item : fisiere2) {
                    System.out.println(item);
                }
            } else {
                System.out.println("Partiția este goala");
            }
        }

    }
}

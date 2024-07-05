package assignment4.view;

import assignment4.model.DatabaseModel;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Scanner;

/**
 * Class to manage reading and writing to the file.
 */
public class ReadWrite {
  private String filePath = "C:\\Users\\Dator\\Documents\\skola\\1DV502\\assignment-4\\app\\src\\main\\java\\assignment4\\registry.txt";

  /**
   * Method to read the data from a file.
   *
   * @param database Database, instance of class DatabaseModel.
   */
  public void fileReader(DatabaseModel database) {
    String[] data;
    String memId = null;
    File file = new File(filePath);

    if (!file.exists()) {
      System.err.println("Error: File not found at path " + filePath);
      return;
    }

    try (Scanner scan = new Scanner(file, Charset.defaultCharset())) {
      while (scan.hasNextLine()) {

        String s = scan.nextLine();

        if (s.trim().length() == 0) {
          continue;
        }

        data = s.split(":");

        if (data.length >= 4 && data[0].equals("MEMBER")) {
          String name = data[1];
          String mail = data[2];
          memId = data[3];
          database.addNewMember(name, mail, memId);

        } else if (data.length >= 3 && data[0].equals("BOAT")) {
          if (database.selectMember(memId) == null) {
            System.err.println("Error: Boat found without a preceding member. Skipping line: " + s);
            continue;
          }
          String boatName = data[1];
          String boatType = data[2];

          try {
            switch (boatType) {
              case "sailboat":
                if (data.length != 5) {
                  System.err.println("Invalid sailboat data: " + s);
                  continue;
                }
                int sailboatLength = Integer.parseInt(data[3]);
                int sailboatDepth = Integer.parseInt(data[4]);
                database.addSailerBoat(memId, boatName, sailboatLength, sailboatDepth);
                break;
              case "motorboat":
                if (data.length != 5) {
                  System.err.println("Invalid motorboat data: " + s);
                  continue;
                }
                int motorboatLength = Integer.parseInt(data[3]);
                int motorboatEnginePower = Integer.parseInt(data[4]);
                database.addMotorBoat(memId, boatName, motorboatLength, motorboatEnginePower);
                break;
              case "motorsailer":
                if (data.length != 6) {
                  System.err.println("Invalid motorsailer data: " + s);
                  continue;
                }
                int motorsailerLength = Integer.parseInt(data[3]);
                int motorsailerDepth = Integer.parseInt(data[4]);
                int motorsailerEnginePower = Integer.parseInt(data[5]);
                database.addMotorSailerBoat(memId, boatName, motorsailerLength,
                    motorsailerDepth, motorsailerEnginePower);
                break;
              case "canoe":
                if (data.length != 4) {
                  System.err.println("Invalid canoe data: " + s);
                  continue;
                }
                int canoeLength = Integer.parseInt(data[3]);
                database.addCanoeBoat(memId, boatName, canoeLength);
                break;
              default:
                System.err.println("Unknown boat type: " + boatType);
                break;
            }
          } catch (NumberFormatException e) {
            System.err.println("Error parsing number in line: " + s);
          }
        }
      }
    } catch (IOException exception) {
      System.err.println("Error: File not found at path " + filePath);
      exception.printStackTrace();
    }
  }

  /**
   * Method to write the data to a specific file.
   *
   * @param database SysRegistry, instance of class SysRegistry.
   */
  public void writeToFile(DatabaseModel database) {
    try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
      bw.write(database.writeToFile());
    } catch (IOException exception) {
      exception.printStackTrace();
    }
  }

}
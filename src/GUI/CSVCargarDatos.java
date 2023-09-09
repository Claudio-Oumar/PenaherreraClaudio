package GUI;


import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.PreparedStatement;

import DataAccess.SP_CP_SQLiteDataHelper;


public class CSVCargarDatos extends SP_CP_SQLiteDataHelper {
    
    public static String csvFilePath = "Archivo\\Coordenadas.csv"; // Reemplaza con la ruta a tu archivo CSV
   
    public String[] csvFilePaths = {csvFilePath}; // Reemplaza con la ruta a tu archivo CSV

    public static void loadMultipleCSVs(String[] csvFilePaths) {
        String csvSplitBy = ";"; // Cambia esto si tus datos CSV usan un separador diferente

        try (Connection connection = SP_CP_SQLiteDataHelper.openConnection()) {
            String insertQuery = "INSERT INTO SP_CP_COORDENADAS( Geoposicion, Lunes, Martes, Miercoles, Jueves, Viernes, Tipo   ) VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);

            for (String csvFilePath : csvFilePaths) {
                try (BufferedReader br = new BufferedReader(new FileReader(csvFilePath))) {
                    String line;
                    while ((line = br.readLine()) != null) {
                        String[] data = line.split(csvSplitBy);

                        // Verifica si la línea tiene la cantidad correcta de columnas antes de procesarla
                        if (data.length == 13) {
                            // Configura los valores para la consulta preparada
                            for (int i = 0; i < data.length; i++) {
                                preparedStatement.setString(i + 1, data[i]);
                            }
                            preparedStatement.executeUpdate();
                        } else {
                            System.out.println("Ignorando línea incorrecta en el archivo: " + csvFilePath);
                        }
                    }
                }
            }

            System.out.println("Datos CSV importados con éxito.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setVisible(boolean b) {
    }

   
}
import GUI.CSVCargarDatos;
import GUI.Login;

public class App {
    public static void main(String[] args) throws Exception {
        Login login = new Login();
        login.setVisible(true);
        CSVCargarDatos cargarDatos = new CSVCargarDatos();
        cargarDatos.setVisible(true);
    }

}

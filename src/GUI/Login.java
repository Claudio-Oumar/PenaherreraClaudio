package GUI;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends JFrame {
    
    
    private JButton exitButton;
    private JButton jLogin;
    private JTextField jUser;
    private JPasswordField jPassword;

    public Login() {
        initComponents();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    private void initComponents() {
        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                ImageIcon backgroundImage = new ImageIcon("/src/imagenes/ghost.png");
                Image image = backgroundImage.getImage();
                g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
            }
        };
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        JLabel titleLabel = new JLabel("INICIAR SESION");
        titleLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        panel.add(titleLabel, gbc);

        JLabel jLogoLabel = new JLabel();
        jLogoLabel.setPreferredSize(new Dimension(170, 280));
        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(jLogoLabel, gbc);

        JLabel userLabel = new JLabel("     Usuario :");
        userLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(userLabel, gbc);

        jUser = new JTextField(15);
        gbc.gridx = 1;
        panel.add(jUser, gbc);

        JLabel passwordLabel = new JLabel(" Password :");
        passwordLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(passwordLabel, gbc);

        jPassword = new JPasswordField(15);
        gbc.gridx = 1;
        panel.add(jPassword, gbc);

        jLogin = new JButton("Enviar");
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(jLogin, gbc);

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(panel, BorderLayout.CENTER);

        exitButton = new JButton("X");
        exitButton.setBackground(Color.GRAY);
        exitButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
        exitButton.setBorder(BorderFactory.createLineBorder(Color.gray, 2));
        exitButton.addActionListener(evt -> System.exit(0));

        getContentPane().add(exitButton, BorderLayout.NORTH);

        // Agregar ActionListener para el botón de inicio de sesión
        jLogin.addActionListener(e -> {
            String username = jUser.getText();
            String password = String.valueOf(jPassword.getPassword());

            // Verificar las credenciales
            if ((username.equals("Profe") && password.equals("12345"))||(username.equals("Santiago") && password.equals("1752192086"))
            ||(username.equals("Claudio") && password.equals("1755501044"))) {
                // Cerrar la ventana de inicio de sesión
                dispose();

                // Abrir la nueva ventana después de la autenticación exitosa
                openNewWindow();
            } else {
                JOptionPane.showMessageDialog(this, "Credenciales incorrectas. Por favor, inténtalo de nuevo.");
            }
        });
    }

    private void openNewWindow() {
        // Puedes crear una nueva ventana aquí o realizar cualquier acción deseada después de la autenticación exitosa
        // Por ejemplo, abrir una nueva ventana:
        NewWindow newWindow = new NewWindow();
        newWindow.setVisible(true);
    }

    
    
}

class NewWindow extends JFrame {
    private Connection connection;
    private JButton BookButton, LendingButton, ClientButton;
    private JTable dataTable;
    
    public NewWindow() {
        super("Interfaz de Música");

        // try {
        //     connection = DriverManager.getConnection("jdbc:sqlite:database\\biblioteca.db"); 
        // } catch (SQLException e) {
        //     System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        //     System.exit(1);
        // }

        JPanel buttonPanel = new JPanel(new FlowLayout());
        BookButton = new JButton("Book");
        LendingButton = new JButton("Prestamo");
        ClientButton = new JButton("Client");

        buttonPanel.add(BookButton);
        buttonPanel.add(LendingButton);
        buttonPanel.add(ClientButton);

        dataTable = new JTable();
        JScrollPane scrollPane = new JScrollPane(dataTable);

        BookButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // actualizarTabla("SELECT * FROM Book");
            }
        });

        LendingButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // actualizarTabla("SELECT * FROM Lending");
            }
        });

        ClientButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // actualizarTabla("SELECT * FROM Client");
            }
        });

        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(buttonPanel, BorderLayout.NORTH);
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        // actualizarTabla("SELECT * FROM Book");  // Mostrar datos de Book por defecto
        // Puedes personalizar esta ventana según tus necesidades
    }

    // protected void actualizarTabla(String query) {
    //     try (Statement statement = connection.createStatement();
    //          ResultSet resultSet = statement.executeQuery(query)) {

    //         DefaultTableModel model = new DefaultTableModel();
    //         int columnCount = resultSet.getMetaData().getColumnCount();

    //         for (int i = 1; i <= columnCount; i++) {
    //             model.addColumn(resultSet.getMetaData().getColumnName(i));
    //         }

    //         while (resultSet.next()) {
    //             Object[] row = new Object[columnCount];
    //             for (int i = 1; i <= columnCount; i++) {
    //                 row[i - 1] = resultSet.getObject(i);
    //             }
    //             model.addRow(row);
    //         }

    //         dataTable.setModel(model);
    //     } catch (SQLException e) {
    //         JOptionPane.showMessageDialog(this, "Error al obtener datos: " + e.getMessage());
    //     }
    // }
}
package projet;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.DefaultCellEditor;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;
public class EditionUtilisateur extends JFrame implements ActionListener {

	// le titre de la page

    Connecter conn = new Connecter();

    JLabel welcomeLabel = new JLabel("EDITION DE L'UTILISATEURS");
    ImageIcon EnsaIcon = new ImageIcon("fichier/logo.png");
    JLabel EnsaLabel = new JLabel(EnsaIcon);
    Container container = getContentPane();

    // buttom de Déconnexion
    JButton DeconnexionButtom = new JButton("Deconnexion");
    // buttom du rotour
    Icon icon = new ImageIcon("fichier/retour.PNG");
    JButton RoteurButtom = new JButton(icon);
    // ajouter
    ImageIcon addIcon = new ImageIcon(
            new ImageIcon("fichier/addIcon.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
    JButton addButton = new JButton(addIcon);
    JLabel ajouterLabel = new JLabel("Ajouter ");
    // ---------------------------------------------------------------------------------------

    private JTable table;
    private JScrollPane scrollPane;
    private String[] columns = new String[8];
    private String[][] data = new String[3][3];
    JButton supprimerButton = new JButton();

    int dataLength = 0;
    JPanel a = new JPanel();

    // ----------------------------------------------------------------------------------------
    public void setLayoutManager() {
        // Pour en-tete
        container.setLayout(null);

    }

    public void setLocationAndSizeAndColor() {
        // Pour en-tete
        welcomeLabel.setBounds(0, 0, 1015, 90);
        welcomeLabel.setOpaque(true);
        welcomeLabel.setBackground(new Color(173, 216, 230));
        welcomeLabel.setFont(new Font("Segoe UI", 1, 16));
        welcomeLabel.setForeground(Color.BLACK);
        welcomeLabel.setHorizontalAlignment(JLabel.CENTER);

        EnsaLabel.setBounds(10, 0, 350, 90);
        EnsaLabel.setOpaque(true);
        EnsaLabel.setBackground(new Color(173, 216, 230));
        EnsaLabel.setHorizontalAlignment(JLabel.LEFT);

        addButton.setBounds(35, 100, 38, 38);
        addButton.setOpaque(true);
        addButton.setFont(new Font("Segoe UI", 1, 14));

        ajouterLabel.setBounds(60, 110, 100, 20);
        ajouterLabel.setOpaque(true);
        ajouterLabel.setFont(new Font("Segoe UI", 1, 14));
        ajouterLabel.setForeground(Color.BLACK);
        ajouterLabel.setHorizontalAlignment(JLabel.CENTER);

        DeconnexionButtom.setBounds(852, 24, 142, 57);
        DeconnexionButtom.setOpaque(true);
        DeconnexionButtom.setBackground(new Color(173, 216, 230));
        DeconnexionButtom.setFont(new Font("Segoe UI", 1, 14));
        DeconnexionButtom.setForeground(Color.BLACK);

        RoteurButtom.setBounds(10, 10, 70, 70);
        RoteurButtom.setOpaque(true);
        RoteurButtom.setForeground(Color.BLACK);
        RoteurButtom.setBorderPainted(false);
    }

    public void addComponentsToContainer() {
        // Pour en-tete
        container.add(EnsaLabel);
        container.add(welcomeLabel);
        container.add(DeconnexionButtom);
        container.add(addButton);
        container.add(ajouterLabel);

    }

    public void addActionEvent() {
        DeconnexionButtom.addActionListener(this);
        RoteurButtom.addActionListener(this);
        addButton.addActionListener(this);
        supprimerButton.addActionListener(this);

    }

    private void Data() {

        columns = new String[]{"CODE(Login)", "NOM", "PRENOM", "CIN", "TYPE", "password",
            "Supprimer"};

        data = tableData();

        DefaultTableModel model = new DefaultTableModel(data, columns);
        table = new JTable();
        table.setModel(model);
        table.getColumn("Supprimer").setCellRenderer(new ButtonRenderer());
        table.getColumn("Supprimer").setCellEditor(new ButtonEditor(new JCheckBox()));

        table.setForeground(Color.black);
        table.setBackground(Color.LIGHT_GRAY);

        JTableHeader Theader = table.getTableHeader();
        Theader.setBackground(Color.DARK_GRAY);
        Theader.setForeground(Color.white);
        Theader.setFont(new Font("Tahome", Font.HANGING_BASELINE, 14));
        scrollPane = new JScrollPane(table);

        scrollPane.setPreferredSize(new Dimension(850, 25 + 17 * dataLength));

        a.setBounds(0, 140, 1041, 440);
        a.add(scrollPane, BorderLayout.CENTER);
        supprimerButton.addActionListener(this);

    }

    public String[][] tableData() {
        String[][] data;

        try {

            Statement stmt = conn.obtenirconnexion().createStatement();
            Statement stmt1 = conn.obtenirconnexion().createStatement();

            ResultSet rs_length = stmt1.executeQuery("SELECT count(*) As count FROM `utilisateur` where type <> 'etudiant' ;");

            rs_length.next();
            dataLength = rs_length.getInt("count");
         
            data = new String[dataLength][8];
            ResultSet rs_utilisateur = stmt.executeQuery("SELECT * FROM `utilisateur` where type <>'etudiant';");
            String type;
            String id_personnel;
            int i = 0;
            while (i < dataLength && rs_utilisateur.next()) {
                type = rs_utilisateur.getString("type");
                id_personnel = rs_utilisateur.getString("login");

                if (type.equals("professeur")) {
                    ResultSet rs_personnel = stmt1
                            .executeQuery("SELECT *  FROM `professeur` where code_prof='" + id_personnel + "' ;");

                    while (rs_personnel.next()) {
                        String[] row = new String[10];
                        row[0] = "" + id_personnel;
                        row[1] = (rs_personnel.getString("nom"));
                        row[2] = (rs_personnel.getString("prenom"));
                        row[3] = ("" + rs_personnel.getString("cin"));
                        row[4] = (rs_utilisateur.getString("type"));
                        row[5] = (rs_utilisateur.getString("password"));
                        data[i] = row;
                        i++;
                    }

                }
                if (type.equals("directeur") || type.equals("scolarite") || type.equals("admin_site")
                        || type.equals("professeur") || type.equals("admin_apogee")) {
                    ResultSet rs_personnel = stmt1.executeQuery("SELECT *  FROM administrateur where code_admin='" + id_personnel + " ';");

                    while (rs_personnel.next()) {
                        String[] row = new String[10];
                        row[0] = "" + id_personnel;
                        row[1] = (rs_personnel.getString("nom"));
                        row[2] = (rs_personnel.getString("prenom"));
                        row[3] = ("" + rs_personnel.getString("cin"));
                        row[4] = (rs_utilisateur.getString("type"));
                        row[5] = (rs_utilisateur.getString("password"));

                        data[i] = row;
                        i++;
                    }

                }
            }

        } catch (Exception ex) {
            System.out.println("Error in table: " + ex);
            data = null;
        }

        return data;
    }

    public void actionPerformed(ActionEvent e) {
        Statement prepared;
        
        if (e.getSource() == DeconnexionButtom) {
            dispose();
        }

        if (e.getSource() == supprimerButton) {
            String code = data[table.getSelectedRow()][0];
            Connecter conn = new Connecter();
            ;
            try {
                //étape 1: charger la classe driver
                Class.forName("com.mysql.jdbc.Driver");
                //étape 2: créer l'objet de connexion
                //étape 3: créer l'objet statement 
                Statement stmt = conn.obtenirconnexion().createStatement();
                //étape 4: exécuter la requête
                String sql = "DELETE FROM utilisateur WHERE login=" + code;
                stmt.executeUpdate(sql);
                //étape 5: fermez l'objet de connexion
                conn.obtenirconnexion().close();
                JOptionPane.showMessageDialog(this, "L'utilisateur a été supprimé");
                
            } catch (Exception e7) {
                System.out.println(e7);
            }

        }
        if (e.getSource() == addButton) {
            AjouterUtilisateur nvEtudiant = new AjouterUtilisateur();
            dispose();
        }

    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {

            setText((value == null) ? "Supprimer" : value.toString());
            return this;

        }
    }

    class ButtonEditor extends DefaultCellEditor {

        private String label;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
                int column) {

            label = (value == null) ? "Supprimer" : value.toString();
            supprimerButton.setText(label);
            supprimerButton.setName("" + row);
            return supprimerButton;

        }

        public Object getCellEditorValue() {
            return new String(label);
        }
    }

    EditionUtilisateur() {

        setLayoutManager();
        setLocationAndSizeAndColor();
        addComponentsToContainer();
        addActionEvent();

        Data();
        getContentPane().add(a);
        this.setTitle("EDITION DE L'UTILISATEURS");
        this.setVisible(true);
        this.setBounds(160, 150,1020, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    public static void main(String[] args) {
        EditionUtilisateur eu = new EditionUtilisateur();

    }
}

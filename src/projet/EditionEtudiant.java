package projet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Color.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableCellRenderer;

import com.mysql.jdbc.PreparedStatement;

public class EditionEtudiant extends JFrame implements ActionListener {

	private JPanel contentPane;
	// le titre de la page
		JLabel welcomeLabel = new JLabel("EDITION DE L'ETUDIANT");
		ImageIcon EnsaIcon = new ImageIcon("fichier/logo.png");
		JLabel EnsaLabel = new JLabel(EnsaIcon);
		Container container = getContentPane();

		// buttom de Déconnexion
		JButton DeconnexionButtom = new JButton("Déconnexion");
		// buttom du rotour
		JButton RoteurButtom = new JButton("Retour");
		
		// ajouter
		ImageIcon addIcon = new ImageIcon(
				new ImageIcon("fichier/addIcon.png").getImage().getScaledInstance(60, 60, Image.SCALE_DEFAULT));
		JButton addButton = new JButton(addIcon);
		JLabel ajouterLabel = new JLabel("Ajouter ");
	//---------------------------------------------------------------------------------------

		Connecter conn = new Connecter();
		private JTable table;
		private JScrollPane scrollPane;
		private String[] columns = new String[8];
		private String[][] data = new String[3][3];
		JButton modifierButton = new JButton();
		JButton supprimerButton = new JButton();

		int dataLength = 0;
		JPanel a = new JPanel();
		DefaultTableModel model;
		EditionEtudiant() {

			setLayoutManager();
			setLocationAndSizeAndColor();
			addComponentsToContainer();
			addActionEvent();

			Data();
			getContentPane().add(a);
			this.setTitle("EDITION DE L'ETUDIANT");
			this.setVisible(true);
			this.setBounds(160, 100,1020, 550);
			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			this.setResizable(false);
		}

		public void setLayoutManager() {
			// Pour en-tete
			container.setLayout(null);

		}

		public void setLocationAndSizeAndColor() {
			// Pour en-tete
			welcomeLabel.setBounds(0, 0, 1004, 90);
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

			RoteurButtom.setBounds(848, 9, 120, 30);
			RoteurButtom.setOpaque(true);
			RoteurButtom.setBackground(Color.WHITE);
			RoteurButtom.setFont(new Font("Segoe UI", 1, 14));
			RoteurButtom.setForeground(Color.BLACK);
			
			DeconnexionButtom.setBounds(858, 49, 120, 30);
			DeconnexionButtom.setOpaque(true);
			DeconnexionButtom.setBackground(Color.WHITE);
			DeconnexionButtom.setFont(new Font("Segoe UI", 1, 14));
			DeconnexionButtom.setForeground(Color.BLACK);

		}

		public void addComponentsToContainer() {
			// Pour en-tete
			container.add(EnsaLabel);
			container.add(welcomeLabel);
			container.add(RoteurButtom);
			container.add(DeconnexionButtom);
			container.add(addButton);
			container.add(ajouterLabel);

		}

		public void addActionEvent() {
			DeconnexionButtom.addActionListener(this);
			RoteurButtom.addActionListener(this);
			addButton.addActionListener(this);
			modifierButton.addActionListener(this);
			supprimerButton.addActionListener(this);

		}

		private void Data() {

			columns = new String[] { "Numero d'APOGEE", "PRENOM", "NOM", "NIVEAU", "FILIERE", "DATE DE NAISSANCE",
					"ADRESSE", "EMAIL", "Modifier", "Archiver" };

			data = tableData();

			 model = new DefaultTableModel(data, columns);
			table = new JTable();
			table.setModel(model);
			table.getColumn("Modifier").setCellRenderer(new ButtonRenderer());
			table.getColumn("Modifier").setCellEditor(new ButtonEditor(new JCheckBox()));
			table.getColumn("Archiver").setCellRenderer(new ButtonRenderer());
			table.getColumn("Archiver").setCellEditor(new ButtonEditor(new JCheckBox()));

			table.setForeground(Color.black);
			table.setBackground(Color.LIGHT_GRAY);

			JTableHeader Theader = table.getTableHeader();
			Theader.setBackground(Color.DARK_GRAY);
			Theader.setForeground(Color.white);
			Theader.setFont(new Font("Tahome", Font.HANGING_BASELINE, 14));
			scrollPane = new JScrollPane(table);

			scrollPane.setPreferredSize(new Dimension(850, 25 + 17 * dataLength));

			a.setBounds(0, 140, 1004, 440);
			a.add(scrollPane, BorderLayout.CENTER);

		}

		public String[][] tableData() {
			String[][] data;

			try {

				Statement stmt = conn.obtenirconnexion().createStatement();
				Statement stmt1 = conn.obtenirconnexion().createStatement();
				ResultSet rs_e = stmt.executeQuery("SELECT * FROM `etudiant` ;");

				ResultSet rs_length = stmt1.executeQuery("SELECT count(*) As count FROM `etudiant`");

				rs_length.next();
				dataLength = rs_length.getInt("count");
				data = new String[dataLength][8];

				int i = 0;
				while (i < dataLength && rs_e.next()) {

					String[] row = new String[10];
					row[0] = rs_e.getString("apogee");
					row[1] = (rs_e.getString("prenom"));
					row[2] = (rs_e.getString("nom"));
					row[3] = "" + rs_e.getString("niveau");
					row[4] = (rs_e.getString("filiere"));
					row[5] = (rs_e.getString("date_naissance"));
					row[6] = (rs_e.getString("adresse"));
					row[7] = (rs_e.getString("email"));

					data[i] = row;
					i++;
				}

			} catch (Exception e) {
				System.out.println("Error in table: " + e);
				data = null;
			}

			return data;
		}

		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == RoteurButtom) {
				 apogee espaseAdmin = new apogee();
				dispose();
			}
			if (e.getSource() == DeconnexionButtom)
				dispose();
			if (e.getSource() == modifierButton) {
				String apogee = data[table.getSelectedRow()][0];
		        ModifieEtudiant mod = new ModifieEtudiant(apogee);
	            dispose();
				
			}
			if (e.getSource() == supprimerButton) {
				
					Connecter cnx = new Connecter();
					String apogee = data[table.getSelectedRow()][0];
					
					PreparedStatement prepared = null;
					ResultSet resultat = null;
					String sql = "INSERT INTO archive(`id_etudiant`, `apogee`, `cin`, `cne`, `nom`, `prenom`, `email`, `niveau`, `filiere`, `groupe`, `date_naissance`, `adresse`, `telephone`) SELECT * FROM etudiant WHERE apogee='"
							+ apogee + "'";
					try {
						prepared = (PreparedStatement) cnx.obtenirconnexion().prepareStatement(sql);

						prepared.execute();

						String sql1 = "delete from etudiant where apogee='" + apogee + "'";

						prepared = (PreparedStatement) cnx.obtenirconnexion().prepareStatement(sql1);

						prepared.execute();
					} catch (SQLException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					dispose();
					EditionEtudiant nv=new EditionEtudiant();
				
			}
			if (e.getSource() == addButton) {

				AjouterEtudiant nvEtudiant = new AjouterEtudiant();
				dispose();
			}

		}

		class ButtonRenderer extends JButton implements TableCellRenderer {
			public ButtonRenderer() {
				setOpaque(true);
			}

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
					int row, int column) {
				if (column == 8) {
					setText((value == null) ? "Modifier" : value.toString());
					return this;
				} else {
					setText((value == null) ? "Archiver" : value.toString());
					return this;
				}

			}
		}

		class ButtonEditor extends DefaultCellEditor {
			private String label;

			public ButtonEditor(JCheckBox checkBox) {
				super(checkBox);
			}

			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row,
					int column) {
				if (column == 8) {
					label = (value == null) ? "Modifier" : value.toString();
					modifierButton.setText(label);
					modifierButton.setName("" + row);
					return modifierButton;
				} else {
					label = (value == null) ? "Archiver" : value.toString();
					supprimerButton.setText(label);
					supprimerButton.setName("" + row);
					return supprimerButton;
				}
			}

			public Object getCellEditorValue() {
				return new String(label);
			}
		}

}

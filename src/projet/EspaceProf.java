package projet;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextPane;
import javax.swing.tree.DefaultTreeCellEditor.EditorContainer;
import javax.swing.JMenuBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.SystemColor;
public class EspaceProf extends JFrame {

	Connecter cnx = new Connecter() ;
	PreparedStatement prepared = null;
	ResultSet resultat = null;
	private JFrame frame;
	private JTable table;
	public JComboBox nomcomboBox,comboBox_1;
	public JTextField txtModule;
	public String idetudiant;
	public JComboBox comboBox;

	public String niveau;
	private String code;
;

	public EspaceProf(String c) {
		code=c;
		initialize();
	}

	/**
	 * Initialize the contents of the 
	 */
	private void initialize() {
		
		
		getContentPane().setBackground(Color.WHITE);
		setBounds(160, 100,1020, 550);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		getContentPane().setLayout(null);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 74, 1004, 179);
		getContentPane().add(scrollPane);
		
		table = new JTable();
		table = new JTable();
		DefaultTableModel model=new DefaultTableModel();
		Object [] column= {"apogee","nom","prenom","groupe"};
		Object [] rows=new Object[0] ;
		
		model.setColumnIdentifiers(column);
		table.setModel(model);
		// Design du tableau 
		table.setForeground(Color.black);
		table.setBackground(Color.white);
		scrollPane.setViewportView(table);
		
		JTableHeader Theader = table.getTableHeader();
		Theader.setBackground(Color.black);
		Theader.setForeground(Color.white);
		Theader.setFont(new Font("Tahome",Font.HANGING_BASELINE,14));


		scrollPane.setViewportView(table);
		
		
		JLabel lblNewLabel = new JLabel("Nom et Prenom:");
		lblNewLabel.setBounds(69, 264, 142, 29);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Date Absence:");
		lblNewLabel_1.setBounds(69, 312, 103, 21);
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Raison:");
		lblNewLabel_2.setBounds(69, 344, 111, 29);
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		getContentPane().add(lblNewLabel_2);
		
		 nomcomboBox = new JComboBox();
		 nomcomboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 nomcomboBox.setBounds(221, 264, 243, 29);
		 nomcomboBox.setForeground(SystemColor.textHighlight);
		 nomcomboBox.setBackground(Color.WHITE);
		 nomcomboBox.setModel(new DefaultComboBoxModel(new String[] {"S\u00E9lectionnez"}));
		nomcomboBox.disable();

		getContentPane().add(nomcomboBox);

	
		
		 comboBox_1 = new JComboBox();
		 comboBox_1.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 comboBox_1.setBounds(221, 344, 243, 29);
		 comboBox_1.setForeground(SystemColor.textHighlight);
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"S\u00E9lectionnez", "justifi\u00E9e", "non justifi\u00E9e"}));
		getContentPane().add(comboBox_1);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(219, 304, 245, 29);
		getContentPane().add(dateChooser);
		
		txtModule = new JTextField();
		txtModule.setBounds(136, 20, 199, 24);
		getContentPane().add(txtModule);
		txtModule.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Module :");
		lblNewLabel_3.setBounds(60, 20, 66, 13);
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		getContentPane().add(lblNewLabel_3);
		
		 comboBox = new JComboBox();
		 comboBox.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		 comboBox.setBounds(408, 16, 226, 28);
		 comboBox.setForeground(SystemColor.textHighlight);
		 comboBox.setModel(new DefaultComboBoxModel(new String[] {"S\u00E9lectionnez classe"}));
		getContentPane().add(comboBox);
		
		JButton btnNewButton_2 = new JButton("Ajouter");
		btnNewButton_2.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		btnNewButton_2.setBounds(169, 416, 131, 29);
		btnNewButton_2.setForeground(SystemColor.textHighlight);
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nometud = nomcomboBox.getSelectedItem().toString();
				String date = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
				String raison = comboBox_1.getSelectedItem().toString();
			   String module = txtModule.getText().toString();

				String sql = "Insert Into absence(date_absence,raison,module_absence,id_etudiant) values(?,?,?,?)";
			if(nomcomboBox.getSelectedItem().equals("Sélectionnez")|| dateChooser.equals("") || comboBox_1.getSelectedItem().equals("Sélectionnez")) {
				JOptionPane.showMessageDialog(null,"Veulliez remlissez tous les champs s'il vous plait!");
				
			}
			else {
				try {
					prepared =cnx.obtenirconnexion().prepareStatement(sql);
					prepared.setString(1, date);
					prepared.setString(2, raison);
					prepared.setString(3, module);
					prepared.setString(4,idetudiant);


					prepared.execute();
					nomcomboBox.setSelectedItem("Sélectionnez");
					comboBox_1.setSelectedItem("Sélectionnez");

					JOptionPane.showMessageDialog(null,"Absence Ajoutée!");
				
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
			}
		update(niveau);
			}
		});
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(0,0,0));
		menuBar.setBackground(new Color (173,216,230));
		menuBar.setBorder(new EmptyBorder(5, 5, 5, 5));
		menuBar.setBounds(0, 0, 1004, 60);
	
		setJMenuBar(menuBar);
		
		JButton btnNewButton_1 = new JButton("retour");
		btnNewButton_1.setOpaque(true);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton_1.setForeground(Color.BLACK);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		menuBar.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("visualiser liste");
		btnNewButton.setOpaque(true);
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Segoe UI", Font.BOLD, 14));
		btnNewButton.setForeground(Color.BLACK);
		menuBar.add(btnNewButton);
		btnNewButton.setOpaque(true);
		btnNewButton.setFont(new Font("Segoe UI", 1, 14));
		
		JButton btnGererAbscence = new JButton("gerer absence");
		btnGererAbscence.setOpaque(true);
		btnGererAbscence.setBackground(Color.WHITE);
		btnGererAbscence.setFont(new Font("Segoe UI", 1, 14));
		btnGererAbscence.setForeground(Color.BLACK);
		menuBar.add(btnGererAbscence);
		
		
		JButton btnNewButton_3 = new JButton("se deconnecter");
		menuBar.add(btnNewButton_3);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setOpaque(true);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Segoe UI", 1, 14));
		btnNewButton_3.setForeground(Color.BLACK);
		btnGererAbscence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				niveau=comboBox.getSelectedItem().toString();

				if(comboBox.getSelectedItem().equals("Sélectionnez classe")) {
					JOptionPane.showMessageDialog(null,"Veulliez selectionner une classe!");
					
				}
				else {
					nomcomboBox.enable();
					nomcomboBox.removeAllItems();
					 nomcomboBox.setModel(new DefaultComboBoxModel(new String[] {"S\u00E9lectionnez"}));
					remplircombo(niveau);
					update(niveau);

				}
	

			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("Sélectionnez classe")) {
					JOptionPane.showMessageDialog(null,"Veulliez selectionner une classe!");
					
				}
				else {
					niveau=comboBox.getSelectedItem().toString();
					String sql="select apogee,nom,prenom,groupe from etudiant where niveau = '"+niveau+"'";
				try {
					prepared = cnx.obtenirconnexion().prepareStatement(sql);
					resultat=prepared.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(resultat));
				

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
				}
		});
		
		remplirNIV();
	}
	
	public void remplirNIV() {
		int id = 0;
		String sql3 = "select * from  professeur where code_prof = '"+code+"' ";
		System.out.println(code);
		try {
			prepared = cnx.obtenirconnexion().prepareStatement(sql3);
			resultat=prepared.executeQuery();
			if(resultat.next()) {
				id=(int)resultat.getDouble("id_prof");
				System.out.println(id);

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql2 = "select * from classe join professeur where classe.id_professeur = "+id;
		
		try {
			
			
			prepared = cnx.obtenirconnexion().prepareStatement(sql2);
			resultat=prepared.executeQuery();
			
			
			
			while(resultat.next()) {
				String nom = resultat.getString("nom").toString();
		//		idetudiant = resultat.getString("id_etudiant").toString();
				comboBox.addItem(nom);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	public void remplircombo(String s) {
		
		String sql2 = "select * from etudiant where niveau = '"+s+"'";
		try {
			prepared = cnx.obtenirconnexion().prepareStatement(sql2);
			resultat=prepared.executeQuery();
			while(resultat.next()) {
				String nom = resultat.getString("nom").toString();
				String prenom = resultat.getString("prenom").toString();
				idetudiant = resultat.getString("id_etudiant").toString();
				nomcomboBox.addItem(nom+" "+prenom);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	
	
	public void update(String s) {
		String sql1="select etudiant.id_etudiant,etudiant.apogee,etudiant.nom,etudiant.prenom,etudiant.groupe,absence.module_absence,absence.date_absence,absence.raison from etudiant join absence where etudiant.id_etudiant=absence.id_etudiant and niveau='"+s+"'";
		try {
			prepared = cnx.obtenirconnexion().prepareStatement(sql1);
			resultat=prepared.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(resultat));
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

}
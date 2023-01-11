package projet;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class filiere_gc extends JFrame {

	private JFrame frame;
	private JTable table_1;
	private DefaultTableModel model;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filiere_gc frame = new filiere_gc();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public filiere_gc() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(160, 150,1020, 480);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		getContentPane();
		setVisible(true);
		
		// La barre de Menu 
		
		JMenuBar myMenuBar=new JMenuBar();
		myMenuBar.setBackground(new Color(173, 216, 230));
		myMenuBar.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(myMenuBar);
		myMenuBar.setBounds(0, 0, 1004, 60);
		setVisible(true);
		setVisible(true);
		
		JMenu menuFichier3 = new JMenu("");
		menuFichier3.setIcon(new ImageIcon(filiere_gc.class.getResource("/image/icons8-menu-2-48.png")));
		menuFichier3.setForeground(Color.WHITE);
		myMenuBar.add(menuFichier3);
		setVisible(true);
		
		JMenuItem menuQuitter = new JMenuItem("Déconnexion"); 
		JMenuItem menuaceuil = new JMenuItem("Retour ");
		
		

		menuFichier3.add(menuQuitter);
		menuFichier3.add(menuaceuil);
		
			JLabel lblNewLabel = new JLabel("Génie civil");
			myMenuBar.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		
		menuaceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				menu_filiere y=new menu_filiere();
			}
		});
		
		menuQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login y=new login();
			}
		});
		
		
		
        
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 71, 979, 199);
		scrollPane.setBackground(Color.black);
		getContentPane().add(scrollPane);
		
		// Representation de tableau de profs
		table_1 = new JTable();
		model=new DefaultTableModel();
		Object [] column= {"code apogée","nom","prenom","email","filiere"};
		Object [] rows=new Object[0] ;
		
		model.setColumnIdentifiers(column);
		table_1.setModel(model);
		// Design du tableau 
		table_1.setForeground(Color.black);
		table_1.setBackground(Color.white);
		scrollPane.setViewportView(table_1);
		
		JTableHeader Theader = table_1.getTableHeader();
		Theader.setBackground(Color.black);
		Theader.setForeground(Color.white);
		Theader.setFont(new Font("Tahome",Font.HANGING_BASELINE,18));
		
		
      
		
	
	
		JButton edit = new JButton("modifier une filière");
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(table_1.getSelectedRow()==-1) {
					JOptionPane.showMessageDialog(null,"vous devez selectioner un étudiant!");
				}
				else
				{
				
				
				int i =table_1.getSelectedRow();
				String apogee = model.getValueAt(i, 0).toString();
				ModifierFiliere mod = new ModifierFiliere(apogee);
				
				}
				
				
				}
		});
		
			     
				
		edit.setFont(new Font("Times New Roman", Font.BOLD, 25));
		edit.setBounds(720, 344, 243, 33);
		edit.setFocusPainted(false);
		edit.setBackground(Color.LIGHT_GRAY);
		contentPane.add(edit);
	
		 PreparedStatement st;
			Connection con;
		try {
		       Class.forName("com.mysql.jdbc.Driver");
		       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ensasms","root","");
		       String sql = "SELECT apogee,nom,prenom,email,filiere FROM etudiant where filiere='GC' ";
			      st = con.prepareStatement(sql);
			      ResultSet res = st.executeQuery(sql);
			       while(res.next()) {
				model.addRow(new Object[]{res.getString("apogee"),res.getString("nom"),res.getString("prenom"),res.getString("email"),res.getString("filiere")});
			 	}
			}catch(Exception e){
			System.err.println(e);
			}
	}

}

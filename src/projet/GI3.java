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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

public class GI3 extends JFrame {

	private JPanel contentPane;
	private JFrame frame;
	private JTable table_1;
	private DefaultTableModel model;
	private Object color;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GI3 frame = new GI3();
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
	public GI3() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(160, 150,1020, 480);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		getContentPane();
		setVisible(true);
		
		JMenuBar myMenuBar=new JMenuBar();
		myMenuBar.setBackground(new Color(173, 216, 230));
		myMenuBar.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(myMenuBar);
		myMenuBar.setBounds(0, 0, 1004, 60);
		setVisible(true);
		setVisible(true);
		
		
		JMenu menuFichier3 = new JMenu("");
		menuFichier3.setIcon(new ImageIcon(GI3.class.getResource("/image/icons8-menu-2-48.png")));
		menuFichier3.setForeground(Color.WHITE);
		myMenuBar.add(menuFichier3);
		setVisible(true);
		
		JMenuItem menuQuitter = new JMenuItem("Déconnexion"); 
		JMenuItem menuaceuil = new JMenuItem("Retour ");
		
		

		menuFichier3.add(menuQuitter);
		menuFichier3.add(menuaceuil);
		
		JLabel lblNewLabel_11 = new JLabel("génie informatique-3ème année");
		myMenuBar.add(lblNewLabel_11);
		lblNewLabel_11.setForeground(new Color(0,0,0));
		lblNewLabel_11.setFont(new Font("Times New Roman", Font.BOLD, 25));
		
		
		menuaceuil.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				listes_info y=new listes_info();
			}
		});
		
		menuQuitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				login y=new login();
			}
		});
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(63, 96, 810, 298);
		scrollPane.setBackground(Color.WHITE);
		getContentPane().add(scrollPane);
		
		
		
		table_1 = new JTable();
		model=new DefaultTableModel();
		Object [] column= {"apogee","nom","prenom","email","filiere"};
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
		Theader.setFont(new Font("Tahome",Font.HANGING_BASELINE,20));
		
		 PreparedStatement st;
			Connection con;
			
	   try {
	       Class.forName("com.mysql.jdbc.Driver");
	       con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ensasms","root","");
	       String sql = "SELECT apogee,nom,prenom,email,filiere FROM etudiant where niveau='GI3'";
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

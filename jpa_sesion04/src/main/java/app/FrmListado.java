package app;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Tipo;
import modelo.Usuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class FrmListado extends JFrame {

	private JPanel contentPane;
	private JComboBox cboTipo;
	private JScrollPane scrollPane;
	private JTextArea txtSalida;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmListado frame = new FrmListado();
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
	public FrmListado() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 549, 369);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Tipo de Usuario");
		lblUsuario.setBounds(27, 36, 113, 14);
		contentPane.add(lblUsuario);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				listar();
			}
		});
		btnListar.setBounds(390, 32, 89, 23);
		contentPane.add(btnListar);
		
		cboTipo = new JComboBox();
		cboTipo.setBounds(163, 33, 144, 20);
		contentPane.add(cboTipo);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 76, 480, 243);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		llenarCombo();
	}
	
	
	void listar() {
		txtSalida.setText("");
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion04");
		EntityManager em = fabrica.createEntityManager();
		
		int tipo = cboTipo.getSelectedIndex();
		
		try {
			List<Usuario> lista = em.createQuery("Select u from Usuario u where u.idtipo = :tipo" , Usuario.class)
					.setParameter("tipo",tipo).getResultList();
			
			for (Usuario usuario : lista) {
			
				txtSalida.append("-----------------------------------" + "\n");
				txtSalida.append("NOMBRE USUARIO: " + usuario.getNom_usua() + "\n");
				txtSalida.append("APELLIDO USUARIO: " + usuario.getApe_usua() + "\n");
				txtSalida.append("USER USUARIO: " + usuario.getCorreo() + "\n");
				txtSalida.append("FECHA USUARIO: " + usuario.getFna_usua() + "\n");
			}
		
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null,e);
		}
		
	}

	void llenarCombo() {
		 EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("jpa_sesion04");
		 EntityManager em = fabrica.createEntityManager();
		
		
		List<Tipo> lista = em.createQuery("Select t from Tipo t", Tipo.class).getResultList();
		cboTipo.addItem("Seleccione...");
		for (Tipo tipo : lista) {
			cboTipo.addItem(tipo.getDescripcion());
		}
	}
}

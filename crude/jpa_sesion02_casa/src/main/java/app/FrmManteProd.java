package app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import modelo.Categoria;
import modelo.Producto;
import modelo.Proveedor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;

public class FrmManteProd extends JFrame {

	private JPanel contentPane;
	
	private JTextArea txtSalida;
	private JTextField txtCódigo;
	JComboBox cboCategorias;
	private JTextField txtDescripcion;
	private JTextField txtStock;
	private JTextField txtPrecio;
	private JButton btnBuscar;
	private JComboBox cboProveedor;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmManteProd frame = new FrmManteProd();
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
	public FrmManteProd() {
		setTitle("Mantenimiento de Productos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 390);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnNewButton = new JButton("Registrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				registrar();
			}
		});
		btnNewButton.setBounds(324, 29, 89, 23);
		contentPane.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 171, 414, 143);
		contentPane.add(scrollPane);
		
		txtSalida = new JTextArea();
		scrollPane.setViewportView(txtSalida);
		
		JButton btnListado = new JButton("Listado");
		btnListado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				listado();
			}
		});
		btnListado.setBounds(177, 322, 89, 23);
		contentPane.add(btnListado);
		
		txtCódigo = new JTextField();
		txtCódigo.setBounds(122, 11, 86, 20);
		contentPane.add(txtCódigo);
		txtCódigo.setColumns(10);
		
		JLabel lblCodigo = new JLabel("Id. Producto :");
		lblCodigo.setBounds(10, 14, 102, 14);
		contentPane.add(lblCodigo);
		
		cboCategorias = new JComboBox();
		cboCategorias.setBounds(122, 70, 86, 22);
		contentPane.add(cboCategorias);
		
		JLabel lblCategora = new JLabel("Categor\u00EDa");
		lblCategora.setBounds(10, 74, 102, 14);
		contentPane.add(lblCategora);
		
		JLabel lblNomProducto = new JLabel("Nom. Producto :");
		lblNomProducto.setBounds(10, 45, 102, 14);
		contentPane.add(lblNomProducto);
		
		txtDescripcion = new JTextField();
		txtDescripcion.setColumns(10);
		txtDescripcion.setBounds(122, 42, 144, 20);
		contentPane.add(txtDescripcion);
		
		JLabel lblStock = new JLabel("Stock:");
		lblStock.setBounds(10, 106, 102, 14);
		contentPane.add(lblStock);
		
		txtStock = new JTextField();
		txtStock.setColumns(10);
		txtStock.setBounds(122, 103, 77, 20);
		contentPane.add(txtStock);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(10, 134, 102, 14);
		contentPane.add(lblPrecio);
		
		txtPrecio = new JTextField();
		txtPrecio.setColumns(10);
		txtPrecio.setBounds(122, 131, 77, 20);
		contentPane.add(txtPrecio);
		
		btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buscar();
			}
		});
		btnBuscar.setBounds(324, 63, 89, 23);
		contentPane.add(btnBuscar);
		
		JLabel lblProveedor = new JLabel("Proveedor");
		lblProveedor.setBounds(242, 106, 102, 14);
		contentPane.add(lblProveedor);
		
		cboProveedor = new JComboBox();
		cboProveedor.setBounds(327, 102, 86, 22);
		contentPane.add(cboProveedor);
		
		llenaComboCategoria();
		llenaComboProveedor();
	}

	void llenaComboCategoria() {
		
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ejercicios");
		EntityManager em = fabrica.createEntityManager();
		
		List<Categoria> listadoCategoria = em.createQuery("Select c from Categoria c", Categoria.class).getResultList();
		cboCategorias.addItem("Seleccione");
		
		
		for (Categoria categoria : listadoCategoria) {
	
			cboCategorias.addItem(categoria.getDescripcion());	
		}
	}
	
	void llenaComboProveedor() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ejercicios");
		EntityManager em = fabrica.createEntityManager();
		
		List<Proveedor> listaProveedor = em.createQuery("Select p from Proveedor p", Proveedor.class).getResultList();
		
		cboProveedor.addItem("Seleccione");
		
		for (Proveedor proveedor : listaProveedor) {
			cboProveedor.addItem(proveedor.getNombre_rs());
		}
		
	}
	
	
	void listado() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ejercicios");
		EntityManager em = fabrica.createEntityManager();
		
		List<Producto> listadoProductos = em.createQuery("Select pr from Producto pr", Producto.class).getResultList();
		
		
		for (Producto producto : listadoProductos) {
			txtSalida.append("CODIGO: " + producto.getId_prod() + "\n" );
			txtSalida.append("NOMBRE: " + producto.getDes_prod() + "\n" );
			txtSalida.append("CATEGORIA: " + producto.getObjCategoria().getDescripcion() + "\n" );
			txtSalida.append("STOCK: " + producto.getStk_prod() + "\n" );
			txtSalida.append("PRECIO: " + producto.getPre_prod() + "\n" );
			txtSalida.append("PROVEEDOR: " + producto.getObjProveedor().getNombre_rs() + "\n" );
			txtSalida.append("-------------------------------------------" + "\n");
		}
		
		
	}
	
	void registrar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ejercicios");
		EntityManager em = fabrica.createEntityManager();
	
		em.getTransaction().begin();
		
		String codigo = txtCódigo.getText();
		String nombre = txtDescripcion.getText();
		double precio = Double.parseDouble(txtPrecio.getText());
		int stock = Integer.parseInt(txtStock.getText());
		int proveedor = cboProveedor.getSelectedIndex();
		int categoria = cboCategorias.getSelectedIndex();
		
		Producto p = new Producto();
		p.setId_prod(codigo);
		p.setDes_prod(nombre);
		p.setPre_prod(precio);
		p.setStk_prod(stock);
		p.setIdproveedor(proveedor);
		p.setIdcategoria(categoria);
		
		try {
			em.persist(p);
			
			em.getTransaction().commit();
			
			JOptionPane.showMessageDialog(null, "Se inserto correctamente");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "No pudo insertarse");
		}

	}
	
	void buscar() {
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("ejercicios");
		EntityManager em = fabrica.createEntityManager();
	
		String codigo = txtCódigo.getText();
		
		Producto p = em.find(Producto.class, codigo);
		
		if(p!=null) {
			txtDescripcion.setText(p.getDes_prod());
			txtPrecio.setText(p.getPre_prod()+ "");
			txtStock.setText(p.getStk_prod()+"");
			cboCategorias.setSelectedIndex(p.getIdcategoria());
			cboProveedor.setSelectedIndex(p.getIdproveedor());
			JOptionPane.showMessageDialog(null, "Producto encontrado");
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Este codigo no existe");
		}
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
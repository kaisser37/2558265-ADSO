import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;
import java.util.Locale;

public class Factura extends JFrame{

	private Persona Clientes [];
	private Persona Vendedores [];
	private Producto Productos [];
	private JLabel etqdatosCliente;
	private JLabel etqcedulaCliente;
	private JLabel etq_nombres_cliente;
	private JLabel etqdireccionCliente;
	private JLabel etqdatosVendedor;
	private JLabel etqcedulaVendedor;
	private JLabel etqnombresVendedor;
	private JLabel etqdatosProductos;
	private JLabel etq_id_producto;
	private JLabel etq_nombre_producto;
	private JLabel etq_cant_producto;
	private JLabel etq_btn_producto;
	private JLabel etqResultado;
	private JLabel etqTotal;
	private JTextField inputcedulaCliente;
	private JTextField inputnombresCliente;
	private JTextField inputdireccionCliente;
	private JTextField inputcedulaVendedor;
	private JTextField inputnombresVendedor;
	private JTextField inputidProducto;
	private JTextField inputnombreProducto;
	private JTextField inputcantidadProducto;
	private JButton btbuscarCliente;
	private JButton btbuscarVendedor;
	private JButton btaddProducto;

	// Metodos
	public Factura(Persona[] Clientes, Persona[] Vendedores, Producto[] Productos){
		this.Clientes = Clientes;
		this.Vendedores = Vendedores;
		this.Productos = Productos;

		initComponent();
	}

	public void initComponent(){

		setTitle("FACTURA");
		setSize( 400, 600 );
		setDefaultCloseOperation( EXIT_ON_CLOSE );
		setLocationRelativeTo(null);

		Image icono = getToolkit().createImage( ClassLoader.getSystemResource("imagenes/icono_factura.png") );
setIconImage(icono);
		
		JPanel contPrincipal = new JPanel();
		contPrincipal.setLayout(new GridBagLayout());
		contPrincipal.setBorder( BorderFactory.createEmptyBorder(20, 20, 20, 10) );
		GridBagConstraints restriccion = new GridBagConstraints();

		// cliente

		etqdatosCliente = new JLabel("DATOS CLIENTE:");
		etqdatosCliente.setFont( new Font("Comic Sans MS", Font.BOLD, 20) );
		etqdatosCliente.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
		restriccion.gridy = 0;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 2;
		restriccion.weightx = 100;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etqdatosCliente, restriccion );

		etqcedulaCliente = new JLabel("CEDULA:");
		restriccion.gridy = 1;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etqcedulaCliente, restriccion );

		inputcedulaCliente = new JTextField();
		inputcedulaCliente.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 1;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 2;
		restriccion.weightx = 80;
		restriccion.insets = new Insets(0, 10, 0, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( inputcedulaCliente, restriccion );

		btbuscarCliente = new JButton("BUSCAR");
		restriccion.gridy = 1;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( btbuscarCliente, restriccion );

		etq_nombres_cliente = new JLabel("NOMBRES:");
		restriccion.gridy = 2;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(10, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_nombres_cliente, restriccion );

		inputnombresCliente = new JTextField();
		inputnombresCliente.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
		restriccion.gridy = 2;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 2;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(10, 10, 10, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( inputnombresCliente, restriccion );

		etqdireccionCliente = new JLabel("DIRECCION:");
		restriccion.gridy = 3;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etqdireccionCliente, restriccion );

		inputdireccionCliente = new JTextField();
		inputdireccionCliente.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
		restriccion.gridy = 3;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 2;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(0, 10, 10, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( inputdireccionCliente, restriccion );

		
		// vendedor

		etqdatosVendedor = new JLabel("DATOS VENDEDOR:");
		etqdatosVendedor.setFont( new Font("Comic Sans MS", Font.BOLD, 20) );
		etqdatosVendedor.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
		restriccion.gridy = 4;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 2;
		restriccion.weightx = 100;
		restriccion.insets = new Insets(10, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etqdatosVendedor, restriccion );

		etqcedulaVendedor = new JLabel("CEDULA:");
		restriccion.gridy = 5;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etqcedulaVendedor, restriccion );

		inputcedulaVendedor = new JTextField();
		inputcedulaVendedor.setBorder( BorderFactory.createEmptyBorder(0, 10, 0, 10) );
		restriccion.gridy = 5;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 2;
		restriccion.weighty = 2;
		restriccion.weightx = 80;
		restriccion.insets = new Insets(0, 10, 0, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( inputcedulaVendedor, restriccion );

		btbuscarVendedor = new JButton("BUSCAR");
		restriccion.gridy = 5;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( btbuscarVendedor, restriccion );

		etqnombresVendedor = new JLabel("NOMBRES:");
		restriccion.gridy = 6;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(10, 0, 10, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etqnombresVendedor, restriccion );

		inputnombresVendedor = new JTextField();
		inputnombresVendedor.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
		restriccion.gridy = 6;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 3;
		restriccion.weighty = 2;
		restriccion.weightx = 90;
		restriccion.insets = new Insets(10, 10, 10, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( inputnombresVendedor, restriccion );

		
		//Productos

		etqdatosProductos = new JLabel("PRODUCTOS FACTURADOS:");
		etqdatosProductos.setFont( new Font("Comic Sans MS", Font.BOLD, 20) );
		etqdatosProductos.setBorder( BorderFactory.createEmptyBorder(0, 0, 10, 0) );
		restriccion.gridy = 7;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 2;
		restriccion.weightx = 100;
		restriccion.insets = new Insets(10, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etqdatosProductos, restriccion );

		etq_id_producto = new JLabel("ID");
		etq_id_producto.setHorizontalAlignment( JLabel.CENTER );
		restriccion.gridy = 8;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_id_producto, restriccion );

		etq_nombre_producto = new JLabel("NOMBRE");
		etq_nombre_producto.setHorizontalAlignment( JLabel.CENTER );
		restriccion.gridy = 8;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 70;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_nombre_producto, restriccion );

		etq_cant_producto = new JLabel("CANT.");
		etq_cant_producto.setHorizontalAlignment( JLabel.CENTER );
		restriccion.gridy = 8;
		restriccion.gridx = 2;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_cant_producto, restriccion );

		etq_btn_producto = new JLabel();
		restriccion.gridy = 8;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( etq_btn_producto, restriccion );


		inputidProducto = new JTextField();
		inputidProducto.setHorizontalAlignment(JLabel.CENTER);
		restriccion.gridy = 9;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( inputidProducto, restriccion );

		inputnombreProducto = new JTextField();
		inputnombreProducto.setHorizontalAlignment(JLabel.CENTER);
		restriccion.gridy = 9;
		restriccion.gridx = 1;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 70;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( inputnombreProducto, restriccion );

		inputcantidadProducto = new JTextField();
		inputcantidadProducto.setHorizontalAlignment(JLabel.CENTER);
		restriccion.gridy = 9;
		restriccion.gridx = 2;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 0, 0, 0);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( inputcantidadProducto, restriccion );

		btaddProducto = new JButton("ADD");
		restriccion.gridy = 9;
		restriccion.gridx = 3;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 1;
		restriccion.weighty = 2;
		restriccion.weightx = 10;
		restriccion.insets = new Insets(0, 10, 0, 10);
		restriccion.fill = GridBagConstraints.BOTH;
		contPrincipal.add( btaddProducto, restriccion );

		etqResultado = new JLabel(" ---- ");
		etqResultado.setHorizontalAlignment( JLabel.RIGHT );
		etqResultado.setVerticalAlignment( JLabel.TOP );
		etqResultado.setFont( new Font("Comic Sans MS", Font.BOLD, 10) );
		etqResultado.setOpaque(true);
		etqResultado.setBackground( Color.white );
		etqResultado.setBorder( BorderFactory.createEmptyBorder(10, 10, 10, 10) );
		restriccion.gridy = 10;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 89;
		restriccion.weightx = 100;
		restriccion.fill = GridBagConstraints.BOTH;
		restriccion.insets = new Insets(10, 0, 0, 10);
		contPrincipal.add( etqResultado, restriccion );

		etqTotal = new JLabel("Total: $ 0");
		etqTotal.setHorizontalAlignment( JLabel.RIGHT );
		etqTotal.setFont( new Font("Comic Sans MS", Font.BOLD, 20) );
		etqTotal.setOpaque(true);
		etqTotal.setBackground( Color.white );
		etqTotal.setBorder( BorderFactory.createEmptyBorder(5, 10, 5, 10) );
		restriccion.gridy = 11;
		restriccion.gridx = 0;
		restriccion.gridheight = 1;
		restriccion.gridwidth = 4;
		restriccion.weighty = 2;
		restriccion.weightx = 100;
		restriccion.fill = GridBagConstraints.BOTH;
		restriccion.insets = new Insets(0, 0, 0, 10);
		contPrincipal.add( etqTotal, restriccion );

		this.inputnombresCliente.setEnabled(false);
		this.inputdireccionCliente.setEnabled(false);
		deshabilitarInput(this.inputnombresCliente);
		deshabilitarInput(this.inputdireccionCliente);
		deshabilitarInput(this.inputnombresVendedor);
		deshabilitarInput(this.inputidProducto);
		deshabilitarInput(this.inputnombreProducto);
		deshabilitarInput(this.inputcantidadProducto);

		add( contPrincipal );
		setResizable(false);
		setVisible(true);
		revalidate();
		repaint();

		ActionListener eventoClickBuscarCliente = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buscarCliente();
			}
		};

		KeyListener eventoKeyBuscarCliente = new KeyListener(){
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                String texto = inputcedulaCliente.getText();
                if(texto.equalsIgnoreCase("")){
                    inputnombresCliente.setText("");
                    inputdireccionCliente.setText("");
                }
                if (e.getKeyCode()==10) {
                    buscarCliente();
                }else{
                	inputnombresCliente.setText("");
                    inputdireccionCliente.setText("");
                    deshabilitarInput(inputnombresCliente);
					deshabilitarInput(inputdireccionCliente);
                }
            }

            public void keyTyped(KeyEvent e){
            }
        };

        ActionListener eventoClickBuscarVendedor = new ActionListener(){
			public void actionPerformed(ActionEvent e){
				buscarVendedor();
			}
		};

		KeyListener eventoKeyBuscarVendedor = new KeyListener(){
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                String texto = inputcedulaVendedor.getText();
                if(texto.equalsIgnoreCase("")){
                    inputnombresVendedor.setText("");
                }
                if (e.getKeyCode()==10) {
                    buscarVendedor();
                }else{
                	inputnombresVendedor.setText("");
                    deshabilitarInput(inputnombresVendedor);

                    inputidProducto.setText("");
					deshabilitarInput(inputidProducto);
					inputnombreProducto.setText("");
					deshabilitarInput(inputnombreProducto);
					inputcantidadProducto.setText("");
					deshabilitarInput(inputcantidadProducto);
                }
            }

            public void keyTyped(KeyEvent e){
            }
        };

		btbuscarCliente.addActionListener( eventoClickBuscarCliente );
		inputcedulaCliente.addKeyListener( eventoKeyBuscarCliente );

		btbuscarVendedor.addActionListener( eventoClickBuscarVendedor );
		inputcedulaVendedor.addKeyListener( eventoKeyBuscarVendedor );


		KeyListener eventoKeyBuscarProducto = new KeyListener(){
            public void keyPressed(KeyEvent e){
            }

            public void keyReleased(KeyEvent e){
                String texto = inputidProducto.getText();
                if(texto.equalsIgnoreCase("")){
                    inputnombreProducto.setText("");
                    inputcantidadProducto.setText("");
                }
                
                if (e.getKeyCode()==10) {
                    buscarProducto();
                }else if (e.getKeyCode()==8) {
                	inputnombreProducto.setText("");
                    inputcantidadProducto.setText("");
                    deshabilitarInput(inputnombreProducto);
                }else if (e.getKeyCode()!=16){
                	inputnombreProducto.setText("");
                    inputcantidadProducto.setText("");
                    deshabilitarInput(inputnombreProducto);
                    buscarProducto();
                }
            }

            public void keyTyped(KeyEvent e){
            }
        };
        inputidProducto.addKeyListener(eventoKeyBuscarProducto);
	}

	public boolean validarNumero(String texto){
		int count = 0;
		for (int i=0; i<texto.length(); i++) {
			int codigo = (int) texto.charAt(i);
			if ((codigo<48 || codigo>57) && codigo!=44 && codigo!=45 && codigo!=46){
				return false;
			}
			if (codigo==44 || codigo==46){
				count++;
			}
		}
		return (count<=1);
	}

	public String formatoMoneda(String texto){
		Double numero = Double.parseDouble(texto.replace(",","."));
		NumberFormat formatoMoneda = NumberFormat.getCurrencyInstance(Locale.getDefault());
		return formatoMoneda.format(numero).replaceAll(",00","");
	}

	public void buscarCliente(){
		String texto = inputcedulaCliente.getText();
		boolean encontrado = false;
		for (int i=0; i<this.Clientes.length; i++) {
			if(this.Clientes[i]!=null && this.Clientes[i].getCedula().equalsIgnoreCase(texto)){
				this.inputnombresCliente.setText( this.Clientes[i].getNombres() );
				this.inputdireccionCliente.setText( this.Clientes[i].getDireccion() );
				encontrado = true;
				break;
			}
		}

		if(encontrado){
			deshabilitarInput(this.inputnombresCliente);
			deshabilitarInput(this.inputdireccionCliente);
			this.inputcedulaVendedor.requestFocus();
		}
	}	

	public void buscarVendedor(){
		String texto = inputcedulaVendedor.getText();
		boolean encontrado = false;
		for (int i=0; i<this.Vendedores.length; i++) {
			if(this.Vendedores[i]!=null && this.Vendedores[i].getCedula().equalsIgnoreCase(texto)){
				this.inputnombresVendedor.setText( this.Vendedores[i].getNombres() );
				encontrado = true;
				break;
			}
		}

		if(!encontrado){
			this.inputidProducto.setText("");
			deshabilitarInput(this.inputidProducto);
			this.inputnombreProducto.setText("");
			deshabilitarInput(this.inputnombreProducto);
			this.inputcantidadProducto.setText("");
			deshabilitarInput(this.inputcantidadProducto);

			this.inputnombresVendedor.setText("");
			this.inputcedulaVendedor.requestFocus();
		}else{
			this.inputidProducto.setText("");
			habilitarInput(this.inputidProducto);
			this.inputnombreProducto.setText("");
			deshabilitarInput(this.inputnombreProducto);
			this.inputcantidadProducto.setText("");
			habilitarInput(this.inputcantidadProducto);

			this.inputidProducto.requestFocus();
		}
	}

	public void buscarProducto(){
		String texto = inputidProducto.getText();
		boolean encontrado = false;
		for (int i=0; i<this.Productos.length; i++) {
			if(this.Productos[i]!=null && this.Productos[i].id==Integer.valueOf(texto) ){
				this.inputnombreProducto.setText( this.Productos[i].nombre );
				encontrado = true;
				break;
			}
		}

		if(!encontrado){
			this.inputnombreProducto.setText("");
			deshabilitarInput(this.inputnombreProducto);
			this.inputcantidadProducto.setText("");
			this.inputidProducto.requestFocus();
		}else{
			this.inputcantidadProducto.setText("");
			habilitarInput(this.inputcantidadProducto);
			this.inputcantidadProducto.requestFocus();
		}
	}

	public void deshabilitarInput(JTextField input){
		input.setEditable(false);
		input.setEnabled(false);
		input.setDisabledTextColor(Color.black);
	}

	public void habilitarInput(JTextField input){
		input.setText("");
		input.setEditable(true);
		input.setEnabled(true);
	}

}
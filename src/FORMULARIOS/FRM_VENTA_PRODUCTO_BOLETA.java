
package FORMULARIOS;
import BASE.conectaBD;
import java.awt.Color;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FRM_VENTA_PRODUCTO_BOLETA extends javax.swing.JFrame {
 
  conectaBD cnx = new conectaBD();
  

 Date ahora = new Date(System.currentTimeMillis());
 SimpleDateFormat fecha = new SimpleDateFormat("dd/MM/yyyy");

 String sql = "SELECT * FROM V_MANTENIMIENTO_PRODUCTO ORDER BY nombre";
 String sql21=" SELECT * FROM V_MANTENIMIENTO_PRODUCTO WHERE fecha_venci >'"+ahora+"' ORDER BY nombre";


 public void icono() {
  Image icon = Toolkit.getDefaultToolkit().getImage(getClass().getResource("/imagenes/home.png"));
  setIconImage(icon);
  setVisible(true);
 }
 
 public void MostrarTicket(){
     String cod,sql1;
     cod = this.jlblnumventa.getText();
       try{
         cod=this.jTblDetalleVenta.getValueAt(this.jTblDetalleVenta.getSelectedRow(),0).toString();
         sql1="SELECT * FROM V_TICKER WHERE idventa='"+cod+"'";
         cnx.rs=cnx.stm.executeQuery(sql1);
         if(cnx.rs.next()){
           FRM_TICKET.jlblcodigo.setText(cnx.rs.getString(1));
           FRM_TICKET.jlblcantidad.setText(cnx.rs.getString(2)); 
           FRM_TICKET.jlblprecio.setText(cnx.rs.getString(3));
           FRM_TICKET.jlblpreoducto.setText(cnx.rs.getString(4));
           FRM_TICKET.jlblfecha.setText(cnx.rs.getString(5));
         }
       }catch(Exception a){   
          System.out.println(a.getMessage());
        }  
 }
 
 
 
 public void Cajas(boolean estado) {
  this.jtxtbuscar.setEnabled(estado);
  this.jtbproducto.setEnabled(estado);
  this.jdcfecha.setEnabled(estado);
  this.jTblDetalleVenta.setEnabled(estado);
  this.jtxtnomempleado.setEnabled(estado);
  this.jbtne.setEnabled(estado);
  this.jtxtdni.setEnabled(estado);
  this.jBtnAgregar.setEnabled(estado);
  //this.jbtnimprimir.setEnabled(estado);
  this.jtxtcantidad.setEnabled(estado);
  this.jtbproducto.setEnabled(estado);
 }

 public void Botones(boolean estado) {
  this.jBtnNuevo.setEnabled(estado);
  this.jBtnGuardar.setEnabled(!estado);
  this.jBtnCancelar.setEnabled(!estado);
  this.jBtnQuitar.setEnabled(!estado);
  this.jBtnSalir.setEnabled(estado);
 }

 public void Limpiar() {
  this.jtxtbuscar.setText("");
  this.jtxtdni.setText("");
  this.jlblcliente.setText("");
  this.jlbldireccion.setText("");
  this.jlbltotal.setText("");
  this.jlblnumventa.setText("");
  this.jtxtbuscar.requestFocus();
  this.jlblcodproducto.setText("");
  this.jlblnomproducto.setText("");
  this.jlblprecio.setText("");
  this.jlblstock.setText("");
  this.jtxtcantidad.setText("1");
  this.jtxtnomempleado.setText("");
  
  DefaultTableModel tbl = (DefaultTableModel) jTblDetalleVenta.getModel();
  LimpiarTabla(tbl);
 }
 
 public void GenerarNumBoleta() {
  int reg = 0;
  String num = "", r = "";
  try {
   cnx.rs = cnx.stm.executeQuery("SELECT COUNT(*)+1 FROM VENTA");
   if (cnx.rs.next()) {
    reg = Integer.parseInt(cnx.rs.getString(1));
    if (reg >= 1 && reg < 10) {
     r = "000";
    } else {
     if (reg >= 10 && reg < 100) {
      r = "00";
     } else {
      if (reg >= 100 && reg < 1000) {
       r = "0";
      }
     }
    }
   }
   num = r + String.valueOf(reg);
   this.jlblnumventa.setText(num);
  } catch (Exception a) {
   System.out.println(a.getMessage());
  }
 }
 
 public void nopasarDobleP(){
            String total="",asien="";
            asien= jtbproducto.getValueAt(this.jtbproducto.getSelectedRow(),0).toString();
            int a=Integer.parseInt(asien);
            int b=0;
        for(int fila=0;fila<=this.jTblDetalleVenta.getRowCount()-1;fila++){
            total=(this.jTblDetalleVenta.getValueAt(fila,4).toString());
           b=Integer.parseInt(total);
            if(a==b){
                JOptionPane.showMessageDialog(null,"Producto Ya Existe En La Lista","",0);
                jtxtcantidad.setText("");
                fila=999;
            }
            else{    //pasar();
            }
        }   
    }

 
 
 
 
  public void CalcularTotal() {
  double total = 0;
  for (int fila = 0; fila <= this.jTblDetalleVenta.getRowCount() - 1; fila++) {
   total = total + Double.parseDouble(this.jTblDetalleVenta.getValueAt(fila, 3).toString());
  }
  this.jlbltotal.setText(String.valueOf(total));
 }
    
  
 public void MostrarProducto() {
  String cod, sql1;
  try {
   cod = this.jtbproducto.getValueAt(this.jtbproducto.getSelectedRow(), 0).toString();
   sql1 = "SELECT * FROM V_UTILIDAD WHERE idproducto='" + cod + "'";
   cnx.rs = cnx.stm.executeQuery(sql1);
   if (cnx.rs.next()) {
    this.jlblcodproducto.setText(cnx.rs.getString(1));
    this.jlblnomproducto.setText(cnx.rs.getString(2));
    this.jlblcosto.setText(cnx.rs.getString(3));
    this.jlblprecio.setText(cnx.rs.getString(4));
    this.jtxtvendera.setText(cnx.rs.getString(4));
    this.jlblutilidad.setText(cnx.rs.getString(5));
    this.jlblstock.setText(cnx.rs.getString(6));
   }
  } catch (Exception a) {
   System.out.println(a.getMessage());
  }
  
 }
 
 

 public void LimpiarTabla(DefaultTableModel tbl) {
  for (int x = tbl.getRowCount() - 1; x >= 0; x--) {
   tbl.removeRow(x);
  }
 }

 public void LlenarTabla(String sql) {
  try {
   cnx.rs = cnx.stm.executeQuery(sql);
   DefaultTableModel tbl = (DefaultTableModel) jtbproducto.getModel();
   LimpiarTabla(tbl);
   while (cnx.rs.next()) {
    String col1 = cnx.rs.getString(1);
    String col2 = cnx.rs.getString(2);
    String col3 = cnx.rs.getString(3);
    String col4 = cnx.rs.getString(4);
    String col5 = cnx.rs.getString(5);
    String col6 = cnx.rs.getString(6);
    String col7 = cnx.rs.getString(7);
    String col8 = cnx.rs.getString(8);
    
    Vector fila = new Vector();
    fila.addElement(col1);
    fila.addElement(col2);
    fila.addElement(col3);
    fila.addElement(col4);
    fila.addElement(col5);
    fila.addElement(col6);
    fila.addElement(col7);
    fila.addElement(col8);
    
    tbl.addRow(fila);
   }
  } catch (Exception e) {
   System.out.println(e.getMessage());
  }
 }
 
 public void solonumeros (JTextField a){
  a.addKeyListener(new KeyAdapter(){
    public void keyTyped (KeyEvent e){
    char c=e.getKeyChar();
    if(!Character.isDigit(c)){
     getToolkit().beep();
     e.consume();
    }     
            
   }
  }); 
 }
 
 

 public FRM_VENTA_PRODUCTO_BOLETA() {
  initComponents();
  this.setResizable(false);
  this.setLocationRelativeTo(this);
  solonumeros(this.jtxtdni);
//  solonumeros(this.jtxtcantidad);
 }
 

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jtxtbuscar = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbproducto = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jlblcodproducto = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlblnomproducto = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jlblprecio = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jlblstock = new javax.swing.JLabel();
        jBtnAgregar = new javax.swing.JButton();
        jtxtcantidad = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jlblcosto = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jlblutilidad = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtxtvendera = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jlblnumventa = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jtxtnomempleado = new javax.swing.JTextField();
        jbtne = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jtxtdni = new javax.swing.JTextField();
        jlblcliente = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jlbldireccion = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jBtnNuevo = new javax.swing.JButton();
        jBtnGuardar = new javax.swing.JButton();
        jBtnCancelar = new javax.swing.JButton();
        jBtnSalir = new javax.swing.JButton();
        jBtnQuitar = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jlbltotal = new javax.swing.JLabel();
        jpane = new javax.swing.JPanel();
        jtxtcodcliente = new javax.swing.JTextField();
        jtxtcodempleado = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTblDetalleVenta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("VENTA DE PRODUCTOS ");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
                formWindowLostFocus(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("BUSCAR PRODUCTO");

        jtxtbuscar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtbuscar.setForeground(new java.awt.Color(0, 0, 255));
        jtxtbuscar.setToolTipText("BUSCAR  PRODUTO");
        jtxtbuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtbuscarKeyReleased(evt);
            }
        });

        jtbproducto.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jtbproducto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CODIGO", "NOMBRE", "COSTO", "PRECIO", "STOCK", "FECHA V", "MARCA", "CATEGORIA"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbproducto.setToolTipText("LISTADE PRODUCTOS");
        jtbproducto.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbproductoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbproducto);
        if (jtbproducto.getColumnModel().getColumnCount() > 0) {
            jtbproducto.getColumnModel().getColumn(0).setMinWidth(80);
            jtbproducto.getColumnModel().getColumn(0).setMaxWidth(50);
            jtbproducto.getColumnModel().getColumn(1).setMinWidth(200);
            jtbproducto.getColumnModel().getColumn(1).setMaxWidth(180);
            jtbproducto.getColumnModel().getColumn(2).setMinWidth(60);
            jtbproducto.getColumnModel().getColumn(2).setMaxWidth(40);
        }

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "DATOS-PRODUCTO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(51, 0, 255))); // NOI18N
        jPanel1.setToolTipText("DATOS DEL PRODUCTO");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel7.setText("CODIGO");

        jlblcodproducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblcodproducto.setForeground(new java.awt.Color(0, 0, 204));
        jlblcodproducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblcodproducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel8.setText("PRODUCTO");

        jlblnomproducto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblnomproducto.setForeground(new java.awt.Color(0, 0, 204));
        jlblnomproducto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblnomproducto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel9.setText("PRECIO");

        jlblprecio.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblprecio.setForeground(new java.awt.Color(0, 0, 204));
        jlblprecio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblprecio.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel11.setText("CANTIDAD");

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel12.setText("STOCK");

        jlblstock.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblstock.setForeground(new java.awt.Color(0, 0, 204));
        jlblstock.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblstock.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jBtnAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/check_mark_32x32.png"))); // NOI18N
        jBtnAgregar.setText("AGREGAR");
        jBtnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnAgregarActionPerformed(evt);
            }
        });

        jtxtcantidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtcantidad.setText("1");
        jtxtcantidad.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtcantidadKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtxtcantidadKeyReleased(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel13.setText("COSTO");

        jlblcosto.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblcosto.setForeground(new java.awt.Color(0, 0, 255));
        jlblcosto.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblcosto.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel14.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel14.setText("UTILIDAD");

        jlblutilidad.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblutilidad.setForeground(new java.awt.Color(0, 0, 255));
        jlblutilidad.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblutilidad.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel15.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel15.setText("VENDER A");

        jtxtvendera.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jtxtvendera.setForeground(new java.awt.Color(51, 51, 255));
        jtxtvendera.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jtxtvendera.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtvenderaKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel15))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlblcodproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblnomproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlblcosto, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxtvendera, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel11))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblprecio, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel14)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jlblutilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel12)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jlblstock, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jtxtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)
                                .addComponent(jBtnAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jlblcodproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel8)
                    .addComponent(jlblnomproducto, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlblcosto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jlblutilidad, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblprecio, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(jlblstock, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel12)
                    .addComponent(jLabel14))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtxtcantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel15)
                    .addComponent(jtxtvendera, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jBtnAgregar))
                .addGap(7, 7, 7))
        );

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel2.setText("N° BOLETA DE VENTA");

        jlblnumventa.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblnumventa.setForeground(new java.awt.Color(0, 0, 204));
        jlblnumventa.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblnumventa.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel3.setText("FECHA");

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "DATOS-EMPLEADO", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel2.setToolTipText("DATOS DEL EMPLEADO");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel6.setText("NOMBRE");

        jtxtnomempleado.setEditable(false);
        jtxtnomempleado.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtnomempleado.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jtxtnomempleado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jbtne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/iempleado.jpg"))); // NOI18N
        jbtne.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtneActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtxtnomempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtne, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(43, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jbtne, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtnomempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "DATOS-CLIENTE", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N
        jPanel3.setToolTipText("DATOS DEL CLIENTE");

        jLabel4.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel4.setText("DPI");

        jtxtdni.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jtxtdni.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtdniActionPerformed(evt);
            }
        });
        jtxtdni.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtxtdniKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jtxtdniKeyTyped(evt);
            }
        });

        jlblcliente.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlblcliente.setForeground(new java.awt.Color(0, 0, 204));
        jlblcliente.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlblcliente.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel5.setText("DIRECCION");

        jlbldireccion.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jlbldireccion.setForeground(new java.awt.Color(0, 0, 204));
        jlbldireccion.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbldireccion.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(22, 22, 22)
                        .addComponent(jtxtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlblcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlblcliente, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtxtdni, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel5))
                    .addComponent(jlbldireccion, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1), "OPCIONES", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14), new java.awt.Color(0, 0, 255))); // NOI18N

        jBtnNuevo.setBackground(new java.awt.Color(102, 255, 102));
        jBtnNuevo.setFont(new java.awt.Font("Arial Narrow", 1, 13)); // NOI18N
        jBtnNuevo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/nuevo.png"))); // NOI18N
        jBtnNuevo.setText("NUEVO");
        jBtnNuevo.setToolTipText("NUEVA VENTA");
        jBtnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnNuevoActionPerformed(evt);
            }
        });

        jBtnGuardar.setBackground(new java.awt.Color(102, 255, 102));
        jBtnGuardar.setFont(new java.awt.Font("Arial Narrow", 1, 13)); // NOI18N
        jBtnGuardar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/guardar.png"))); // NOI18N
        jBtnGuardar.setText("GUARDAR");
        jBtnGuardar.setToolTipText("GUARDAR VENTA");
        jBtnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnGuardarActionPerformed(evt);
            }
        });

        jBtnCancelar.setBackground(new java.awt.Color(102, 255, 102));
        jBtnCancelar.setFont(new java.awt.Font("Arial Narrow", 1, 13)); // NOI18N
        jBtnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/eliminar.gif"))); // NOI18N
        jBtnCancelar.setText("CANCELAR");
        jBtnCancelar.setToolTipText("CANCELAR VENTA");
        jBtnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnCancelarActionPerformed(evt);
            }
        });

        jBtnSalir.setBackground(new java.awt.Color(102, 255, 102));
        jBtnSalir.setFont(new java.awt.Font("Arial Narrow", 1, 13)); // NOI18N
        jBtnSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Salir.JPG"))); // NOI18N
        jBtnSalir.setText("SALIR");
        jBtnSalir.setToolTipText("SALIR SIN GURDAR");
        jBtnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnSalirActionPerformed(evt);
            }
        });

        jBtnQuitar.setBackground(new java.awt.Color(102, 255, 102));
        jBtnQuitar.setFont(new java.awt.Font("Arial Narrow", 1, 13)); // NOI18N
        jBtnQuitar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/eliminar.png"))); // NOI18N
        jBtnQuitar.setText("QUITAR");
        jBtnQuitar.setToolTipText("QUITAR PRODUCTO DE LA LISTA");
        jBtnQuitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBtnQuitarActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("TOTAL");

        jlbltotal.setBackground(new java.awt.Color(255, 255, 204));
        jlbltotal.setFont(new java.awt.Font("Arial Narrow", 1, 30)); // NOI18N
        jlbltotal.setForeground(new java.awt.Color(255, 0, 0));
        jlbltotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jlbltotal.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jlbltotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jlbltotalKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jBtnQuitar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnNuevo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                        .addComponent(jBtnSalir, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jBtnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jBtnNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jBtnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jBtnQuitar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jBtnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jlbltotal, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jtxtcodcliente.setBackground(new java.awt.Color(240, 240, 240));

        jtxtcodempleado.setBackground(new java.awt.Color(240, 240, 240));

        javax.swing.GroupLayout jpaneLayout = new javax.swing.GroupLayout(jpane);
        jpane.setLayout(jpaneLayout);
        jpaneLayout.setHorizontalGroup(
            jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jpaneLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jtxtcodempleado, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtxtcodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(22, 22, 22))
        );
        jpaneLayout.setVerticalGroup(
            jpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jtxtcodcliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jtxtcodempleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        jTblDetalleVenta.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jTblDetalleVenta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "CANTIDAD", "PRODUCTO", "PRECIO", "IMPORTE", "COD"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTblDetalleVenta.setToolTipText("PRODUCTOS A VENDER");
        jTblDetalleVenta.getTableHeader().setReorderingAllowed(false);
        jTblDetalleVenta.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTblDetalleVentaKeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTblDetalleVenta);
        if (jTblDetalleVenta.getColumnModel().getColumnCount() > 0) {
            jTblDetalleVenta.getColumnModel().getColumn(0).setMinWidth(90);
            jTblDetalleVenta.getColumnModel().getColumn(0).setMaxWidth(60);
            jTblDetalleVenta.getColumnModel().getColumn(1).setMinWidth(200);
            jTblDetalleVenta.getColumnModel().getColumn(1).setMaxWidth(180);
            jTblDetalleVenta.getColumnModel().getColumn(4).setMinWidth(0);
            jTblDetalleVenta.getColumnModel().getColumn(4).setMaxWidth(0);
        }

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(15, 15, 15)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jpane, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(16, 16, 16)
                                .addComponent(jlblnumventa, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(932, 932, 932)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(542, 542, 542)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 430, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jtxtbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(6, 6, 6)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(jpane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jlblnumventa, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(4, 4, 4)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 
 public void agregarproducto(){
     try{
     if (this.jlblcodproducto.getText().equals("")) {
       JOptionPane.showMessageDialog(null, "SELECCIONE PRODUCTO", "Aviso", 0);
       this.jtxtbuscar.requestFocus();
       return;
     }
     if (this.jtxtcantidad.getText().equals("")) {
        JOptionPane.showMessageDialog(null, "Ingrese cantidad", "Aviso", 0);
       this.jtxtbuscar.requestFocus();
       return;
     }
      
  else{
  int cant,stock;
  double precio;
  cant=Integer.parseInt(this.jtxtcantidad.getText());
  stock=Integer.parseInt(this.jlblstock.getText());
      
 if(cant<=0){
   JOptionPane.showMessageDialog(null,"INGRESE CANTIDAD MAYOR A 0","Aviso",1);
   this.jtxtcantidad.requestFocus();
   this.jtxtcantidad.setText("");
   return;
  }
     
  if(cant>stock){
   JOptionPane.showMessageDialog(null,"NO CUENTA CON EL STOCK NECESARIO","Aviso",0);
   this.jtxtcantidad.requestFocus();
   return;
  }
  String cantidad=this.jtxtcantidad.getText();
  String nomproducto=this.jlblnomproducto.getText();
  String preciou=this.jtxtvendera.getText();
  String cod = this.jlblcodproducto.getText();
  Double col4=Double.parseDouble(preciou)*Integer.parseInt(cantidad);
 
  DefaultTableModel modelo=(DefaultTableModel)jTblDetalleVenta.getModel();
  
  Vector vRow=new Vector();
  
  vRow.addElement(cantidad);
  vRow.addElement(nomproducto);
  vRow.addElement(preciou);
  vRow.addElement(col4);
  vRow.addElement(cod);
  
  modelo.addRow(vRow);
  
  CalcularTotal();
  
  this.jlblcodproducto.setText("");
  this.jlblnomproducto.setText("");
  this.jlblprecio.setText("");
  this.jlblstock.setText("");
  this.jtxtcantidad.setText("1");
   this.jtxtvendera.setText("");
  this.jlblutilidad.setText("");
  this.jtxtbuscar.requestFocus();
     

   }
          
  }
  catch(Exception e){
   System.out.println(e.getMessage());
  
  
  }  
 
 }
 private void jBtnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnAgregarActionPerformed
   
     try{
       
       nopasarDobleP();
       if(jtxtcantidad.getText().isEmpty()){
          
       return;
       }else{
          agregarproducto();   
       }
                                       
   }
   catch(Exception e){
       System.out.println(e.getMessage());
   }
 }//GEN-LAST:event_jBtnAgregarActionPerformed

 private void jbtneActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtneActionPerformed
FRM_EMPLEADO_PASAR E=new FRM_EMPLEADO_PASAR();
E.show();
 }//GEN-LAST:event_jbtneActionPerformed

 private void jtxtdniKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyPressed
if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
   String sql, dni;
   dni = this.jtxtdni.getText();
   sql = "SELECT * FROM CLIENTE WHERE dni='" + dni + "'";
   try {
    cnx.rs = cnx.stm.executeQuery(sql);
    if (cnx.rs.next()) {
     this.jtxtcodcliente.setText(cnx.rs.getString(1));
     this.jtxtdni.setText(cnx.rs.getString(2));
     this.jlblcliente.setText(cnx.rs.getString(3)); 
     this.jlbldireccion.setText(cnx.rs.getString(7)); 
     this.jtxtdni.requestFocus();
    } else {
     int r;
     r = JOptionPane.showConfirmDialog(null, "DESEA REGISTRAR CLIENTE", "Actualizar Datos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     if (r == JOptionPane.YES_OPTION) {
      FRM_CLIENTE_NUEVO cliente = new FRM_CLIENTE_NUEVO();
      FRM_CLIENTE_NUEVO.jtxtdni.setText(dni);
      cliente.show();
     } else {
      this.jtxtdni.requestFocus();
     }
    }

   } catch (Exception e) {
    System.out.println(e.getMessage());
   }
  }
 }//GEN-LAST:event_jtxtdniKeyPressed

 private void jBtnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnNuevoActionPerformed
    Cajas(true);
     Botones(false);
     GenerarNumBoleta();
 }//GEN-LAST:event_jBtnNuevoActionPerformed
public void guardar(){
  int r, fila, col5;
     String nompro, col1, col2, col3,col8, col4 = "", sql1, sql2, sql3;
     double col6;
     try {
      if (this.jtxtcodcliente.getText().equals("")) {
       JOptionPane.showMessageDialog(null, "REGISTRE CLIENTE", "Aviso", 0);
       this.jtxtdni.requestFocus();
       return;
      }
       if (this.jtxtcodempleado.getText().equals("")) {
       JOptionPane.showMessageDialog(null, "SELECCIONE EMPLEADO", "Aviso", 0);
       this.jbtne.requestFocus();
       return;
      }

      if (this.jTblDetalleVenta.getRowCount() == 0) {
       JOptionPane.showMessageDialog(null, "No existe ningún Producto en la lista", "Aviso", 0);
       this.jtxtbuscar.requestFocus();
       return;
      }
      //r = JOptionPane.showConfirmDialog(null, "Registrar Venta", "Guardar Datos", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
     // if (r == JOptionPane.YES_OPTION) {
       col1 = this.jlblnumventa.getText();
       col2 = fecha.format(this.jdcfecha.getDate());
       col8 = this.jtxtcodempleado.getText();
       col3 = this.jtxtcodcliente.getText();
       
       sql1 = "INSERT VENTA VALUES('" + col1 + "','" + col2 + "','" + col8 + "','" + col3 + "')";
       cnx.stm.execute(sql1);
       
       for (fila = 0; fila <= this.jTblDetalleVenta.getRowCount() - 1; fila++) {
        nompro = this.jTblDetalleVenta.getValueAt(fila, 1).toString();
        sql1 = " SELECT * FROM V_MANTENIMIENTO_PRODUCTO WHERE nombre='" + nompro + "'";
        cnx.rs = cnx.stm.executeQuery(sql1);
        if (cnx.rs.next()) {
         col4 = cnx.rs.getString(1);
        }
        col5 = Integer.parseInt(this.jTblDetalleVenta.getValueAt(fila, 0).toString());
        col6 = Double.parseDouble(this.jTblDetalleVenta.getValueAt(fila, 2).toString());
        sql2 = "INSERT DETALLE_VENTA VALUES('" + col1 + "','" + col4 + "'," + col5 + ",'" + col6 + "')";
        sql3 = "UPDATE PRODUCTO SET stock = stock-'" + col5 + "' WHERE idproducto='" + col4 + "'";
        cnx.stm.execute(sql2);
        cnx.stm.execute(sql3);
       }
       JOptionPane.showMessageDialog(null, "La Venta se realizo satisfactoriamente", "Registro de Datos", 1);
      //}
     } catch (SQLException a) {
      System.out.println(a.getMessage());
     }
     Cajas(false);
     Botones(true);
     Limpiar();
     LlenarTabla(sql21);
     
}
 private void jBtnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnGuardarActionPerformed
try{
 guardar();
} 
catch(Exception e){
 System.out.println(e.getMessage());
}
 }//GEN-LAST:event_jBtnGuardarActionPerformed

 private void jBtnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnCancelarActionPerformed
     Cajas(false);
     Botones(true);
     Limpiar();
 }//GEN-LAST:event_jBtnCancelarActionPerformed

 private void jBtnQuitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnQuitarActionPerformed
int fila, r;
try{
     DefaultTableModel tbl = (DefaultTableModel) jTblDetalleVenta.getModel();
   
      fila = this.jTblDetalleVenta.getSelectedRow();
      tbl.removeRow(fila);
      CalcularTotal();
     
}
     catch(Exception e){
           JOptionPane.showMessageDialog(null, "SELECCIONE FILA A QUITAR","QUITAR",1);
             }
 }//GEN-LAST:event_jBtnQuitarActionPerformed

 private void jBtnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBtnSalirActionPerformed
  dispose();
 }//GEN-LAST:event_jBtnSalirActionPerformed

 private void jtxtdniActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtdniActionPerformed
  // TODO add your handling code here:
 }//GEN-LAST:event_jtxtdniActionPerformed

 private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
cnx.conectar();
     
 icono();
 this.jdcfecha.setDate(ahora);
 Cajas(false);
 Botones(true);
 this.jtxtbuscar.requestFocus();
 this.jtxtcodempleado.setVisible(false);
 this.jtxtcodcliente.setVisible(false);
// this.jtxtcantidad.setText("0");
 LlenarTabla(sql21);
 
 }//GEN-LAST:event_formWindowOpened

 private void jtbproductoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbproductoMouseClicked
 MostrarProducto();
 }//GEN-LAST:event_jtbproductoMouseClicked

 private void jtxtbuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyPressed
   
 }//GEN-LAST:event_jtxtbuscarKeyPressed

 private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
 CalcularTotal();
 }//GEN-LAST:event_formWindowActivated

 private void jlbltotalKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlbltotalKeyReleased

 }//GEN-LAST:event_jlbltotalKeyReleased

    private void formWindowLostFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowLostFocus
        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowLostFocus

    private void jtxtdniKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtdniKeyTyped
        String Caracteres = jtxtdni.getText();
  if(Caracteres.length()>=8){
   evt.consume();
  }
    }//GEN-LAST:event_jtxtdniKeyTyped

    private void jtxtbuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtbuscarKeyReleased
        String dato = this.jtxtbuscar.getText();
     String sql1 =  " SELECT * FROM V_MANTENIMIENTO_PRODUCTO WHERE nombre LIKE '%" + dato + "%' AND fecha_venci >'"+ahora+"'";
     LlenarTabla(sql1);
    }//GEN-LAST:event_jtxtbuscarKeyReleased

    private void jtxtvenderaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtvenderaKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
   this.jtxtcantidad.requestFocus();
  }
    }//GEN-LAST:event_jtxtvenderaKeyPressed

    private void jtxtcantidadKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcantidadKeyPressed
//        if(evt.getKeyCode()==KeyEvent.VK_ENTER){
//   double precio,costo,utilidad;
//   int cantidad;
//   cantidad=Integer.parseInt(this.jtxtcantidad.getText());
//   costo=Double.parseDouble(this.jlblcosto.getText());
//   precio=Double.parseDouble(this.jtxtvendera.getText());
//   utilidad= 0;
//   DecimalFormat u=new DecimalFormat("######.00");
//  try{
//   utilidad=(double)((precio-costo)*cantidad);
//  this.jlblutilidad.setText(String.valueOf(utilidad));
//  this.jlblutilidad.setText(u.format(utilidad));
//   if (utilidad<=0){
//    jlblutilidad.setForeground(Color.red); 
//    }
//   else{
//     jlblutilidad.setForeground(Color.black);
//   }  
//  } 
//  catch(Exception e){
//   JOptionPane.showMessageDialog(null,"","",0);
//  }  
// }
    }//GEN-LAST:event_jtxtcantidadKeyPressed

    private void jtxtcantidadKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtxtcantidadKeyReleased
    try{
   double precio,costo,utilidad;
   int cantidad;
   
   cantidad=Integer.parseInt(this.jtxtcantidad.getText());
   costo=Double.parseDouble(this.jlblcosto.getText());
   precio=Double.parseDouble(this.jtxtvendera.getText());
   utilidad= 0;
   DecimalFormat u=new DecimalFormat("#####0.00");
 
   utilidad=(double)((precio-costo)*cantidad);
  this.jlblutilidad.setText(String.valueOf(utilidad));
  this.jlblutilidad.setText(u.format(utilidad));
   
   if (utilidad<=0){
    jlblutilidad.setForeground(Color.red); 
    }
   else{
     jlblutilidad.setForeground(Color.black);
   }  
  } 
  catch(Exception e){
      System.out.println(e.getMessage());
  }  
    }//GEN-LAST:event_jtxtcantidadKeyReleased

    private void jTblDetalleVentaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTblDetalleVentaKeyPressed
       if(evt.getKeyCode()==KeyEvent.VK_ENTER){
  double t,total=0;
  int c=Integer.parseInt(this.jTblDetalleVenta.getValueAt(this.jTblDetalleVenta.getSelectedRow(),0).toString());
  Double p=Double.parseDouble(this.jTblDetalleVenta.getValueAt(this.jTblDetalleVenta.getSelectedRow(),2).toString());
  t=c*p;
  this.jTblDetalleVenta.setValueAt(String.valueOf(t), this.jTblDetalleVenta.getSelectedRow(), 3);
  }
       CalcularTotal();
    }//GEN-LAST:event_jTblDetalleVentaKeyPressed


 public static void main(String args[]) {
  
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_VENTA_PRODUCTO_BOLETA().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBtnAgregar;
    private javax.swing.JButton jBtnCancelar;
    private javax.swing.JButton jBtnGuardar;
    private javax.swing.JButton jBtnNuevo;
    private javax.swing.JButton jBtnQuitar;
    private javax.swing.JButton jBtnSalir;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    public static javax.swing.JTable jTblDetalleVenta;
    private javax.swing.JButton jbtne;
    public static javax.swing.JLabel jlblcliente;
    public static javax.swing.JLabel jlblcodproducto;
    private javax.swing.JLabel jlblcosto;
    public static javax.swing.JLabel jlbldireccion;
    public static javax.swing.JLabel jlblnomproducto;
    private javax.swing.JLabel jlblnumventa;
    public static javax.swing.JLabel jlblprecio;
    protected static javax.swing.JLabel jlblstock;
    private javax.swing.JLabel jlbltotal;
    private javax.swing.JLabel jlblutilidad;
    private javax.swing.JPanel jpane;
    private javax.swing.JTable jtbproducto;
    private javax.swing.JTextField jtxtbuscar;
    private javax.swing.JTextField jtxtcantidad;
    public static javax.swing.JTextField jtxtcodcliente;
    public static javax.swing.JTextField jtxtcodempleado;
    public static javax.swing.JTextField jtxtdni;
    public static javax.swing.JTextField jtxtnomempleado;
    private javax.swing.JTextField jtxtvendera;
    // End of variables declaration//GEN-END:variables
private com.toedter.calendar.JDateChooser jdcfecha;
}

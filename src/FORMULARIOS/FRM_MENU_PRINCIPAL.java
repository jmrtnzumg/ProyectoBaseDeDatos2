
package FORMULARIOS;

import Base.Conectar;
import java.security.Principal;
import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
//import net.sf.jasperreports.engine.JRException;
//import net.sf.jasperreports.engine.JasperFillManager;
//import net.sf.jasperreports.engine.JasperPrint;
//import net.sf.jasperreports.engine.JasperReport;
//import net.sf.jasperreports.engine.util.JRLoader;
//import net.sf.jasperreports.view.JasperViewer;
public class FRM_MENU_PRINCIPAL extends javax.swing.JFrame {
     Conectar c= new Conectar();
      Connection cn = c.conexion();
                       
 public FRM_MENU_PRINCIPAL() {
  initComponents();
  this.setResizable(false);
  this.setLocationRelativeTo(this);
 }

 @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLblNombre = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMMantenimiento = new javax.swing.JMenu();
        jMiCliente1 = new javax.swing.JMenuItem();
        jMiProducto1 = new javax.swing.JMenuItem();
        jMiMarca1 = new javax.swing.JMenuItem();
        jMiCategoria1 = new javax.swing.JMenuItem();
        jMiEmpleado1 = new javax.swing.JMenuItem();
        jMiCargo1 = new javax.swing.JMenuItem();
        jMTransaciones = new javax.swing.JMenu();
        jMiVentaProd = new javax.swing.JMenuItem();
        jMConsultas = new javax.swing.JMenu();
        jMiVentas = new javax.swing.JMenuItem();
        jMiVencimientoPr = new javax.swing.JMenuItem();
        jMiClientes = new javax.swing.JMenuItem();
        jMiProductos = new javax.swing.JMenuItem();
        jMiMarca = new javax.swing.JMenuItem();
        jMiCategoria = new javax.swing.JMenuItem();
        jMiEmpleado = new javax.swing.JMenuItem();
        jMiCargo = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMRepotes = new javax.swing.JMenu();
        jMiReporteDia = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMsalir = new javax.swing.JMenu();
        jMiSalir = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("BODEGA_UMG");
        setBackground(new java.awt.Color(204, 255, 204));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLblNombre.setFont(new java.awt.Font("Tahoma", 1, 48)); // NOI18N
        jLblNombre.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLblNombre.setText("SISTEMA DE BODEGA UMG BD2");

        jLabel1.setBackground(new java.awt.Color(0, 204, 204));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/BODEGAUMG.jpeg"))); // NOI18N

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jMMantenimiento.setBackground(new java.awt.Color(204, 204, 204));
        jMMantenimiento.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMMantenimiento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo.png"))); // NOI18N
        jMMantenimiento.setText("INSERCIONES");
        jMMantenimiento.setToolTipText("Mantenimiento ");
        jMMantenimiento.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMMantenimiento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiCliente1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiCliente1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCliente1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/user.gif"))); // NOI18N
        jMiCliente1.setText("CLIENTE");
        jMiCliente1.setToolTipText("Mantenimiento Cliente");
        jMiCliente1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCliente1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCliente1);

        jMiProducto1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiProducto1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiProducto1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/producto.png"))); // NOI18N
        jMiProducto1.setText("PRODUCTO");
        jMiProducto1.setToolTipText("Mantenimiento Producto");
        jMiProducto1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiProducto1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiProducto1);

        jMiMarca1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiMarca1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiMarca1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/marca.png"))); // NOI18N
        jMiMarca1.setText("MARCA");
        jMiMarca1.setToolTipText("Mantenimineto Categoria");
        jMiMarca1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiMarca1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiMarca1);

        jMiCategoria1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_D, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiCategoria1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCategoria1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/categoria.png"))); // NOI18N
        jMiCategoria1.setText("CATEGORIA");
        jMiCategoria1.setToolTipText("Mantenimineto Categoria");
        jMiCategoria1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCategoria1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCategoria1);

        jMiEmpleado1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiEmpleado1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiEmpleado1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/usuariohoy.png"))); // NOI18N
        jMiEmpleado1.setText("EMPLEADO");
        jMiEmpleado1.setToolTipText("Mantenimiento Empleado");
        jMiEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiEmpleado1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiEmpleado1);

        jMiCargo1.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiCargo1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCargo1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/maletin.png"))); // NOI18N
        jMiCargo1.setText("CARGO");
        jMiCargo1.setToolTipText("Mantenimineto Categoria");
        jMiCargo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCargo1ActionPerformed(evt);
            }
        });
        jMMantenimiento.add(jMiCargo1);

        jMenuBar1.add(jMMantenimiento);

        jMTransaciones.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMTransaciones.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/proceso.png"))); // NOI18N
        jMTransaciones.setText("EGRESOS");
        jMTransaciones.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMTransaciones.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMTransaciones.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiVentaProd.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiVentaProd.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiVentaProd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/nuevo.png"))); // NOI18N
        jMiVentaProd.setText("VENTA_PRODUCTOS");
        jMiVentaProd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiVentaProdActionPerformed(evt);
            }
        });
        jMTransaciones.add(jMiVentaProd);

        jMenuBar1.add(jMTransaciones);

        jMConsultas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMConsultas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMConsultas.setText("CONSULTAS");
        jMConsultas.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMConsultas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiVentas.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiVentas.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiVentas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMiVentas.setText("VENTAS");
        jMiVentas.setToolTipText("Consulta Ventas");
        jMiVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiVentasActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiVentas);

        jMiVencimientoPr.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        jMiVencimientoPr.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiVencimientoPr.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMiVencimientoPr.setText("VENCIMIENTO_PRODUCTOS");
        jMiVencimientoPr.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiVencimientoPrActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiVencimientoPr);

        jMiClientes.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiClientes.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiClientes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMiClientes.setText("CLIENTES");
        jMiClientes.setToolTipText("Consulta Clientes");
        jMiClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiClientesActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiClientes);

        jMiProductos.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_K, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiProductos.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiProductos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMiProductos.setText("PRODUCTO");
        jMiProductos.setToolTipText("Consulta Producto");
        jMiProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiProductosActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiProductos);

        jMiMarca.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiMarca.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiMarca.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMiMarca.setText("MARCA");
        jMiMarca.setToolTipText("Consulta Empleado");
        jMiMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiMarcaActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiMarca);

        jMiCategoria.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiCategoria.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCategoria.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMiCategoria.setText("CATEGORIA");
        jMiCategoria.setToolTipText("Consulta Empleado");
        jMiCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCategoriaActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiCategoria);

        jMiEmpleado.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiEmpleado.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMiEmpleado.setText("EMPLEADO");
        jMiEmpleado.setToolTipText("Consulta Empleado");
        jMiEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiEmpleadoActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiEmpleado);

        jMiCargo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_L, java.awt.event.InputEvent.ALT_DOWN_MASK));
        jMiCargo.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMiCargo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/buscar.png"))); // NOI18N
        jMiCargo.setText("CARGO");
        jMiCargo.setToolTipText("Consulta Empleado");
        jMiCargo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiCargoActionPerformed(evt);
            }
        });
        jMConsultas.add(jMiCargo);

        jMenuItem3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jMenuItem3.setText("GANANCIA");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMConsultas.add(jMenuItem3);

        jMenuBar1.add(jMConsultas);

        jMRepotes.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMRepotes.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/notebook_32x32.png"))); // NOI18N
        jMRepotes.setText("REPORTES");
        jMRepotes.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMRepotes.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiReporteDia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/editar.jpg"))); // NOI18N
        jMiReporteDia.setText("REPORTE DIARIO");
        jMiReporteDia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiReporteDiaActionPerformed(evt);
            }
        });
        jMRepotes.add(jMiReporteDia);

        jMenuItem1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/usuariohoy.png"))); // NOI18N
        jMenuItem1.setText("EMPLEADO");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMRepotes.add(jMenuItem1);

        jMenuItem2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/producto.png"))); // NOI18N
        jMenuItem2.setText("PRODUCTO");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMRepotes.add(jMenuItem2);

        jMenuBar1.add(jMRepotes);

        jMsalir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jMsalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Salir.JPG"))); // NOI18N
        jMsalir.setText("SALIR");
        jMsalir.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jMsalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);

        jMiSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/IMAGENES/Salir.JPG"))); // NOI18N
        jMiSalir.setText("SALIR");
        jMiSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMiSalirActionPerformed(evt);
            }
        });
        jMsalir.add(jMiSalir);

        jMenuBar1.add(jMsalir);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleName("BODEGA_UMG");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 1070, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 890, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLblNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 475, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

 private void jMiCliente1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCliente1ActionPerformed
  FRM_MANTENIMIENTO_CLIENTE cliente = new FRM_MANTENIMIENTO_CLIENTE();
  cliente.show();
 }//GEN-LAST:event_jMiCliente1ActionPerformed

 private void jMiProducto1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiProducto1ActionPerformed
  FRM_MANTENIMIENTO_PRODUCTO producto = new FRM_MANTENIMIENTO_PRODUCTO();
  producto.show();
 }//GEN-LAST:event_jMiProducto1ActionPerformed

 private void jMiEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiEmpleado1ActionPerformed
  FRM_MANTENIMIENTO_EMPLEADO empleado = new FRM_MANTENIMIENTO_EMPLEADO();
  empleado.show();
 }//GEN-LAST:event_jMiEmpleado1ActionPerformed

 private void jMiCategoria1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCategoria1ActionPerformed
  FRM_MANTENIMIENTO_CATEGORIA categori = new FRM_MANTENIMIENTO_CATEGORIA();
  categori.show();
 }//GEN-LAST:event_jMiCategoria1ActionPerformed

 private void jMiVentaProdActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiVentaProdActionPerformed
  FRM_VENTA_PRODUCTO_BOLETA venta = new FRM_VENTA_PRODUCTO_BOLETA();
  venta.show();
 }//GEN-LAST:event_jMiVentaProdActionPerformed

 private void jMiProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiProductosActionPerformed
FRM_CONSULTA_PRODUCTO producto=new FRM_CONSULTA_PRODUCTO();
producto.show();
 }//GEN-LAST:event_jMiProductosActionPerformed

 private void jMiEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiEmpleadoActionPerformed
 FRM_CONSULTA_EMPLEADO empleado =new FRM_CONSULTA_EMPLEADO();
 empleado.show();
 }//GEN-LAST:event_jMiEmpleadoActionPerformed

 private void jMiClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiClientesActionPerformed
 FRM_CONSULTA_CLIENTES cliente=new FRM_CONSULTA_CLIENTES();
 cliente.show();
 }//GEN-LAST:event_jMiClientesActionPerformed

 private void jMiReporteDiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiReporteDiaActionPerformed
FRM_VENTA_DIA dia=new FRM_VENTA_DIA();
dia.show();
 }//GEN-LAST:event_jMiReporteDiaActionPerformed

 private void jMiMarca1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiMarca1ActionPerformed
FRM_MANTENIMIENTO_MARCA M=new FRM_MANTENIMIENTO_MARCA(); 
M.show();
 }//GEN-LAST:event_jMiMarca1ActionPerformed

 private void jMiCargo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCargo1ActionPerformed
  FRM_MANTENIMIENTO_CARGO C=new FRM_MANTENIMIENTO_CARGO();
  C.show();
 }//GEN-LAST:event_jMiCargo1ActionPerformed

 private void jMiMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiMarcaActionPerformed
  FRM_CONSULTA_MARCA M=new FRM_CONSULTA_MARCA();
  M.show();
 }//GEN-LAST:event_jMiMarcaActionPerformed

 private void jMiCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCategoriaActionPerformed
  FRM_CONSULTA_CATEGORIA C=new FRM_CONSULTA_CATEGORIA();
  C.show();
 }//GEN-LAST:event_jMiCategoriaActionPerformed

 private void jMiCargoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiCargoActionPerformed
  FRM_CONSULTA_CARGO CARGO=new FRM_CONSULTA_CARGO();
  CARGO.show();
 }//GEN-LAST:event_jMiCargoActionPerformed

    private void jMiVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiVentasActionPerformed
       FRM_CONSULTA_VENTAS ventas = new FRM_CONSULTA_VENTAS();
       ventas.show();
    }//GEN-LAST:event_jMiVentasActionPerformed

    private void jMiVencimientoPrActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiVencimientoPrActionPerformed
        FRM_VENCIMIENTO_PRODUCTO producto = new FRM_VENCIMIENTO_PRODUCTO();
        producto.show();
    }//GEN-LAST:event_jMiVencimientoPrActionPerformed

    private void jMiSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMiSalirActionPerformed
        dispose();
    }//GEN-LAST:event_jMiSalirActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
//       JasperReport reporte;
//        String path = "src\\REPORTES\\Reporte_Empleado.jasper";
//     try {
//            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); //Cargo el reporte al objeto
//            JasperPrint jprint = JasperFillManager.fillReport(path, null, cn); //Llenado del Reporte con Tres parametros ubicacion,parametros,conexion a la base de datos
//            JasperViewer viewer = new JasperViewer(jprint,false); //Creamos la vista del Reporte
//             viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Le agregamos que se cierre solo el reporte cuando lo cierre el usuario
//            viewer.setVisible(true); //Inicializamos la vista del Reporte
//        } catch (JRException ex) {
//            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//        } 
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
//         JasperReport reporte;
//        String path = "src\\REPORTES\\Reporte_Producto.jasper";
//     try {
//            reporte = (JasperReport) JRLoader.loadObjectFromFile(path); //Cargo el reporte al objeto
//            JasperPrint jprint = JasperFillManager.fillReport(path, null, cn); //Llenado del Reporte con Tres parametros ubicacion,parametros,conexion a la base de datos
//            JasperViewer viewer = new JasperViewer(jprint,false); //Creamos la vista del Reporte
//             viewer.setDefaultCloseOperation(DISPOSE_ON_CLOSE); // Le agregamos que se cierre solo el reporte cuando lo cierre el usuario
//            viewer.setVisible(true); //Inicializamos la vista del Reporte
//        } catch (JRException ex) {
//            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        FRM_UTILIDAD uti = new FRM_UTILIDAD();
        uti.show();
    }//GEN-LAST:event_jMenuItem3ActionPerformed


 public static void main(String args[]) {
  
  java.awt.EventQueue.invokeLater(new Runnable() {
   public void run() {
    new FRM_MENU_PRINCIPAL().setVisible(true);
   }
  });
 }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLblNombre;
    private javax.swing.JMenu jMConsultas;
    private javax.swing.JMenu jMMantenimiento;
    private javax.swing.JMenu jMRepotes;
    private javax.swing.JMenu jMTransaciones;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMiCargo;
    private javax.swing.JMenuItem jMiCargo1;
    private javax.swing.JMenuItem jMiCategoria;
    private javax.swing.JMenuItem jMiCategoria1;
    private javax.swing.JMenuItem jMiCliente1;
    private javax.swing.JMenuItem jMiClientes;
    private javax.swing.JMenuItem jMiEmpleado;
    private javax.swing.JMenuItem jMiEmpleado1;
    private javax.swing.JMenuItem jMiMarca;
    private javax.swing.JMenuItem jMiMarca1;
    private javax.swing.JMenuItem jMiProducto1;
    private javax.swing.JMenuItem jMiProductos;
    private javax.swing.JMenuItem jMiReporteDia;
    private javax.swing.JMenuItem jMiSalir;
    private javax.swing.JMenuItem jMiVencimientoPr;
    private javax.swing.JMenuItem jMiVentaProd;
    private javax.swing.JMenuItem jMiVentas;
    private javax.swing.JMenu jMsalir;
    // End of variables declaration//GEN-END:variables
}

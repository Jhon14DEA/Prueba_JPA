/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.ups.vista;

import ec.edu.ups.controlador.ControladorPrincipal;
import ec.edu.ups.excepciones.GaranteExepcion;
import ec.edu.ups.excepciones.HipotecaExcepcion;
import ec.edu.ups.excepciones.VacioExcepcion;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import ec.edu.ups.modelo.Casa;
import ec.edu.ups.modelo.EnumHipoteca;
import ec.edu.ups.modelo.Hipoteca;
import ec.edu.ups.modelo.Persona;

/**
 * 
 * @author ASUS
 */
public class VentanaHipotecas extends javax.swing.JPanel {
    
    private SimpleDateFormat formato;
    private SimpleDateFormat formato1;
    private ControladorPrincipal controladorPrincipal;
    private DefaultTableModel tabla;

    /**
     * Creates new form VentanaHipotecas
     *
     * @param controladorPrincipal
     */
    public VentanaHipotecas(ControladorPrincipal controladorPrincipal) {
        this.controladorPrincipal = controladorPrincipal;
        formato = new SimpleDateFormat("dd/mm/yyyy");
        formato1 = new SimpleDateFormat("dd/mm/yyyy");
//        tabla = (DefaultTableModel) tablaFechas.getModel();
        initComponents();
        txtCedulaGarante.setEnabled(false);
        txtInteres.setText("8.99");
        txtSINO.setText("NO");
        //this.cargarDatosTabla();
    }
    
    public void cargarDatosTabla()  {
        tabla = (DefaultTableModel) tablaFechas.getModel();
        try {
           Date fecha1 = formato.parse(txtFechaInicio.getText());
        Calendar fecha = new GregorianCalendar();
        fecha.setTime(fecha1); 
         int n = Integer.valueOf(txtNumeroPagos.getText());
        tabla.setRowCount(0);
        int contador = 0;
            String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(fecha.get(Calendar.MONTH));
            String año = Integer.toString(fecha.get(Calendar.YEAR));
            int m = Integer.valueOf(mes)+1;
            mes = String.valueOf(m);
        for (int i = 0; i < n; i++) {
            contador += 1;
             m = Integer.valueOf(mes)+1;
            mes = String.valueOf(m);
            if (m>12) {
                int a = Integer.valueOf(año)+1;
                año = String.valueOf(a);
                mes="1";
            } else {
            }
            String fechaPago = dia + "/" + mes + "/" + año;
            String datos[] = {fechaPago, String.valueOf(contador)};
            tabla.addRow(datos);
        }
            
            
        } catch (Exception e) {
        }
       
        
    }
    
    public void vizualizarDatos(int posicion) {
        if (posicion >= 0) {
            Hipoteca hipoteca = this.controladorPrincipal.getHipotecaDAO().getListado().get(posicion);
            String deudor = hipoteca.getDeudor().getCedula();
            String garante = "";
            if (hipoteca.getGarante() != null) {
                garante = hipoteca.getGarante().getCedula();
                txtSINO.setText("SI");
            } else {
                txtSINO.setText("NO");
            }
            /*
            if (null != hipoteca.getEnumHipoteca()) {
                switch (hipoteca.getEnumHipoteca()) {
                    case NORMAL:
                        cmbEstado.setSelectedIndex(0);
                        break;
                    case PAGADO:
                        cmbEstado.setSelectedIndex(1);
                        break;
                    case EMBARGADO:
                        cmbEstado.setSelectedIndex(2);
                        break;
                    default:
                        break;
                }
            }
             */
            String casa = String.valueOf(hipoteca.getCasa().getCodigo());
            txtCodigo.setText(String.valueOf(hipoteca.getCodigo()));
            txtCasa.setText(casa);
            txtDeudor.setText(deudor);
            txtCedulaGarante.setText(garante);
            txtMonto.setText(String.valueOf(hipoteca.getMonto()));
            txtInteres.setText(String.valueOf(hipoteca.getInteres()));
            Calendar fecha = hipoteca.getFechaInicio();
            String dia = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
            String mes = Integer.toString(fecha.get(Calendar.MONTH));
            String año = Integer.toString(fecha.get(Calendar.YEAR));
            String fechaInicio = dia + "/" + mes + "/" + año;
            txtFechaInicio.setText(fechaInicio);
            Calendar fecha1 = hipoteca.getFechaFin();
            String dia1 = Integer.toString(fecha.get(Calendar.DAY_OF_MONTH));
            String mes1 = Integer.toString(fecha.get(Calendar.MONTH));
            String año1 = Integer.toString(fecha.get(Calendar.YEAR));
            String fechaFin = dia + "/" + mes + "/" + año;
            txtFechaInicio.setText(fechaInicio);
            txtFechaInicio.setText(fechaFin);
            
            probarHipoteca();
            
        } else {
            txtCasa.setText("");
            txtCedulaGarante.setText("");
            txtCodigo.setText("");
            txtDatosCasa.setText("");
            txtDeudor.setText("");
            txtInteres.setText("");
            txtMonto.setText("");
            txtNumeroPagos.setText("");
            txtNumeroPagos.setText("");
            txtPagoMensual.setText("");
            txtSINO.setText("");
            txtFechaInicio.setText("");
            txtFechaInicio.setText("");
            
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        txtInteres = new javax.swing.JTextField();
        txtMonto = new javax.swing.JTextField();
        txtFechaInicio = new javax.swing.JTextField();
        txtFechaFin = new javax.swing.JTextField();
        txtCasa = new javax.swing.JTextField();
        txtDeudor = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDatosPersona = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDatosCasa = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        txtSINO = new javax.swing.JTextField();
        txtCedulaGarante = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNumeroPagos = new javax.swing.JTextField();
        txtTotal = new javax.swing.JTextField();
        txtPagoMensual = new javax.swing.JTextField();
        jScrollPane5 = new javax.swing.JScrollPane();
        tablaFechas = new javax.swing.JTable();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(jTable1);

        jLabel1.setText("Id ");

        jLabel2.setText("Cedula ");

        jLabel3.setText("Id Casa ");

        jLabel4.setText("Valor  Casa");

        jLabel5.setText("Interes ");

        jLabel6.setText("Fecha inicio ");

        jLabel7.setText("Fecha fin ");

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });

        jButton1.setText("Calcular");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtDatosPersona.setColumns(20);
        txtDatosPersona.setRows(5);
        jScrollPane1.setViewportView(txtDatosPersona);

        txtDatosCasa.setColumns(20);
        txtDatosCasa.setRows(5);
        jScrollPane2.setViewportView(txtDatosCasa);

        jLabel8.setText("Persona ");

        jLabel9.setText("Casa ");

        jButton2.setText("OK");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Limpiar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE)
            .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );

        jLabel10.setText("Garante ");

        jLabel11.setText("Cedula Garante ");

        txtSINO.setEditable(false);

        jLabel12.setText("N Pagos ");

        jLabel13.setText("Pagos Mensuales ");

        jLabel14.setText("Pago Total ");

        txtNumeroPagos.setEditable(false);

        txtTotal.setEditable(false);

        txtPagoMensual.setEditable(false);

        tablaFechas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Fecha", "Numero de pago"
            }
        ));
        jScrollPane5.setViewportView(tablaFechas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(jLabel1))
                                    .addComponent(jLabel7))
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtDeudor, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(67, 67, 67)
                                        .addComponent(jLabel8))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel3)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtCasa, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel4)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel5)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel6)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGap(28, 28, 28)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addComponent(jLabel9))))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel10)
                                .addGap(18, 18, 18)
                                .addComponent(txtSINO, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtCedulaGarante, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(txtPagoMensual))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel14)
                                .addGap(47, 47, 47)
                                .addComponent(txtTotal))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel12)
                                .addGap(60, 60, 60)
                                .addComponent(txtNumeroPagos, javax.swing.GroupLayout.PREFERRED_SIZE, 299, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1086, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(182, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(txtDeudor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtCasa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(txtMonto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel5)
                            .addComponent(txtInteres, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtFechaFin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addComponent(jScrollPane2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel10)
                            .addComponent(jLabel11)
                            .addComponent(txtSINO, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCedulaGarante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel12)
                            .addComponent(txtNumeroPagos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel13)
                            .addComponent(txtPagoMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel14)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(441, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        try {
            Date fecha1 = formato.parse(txtFechaInicio.getText());
            Calendar fechaInicio = new GregorianCalendar();
            fechaInicio.setTime(fecha1);
            Date fecha2 = formato1.parse(txtFechaFin.getText());
            Calendar fechaFin = new GregorianCalendar();
            fechaFin.setTime(fecha2);
            Casa casa = controladorPrincipal.BuscarCasa(Integer.valueOf(txtCasa.getText()));
            EnumHipoteca estado = EnumHipoteca.NORMAL;
            estado = EnumHipoteca.NORMAL;
            
            Persona deudor = new Persona();
            try {
                deudor = controladorPrincipal.BuscarPersona(txtDeudor.getText());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Persona no encontrada");
            }
            
            try {
                if (txtCodigo.getText().equals("") && txtSINO.getText().equals("NO")) {
                    
                    String mensaje = controladorPrincipal.crearHipoteca(Double.valueOf(txtMonto.getText()), Double.valueOf(txtInteres.getText()), fechaInicio, fechaFin, Double.valueOf(txtPagoMensual.getText()), casa, Integer.valueOf(txtNumeroPagos.getText()), deudor, null, estado,Integer.valueOf(txtNumeroPagos.getText()));
                    JOptionPane.showMessageDialog(this, mensaje);
                    if (estado.equals(estado.PAGADO)) {
                        controladorPrincipal.actualizarEstado(false, casa.getCodigo());
                    } else {
                        controladorPrincipal.actualizarEstado(true, casa.getCodigo());
                    }
                    
                } else if (txtCodigo.getText().equals("") && txtSINO.getText().equals("SI")) {
                    Persona garante = controladorPrincipal.BuscarPersona(txtCedulaGarante.getText());
                    String mensaje = controladorPrincipal.crearHipoteca(Double.valueOf(txtMonto.getText()), Double.valueOf(txtInteres.getText()), fechaInicio, fechaFin, Double.valueOf(txtPagoMensual.getText()), casa, Integer.valueOf(txtNumeroPagos.getText()), deudor, garante, estado,Integer.valueOf(txtNumeroPagos.getText()));
                    JOptionPane.showMessageDialog(this, mensaje);
                    if (estado.PAGADO.equals(EnumHipoteca.PAGADO)) {
                        controladorPrincipal.actualizarEstado(false, casa.getCodigo());
                    } else {
                        controladorPrincipal.actualizarEstado(true, casa.getCodigo());
                    }
                    
                } else {
                    
                    if (txtSINO.getText().equals("NO")) {
                        String mensaje = controladorPrincipal.actualizarHipoteca(Integer.parseInt(txtCodigo.getText()), Double.valueOf(txtMonto.getText()), Double.valueOf(txtInteres.getText()), fechaInicio, fechaFin, Double.valueOf(txtPagoMensual.getText()), casa, Integer.valueOf(txtNumeroPagos.getText()), deudor, null, estado);
                        JOptionPane.showMessageDialog(this, mensaje);
                        if (estado.PAGADO.equals(EnumHipoteca.PAGADO)) {
                            controladorPrincipal.actualizarEstado(false, casa.getCodigo());
                        } else {
                            controladorPrincipal.actualizarEstado(true, casa.getCodigo());
                        }
                        
                    } else if (txtSINO.getText().equals("SI")) {
                        Persona garante = controladorPrincipal.BuscarPersona(txtCedulaGarante.getText());
                        String mensaje = controladorPrincipal.actualizarHipoteca(Integer.parseInt(txtCodigo.getText()), Double.valueOf(txtMonto.getText()), Double.valueOf(txtInteres.getText()), fechaInicio, fechaFin, Double.valueOf(txtPagoMensual.getText()), casa, Integer.valueOf(txtNumeroPagos.getText()), deudor, garante, estado);
                        JOptionPane.showMessageDialog(this, mensaje);
                        if (estado.equals(EnumHipoteca.PAGADO)) {
                            controladorPrincipal.actualizarEstado(false, casa.getCodigo());
                        } else {
                            controladorPrincipal.actualizarEstado(true, casa.getCodigo());
                        }
                        
                    }
                }
            } catch (VacioExcepcion | GaranteExepcion | HipotecaExcepcion ex) {
                JOptionPane.showMessageDialog(this, ex.toString());
            } finally {
              //  cargarDatosTabla();
                this.vizualizarDatos(-1);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Eroor: Pruebe Primero con el boton Probar Hipoteca ");
        }
    }//GEN-LAST:event_jButton2ActionPerformed
    public void probarHipoteca() {
        try {
            
            Date fecha1 = formato.parse(txtFechaInicio.getText());
            Calendar fechaInicio = new GregorianCalendar();
            fechaInicio.setTime(fecha1);
            Date fecha2 = formato1.parse(txtFechaFin.getText());
            Calendar fechaFin = new GregorianCalendar();
            fechaFin.setTime(fecha2);
            int diaInicio = fechaInicio.get(Calendar.DAY_OF_YEAR);
            int diaFin = fechaFin.get(Calendar.DAY_OF_YEAR);
            int mesInicio = fechaInicio.get(Calendar.MONTH);
            int añoInicio = fechaInicio.get(Calendar.YEAR);
            int mesFin = fechaFin.get(Calendar.MONTH);
            int añoFin = fechaFin.get(Calendar.YEAR);
            if (fechaInicio == null || fechaFin == null) {
                JOptionPane.showMessageDialog(null, "Colocar Fechas ");
            } else if (añoFin - añoInicio < 0) {
                JOptionPane.showMessageDialog(null, "Fechas mal Colocadas ");
            } else if (añoFin - añoInicio == 0 && mesFin - mesInicio < 0) {
                JOptionPane.showMessageDialog(null, "Fechas mal Colocadas ");
            } else if (añoFin - añoInicio == 0 && diaFin - diaInicio < 0) {
                JOptionPane.showMessageDialog(null, "Fechas mal Colocadas ");
            } else {
                double valorTotal = Double.valueOf(txtMonto.getText()) + (Double.valueOf(txtMonto.getText()) * (Double.valueOf(txtInteres.getText()) / 100));
                
                if ((añoInicio - añoFin) == 0) {
                    int valor = mesFin - mesInicio;
                    if (valor == 0) {
                        txtNumeroPagos.setText("1");
                        
                    } else {
                        txtNumeroPagos.setText(String.valueOf(valor));
                    }
                    
                } else if ((añoFin - añoInicio) == 1) {
                    int valor = (12 - mesFin + 1) + (12 - mesInicio + 1);
                    txtNumeroPagos.setText(String.valueOf(valor));
                } else if ((añoFin - añoInicio) == 2) {
                    int valor = mesFin + (12 - mesInicio) + 12;
                    txtNumeroPagos.setText(String.valueOf(valor));
                } else {
                    int años = añoFin - añoInicio - 2;
                    int valor = mesFin - (12 - mesInicio + 1) + (años * 12);
                    txtNumeroPagos.setText(String.valueOf(valor));
                }
                txtPagoMensual.setText(String.valueOf(Double.valueOf(txtMonto.getText()) / Double.valueOf(txtNumeroPagos.getText())));
                Persona persona = controladorPrincipal.BuscarPersona(txtDeudor.getText());
                txtDatosPersona.setText(persona.toString());
                
                Casa casa = controladorPrincipal.BuscarCasa(Integer.valueOf(txtCasa.getText()));
                txtDatosCasa.setText(casa.toString());
                if (persona.getSueldo() < Double.valueOf(txtPagoMensual.getText()) && casa.getAvaluo() < valorTotal) {
                    txtSINO.setText("SI");
                    txtCedulaGarante.setEnabled(true);
                } else {
                    txtSINO.setText("NO");
                    txtCedulaGarante.setEnabled(false);
                }
                txtTotal.setText(String.valueOf(valorTotal));
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Error: Datos Faltantes o mal ingresados");
        }
        
    }
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            probarHipoteca();
            cargarDatosTabla();
        } catch (Exception e) {
        }

    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable tablaFechas;
    private javax.swing.JTextField txtCasa;
    private javax.swing.JTextField txtCedulaGarante;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextArea txtDatosCasa;
    private javax.swing.JTextArea txtDatosPersona;
    private javax.swing.JTextField txtDeudor;
    private javax.swing.JTextField txtFechaFin;
    private javax.swing.JTextField txtFechaInicio;
    private javax.swing.JTextField txtInteres;
    private javax.swing.JTextField txtMonto;
    private javax.swing.JTextField txtNumeroPagos;
    private javax.swing.JTextField txtPagoMensual;
    private javax.swing.JTextField txtSINO;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}

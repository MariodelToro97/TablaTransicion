/*
* Este programa fue hecho por Mario Josue del Toro Morales
* con Número de Control 15460644
* Estudiante del sexto semestre de la carrera de Ingeniería en Sistemas Computacionales
* del Instituto Tecnológico de Colima
* Materia de Lenguajes y Autómatas I
******Descripción************
* Programa que analiza Léxicamente un código hecho
 */
package tablatransicion;

import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mario Josue del Toro Morales
 */
public class Principal extends javax.swing.JFrame {

    /**
     * Creates new form Principal
     */
    //Declaración de la matriz de Transición y el vector del alfabeto
    int matrizTransicion[][] = new int[24][15];
    char alfabeto[] = new char[15];
    static File archivo; //Variable de tipo archivo
    FileInputStream entrada; //Variable que recoge la ruta que el usuario ingresa
    FileOutputStream salida; //Variable que recoge la ruta de salida
    FileReader fr;
    JFileChooser seleccionar = new JFileChooser(); //Creación de las librerias para escoger ruta
    String estadoFinal[][] = new String[17][2]; //Creación de matriz de los estados finales

    public Principal() {
        initComponents();
        this.setLocationRelativeTo(null); //Coloca la ventana al centro de la pantalla

        //Inicialización de la matriz de transición en -1
        for (int i = 0; i < 24; i++) {
            for (int j = 0; j < 15; j++) {
                matrizTransicion[i][j] = -1;
            }
        }

        //Llenado de la matriz de Transición
        matrizTransicion[0][0] = 1;
        matrizTransicion[0][1] = 3;
        matrizTransicion[0][4] = 6;
        matrizTransicion[0][5] = 8;
        matrizTransicion[0][6] = 7;
        matrizTransicion[0][7] = 18;
        matrizTransicion[0][8] = 12;
        matrizTransicion[0][9] = 10;
        matrizTransicion[0][10] = 9;
        matrizTransicion[0][11] = 16;
        matrizTransicion[0][12] = 17;
        matrizTransicion[0][13] = 0;
        matrizTransicion[0][14] = 0;

        matrizTransicion[1][0] = 1;
        matrizTransicion[1][1] = 2;
        matrizTransicion[1][2] = 13;
        matrizTransicion[1][3] = 2;
        matrizTransicion[1][13] = 99;
        matrizTransicion[1][14] = 99;

        matrizTransicion[2][0] = 2;
        matrizTransicion[2][1] = 2;
        matrizTransicion[2][3] = 2;
        matrizTransicion[2][13] = 99;
        matrizTransicion[2][14] = 99;

        matrizTransicion[3][1] = 3;
        matrizTransicion[3][2] = 4;
        matrizTransicion[3][13] = 99;
        matrizTransicion[3][14] = 99;

        matrizTransicion[4][1] = 5;

        matrizTransicion[5][1] = 5;
        matrizTransicion[5][13] = 99;
        matrizTransicion[5][14] = 99;

        matrizTransicion[6][4] = 7;
        matrizTransicion[6][13] = 99;
        matrizTransicion[6][14] = 99;

        matrizTransicion[7][13] = 99;
        matrizTransicion[7][14] = 99;

        matrizTransicion[8][5] = 7;
        matrizTransicion[8][13] = 99;
        matrizTransicion[8][14] = 99;

        matrizTransicion[9][8] = 11;
        matrizTransicion[9][13] = 99;
        matrizTransicion[9][14] = 99;

        matrizTransicion[10][8] = 11;

        matrizTransicion[11][13] = 99;
        matrizTransicion[11][14] = 99;

        matrizTransicion[12][8] = 11;
        matrizTransicion[12][13] = 99;
        matrizTransicion[12][14] = 99;

        matrizTransicion[13][0] = 15;
        matrizTransicion[13][6] = 14;

        matrizTransicion[14][13] = 99;
        matrizTransicion[14][14] = 99;

        matrizTransicion[15][0] = 15;
        matrizTransicion[15][2] = 13;
        matrizTransicion[15][13] = 99;
        matrizTransicion[15][14] = 99;

        matrizTransicion[16][13] = 99;
        matrizTransicion[16][14] = 99;

        matrizTransicion[17][13] = 99;
        matrizTransicion[17][14] = 99;

        matrizTransicion[18][6] = 20;
        matrizTransicion[18][7] = 19;

        matrizTransicion[19][0] = 19;
        matrizTransicion[19][1] = 19;
        matrizTransicion[19][2] = 19;
        matrizTransicion[19][3] = 19;
        matrizTransicion[19][4] = 19;
        matrizTransicion[19][5] = 19;
        matrizTransicion[19][6] = 19;
        matrizTransicion[19][7] = 19;
        matrizTransicion[19][8] = 19;
        matrizTransicion[19][9] = 19;
        matrizTransicion[19][10] = 19;
        matrizTransicion[19][11] = 19;
        matrizTransicion[19][12] = 19;
        matrizTransicion[19][13] = 19;
        matrizTransicion[19][14] = 99;

        matrizTransicion[20][0] = 20;
        matrizTransicion[20][1] = 20;
        matrizTransicion[20][2] = 20;
        matrizTransicion[20][3] = 20;
        matrizTransicion[20][4] = 20;
        matrizTransicion[20][5] = 20;
        matrizTransicion[20][6] = 21;
        matrizTransicion[20][7] = 20;
        matrizTransicion[20][8] = 20;
        matrizTransicion[20][9] = 20;
        matrizTransicion[20][10] = 20;
        matrizTransicion[20][11] = 20;
        matrizTransicion[20][12] = 20;

        matrizTransicion[21][0] = 20;
        matrizTransicion[21][1] = 20;
        matrizTransicion[21][2] = 20;
        matrizTransicion[21][3] = 20;
        matrizTransicion[21][4] = 20;
        matrizTransicion[21][5] = 20;
        matrizTransicion[21][6] = 20;
        matrizTransicion[21][7] = 22;
        matrizTransicion[21][8] = 20;
        matrizTransicion[21][9] = 20;
        matrizTransicion[21][10] = 20;
        matrizTransicion[21][11] = 20;
        matrizTransicion[21][12] = 20;

        matrizTransicion[22][13] = 99;
        matrizTransicion[22][14] = 99;

        //Inserción de valores en el vector del alfabeto
        alfabeto[0] = 'A'; //Alfabeto
        alfabeto[1] = '0'; //Números
        alfabeto[2] = '.';
        alfabeto[3] = '_'; // _ $
        alfabeto[4] = '+';
        alfabeto[5] = '-';
        alfabeto[6] = '*';
        alfabeto[7] = '/';
        alfabeto[8] = '=';
        alfabeto[9] = '!';
        alfabeto[10] = '>'; //> <
        alfabeto[11] = ';'; //; ,
        alfabeto[12] = '"'; // { } [ ] ( ) "
        alfabeto[13] = ' '; //\t
        alfabeto[14] = '\n';

        //Inserción de valores finales a la matriz de estados finales
        estadoFinal[0][0] = "1";
        estadoFinal[0][1] = "ID";

        estadoFinal[1][0] = "2";
        estadoFinal[1][1] = "ID";

        estadoFinal[2][0] = "14";
        estadoFinal[2][1] = "CLASE";

        estadoFinal[3][0] = "15";
        estadoFinal[3][1] = "CLASE";

        estadoFinal[4][0] = "3";
        estadoFinal[4][1] = "NUMERO ENTERO";

        estadoFinal[5][0] = "5";
        estadoFinal[5][1] = "NUMERO FLOTANTE";

        estadoFinal[6][0] = "9";
        estadoFinal[6][1] = "OPERADOR LÓGICO";

        estadoFinal[7][0] = "11";
        estadoFinal[7][1] = "OPERADOR LÓGICO";

        estadoFinal[8][0] = "12";
        estadoFinal[8][1] = "OPERADOR LÓGICO";

        estadoFinal[9][0] = "6";
        estadoFinal[9][1] = "OPERADOR ARITMÉTICO";

        estadoFinal[10][0] = "7";
        estadoFinal[10][1] = "OPERADOR ARITMÉTICO";

        estadoFinal[11][0] = "8";
        estadoFinal[11][1] = "OPERADOR ARITMÉTICO";

        estadoFinal[12][0] = "18";
        estadoFinal[12][1] = "OPERADOR ARITMÉTICO";

        estadoFinal[13][0] = "17";
        estadoFinal[13][1] = "SIGNO DE AGRUPACIÓN";

        estadoFinal[14][0] = "19";
        estadoFinal[14][1] = "COMENTARIO";

        estadoFinal[15][0] = "22";
        estadoFinal[15][1] = "COMENTARIO";

        estadoFinal[16][0] = "16";
        estadoFinal[16][1] = "SEPARADOR";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Limpiar = new javax.swing.JButton();
        Obtener = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Texto = new javax.swing.JTextArea();
        Abrir = new javax.swing.JButton();
        Guardar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Tab_lexico = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Análisis Léxico");

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(207, 30, 67));
        jLabel11.setText("Ingeniería en Sistemas Computacionales");
        jLabel11.setToolTipText("Carrera que se está cursando");

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel12.setText("Sexto");

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(0, 0, 204));
        jLabel13.setText("Semestre:");

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(0, 0, 204));
        jLabel15.setText("Docente:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel16.setText("Ma. Elena Martínez Durán");

        jButton3.setBackground(new java.awt.Color(255, 102, 102));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jButton3.setText("Salir");
        jButton3.setToolTipText("Termina la aplicación");
        jButton3.setName("salir"); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 3, 36)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(245, 91, 91));
        jLabel4.setText("Lenguajes y Autómatas I");
        jLabel4.setToolTipText("Nombre de la materia");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Mario Josué Del Toro Morales ");
        jLabel5.setToolTipText("Autor");

        jLabel9.setFont(new java.awt.Font("Tahoma", 2, 14)); // NOI18N
        jLabel9.setText("Este programa tiene como función mostrar checar un código dado para que cumpla con ciertas reglas");
        jLabel9.setToolTipText("Descripción de programa");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 204));
        jLabel2.setText("Autor:");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 204));
        jLabel3.setText("Número de Control:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("15460644");
        jLabel6.setToolTipText("Número de Control");

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel7.setText("Programa que realiza el análisis léxico de un programa");
        jLabel7.setToolTipText("Nombre de la práctica");

        Limpiar.setBackground(new java.awt.Color(255, 255, 102));
        Limpiar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Limpiar.setText("Limpiar");
        Limpiar.setToolTipText("Borrará el código escrito así como la tabla de tokens");
        Limpiar.setEnabled(false);
        Limpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarActionPerformed(evt);
            }
        });

        Obtener.setBackground(new java.awt.Color(102, 255, 204));
        Obtener.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        Obtener.setText("Análisis Léxico");
        Obtener.setToolTipText("Realiza el análisis léxico del programa");
        Obtener.setEnabled(false);
        Obtener.setName("potencia"); // NOI18N
        Obtener.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ObtenerActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 30)); // NOI18N
        jLabel10.setText("Instituto Tecnológico de Colima");
        jLabel10.setToolTipText("Nombre de la Escuela");

        Texto.setColumns(20);
        Texto.setRows(5);
        Texto.setToolTipText("Escribe aquí tu texto deseado");
        Texto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TextoKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(Texto);

        Abrir.setBackground(new java.awt.Color(255, 153, 153));
        Abrir.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Abrir.setText("Abrir");
        Abrir.setToolTipText("Abrir un documento creado anteriormente");
        Abrir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AbrirActionPerformed(evt);
            }
        });

        Guardar.setBackground(new java.awt.Color(153, 255, 204));
        Guardar.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
        Guardar.setText("Guardar");
        Guardar.setToolTipText("Guarda el código creado en el espacio");
        Guardar.setEnabled(false);
        Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarActionPerformed(evt);
            }
        });

        Tab_lexico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Lexema", "Token"
            }
        ));
        Tab_lexico.setToolTipText("Tabla de los Lexemas que aparecen en el código y el Token que representa");
        jScrollPane3.setViewportView(Tab_lexico);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel15)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel13)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel12))
                    .addComponent(jLabel16))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel3)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Obtener, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel6)
                        .addGap(37, 37, 37))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane1)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(183, 183, 183)
                                .addComponent(Guardar, javax.swing.GroupLayout.PREFERRED_SIZE, 144, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(Abrir, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(117, 117, 117))))))
            .addGroup(layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 631, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(96, 96, 96)
                                .addComponent(jLabel10))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(128, 128, 128)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 471, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel7)
                .addContainerGap(606, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(307, 307, 307)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addGap(5, 5, 5)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Limpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Obtener, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(Guardar, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Abrir, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(jLabel16))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel12)
                    .addComponent(jLabel6))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Cierra la aplicación
        JOptionPane.showMessageDialog(null, "Gracias por usar este programa\n Lo esperamos de vuelta pronto\n Versión 1.5.32\n\n Creado por: Mario Josue del Toro Morales\nEstudiante del Instituto Tecnológico de Colima\n Carrera de Ingeniería en Sistemas Coputacionales\n No. Control: 15460647\n Sexto Semestre", "AGRADECIMIENTO", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void LimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimpiarActionPerformed
        //Método que se ejecuta al dar clic en el botón de limpiar
        Texto.setText(""); //se vacia la caja de texto
        Obtener.setEnabled(false); //se deshabilita el botón de obtener
        Limpiar.setEnabled(false); //se deshabilita el botón de habilitación

        //Pasa el foco al textfield del código
        Texto.requestFocus();

        //Pasos para reiniciar la Tabla 
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Lexema");
        modelo.addColumn("Token");
        Tab_lexico.setModel(modelo);
    }//GEN-LAST:event_LimpiarActionPerformed

    public int obtenerColumna(String letra) {
        //Método que revisa si existe el caracter  en la cadena capturada
        int valor = -1;

        for (int i = 0; i < alfabeto.length; i++) {
            if (letra.equalsIgnoreCase(Character.toString(alfabeto[i]))) {
                valor = i;
                break;
            }
        }
        return valor;
    }

    public String obtenerCaracter(int posicion) {
        //Método que obtiene el valor del alfabeto si es letra o número el caracter leido
        // A = Alfabeto
        // 0 = Número
        String cadena = "";

        if (Character.isLetter(Texto.getText().charAt(posicion))) {
            cadena = "A";
        } else if (Character.isDigit(Texto.getText().charAt(posicion))) {
            cadena = "0";
        }

        return cadena;
    }

    public int tablaTransicion(int estado, int columna) {
        //Método que obtiene el valor de la matriz de un camino en especifico
        return matrizTransicion[estado][columna];
    }

    public void llenadoTablaTokens(Object[] fila, String palabra, DefaultTableModel modelo, String token) {
        //Método que llenará la tabla de Tokens
        fila[0] = palabra; //valor de la columna lexema de la tabla
        fila[1] = token; //valor de la columna token de la tabla

        modelo.addRow(fila); //Añadido de fila en el modelo auxiliar
        this.Tab_lexico.setModel(modelo); //Colocación del modelo en la tabla original visible en la interfaz
    }

    public void agregadoEspacio() {
        //Este método agrega un espacio despues de cierta secuencia de caracteres para evitar errores en la ejecución y compilación
        String codigo, espacio = "", caracter;

        if (Texto.getText().length() == 1) {
            espacio = Texto.getText();
            espacio += " ";

        } else {
            codigo = Texto.getText();

            for (int i = 0; i < codigo.length() - 1; i++) {
                caracter = Character.toString(codigo.charAt(i));
                if ((!caracter.equalsIgnoreCase(" ") && Character.toString(codigo.charAt(i + 1)).equalsIgnoreCase("\t")) || (!caracter.equalsIgnoreCase(" ") && Character.toString(codigo.charAt(i + 1)).equalsIgnoreCase("\n"))) {
                    espacio += caracter + " ";

                } else {

                    if (i == (codigo.length() - 2)) {
                        espacio += caracter;
                        espacio += Character.toString(codigo.charAt(codigo.length() - 1));
                        espacio += " ";
                    } else {
                        espacio += caracter;
                    }
                }
            }
        }

        Texto.setText(espacio);
    }

    public String obtenerToken(int valor) {
        //Método que obtiene el token de la matriz de estados finales
        String token = "";
        boolean encontrado = false;

        for (int i = 0; i < 17; i++) {
            if (this.estadoFinal[i][0].equalsIgnoreCase(Integer.toString(valor))) {
                token = estadoFinal[i][1];
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            token = "ERROR";
        }
        return token;
    }

    private void ObtenerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ObtenerActionPerformed
        // Método que se deesencadena tras pulsar el boton de Obtener de la interfaz principal        
        String cadena = "", palabra = "", token = "";
        int posicion = -1, estado, columna, valor = 0;
        boolean error = false, salir, impresion = false;

        agregadoEspacio(); //Se le llama al método para crear los espacios respectivos despues de cierta secuencia de caracteres

        //Pasos para reiniciar la Tabla 
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Lexema");
        modelo.addColumn("Token");

        Object[] fila = new Object[2]; //Creación del objeto auxiliar para los ingresos a la tabla

        try {
            do {
                //Reinicialización para chequeo de caracteres al estado inicial
                estado = 0;
                error = false;
                palabra = "";

                do {
                    salir = false;
                    posicion++;
                    cadena = Character.toString(Texto.getText().charAt(posicion));

                    if (cadena.equalsIgnoreCase("\t") || cadena.equalsIgnoreCase("\n")) {
                        if (posicion != 0) {
                            if (!cadena.equalsIgnoreCase(" ") && !cadena.equalsIgnoreCase("\t") && !cadena.equalsIgnoreCase("\n") && !impresion) { //Evita que se guarden en la tabla de tokens espacios en blanco                                
                                token = this.obtenerToken(valor);
                                llenadoTablaTokens(fila, palabra, modelo, token); //Llamado al método para llenar la tabla de Tokens
                            }
                            //Reinicialización para chequeo de caracteres al estado inicial
                            estado = 0;
                            error = false;
                            palabra = "";
                        }

                        while (Character.toString(Texto.getText().charAt(posicion)).equalsIgnoreCase(" ")) {
                            posicion++;
                        }
                        salir = true;
                        impresion = true;

                    } else {
                        impresion = false;
                        if (Character.isLetterOrDigit(Texto.getText().charAt(posicion))) { //Checa si el caracter es letra o digito
                            cadena = obtenerCaracter(posicion);
                        } else if (cadena.equalsIgnoreCase("$")) {
                            cadena = "_";
                        } else if (cadena.equalsIgnoreCase("<")) {
                            cadena = ">";
                        } else if (cadena.equalsIgnoreCase(",")) {
                            cadena = ";";
                        } else if (cadena.equalsIgnoreCase("}") || cadena.equalsIgnoreCase("[") || cadena.equalsIgnoreCase("]") || cadena.equalsIgnoreCase("(") || cadena.equalsIgnoreCase(")") || cadena.equalsIgnoreCase("{")) {
                            cadena = Character.toString('"');
                        } else if (cadena.equalsIgnoreCase("\t")) {
                            cadena = " ";
                        }

                        columna = obtenerColumna(cadena); //Ve si existe el caracter en el alfabeto

                        if (columna != -1) { //Entra si existe el caracter en el alfabeto
                            valor = estado;
                            estado = tablaTransicion(estado, columna); //Obtiene el cruce de la matriz de transición
                            System.out.println(valor);
                            
                            if (estado == -1) { //Entra si NO existe camino en el Autómata                                
                                salir = false;
                                error = false;
                                do {
                                    palabra += Character.toString(Texto.getText().charAt(posicion));
                                    posicion++;
                                } while (!Character.toString(Texto.getText().charAt(posicion)).equalsIgnoreCase(" "));

                                if (!palabra.equalsIgnoreCase(" ") && !palabra.equalsIgnoreCase("\t") && !palabra.equalsIgnoreCase("\n")) { //Evita que se guarden en la tabla de tokens espacios en blanco
                                    error = true;
                                    llenadoTablaTokens(fila, palabra, modelo, "SECUENCIA INCORRECTA"); //Llamado al método para llenar la tabla de Tokens
                                }

                            } else { //Entra si existe camino en el Autómata                                
                                salir = true;
                                palabra += Character.toString(Texto.getText().charAt(posicion));
                            }

                            if (" ".equals(cadena) || estado == -1 || estado == 99 || "\t".equals(cadena)) { //Entra si terminó de alguna forma con esa palabra
                                while (Character.toString(Texto.getText().charAt(posicion + 1)).equalsIgnoreCase(" ")) { //Elimina si hay varios espacios despues de una 
                                    posicion++;
                                }

                                if (!palabra.equalsIgnoreCase(" ") && !palabra.equalsIgnoreCase("\t") && !palabra.equalsIgnoreCase("\n") && !error) { //Evita que se guarden en la tabla de tokens espacios en blanco
                                    token = this.obtenerToken(valor);
                                    llenadoTablaTokens(fila, palabra, modelo, token); //Llamado al método para llenar la tabla de Tokens
                                }
                                salir = false;
                            }

                        } else { //Entra si NO existe el caracter en el alfabeto                            

                            do { //Llega a la siguiente palabra si es que existe                            
                                palabra += Character.toString(Texto.getText().charAt(posicion));
                                posicion++;
                            } while (!Character.toString(Texto.getText().charAt(posicion)).equalsIgnoreCase(" "));

                            if (!palabra.equalsIgnoreCase(" ") && !palabra.equalsIgnoreCase("\t") && !palabra.equalsIgnoreCase("\n")) { //Evita que se guarden en la tabla de tokens espacios en blanco
                                error = true;
                                llenadoTablaTokens(fila, palabra, modelo, "CARACTER NO ENCONTRADO"); //Llamado al método para llenar la tabla de Tokens
                            }

                            salir = false;
                        }
                        cadena = Character.toString(Texto.getText().charAt(posicion));
                    }
                } while (salir);

                //JOptionPane.showMessageDialog(null, mostrar, "Resultado", JOptionPane.INFORMATION_MESSAGE);
            } while (cadena.equalsIgnoreCase(" "));

        } catch (StringIndexOutOfBoundsException e) {
            //Pasa el foco al textfield del código
            Texto.requestFocus();

            if (!palabra.equalsIgnoreCase(" ") && !palabra.equalsIgnoreCase("\t") && !palabra.equalsIgnoreCase("\n") && !impresion && !error) { //Evita que se guarden en la tabla de tokens espacios en blanco
                token = this.obtenerToken(valor);
                llenadoTablaTokens(fila, palabra, modelo, token); //Llamado al método para llenar la tabla de Tokens                
            }
        }
    }//GEN-LAST:event_ObtenerActionPerformed

    private void TextoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TextoKeyReleased
        //Método para habilitar el botón de limpiar una vez que se escibe algo en el cuadro de texto
        if (Texto.getText().length() != 0) {
            Limpiar.setEnabled(true); //habilitación del botón de limpiar
            Obtener.setEnabled(true); //habilitación del botón de obtener
            Guardar.setEnabled(true); //Habilitación del botón de guardar archivo
        } else {
            Limpiar.setEnabled(false); //deshabilitación del botón de limpiar
            Obtener.setEnabled(false); //deshabilitación del botón de obtener
            Guardar.setEnabled(false); //Habilitación del botón de guardar archivo
        }
    }//GEN-LAST:event_TextoKeyReleased

    private void AbrirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AbrirActionPerformed
        // Método que se activa al momento de presionar el botón de abrir

        String contenido;
        JFileChooser archivoCarga = new JFileChooser();
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto", "doc", "txt");

        archivoCarga.setFileFilter(filtro);
        archivoCarga.setDialogTitle("Abrir Archivo");

        if (archivoCarga.showDialog(null, "Abrir") == JFileChooser.APPROVE_OPTION) {
            archivo = archivoCarga.getSelectedFile();

            try {

                FileInputStream f1 = new FileInputStream(archivo);
                InputStreamReader f2 = new InputStreamReader(f1);
                BufferedReader linea = new BufferedReader(f2);
                contenido = "";
                while (linea.ready()) {
                    String linea_arch = linea.readLine();
                    contenido = contenido + linea_arch + "\n";
                }
                linea.close();
                Texto.setText(contenido);

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ha ocurrido un error inesperado en la carga del documento", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_AbrirActionPerformed

    private void GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarActionPerformed
        // Método que se activa al momento de presionar el botón de guardar
        if (seleccionar.showDialog(null, "Guardar Archivo") == JFileChooser.APPROVE_OPTION) {
            archivo = seleccionar.getSelectedFile();

            if (archivo.getName().endsWith("txt")) {
                String mensaje = guardarArchivo(archivo, Texto.getText());

                if (mensaje != null) {
                    JOptionPane.showMessageDialog(null, mensaje);

                } else {
                    JOptionPane.showMessageDialog(null, "Archivo no Compatible");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Favor de poner la extensión .txt");
            }
        }
    }//GEN-LAST:event_GuardarActionPerformed

    public String guardarArchivo(File archivo, String documento) {
        //Método para guardar un archivo
        String mensaje = null;

        try {
            salida = new FileOutputStream(archivo);
            byte[] bytxt = documento.getBytes();
            salida.write(bytxt);
            mensaje = "Archivo Guardado";
            Texto.setText("");
        } catch (Exception e) {
        }
        return mensaje;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Abrir;
    private javax.swing.JButton Guardar;
    private javax.swing.JButton Limpiar;
    private javax.swing.JButton Obtener;
    private javax.swing.JTable Tab_lexico;
    private javax.swing.JTextArea Texto;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration//GEN-END:variables
}

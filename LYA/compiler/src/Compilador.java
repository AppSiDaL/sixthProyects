
import com.formdev.flatlaf.FlatIntelliJLaf;
import compilerTools.CodeBlock;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import compilerTools.Directory;
import compilerTools.ErrorLSSL;
import compilerTools.Functions;
import compilerTools.Grammar;
import compilerTools.Production;
import compilerTools.TextColor;
import compilerTools.Token;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.Timer;

/**
 *
 * @author yisus
 */
public class Compilador extends javax.swing.JFrame {

    private String title;
    private Directory directorio;
    private ArrayList<Token> tokens;
    private ArrayList<ErrorLSSL> errors;
    private ArrayList<TextColor> textsColor;
    private Timer timerKeyReleased;
    private ArrayList<Production> identProd;
    private HashMap<String, String> identificadores;
    private boolean codeHasBeenCompiled = false;

    /**
     * Creates new form Compilador
     */
    public Compilador() {
        initComponents();
        init();
    }

    private void init() {
        title = "Compiler";
        setLocationRelativeTo(null);
        setTitle(title);
        directorio = new Directory(this, jtpCode, title, ".robo");
        addWindowListener(new WindowAdapter() {// Cuando presiona la "X" de la esquina superior derecha
            @Override
            public void windowClosing(WindowEvent e) {
                directorio.Exit();
                System.exit(0);
            }
        });
        timerKeyReleased = new Timer((int) (1000 * 0.3), (ActionEvent e) -> {
            timerKeyReleased.stop();
            colorAnalysis();
        });
        Functions.insertAsteriskInName(this, jtpCode, () -> {
            timerKeyReleased.restart();
        });
        tokens = new ArrayList<>();
        errors = new ArrayList<>();
        textsColor = new ArrayList<>();
        identProd = new ArrayList<>();
        identificadores = new HashMap<>();
        Functions.setAutocompleterJTextComponent(new String[]{"número", "color", "adelante", "atrás",
            "izquierda", "derecha", "norte", "sur", "este", "oeste", "pintar", "detenerPintar",
            "tomar", "poner", "lanzarMoneda"}, jtpCode, () -> {
            timerKeyReleased.restart();
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rootPanel = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtpCode = new javax.swing.JTextPane();
        panelButtonCompilerExecute = new javax.swing.JPanel();
        btnCompilar = new javax.swing.JButton();
        btnEjecutar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtaOutputConsole = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTokens = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("COMPILADOR");

        jtpCode.setFont(new java.awt.Font("Monospaced", 0, 16)); // NOI18N
        jScrollPane1.setViewportView(jtpCode);

        btnCompilar.setText("Compilar");
        btnCompilar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCompilarActionPerformed(evt);
            }
        });

        btnEjecutar.setText("Clear");
        btnEjecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEjecutarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelButtonCompilerExecuteLayout = new javax.swing.GroupLayout(panelButtonCompilerExecute);
        panelButtonCompilerExecute.setLayout(panelButtonCompilerExecuteLayout);
        panelButtonCompilerExecuteLayout.setHorizontalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnCompilar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEjecutar)
                .addContainerGap())
        );
        panelButtonCompilerExecuteLayout.setVerticalGroup(
            panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelButtonCompilerExecuteLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelButtonCompilerExecuteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCompilar)
                    .addComponent(btnEjecutar))
                .addContainerGap(7, Short.MAX_VALUE))
        );

        jtaOutputConsole.setEditable(false);
        jtaOutputConsole.setBackground(new java.awt.Color(255, 255, 255));
        jtaOutputConsole.setColumns(20);
        jtaOutputConsole.setRows(5);
        jScrollPane2.setViewportView(jtaOutputConsole);

        tblTokens.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Token", "Lexema", "Patron"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(tblTokens);

        jLabel1.setText("AREA DE CODIGO");

        javax.swing.GroupLayout rootPanelLayout = new javax.swing.GroupLayout(rootPanel);
        rootPanel.setLayout(rootPanelLayout);
        rootPanelLayout.setHorizontalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(423, 423, 423)
                .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 85, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, rootPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 423, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        rootPanelLayout.setVerticalGroup(
            rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(rootPanelLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelButtonCompilerExecute, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15)
                .addGroup(rootPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(rootPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(rootPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCompilarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCompilarActionPerformed

            compile();
        
    }//GEN-LAST:event_btnCompilarActionPerformed

    private void btnEjecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEjecutarActionPerformed
jtpCode.setText("");
jtaOutputConsole.setText("");
    }//GEN-LAST:event_btnEjecutarActionPerformed

    private void executeCode(ArrayList<String> blocksOfCode, int repeats) {
        for (int j = 1; j <= repeats; j++) {
            int repeatCode = -1;
            for (int i = 0; i < blocksOfCode.size(); i++) {
                String blockOfCode = blocksOfCode.get(i);
                if (repeatCode != -1) {
                    int[] posicionMarcador = CodeBlock.getPositionOfBothMarkers(blocksOfCode, blockOfCode);
                    executeCode(new ArrayList<>(blocksOfCode.subList(posicionMarcador[0], posicionMarcador[1])), repeatCode);
                    repeatCode = -1;
                    i = posicionMarcador[1];
                } else {
                    String[] sentences = blockOfCode.split(";");
                    for (String sentence : sentences) {
                        sentence = sentence.trim();
                        // Llamar código de ejecución (arduino, gráfico, etc)
                        if (sentence.startsWith("pintar")) {
                            String parametro;
                            if (sentence.contains("$")) {
                                parametro = identificadores.get(sentence.substring(9, sentence.length() - 2));
                            } else {
                                parametro = sentence.substring(9, sentence.length() - 2);
                            }
                            System.out.println("Pintando de color " + parametro + "...");
                        } else if (sentence.startsWith("izquierda")) {
                            System.out.println("Moviéndose a la izquierda...");
                        } else if (sentence.startsWith("derecha")) {
                            System.out.println("Moviéndose a la derecha...");
                        } else if (sentence.startsWith("adelante")) {
                            System.out.println("Moviéndose hacia adelante");
                        } else if (sentence.contains("-->")) {
                            String[] identComp = sentence.split(" ");
                            System.out.println("Declarando identificador " + identComp[1] + " igual a " + identComp[3]);
                        } else if (sentence.startsWith("atrás")) {
                            System.out.println("Moviéndose hacia atrás");
                        } else if (sentence.startsWith("repetir")) {
                            String parametro;
                            if (sentence.contains("$")) {
                                parametro = identificadores.get(sentence.substring(10, sentence.length() - 2));
                            } else {
                                parametro = sentence.substring(10, sentence.length() - 2);
                            }
                            repeatCode = Integer.parseInt(parametro);
                        }
                    }
                }
            }
        }
    }

    private void compile() {
        clearFields();
        lexicalAnalysis();
        fillTableTokens();
        syntacticAnalysis();
        semanticAnalysis();
        printConsole();
        codeHasBeenCompiled = true;
    }

    private void lexicalAnalysis() {
        // Extraer tokens
        Lexer lexer;
        try {
            File codigo = new File("code.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new Lexer(entrada);
            while (true) {
                Token token = lexer.yylex();
                if (token == null) {
                    break;
                }
                tokens.add(token);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
    }

    private void syntacticAnalysis() {
        Grammar gramatica = new Grammar(tokens, errors);

        /* Deshabilitar mensajes y validaciones */
        gramatica.disableMessages();
        gramatica.disableValidations();

        /* Eliminación de errores */

        /* Agrupación de valores */
        gramatica.group("VALOR", "(NUMERO | COLOR)", true);

        /* Declaración de variables */
        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OP_ASIG VALOR", true, identProd);
        gramatica.group("VARIABLE", "TIPO_DATO OP_ASIG VALOR", true,
                1, " ✘ Sintax Error {}: Variable no declarada [#, %]");

        gramatica.finalLineColumn();

        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR OP_ASIG", true,
                2, " ✘ Sintax Error {}: Variable no Inicializada [#, %]");

        gramatica.initialLineColumn();

        gramatica.group("VARIABLE", "TIPO_DATO IDENTIFICADOR VALOR", true,
                3, " ✘ Sintax Error {}: Falta Asignacion [#, %]", 2);
        gramatica.group("VARIABLE", "IDENTIFICADOR OP_ASIG VALOR", true,
                4, " ✘ Sintax Error {}: Sin tipo de dato [#, %]");

        /* Eliminación de tipos de datos y operadores de asignación */
        gramatica.delete("TIPO_DATO",
                5, " ✘ Sintax Error {}: Falta el tipo de dato [#, %]");
        gramatica.delete("OP_ASIG",
                6, " ✘ Sintax Error {}: Falta asignacion [#, %]");

        /* Agrupación de identificadores como valor y definición de parámetros */
        gramatica.group("VALOR", "IDENTIFICADOR", true);
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

        /* Agrupación de funciones */
        gramatica.group("FUNCION", "(MOVIMIENTO | PINTAR | DETENER_PINTAR |"
                + " TOMAR | LANZAR_MONEDA | VER | DETENER_REPETIR )", true);
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)? PARENTESIS_C", true);
        gramatica.group("FUNCION_COMP", "FUNCION (VALOR | PARAMETROS)? PARENTESIS_C", true,
                7, " ✘ Sintax Error {}: falta el paréntesis que abre en la función [#, %]");
        gramatica.finalLineColumn();
        gramatica.group("FUNCION_COMP", "FUNCION PARENTESIS_A (VALOR | PARAMETROS)", true,
                8, " ✘ Sintax Error  {}: Expected ) [#, %]");

        gramatica.initialLineColumn();

        /* Eliminación de funciones mal declaradas */
        gramatica.delete("FUNCION",
                9, " ✘ Sintax Error {}: Funcion incorrecta [#, %]");

        /* Expresiones lógicas */
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EXP_LOGICA", "(EXP_LOGICA | FUNCION_COMP) (OP_LOGICO (EXP_LOGICA | FUNCION_COMP))+");
            gramatica.group("EXP_LOGICA", "PARENTESIS_A (EXP_LOGICA | FUNCION_COMP) PARENTESIS_C", true);
        });

        /* Eliminación de operadores lógicos */
        gramatica.delete("OP_LOGICO",
                10, " ✘ Sintax Error {}: Operador logico sin expresion [#, %]");

        /* Agrupación de expresiones lógicas como valores y parámetros */
        gramatica.group("VALOR", "EXP_LOGICA", true);
        gramatica.group("PARAMETROS", "VALOR (COMA VALOR)+");

        /* Agrupación de estructuras de control */
        gramatica.group("EST_CONTROL", "(REPETIR | ESTRUCTURA_SI)", true);
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL (VALOR | PARAMETROS)", true);
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A PARENTESIS_C", true);
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A (VALOR | PARAMETROS) PARENTESIS_C", true);
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL (VALOR | PARAMETROS) PARENTESIS_C", true,
                11, " ✘ Sintax Error {}: Expected ( [#, %]");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_C", true,
                12, " ✘ Sintax Error {}: Expected ( [#, %]");
        gramatica.finalLineColumn();
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A (VALOR | PARAMETROS)", true,
                13, " ✘ Sintax Error {}: Expected ) [#, %]");
        gramatica.group("EST_CONTROL_COMP", "EST_CONTROL PARENTESIS_A", true,
                14, " ✘ Sintax Error {}: Expected ) [#, %]");

        gramatica.initialLineColumn();

        /* Eliminación de estructuras de control mal declaradas */
        gramatica.delete("EST_CONTROL",
                15, " ✘ Sintax Error {}: Estructura Incorrecta [#, %]");

        /* Eliminación de paréntesis */
        gramatica.delete(new String[]{"PARENTESIS_A", "PARENTESIS_C"},
                16, " ✘ Sintax Error {}: [] sin agrupacion  [#, %]");

        /* Eliminación de valores */
        gramatica.delete("VALOR",
                17, " ✘ Sintax Error {}: Valor sin estructura de control [#, %]");

        gramatica.finalLineColumn();

        /* Verificación de punto y coma al final de la sentencia */
        // Identificadores
        gramatica.group("VARIABLE_PC", "VARIABLE PUNTO_COMA", true);
        gramatica.group("VARIABLE_PC", "VARIABLE", true,
                18, " ✘ Sintax Error {}: Expected ; [#, %]");
        // Funciones
        gramatica.group("FUNCION_COMP_PC", "FUNCION_COMP PUNTO_COMA", true);
        gramatica.group("FUNCION_COMP_PC", "FUNCION_COMP", true,
                19, " ✘ Sintax Error {}: Expected ; [#, %]");

        gramatica.initialLineColumn();

        /* Eliminación de punto y coma */
        gramatica.delete("PUNTO_COMA",
                20, " ✘ Sintax Error {}: ; Unexpected [#, %]");

        /* Agrupación de sentencias */
        gramatica.group("SENTENCIAS", "(VARIABLE_PC | FUNCION_COMP_PC)+");
        /* Estructuras de control completas */
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP LLAVE_A (SENTENCIAS)? LLAVE_C", true);
            gramatica.group("SENTENCIAS", "(SENTENCIAS | EST_CONTROL_COMP_LASLC)+");
        });

        /* Estructuras de control incompletas */
        gramatica.loopForFunExecUntilChangeNotDetected(() -> {
            gramatica.initialLineColumn();

            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP (SENTENCIAS)? LLAVE_C", true,
                    21, " ✘ Sintax Error {}: { Expected [#, %]");

            gramatica.finalLineColumn();

            gramatica.group("EST_CONTROL_COMP_LASLC", "EST_CONTROL_COMP LLAVE_A SENTENCIAS",
                    22, " ✘ Sintax Error {}: } Expected [#, %]");
            gramatica.group("SENTENCIAS", "(SENTENCIAS | EST_CONTROL_COMP_LASLC)+");
        });

        /* Eliminación de llaves */
        gramatica.delete(new String[]{"LLAVE_A", "LLAVE_C"},
                23, " ✘ Sintax Error {}: {} No esta agrupando [#, %]");

        /* Mostrar gramáticas */
        // gramatica.show();
    }

    private void semanticAnalysis() {
        HashMap<String, String> identDataType = new HashMap<>();
        identDataType.put("color", "COLOR");
        identDataType.put("número", "NUMERO");
        for (Production id : identProd) {
            if (!identDataType.get(id.lexemeRank(0)).equals(id.lexicalCompRank(-1))) {
                errors.add(new ErrorLSSL(1, " × Error semántico {}: valor no compatible con el tipo de dato [#, %]", id, true));
            }
            if (id.lexicalCompRank(-1).equals("COLOR") && !id.lexemeRank(-1).matches("#[0-9a-fA-F]+")) {
                errors.add(new ErrorLSSL(2, " × Error lógico {}: el color no es un número hexadecimal [#, %]", id, false));
            }
            identificadores.put(id.lexemeRank(1), id.lexemeRank(-1));
        }
    }

    private void colorAnalysis() {
        /* Limpiar el arreglo de colores */
        textsColor.clear();
        /* Extraer rangos de colores */
        LexerColor lexer;
        try {
            File codigo = new File("color.encrypter");
            FileOutputStream output = new FileOutputStream(codigo);
            byte[] bytesText = jtpCode.getText().getBytes();
            output.write(bytesText);
            BufferedReader entrada = new BufferedReader(new InputStreamReader(new FileInputStream(codigo), "UTF8"));
            lexer = new LexerColor(entrada);
            while (true) {
                TextColor textColor = lexer.yylex();
                if (textColor == null) {
                    break;
                }
                textsColor.add(textColor);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("El archivo no pudo ser encontrado... " + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("Error al escribir en el archivo... " + ex.getMessage());
        }
        Functions.colorTextPane(textsColor, jtpCode, new Color(40, 40, 40));
    }

    private void fillTableTokens() {
        tokens.forEach(token -> {
            final String[] patron = {""};
            String lexical = token.getLexicalComp();
            if (lexical.equals("OPERACIONES")) {
                patron[0] = "+|-|/|%|*|^";
            } else if (lexical.equals("Variable")) {
                patron[0] = "Letra(Letra|Numero|_)*";
            } else if (lexical.equals("Numero")) {
                patron[0] = "-?Numero+(.Numero+)?";
            } else if (lexical.equals("COMPARADORES")) {
                patron[0] = "==|<=|>=|!=|<|>";
            } else if (lexical.equals("BOOLEANOS")) {
                patron[0] = "vero|falso";
            } else if (lexical.equals("OP_LOGICO")) {
                patron[0] = "& | |";
            }else if (lexical.equals("LOGICOS")) {
                patron[0] = "&& | ||";
            }else if (lexical.equals("INCREMENTO_DECREMENTO")) {
                patron[0] = "++ | --";
            } else if (lexical.equals("NUMERO")) {
                patron[0] = "-?Numero+(.Numero+)?";
            } else if (lexical.equals("ERROR")) {
                patron[0] =  "[" + token.getLine() + ", " + token.getColumn() + "]";
            } else {
                patron[0] = token.getLexeme();
            }
            Object[] data = new Object[]{token.getLexicalComp(), token.getLexeme(), patron[0]};
            Functions.addRowDataInTable(tblTokens, data);
        });
    }
    
    
    

    private void printConsole() {
        int sizeErrors = errors.size();
        if (sizeErrors > 0) {
            Functions.sortErrorsByLineAndColumn(errors);
            String strErrors = "\n";
            for (ErrorLSSL error : errors) {
                String strError = String.valueOf(error);
                strErrors += strError + "\n";
            }
            jtaOutputConsole.setText("Compilado\n" + strErrors + "\nCompilado con Errores");
        } else {
            jtaOutputConsole.setText("Compilado");
        }
        jtaOutputConsole.setCaretPosition(0);
    }

    private void clearFields() {
        Functions.clearDataInTable(tblTokens);
        jtaOutputConsole.setText("");
        tokens.clear();
        errors.clear();
        identProd.clear();
        identificadores.clear();
        codeHasBeenCompiled = false;
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
                if ("GTK+".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Compilador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            } catch (UnsupportedLookAndFeelException ex) {
                System.out.println("LookAndFeel no soportado: " + ex);
            }
            new Compilador().setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCompilar;
    private javax.swing.JButton btnEjecutar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jtaOutputConsole;
    private javax.swing.JTextPane jtpCode;
    private javax.swing.JPanel panelButtonCompilerExecute;
    private javax.swing.JPanel rootPanel;
    private javax.swing.JTable tblTokens;
    // End of variables declaration//GEN-END:variables
}

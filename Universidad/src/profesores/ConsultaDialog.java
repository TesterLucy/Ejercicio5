package profesores;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ConsultaDialog extends JDialog {
        private JTextField txtCodigo;
        private JTextArea txtResultado;
        private GestionProfesores gestion;

        public ConsultaDialog(Frame parent, GestionProfesores gestionProfesores) {
            super(parent, "Consultar Profesor", true);
            this.gestion = gestionProfesores;
            initComponents();
        }

        private void initComponents() {
            JLabel lblCodigo = new JLabel("Ingrese Código:");
            txtCodigo = new JTextField(15);
            JButton btnBuscar = new JButton("Buscar");
            txtResultado = new JTextArea(5, 20);
            txtResultado.setEditable(false);
            JScrollPane scrollPane = new JScrollPane(txtResultado);

            btnBuscar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buscarEstudiante();
                }
            });

            JPanel panelInput = new JPanel();
            panelInput.add(lblCodigo);
            panelInput.add(txtCodigo);

            JPanel panelBoton = new JPanel();
            panelBoton.add(btnBuscar);

            setLayout(new BorderLayout());
            add(panelInput, BorderLayout.NORTH);
            add(scrollPane, BorderLayout.CENTER);
            add(panelBoton, BorderLayout.SOUTH);

            pack();
            setLocationRelativeTo(getParent());
        }

        private void buscarEstudiante() {
            String codigo = txtCodigo.getText().trim();
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un código.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Profesor profesor = gestion.consultarProfesor(codigo);
            if (profesor != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Cédula: ").append(codigo).append("\n");
                sb.append("Nombre: ").append(profesor.getNombres()).append("\n");
                sb.append("Apellido: ").append(profesor.getApellidos()).append("\n");
                sb.append("Carrera: ").append(profesor.getCarrera()).append("\n");
                sb.append("Dirección: ").append(profesor.getDireccion()).append("\n");
                sb.append("Teléfono: ").append(profesor.getTelefono()).append("\n");
                txtResultado.setText(sb.toString());
            } else {
                txtResultado.setText("Profesor no encontrado.");
            }
        }
    }

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
import javax.swing.JTextField;

/**
 *
 * @author Cristian
 */
public class ModificarDialog extends JDialog {
        private JTextField txtCodigo;
        private GestionProfesores gestion;

        public ModificarDialog(Frame parent, GestionProfesores gestionProfesores) {
            super(parent, "Modificar Estudiante", true);
            this.gestion = gestionProfesores;
            initComponents();
        }

        private void initComponents() {
            JLabel lblCodigo = new JLabel("Ingrese Código:");
            txtCodigo = new JTextField(15);
            JButton btnBuscar = new JButton("Buscar");

            btnBuscar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    buscarProfesor();
                }
            });

            JPanel panelInput = new JPanel();
            panelInput.add(lblCodigo);
            panelInput.add(txtCodigo);
            panelInput.add(btnBuscar);

            setLayout(new BorderLayout());
            add(panelInput, BorderLayout.NORTH);

            pack();
            setLocationRelativeTo(getParent());
        }

        private void buscarProfesor() {
            String codigo = txtCodigo.getText().trim();
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un código.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Profesor profesor = gestion.consultarProfesor(codigo);
            if (profesor != null) {
                // Abrir formulario de modificación
                ModificarFormulario modificarFormulario = new ModificarFormulario(this, gestion, codigo, profesor);
                modificarFormulario.setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Estudiante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

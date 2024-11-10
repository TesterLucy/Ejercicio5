
package Estudiantes;

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
public class BorrarDialog extends JDialog {
        private JTextField txtCodigo;
        private GestionEstudiantes gestion;

        public BorrarDialog(Frame parent, GestionEstudiantes gestionEstudiantes) {
            super(parent, "Borrar Estudiante", true);
            this.gestion = gestionEstudiantes;
            initComponents();
        }

        private void initComponents() {
            JLabel lblCodigo = new JLabel("Ingrese Código:");
            txtCodigo = new JTextField(15);
            JButton btnBorrar = new JButton("Borrar");

            btnBorrar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    borrarEstudiante();
                }
            });

            JPanel panelInput = new JPanel();
            panelInput.add(lblCodigo);
            panelInput.add(txtCodigo);

            JPanel panelBoton = new JPanel();
            panelBoton.add(btnBorrar);

            setLayout(new BorderLayout());
            add(panelInput, BorderLayout.NORTH);
            add(panelBoton, BorderLayout.SOUTH);

            pack();
            setLocationRelativeTo(getParent());
        }

        private void borrarEstudiante() {
            String codigo = txtCodigo.getText().trim();
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, ingrese un código.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(this, "¿Está seguro de borrar al estudiante con código " + codigo + "?", "Confirmar Borrado", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                if (gestion.borrarEstudiante(codigo)) {
                    JOptionPane.showMessageDialog(this, "Estudiante borrado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Estudiante no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }

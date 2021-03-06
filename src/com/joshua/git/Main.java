package com.joshua.git;

/**
 *
 * @author Joshua
 */
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JOptionPane;
import org.kohsuke.github.GHCreateRepositoryBuilder;
import org.kohsuke.github.GitHub;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "File",
        id = "com.joshua.git.Main"
)
@ActionRegistration(
        iconBase = "com/joshua/git/github.png",
        displayName = "#CTL_CrearRepositorio"
)
@ActionReference(path = "Menu/Versioning", position = 0)
@Messages("CTL_CrearRepositorio=Crear Repositorio GitHub")

public final class Main implements ActionListener {

    /**
     * Se crea un repositorio con el nombre indicado. Recibe
     * el usuario y contraseña por teclado.
     *
     * @param e
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        String nombre = JOptionPane.showInputDialog("Nombre del Repositorio:");
        GHCreateRepositoryBuilder builder;

        try {
            GitHub github = GitHub.connectUsingPassword(JOptionPane.showInputDialog("Usuario"), JOptionPane.showInputDialog("Contraseña: "));

            builder = github.createRepository(nombre);
            builder.create();
        } catch (IOException ex) {
        }
    }
}

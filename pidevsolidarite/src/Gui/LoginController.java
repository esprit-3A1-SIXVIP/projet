/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class LoginController {

    @FXML
    private AnchorPane interfaceprincipale;

    @FXML
    private VBox vboxconnexion;

    @FXML
    private Label tc1;
    @FXML
    private JFXButton btni;

    @FXML
    private Label tc2;

    @FXML
    private Pane interfaceconnexion;

    @FXML
    private ImageView lc1;

    @FXML
    private Label lc2;

    @FXML
    private Label lc3;

    @FXML
    private JFXTextField tcl;

    @FXML
    private JFXPasswordField tcp;

    @FXML
    private Label mdpforgot;

    @FXML
    private JFXButton btncx;

    @FXML
    private ImageView ic;

    @FXML
    private Pane paneinscription;

    @FXML
    private JFXPasswordField tipas;

    @FXML
    private JFXPasswordField tipas3;

    @FXML
    private JFXTextField tip;

    @FXML
    private JFXTextField tie;

    @FXML
    private JFXTextField tin;

    @FXML
    private JFXTextField til2;

    @FXML
    private JFXTextField tir;

    @FXML
    private JFXTextField tiv;

    @FXML
    private JFXTextField titel;

    @FXML
    private JFXTextField tipay;

    @FXML
    private Label tititre;

    @FXML
    private JFXTextField tinog;

    @FXML
    private JFXTextField tidog;
    @FXML
    private JFXTextField urlimage;
    @FXML
    private ImageView profil;

    @FXML
    private JFXButton btni1;

    @FXML
    private JFXButton btni2;

    @FXML
    private ImageView close;

    @FXML
    private VBox vboxinscription;

    @FXML
    private Label ti1;

    @FXML
    private JFXButton btnc1;

    @FXML
    private Label ti2;

    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ti1.setVisible(false);
        ti2.setVisible(false);
        tidog.setVisible(false);
        tie.setVisible(false);
        til2.setVisible(false);
        tin.setVisible(false);
        tinog.setVisible(false);
        tip.setVisible(false);
        tipas.setVisible(false);
        tipas3.setVisible(false);
        tipay.setVisible(false);
        tir.setVisible(false);
        titel.setVisible(false);
        tititre.setVisible(false);
        tiv.setVisible(false);
        paneinscription.setVisible(false);
        btni.setVisible(false);
        btni1.setVisible(false);
        btni2.setVisible(false);
        vboxinscription.setVisible(false);
        paneinscription.setVisible(false);
        urlimage.setVisible(false);

    }

    private void btnLoginAction(ActionEvent event) {

    }

    @FXML
    private void btnc1(MouseEvent event) {

        TranslateTransition Slide = new TranslateTransition();
        Slide.setDuration(Duration.seconds(0.7));
        Slide.setNode(vboxconnexion);
        Slide.setToX(0);
        Slide.play();
        vboxconnexion.setVisible(true);
        vboxconnexion.setTranslateX(800);
        interfaceconnexion.setVisible(true);
        paneinscription.setVisible(false);
        vboxinscription.setVisible(false);
        ti1.setVisible(false);
        ti2.setVisible(false);
        tidog.setVisible(false);
        tie.setVisible(false);
        til2.setVisible(false);
        tin.setVisible(false);
        tinog.setVisible(false);
        tip.setVisible(false);
        tipas.setVisible(false);
        tipas3.setVisible(false);
        tipay.setVisible(false);
        tir.setVisible(false);
        titel.setVisible(false);
        tititre.setVisible(false);
        tiv.setVisible(false);
        paneinscription.setVisible(false);
        btni.setVisible(true);
        btni1.setVisible(false);
        btni2.setVisible(false);
        urlimage.setVisible(false);
        Slide.setOnFinished((e -> {
        }));

    }

    @FXML
    private void btni(MouseEvent event) {
        TranslateTransition Slide = new TranslateTransition();
        Slide.setDuration(Duration.seconds(0.7));
        Slide.setNode(vboxinscription);
        Slide.setToX(400);
        Slide.play();
        vboxinscription.setTranslateX(-30);
        vboxinscription.setVisible(true);
        interfaceconnexion.setVisible(false);
        vboxconnexion.setVisible(false);
        ti1.setVisible(true);
        ti2.setVisible(true);
        tidog.setVisible(true);
        tie.setVisible(true);
        til2.setVisible(true);
        tin.setVisible(true);
        tinog.setVisible(true);
        tip.setVisible(true);
        tipas.setVisible(true);
        tipas3.setVisible(true);
        tipay.setVisible(true);
        tir.setVisible(true);
        titel.setVisible(true);
        tititre.setVisible(true);
        tiv.setVisible(true);
        paneinscription.setVisible(true);
        btni.setVisible(true);
        btni1.setVisible(true);
        btni2.setVisible(true);
        urlimage.setVisible(true);
        Slide.setOnFinished((e -> {
        }));
    }

    @FXML
    private void closebtn(MouseEvent event) {
        Stage stage = (Stage)close.getScene().getWindow();
    // do what you have to do
    stage.close();
    }

    @FXML
    private void profil(MouseEvent event) {
        JFileChooser file = new JFileChooser();
        file.setCurrentDirectory(new File(System.getProperty("user.home")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.images", "jpg", "gif", "png");
        file.addChoosableFileFilter(filter);
        int result = file.showSaveDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = file.getSelectedFile();
            String path = selectedFile.getAbsolutePath();

            urlimage.setText(path);

        } else if (result == JFileChooser.CANCEL_OPTION) {
            System.out.println("Aucune image selectionner");
        }
    }

    @FXML
    private void btncx(MouseEvent event) 
    {
        
        
    }

}

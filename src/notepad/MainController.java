package notepad;

import java.io.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController{
    private String currentFont = "Consolas";
    private int currentSize = 14;
    public File selected;
    @FXML
    private TextArea textArea;

    @FXML 
    private MenuItem s12;
    @FXML
    private MenuItem s14;
    @FXML
    private MenuItem s16;
    @FXML
    private MenuItem s18;
    @FXML
    private MenuItem s20;
    @FXML
    private MenuItem s22;
    @FXML
    private MenuItem s24;
    @FXML
    private MenuItem s26;
    @FXML
    private MenuItem s28;
    @FXML
    private MenuItem s30;

    @FXML 
    private MenuItem arial;
    @FXML
    private MenuItem century;
    @FXML
    private MenuItem consolas;
    @FXML
    private MenuItem monospace;
    @FXML
    private MenuItem georgia;

    public void closeApp(ActionEvent e){
        Platform.exit();
        System.exit(0);
    }

    public void openFile(ActionEvent e) throws Exception{
        System.out.println("Opening File");
        textArea.setText("");
        FileChooser fc = new FileChooser();
        fc.setTitle("Open File");
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Documents"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        selected = fc.showOpenDialog(null);
        if (selected != null){
            BufferedReader bf = new BufferedReader(new FileReader(selected));
            String line = bf.readLine();
            while(line != null){
                
                textArea.appendText(line + "\n");
                line = bf.readLine();
            }
            bf.close();
        } else{
            System.out.println("Invalid File!");
        }
        System.out.println("File Opened");
    }
    public void saveFile(ActionEvent e) throws Exception{
        System.out.println("Saving File");
        selected = new File("untitled.txt");
        FileChooser fc = new FileChooser();
        fc.setTitle("Save File");
        fc.setInitialDirectory(new File(System.getProperty("user.home") + "\\Documents"));
        fc.getExtensionFilters().addAll(new ExtensionFilter("All Files", "*.*"));
        selected = fc.showSaveDialog(null);
        FileWriter fileWriter = new FileWriter(selected);
        if (!selected.exists()){
            selected.createNewFile();
        }
        System.out.println(textArea.getText());
        BufferedWriter bw = new BufferedWriter(fileWriter);
        bw.write(textArea.getText());
        bw.close();
        System.out.println("File Saved");
    }

    public void changeFont(ActionEvent e){
        if (((MenuItem) e.getSource()).getId() == arial.getId()){
            currentFont = "Arial";
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == century.getId()){
            currentFont = "Century";
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == consolas.getId()){
            currentFont = "Consolas";
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == monospace.getId()){
            currentFont = "Monospace";
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == georgia.getId()){
            currentFont = "Georgia";
            triggerChange();
        }
    }
    public void changeSize(ActionEvent e){
        if (((MenuItem) e.getSource()).getId() == s12.getId()){
            currentSize = 12;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s14.getId()){
            currentSize = 14;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s16.getId()){
            currentSize = 16;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s18.getId()){
            currentSize = 18;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s20.getId()){
            currentSize = 20;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s22.getId()){
            currentSize = 22;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s24.getId()){
            currentSize = 24;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s26.getId()){
            currentSize = 26;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s28.getId()){
            currentSize = 28;
            triggerChange();
        } else if (((MenuItem) e.getSource()).getId() == s30.getId()){
            currentSize = 30;
            triggerChange();
        }
    }
    public void triggerChange(){
        textArea.setFont(Font.font(currentFont, currentSize));
    }
}

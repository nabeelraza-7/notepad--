package notepad;

import java.io.*;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class MainController{
    public File selected;
    @FXML
    private TextArea textArea;
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
}

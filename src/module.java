
import java.util.Stack;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thiwanka
 */

public class module {
    
    public static void main(String[] args) {
        
        File f=new File();
        f.setFileContent("Starting");
        f.save();
        f.setFileContent("Writing");
        f.save();
        f.setFileContent("Still Writing");
        f.save();
        f.setFileContent("Finish");
        f.save();
        
        f.undo();
        System.out.println(f.getFileContent());
        f.undo();
        System.out.println(f.getFileContent());
        f.undo();
        System.out.println(f.getFileContent());
        
    }
    
}

class File{

    /**
     * @return the fileContent
     */
    public String getFileContent() {
        return fileContent;
    }

    /**
     * @param fileContent the fileContent to set
     */
    public void setFileContent(String fileContent) {
        this.fileContent = fileContent;
    }
    
    private String fileContent;
    private final File_caretaker filecaretaker=new File_caretaker();
    
    public void save(){
        filecaretaker.addmemento(new File_Momento(fileContent));
    }
    
    public void undo(){
        this.fileContent=filecaretaker.getMemento().getFileContent();
    }
    
}

class File_Momento{

    /**
     * @return the fileContent
     */
    public String getFileContent() {
        return fileContent;
    }
    
    private final String fileContent;

    public File_Momento(String fileContent) {
        this.fileContent = fileContent;
    }
    
}

class File_caretaker{
    
    Stack<File_Momento> mementoStack=new Stack<>();
    
    public void addmemento(File_Momento memento){
        mementoStack.push(memento);
    }
    
    public File_Momento getMemento(){
        return mementoStack.pop();
    }
    
}

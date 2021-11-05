
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
public class prac {
    public static void main(String[] args) {
        
        file f1 = new file();
        f1.setFileContent("Starting");
        f1.Save();
        f1.setFileContent("Writing");
        f1.Save();
        f1.setFileContent("Still Writing");
        f1.Save();
        f1.setFileContent("Finish");
        f1.Save();
        
        f1.Undo();
        System.out.println(f1.getFileContent());
        f1.Undo();
        System.out.println(f1.getFileContent());
        f1.Undo();
        System.out.println(f1.getFileContent());
        
    }
}
class file{//Originator
    
    
    public String getFileContent(){ //getter method 
        return fileContents;
    }
    public void setFileContent(String fileContents){  //setter method
        this.fileContents = fileContents;
    } 
        private String fileContents;
        private final File_caretaker filecaretaker = new File_caretaker();
        public void Save(){
            filecaretaker.addmemento(new File_Momento(fileContents));
        }
        public void Undo(){
            this.fileContents=filecaretaker.getMemento().getFileContent();
        }
    }
    


class File_Memento{
    private String fileContents;
    
    public String getFileContent(){ //getter method 
       // String fileContent;
        return fileContents;
    }

    public File_Memento(String fileContents) { //constructor
        this.fileContents = fileContents;
    }
    
}

class FileCaretaker{
    Stack<File_Memento> mementoStack = new Stack<>();
    
    public void addmemento(File_Memento memento){
        mementoStack.push(memento);
    }

    public File_Memento getMemento() {
        return mementoStack.pop();
    }
    
}

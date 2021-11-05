
import java.util.Stack;

public class module {
    public static void main(String[] args) {
            
        Originator originator = new Originator();
        originator.setData("Hello");
        originator.setData("Java");
        originator.save();
        originator.setData("OOP");
        originator.save();
        originator.setData("Java Institute");
        originator.save();
        
        originator.undo();
        System.out.println(originator.getData());
        
        originator.undo();
        System.out.println(originator.getData());
}
}
class Originator{

    private String data;
    private final CareTaker careTaker = new CareTaker();
    
    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
    public void save(){
        careTaker.addMemento(new Memento(data));
    }
    public void undo(){
       this.data =  careTaker.getMemento().getData();
    }
}

class Memento{
    private final String data;

    public Memento(String data) {
        this.data= data;
    }

   
    
    public String getData() {
        return data;
    }
}

 class CareTaker{
     private final Stack<Memento> mementoStack = new Stack<>();
     public void addMemento(Memento memento){
         mementoStack.push(memento);
     }
     public Memento getMemento(){
         return mementoStack.pop();
     }
     
 }
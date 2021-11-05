
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Thiwanka
 */
public class Test {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        A a = new A(10);
        a.setI(50);
        a.setI(80);
        a.setI(200);
    }

}

class A {    // Originator

    private int i;
    private final A_Caretaker caretaker = new A_Caretaker();

    public A(int i) {
        this.i = i;
    }

    public void setI(int i) {
        this.i = i;
        caretaker.addMemento(new A_Memento(i));
    }

    public void save() {
        caretaker.addMemento(new A_Memento(i));
    }

    public void undo() {
        this.i = caretaker.getMemento().getI();
    }
}

class A_Memento {//Memento

    private int i;

    public A_Memento(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }
}

class A_Caretaker {//Care Taker

    private final ArrayList<A_Memento> mementoList = new ArrayList<>();

    public void addMemento(A_Memento memento) {
        mementoList.add(memento);
    }
    public A_Memento getMemento() {
       return mementoList.get(mementoList.size()-1);
    }

}

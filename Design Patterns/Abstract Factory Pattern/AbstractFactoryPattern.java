/*
Reference: https://refactoring.guru/design-patterns/abstract-factory
Please refer to the pseudocode given there to understand this commit.
It will help a great deal
 */

//The Parent abstract factory that now is used
interface GUIFactory{
    Button createButton(); // first component
    CheckBox createCheckBox(); // second component
}

//abstract factory's first component
interface Button{
    void paint();
}

//abstract factory's second component
interface CheckBox{
    void paint();
}

// Now that we have created the components' interfaces,
// let's create concrete implementations for two diff OS - Windows and Mac
class WinButton implements Button{
    @Override
    public void paint() {
        System.out.println("Window button is painted");
    }
}

class MacButton implements Button{
    @Override
    public void paint() {
        System.out.println("Mac button is painted");
    }
}

class WinCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Window checkbox is painted");
    }
}

class MacCheckBox implements CheckBox{
    @Override
    public void paint() {
        System.out.println("Mac checkbox is painted");
    }
}

//Now let's segregate the Windows and Mac implementations
// to create 2 concrete factories ie. implementations of parent factory.
class WinFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new WinButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WinCheckBox();
    }
}

class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}


//The class created from abstract factory, that will be used by client
class GUI{
    public CheckBox checkBox;
    public Button button;

    GUI(OSType osType){
        GUIFactory guiFactory = (osType == OSType.WINDOWS) ? new WinFactory() : new MacFactory();

        button = guiFactory.createButton();
        checkBox = guiFactory.createCheckBox();
    }

    void paint(){
        button.paint();
        checkBox.paint();
    }
}

//enum OSType defined below
public class AbstractFactoryPattern {
    //client code using the abstract factory

    public static void main(String[] args) {
        //emulating some code that finds out the OS of the system.
        OSType winType = OSType.WINDOWS;
        OSType macType = OSType.MAC;

        //nice and clean
        GUI gui = new GUI(winType);
        gui.paint();

        gui = new GUI(macType);
        gui.paint();
    }
}

enum OSType{
    WINDOWS(0), MAC(1);

    public final int value;
    OSType(int value) {
        this.value = value;
    }
}

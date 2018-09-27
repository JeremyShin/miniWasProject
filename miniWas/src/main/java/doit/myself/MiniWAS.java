package doit.myself;

public class MiniWAS extends Thread{

    public void run(){
        Connector connector = new Connector();
        connector.run();
    }


}

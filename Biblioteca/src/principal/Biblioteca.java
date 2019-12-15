package principal;

public class Biblioteca extends Object {
  public static void main(String[] args) throws Exception{
    Biblioteca b = new Biblioteca() ;
  }
  public Biblioteca() throws Exception {
    TelaPrincipal telaPrincipal = new TelaPrincipal();
    telaPrincipal.setVisible(true);
  }
}
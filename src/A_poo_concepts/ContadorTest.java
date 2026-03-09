package A_poo_concepts;

public class ContadorTest {
    public static void main(String[] args) {
        Contador cont1 = new Contador();
        cont1.incrementar();
        cont1.incrementar();
        cont1.incrementar();
        
        Contador cont2 = new Contador();
        cont2.incrementar();

        System.out.println("A_poo_concepts.Contador 1: "+cont1.valor);
        System.out.println("A_poo_concepts.Contador 2: "+cont2.valor);

    }
}

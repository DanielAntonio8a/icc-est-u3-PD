public class App {
    public static void main(String[] args) throws Exception {
        runEjerciciosPD();
    }

    public static void runEjerciciosPD() {

        EjerciciosPd ejerciciosPd = new EjerciciosPd();
        
        System.out.println("Fibonacci Recursivo");
        long start = System.nanoTime();
        long resultado = ejerciciosPd.getFibonaci(100);
        long end = System.nanoTime();
        long duration = end - start;
        System.out.println("Resultado = " + resultado + " en tiempo = " + duration + " nanosegundos");

        System.out.println("Fibonacci Recursivo Caching");
        long start1 = System.nanoTime();
        long resultado1 = ejerciciosPd.getFibonaciPD(50);
        long end1 = System.nanoTime();
        long duration1 = end1 - start1;
        System.out.println("Resultado = " + resultado1 + " en tiempo = " + duration1 + " nanosegundos");
    }
}
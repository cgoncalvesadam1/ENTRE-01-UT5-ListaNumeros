/**
 * La clase representa a una lista de 
 * números enteros
 * 
 * @author - CATARINA GONÇALVES ALMEIDA
 * 
 */
import java.util.Arrays;

public class ListaNumeros 
{
    // definir atributos
    private int[] lista;
    private int pos;

    /**
     * Constructor de la clase ListaNumeros 
     * Crea e inicializa adecuadamente los
     * atributos
     * 
     * @param n el tamaño máximo de la lista
     */
    public ListaNumeros(int n) {
        lista = new int[n];
        pos = 0;
    }

    /**
     * Añade un valor siempre al principio de la lista
     * 
     * @param numero el valor que se añade. No se hace nada si la lista está
     *               completa
     * @return true si se ha podido añadir, false en otro caso
     */
    public boolean addElemento(int numero) {
        if(estaCompleta() == false){
            for(int i = pos; i > 0; i--){
                lista[i] = lista[i - 1];
            }
            lista[0] = numero;
            pos++;
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * devuelve true si la lista está completa, false en otro caso
     * Hacer sin if
     */
    public boolean estaCompleta() {

        return pos == lista.length;

    }

    /**
     * devuelve true si la lista está vacía, false en otro caso. 
     * Hacer sin if
     */
    public boolean estaVacia() {
        return pos == 0;
    }

    /**
     * devuelve el nº de elementos realmente guardados en la lista
     */
    public int getTotalNumeros() {
        return pos;
    }

    /**
     * Vacía la lista
     */
    public void vaciarLista() {
        // if (lista.length == 0){
        // System.out.println("vacia"); 
        // } else {
        // System.out.println("no vacía");
        // }
        for(int i = 0; i <= lista.length; i++){
            lista[i] = 0;
        }
    }

    /**
     * Representación textual de la lista de la forma indicada 
     * (leer enunciado)
     * 
     * Si la lista está vacía devuelve ""
     */
    public String toString() {
        String str = "";
        if (!estaVacia()){
            for (int i = 0; i < lista.length; i++){
                str += String.format("%8d", lista[i]);
            }
            str += "\n";
            for (int i = 0; i < lista.length; i++){
                str+= String.format("%8d", i);
            }
            return str;
        }
        return str;
    }

    /**
     * Mostrar en pantalla la lista
     */
    public void escribirLista() {
        System.out.println(this.toString());
    }

    /**
     * Búsqueda lineal de numero en la lista
     * @param numero el nº a buscar
     * @return un array con las posiciones en las que se ha encontrado
     *  
     */
    public int[] buscarPosicionesDe(int numero) {
        int[] posicion = new int[lista.length];
        int total = 0;
        int i = 0;
        while(i < lista.length){
            if(lista[i] == numero){
                posicion[i] = i;
                total++;
            }
        }
        return posicion;
    }

    /**
     * Hace una búsqueda binaria del numero indicado devolviendo -1 si no se
     * encuentra o la posición en la que aparece
     * 
     * El array original lista no se modifica 
     * Para ello crea previamente una copia
     * de lista y trabaja con la copia
     * 
     * Usa exclusivamente métodos de la clase Arrays
     * 
     */
    public int buscarBinario(int numero) {
        int[] resultado = new int[lista.length];
        System.arraycopy( lista, 0, resultado, 0, lista.length );

        int total; 
        total = Arrays.binarySearch(lista, numero); 

        return total; 

    }

    /**
     * borra el primer elemento de la lista
     */
    public void borrarPrimero() {
        for (int  i = 0; i < lista.length; i++){
            if(i == 0){
                lista[i] = 0;
            }
        }
    }

    /**
     *  Invierte cada uno de los grupos de n elementos que hay en lista
     *  
     *  Si el nº de elementos en lista no es divisible entre n los elementos restantes 
     *  quedan igual
     *  
     *  (leer enunciado)
     *  
     */
    public void invertir(int n) {
        int maxNumeros = n;
        int nGrupos = (lista.length / maxNumeros);
        int contGrupos = 0;
        int contNumeros = 0;
        int[] grupito = new int[maxNumeros];
        for (int i = 0; i < lista.length; i++) {
            grupito[contNumeros] = lista[i];
            if (++contNumeros >= maxNumeros) {
                contGrupos++;
                for (int j = 0; j < maxNumeros; j++) {
                    lista[i - j] = grupito[j];
                }
                grupito = new int[maxNumeros];
                contNumeros = 0;
            }
        }
        System.out.println("\nArray cambiado:");
        for (int valore : lista) {
            System.out.print("Lista " + lista);
        }
    }

    /**
     * devuelve un ragged array de 2 dimensiones con tantas filas como valores
     * tenga el atributo lista y rellena el array de la forma indicada
     * (leer enunciado)
     * 
     */
    public int[][] toArray2D() {
        int [][] ragged = new int [lista.length][];
        if(lista.length == 1){
            ragged[0] = new int[1];
            ragged[0][0]= 1;
        }
        else if (lista.length == 2){
            ragged[0] = new int[1];
            ragged[1] = new int[2];
            ragged[0][0] = 1;
            ragged[0][1] = 1;
            ragged[1][0] = 1;
            ragged[1][1] = 1;
        } 
        else{
            ragged[0] = new int[1];
            ragged[1] = new int[2];
            ragged[0][0] = 1;
            ragged[0][1] = 1;
            ragged[1][0] = 1;
            ragged[1][1] = 1;
        }
        for (int i = 2; i < lista.length; i++ ){
            ragged[i] = new int[i + 1];
            ragged[i][0] = 1;
            ragged[i][i] = 1;
        }
        return ragged;
    }

    /**
     * Punto de entrada a la aplicación 
     * Contiene código para probar los métodos de ListaNumeros
     */
    public static void main(String[] args) {
        ListaNumeros lista = new ListaNumeros(20);

        System.out.println("--- addElemento() y toString() -------");
        int[] valores = {21, -5, 6, -7, 21, -17, 21, 15, 22, 21, 77};
        for (int i = 0; i < valores.length; i++) {
            lista.addElemento(valores[i]);
        }
        System.out.println(lista.toString());

        System.out.println("--- buscarPosiciones() -------");
        int numero = 21;
        System.out.println(lista.toString());
        System.out.println("\t" + numero + " aparece en posiciones ");
        // seguir completando
        int[] buscar = lista.buscarPosicionesDe(numero);
        for(int i = 0; i < buscar.length; i++){
            System.out.print("" + buscar[i]);
        }
        System.out.println();

        System.out.println("--- buscarBinario() ---");
        if(lista.buscarBinario(numero) >= 0){
            System.out.println("Aparece en la lista");
        }else{
            System.out.println("No aparece en la lista");
        }
        System.out.println();

        System.out.println("---invertir()---");
        System.out.println("Sin invertir lista:");
        System.out.println(lista.toString());
        System.out.println("Lista invertida con grupos de 4 elementos y " + lista.getTotalNumeros() + " total de elementos");
        lista.invertir(4);
        System.out.println(lista.toString());
        System.out.println();

        System.out.println("---toArray2D()---\n");
        int[][] array2D = lista.toArray2D();
        for(int i = 0; i < array2D.length; i++){
            System.out.print("Fila " + (i + 1) + ":");
            for(int j = 0; j < array2D[i].length; j++){
                System.out.print(array2D[i][j] + " ");
            }
            System.out.println();
        }
    }
}

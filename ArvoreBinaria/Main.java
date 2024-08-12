public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvoreBinaria = new ArvoreBinaria();

        arvoreBinaria.inserir(6);
        arvoreBinaria.inserir(18);
        arvoreBinaria.inserir(3);
        arvoreBinaria.inserir(2);
        arvoreBinaria.inserir(16);
        arvoreBinaria.inserir(15);
        arvoreBinaria.inserir(17);
        arvoreBinaria.inserir(20);
        arvoreBinaria.inserir(21);
        arvoreBinaria.inserir(19);
        arvoreBinaria.remover(6);
        System.out.println("Pré-ordem: ");
        arvoreBinaria.preOrdem(arvoreBinaria.getRaiz());
        System.out.println("Em ordem: ");
        arvoreBinaria.emOrdem(arvoreBinaria.getRaiz());
        System.out.println("Pós ordem: ");
        arvoreBinaria.posOrdem(arvoreBinaria.getRaiz());
    }
}
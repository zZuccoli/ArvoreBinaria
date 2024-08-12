public class ArvoreBinaria {
    private No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        No novoNo = new No(valor);
        if(this.raiz == null) {
            this.raiz = novoNo;
        } else {
            No atual = this.raiz;
            No pai = null;
            boolean esquerda = false;
            while(atual != null) {
                if(novoNo.getValor() < atual.getValor()) {
                    pai = atual;
                    atual = atual.getEsq();
                    esquerda = true;
                } else {
                    pai = atual;
                    atual = atual.getDir();
                    esquerda = false;
                }
            }
            if(esquerda) {
                pai.setEsq(novoNo);
            } else {
                pai.setDir(novoNo);
            }
        }
    }

    public No getRaiz() {
        return this.raiz;
    }

    public void preOrdem(No no) {
        if(no == null) {
            return;
        }
        System.out.println(no.getValor());
        preOrdem(no.getEsq());
        preOrdem(no.getDir());
    }

    public void emOrdem(No no) {
        if(no == null) {
            return;
        }
        emOrdem(no.getEsq());
        System.out.println(no.getValor());
        emOrdem(no.getDir());
    }

    public void posOrdem(No no) {
        if(no == null) {
            return;
        }
        posOrdem(no.getEsq());
        posOrdem(no.getDir());
        System.out.println(no.getValor());
    }

    public void remover(int valor) {
        No atual = raiz;
        No pai = null;

        // Localiza o nó a ser removido
        while (atual != null && atual.getValor() != valor) {
            pai = atual;
            if (valor < atual.getValor()) {
                atual = atual.getEsq();
            } else {
                atual = atual.getDir();
            }
        }

        // Se o nó não foi encontrado
        if (atual == null) {
            System.out.println("O valor " + valor + " não foi encontrado.");
            return;
        }

        // Caso 1: Remoção de nó folha (sem filhos)
        if (atual.getEsq() == null && atual.getDir() == null) {
            if (atual == raiz) {
                raiz = null; // Se o nó é a raiz
            } else if (pai.getEsq() == atual) {
                pai.setEsq(null);
            } else {
                pai.setDir(null);
            }
        }
    // Caso 2: Remoção de nó com um filho
        else if (atual.getEsq() == null || atual.getDir() == null) {
            No filho;
            if (atual.getEsq() != null) {
                filho = atual.getEsq();
            } else {
                filho = atual.getDir();
            }
            if (atual == raiz) {
                raiz = filho;
            }
            else {
                if (pai.getEsq() == atual) {
                    pai.setEsq(filho);
                } else {
                    pai.setDir(filho);
                }
            }
        }
        // Caso 3: Remoção de nó com dois filhos
        else {
            No sucessor = getSucessor(atual);

            if (atual == raiz) {
                raiz = sucessor;
            } else if (pai.getEsq() == atual) {
                pai.setEsq(sucessor);
            } else {
                pai.setDir(sucessor);
            }

            sucessor.setEsq(atual.getEsq());
        }
    }

    //Metodo auxiliar para encontrar o sucessor (menor valor na subárvore direita)
    private No getSucessor(No no) {
        No sucessorPai = no;
        No sucessor = no;
        No atual = no.getDir();

        while (atual != null) {
            sucessorPai = sucessor;
            sucessor = atual;
            atual = atual.getEsq();
        }

        // O sucessor não é o filho direto do nó a ser removido
        if (sucessor != no.getDir()) {
            sucessorPai.setEsq(sucessor.getDir());
            sucessor.setDir(no.getDir());
        }

        return sucessor;
    }
}

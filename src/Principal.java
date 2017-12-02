/*
 * Universidade Federal de Santa Catarina - UFSC
 * Departamento de Informática e Estatística - INE
 * Programa de Pós-Graduação em Ciências da Computação - PROPG
 * Disciplina: Projeto e Análise de Algoritmos
 * Prof Alexandre Gonçalves da Silva 
 *
 * Página 267 Thomas H. Cormen 3 ed
 *
 * Corte de Hastes Memorizado de cima para baixo/Memoized Cut Rod Top Down
 *
 * Atenção:
 * Vetor em java inicia em 0, os algoritmos consideram início em 1.
 * A subtração de -1 ocorre somente no local de acesso ao vetor ou matriz 
 * para manter a compatibilidade entre os algoritmos.
 * 
 */

/**
 * @author Osmar de Oliveira Braz Junior
 */
public class Principal {

    /**
     * Retorna o maior valor entre dois valores inteiros.
     *
     * Em java pode ser utilizando Math.max(int a, int b)
     *
     * @param a primeiro valor inteiro.
     * @param b segundo valor inteiro.
     * @return o maior valor entre os a e b
     */
    public static int max(int a, int b) {
        if (a > b) {
            return a;
        } else {
            return b;
        }
    }

    /**
     *
     * @param p Vetor dos preços das hastes.
     * @param n Tamanho de haste.
     * @param r Vetor da receita máxima possível para uma haste de comprimento
     * n.
     * @return
     */
    public static int memoizedcorteDeHastesAux(int[] p, int n, int[] r) {
        if (r[n] >= 0) {
            return r[n];
        }
        int q;
        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                q = max(q, p[i - 1] + memoizedcorteDeHastesAux(p, n - i, r));
            }
            r[n] = q;
        }
        return q;
    }

    /**
     * Cortes de Hastes/Cut Rod.
     *
     * @param p Preços das hastes.
     * @param n Tamanho da haste.
     */
    public static int memoizedcorteDeHastes(int[] p, int n) {
        //um novo arranjo
        int[] r = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return memoizedcorteDeHastesAux(p, n, r);
    }

    public static void main(String args[]) {

        //Vetor dos dados com os preços das hastes   
        int p[] = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

        //Tamanho da astes
        int n = 4;

        System.out.println(">>> Corte de Hastes Memorizado de cima para baixo/Memoized Cut Rod Top Down <<<");

        int q = memoizedcorteDeHastes(p, n);

        System.out.println("\nReceita máxima para n=" + n + " é " + q);        
    }
}

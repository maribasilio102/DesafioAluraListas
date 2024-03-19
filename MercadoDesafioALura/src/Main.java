import Modelo.Cartao;
import Modelo.Compras;

import java.util.*;

import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        int operacao = 0;

        Cartao cartao = new Cartao();
        cartao.defineLimite();

        ArrayList<Compras> listaCompras = new ArrayList<>();

        while (operacao == 0) {

            double valor = 0;
            String produto = "";

            Scanner input = new Scanner(System.in);

            Compras compras = new Compras(valor, produto);
            compras.setProduto();
            compras.setValor();
            compras.setLimiteCartao(cartao.getLimiteCartao() - valor);
            compras.calcule(cartao.getLimiteCartao());
            cartao.setLimiteCartao(compras.getLimiteCartao());

            listaCompras.add(compras);

            out.println("Seu carrinho de compras até o momento, contém:" );

        for (Compras compra : listaCompras) {
            out.println(compra.getProduto());
        }

            System.out.println("*** Gostaria de realizar outra compra? ***");
            System.out.println("*** Digite 0 para continuar ou 1 para encerrar ***");
            operacao = input.nextInt();

            if (operacao!= 0 && operacao != 1){
                out.println("Esta operação não existe, vamos encerrar suas compras!");
                operacao = 1;
            }
        }

        listaCompras.sort(Comparator.comparing(Compras::getValor));
        out.println("Sua lista de compras: " +listaCompras);
        out.println("Limite atual do cartão " +cartao.getLimiteCartao());

        System.out.println("Obrigado pela sua preferência");
    }
}

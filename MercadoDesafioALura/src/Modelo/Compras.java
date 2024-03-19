package Modelo;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Compras extends Cartao implements Calculadora{
    private Double valor;
    private String produto;

    public Compras(Double valor, String produto) {
        this.valor = valor;
        this.produto = produto;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor() {
        Scanner valorCompra = new Scanner(System.in);
        System.out.println("Digite o valor da sua compra: ");
        this.valor = valorCompra.nextDouble();
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto() {
        Scanner produtoCompra = new Scanner(System.in);
        System.out.println("Digite qual é o seu produto: ");
        this.produto = produtoCompra.nextLine();
    }

    @Override
    public void calcule(Double limiteCartao) {
        if (limiteCartao < valor){
            System.out.println("Você não tem limite disponível para esta compra.");
        }else {
            var limite = limiteCartao - valor;
            System.out.println("Agora você tem " +limite+ " disponível no cartão.");
            this.setLimiteCartao(limite);
        }
    }

    public void listaCompras(Double valor, String produto){
        List<Compras> lista = new ArrayList<>();
        lista.add(new Compras(valor, produto));
        lista.sort(Comparator.comparing(Compras::getValor));

        System.out.println("Lista de compras completa: " +lista);
    }

    @Override
    public String toString() {
        return "Produto: " +produto+ ", valor: " +valor;
    }

}

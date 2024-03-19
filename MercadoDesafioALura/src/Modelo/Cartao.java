package Modelo;

import java.util.Scanner;

public class Cartao {
    private Double limiteCartao;

    public Double defineLimite(){
        Scanner cartaoLimite = new Scanner(System.in);
        System.out.println("Digite o limite do cartão:");
        this.limiteCartao = cartaoLimite.nextDouble();
        return this.limiteCartao;
    }

    public Double getLimiteCartao() {
        return limiteCartao;
    }

    public void setLimiteCartao(Double novoLimite) {
        this.limiteCartao = novoLimite;
    }
}

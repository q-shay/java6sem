package livraria.decorator;

import livraria.builder.Livro;

public class MainDecorator {
    public static void main(String[] args) {
        Livro livro = new Livro.Builder("978-85-359-0277-8", "Clean Architecture", 100.00).build();

        // 1. Componente concreto puro
        ItemPedido item = new LivroItemPedido(livro);

        // 2. Decoração encadeada e dinâmica em tempo de execução
        item = new EmbrulhoPresenteDecorator(item);
        item = new FreteExpressoDecorator(item);
        item = new SeguroExtravioDecorator(item);

        System.out.println("Itens do Pedido: " + item.getDescricao());
        System.out.printf("Valor Final Consolidado: R$ %.2f%n", item.getPreco());
    }
}

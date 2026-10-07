package livraria.decorator;

import livraria.builder.Livro;

/**
 * Papel GoF: ConcreteComponent.
 * Representa o item básico da livraria sem serviços adicionais.
 */
class LivroItemPedido implements ItemPedido {
    private final Livro livro;

    public LivroItemPedido(Livro livro) {
        this.livro = livro;
    }

    @Override
    public String getDescricao() {
        return livro.getTitulo() + " (ISBN: " + livro.getIsbn() + ")";
    }

    @Override
    public double getPreco() {
        return livro.getPrecoBase();
    }
}

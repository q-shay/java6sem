package livraria.decorator;

/**
 * Papel GoF: Decorator Abstrato.
 * Mantém uma referência ao objeto decorado (composição) e implementa a mesma interface (polimorfismo).
 */
abstract class ItemPedidoDecorator implements ItemPedido {
    // Referência composicional protegida para que os ConcreteDecorators façam a delegação
    protected final ItemPedido itemDecorado;

    public ItemPedidoDecorator(ItemPedido itemDecorado) {
        this.itemDecorado = itemDecorado;
    }

    @Override
    public String getDescricao() {
        return itemDecorado.getDescricao(); // Delegação padrão
    }

    @Override
    public double getPreco() {
        return itemDecorado.getPreco(); // Delegação padrão
    }
}

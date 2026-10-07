package livraria.decorator;

/**
 * Papel GoF: ConcreteDecorator 2.
 * Adiciona frete prioritário expresso com rastreamento ativo.
 */
class FreteExpressoDecorator extends ItemPedidoDecorator {
    private static final double TAXA_FRETE = 25.00;

    public FreteExpressoDecorator(ItemPedido itemDecorado) {
        super(itemDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + [Frete Expresso 24h]";
    }

    @Override
    public double getPreco() {
        return super.getPreco() + TAXA_FRETE;
    }
}

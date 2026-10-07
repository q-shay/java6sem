package livraria.decorator;

/**
 * Papel GoF: ConcreteDecorator 1.
 * Adiciona custo e descrição de embrulho para presente.
 */
class EmbrulhoPresenteDecorator extends ItemPedidoDecorator {
    private static final double TAXA_EMBRULHO = 12.50;

    public EmbrulhoPresenteDecorator(ItemPedido itemDecorado) {
        super(itemDecorado);
    }

    @Override
    public String getDescricao() {
        // Intercepta e estende a funcionalidade do componente envolvido
        return super.getDescricao() + " + [Embrulho de Presente em Cetim]";
    }

    @Override
    public double getPreco() {
        // Delegação ao objeto decorado acumulando a nova regra de preço
        return super.getPreco() + TAXA_EMBRULHO;
    }
}

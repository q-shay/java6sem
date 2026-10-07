package livraria.decorator;

/**
 * Papel GoF: ConcreteDecorator 3.
 * Adiciona seguro de extravio para edições raras ou caras.
 */
class SeguroExtravioDecorator extends ItemPedidoDecorator {
    public SeguroExtravioDecorator(ItemPedido itemDecorado) {
        super(itemDecorado);
    }

    @Override
    public String getDescricao() {
        return super.getDescricao() + " + [Seguro Cobertura Total]";
    }

    @Override
    public double getPreco() {
        // Cálculo dinâmico: taxa base de 5 reais + 2% do valor acumulado até aqui
        return super.getPreco() + 5.00 + (super.getPreco() * 0.02);
    }
}

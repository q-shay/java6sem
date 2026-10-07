package livraria.decorator;

/**
 * Padrão GoF: Decorator (Estrutural).
 * Papel: Component (Contrato comum do item negociável na livraria).
 */
public interface ItemPedido {
    String getDescricao();
    double getPreco();
}

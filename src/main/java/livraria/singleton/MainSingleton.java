package livraria.singleton;

import livraria.builder.Livro;

public class MainSingleton {
    public static void main(String[] args) {
        // Simulando acessos concorrentes em múltiplos pontos da livraria
        CatalogoCache moduloVendasCache = CatalogoCache.getInstance();
        CatalogoCache moduloEstoqueCache = CatalogoCache.getInstance();

        Livro livro = new Livro.Builder("978-0132350884", "Clean Code", 85.00).build();
        moduloVendasCache.registrarLivro(livro);

        // Verificação de identidade de instância
        System.out.println("Instância Vendas HashCode: " + moduloVendasCache.hashCode());
        System.out.println("Instância Estoque HashCode: " + moduloEstoqueCache.hashCode());

        boolean mesmaInstancia = (moduloVendasCache == moduloEstoqueCache);
        System.out.println("Referenciam exatamente o mesmo objeto na heap? " + mesmaInstancia);

        // Recuperação de dados compartilhados
        Livro recuperado = moduloEstoqueCache.buscarPorIsbn("978-0132350884");
        System.out.println("Livro recuperado pelo módulo de Estoque: " + recuperado.getTitulo());
    }
}

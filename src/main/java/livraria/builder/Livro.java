package livraria.builder;

import java.util.Objects;

/**
 * Padrão GoF: Builder (Criacional).
 * Papel: Product complexo e imutável no domínio de livraria.
 */
public final class Livro {
    // Atributos obrigatórios (invariantes fundamentais)
    private final String isbn;
    private final String titulo;
    private final double precoBase;

    // Atributos opcionais (variações de produto)
    private final int paginas;
    private final boolean capaDura;
    private final boolean brindeMarcador;
    private final String edicaoEspecial;

    // Construtor privado: impede instanciação direta fora do Builder (Anti-pattern Telescoping Constructor evitado)
    private Livro(Builder builder) {
        this.isbn = builder.isbn;
        this.titulo = builder.titulo;
        this.precoBase = builder.precoBase;
        this.paginas = builder.paginas;
        this.capaDura = builder.capaDura;
        this.brindeMarcador = builder.brindeMarcador;
        this.edicaoEspecial = builder.edicaoEspecial;
    }

    public String getIsbn() { return isbn; }
    public String getTitulo() { return titulo; }
    public double getPrecoBase() { return precoBase; }
    public int getPaginas() { return paginas; }
    public boolean isCapaDura() { return capaDura; }
    public boolean isBrindeMarcador() { return brindeMarcador; }
    public String getEdicaoEspecial() { return edicaoEspecial; }

    @Override
    public String toString() {
        return "Livro [ISBN=" + isbn + ", Titulo=" + titulo + ", PrecoBase=R$ " + precoBase +
               ", Paginas=" + paginas + ", CapaDura=" + capaDura +
               ", Marcador=" + brindeMarcador + ", EdicaoEspecial=" + edicaoEspecial + "]";
    }

    /**
     * Papel GoF: ConcreteBuilder estático interno.
     */
    public static class Builder {
        // Obrigatórios
        private final String isbn;
        private final String titulo;
        private final double precoBase;

        // Opcionais com valores default seguros
        private int paginas = 0;
        private boolean capaDura = false;
        private boolean brindeMarcador = false;
        private String edicaoEspecial = "Edição Padrão";

        // Construtor do Builder exige exclusivamente os campos sem os quais o objeto é semanticamente inválido
        public Builder(String isbn, String titulo, double precoBase) {
            this.isbn = Objects.requireNonNull(isbn, "ISBN não pode ser nulo.");
            this.titulo = Objects.requireNonNull(titulo, "Título não pode ser nulo.");
            this.precoBase = precoBase;
        }

        // Métodos fluentes (Fluent Interface) para atributos opcionais
        public Builder paginas(int paginas) {
            this.paginas = paginas;
            return this; // Permite chamadas encadeadas
        }

        public Builder comCapaDura(boolean capaDura) {
            this.capaDura = capaDura;
            return this;
        }

        public Builder incluirMarcador(boolean brindeMarcador) {
            this.brindeMarcador = brindeMarcador;
            return this;
        }

        public Builder edicaoEspecial(String edicaoEspecial) {
            this.edicaoEspecial = edicaoEspecial;
            return this;
        }

        /**
         * Ponto crítico do padrão: Validação de invariantes antes da criação do Product.
         */
        public Livro build() {
            // Validação de invariantes de negócio do domínio
            if (this.precoBase <= 0.0) {
                throw new IllegalStateException("Falha de invariante: Preço base do livro deve ser estritamente positivo.");
            }
            if (this.isbn.isBlank()) {
                throw new IllegalStateException("Falha de invariante: ISBN não pode ser vazio.");
            }
            if (this.paginas < 0) {
                throw new IllegalStateException("Falha de invariante: Número de páginas não pode ser negativo.");
            }

            // Entrega da instância imutável apenas quando 100% consistente
            return new Livro(this);
        }
    }
}

package livraria.builder;

public class MainBuilder {
    public static void main(String[] args) {
        // 1. Livro básico (apenas obrigatórios + defaults)
        Livro livroPocket = new Livro.Builder("978-85-359-0277-8", "Dom Casmurro", 29.90)
                .build();

        // 2. Livro técnico de luxo (obrigatórios + conjunto de opcionais encadeados)
        Livro livroEdicaoLuxo = new Livro.Builder("978-0134685991", "Effective Java", 189.00)
                .paginas(416)
                .comCapaDura(true)
                .incluirMarcador(true)
                .edicaoEspecial("3ª Edição Anotada")
                .build();

        System.out.println(livroPocket);
        System.out.println(livroEdicaoLuxo);
    }
}

package livraria.singleton;

import livraria.builder.Livro;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Padrão GoF: Singleton (Criacional).
 * Papel: Recurso compartilhado centralizado e thread-safe com inicialização preguiçosa.
 */
public final class CatalogoCache {
    /**
     * A palavra-chave volatile é mandatória.
     * Ela garante visibilidade entre threads e previne o reordenamento de instruções (instruction reordering)
     * pelo compilador JIT/CPU antes da conclusão da inicialização do objeto.
     */
    private static volatile CatalogoCache instance;

    // Estado centralizado e protegido do recurso compartilhado
    private final Map<String, Livro> cacheLivros;

    /**
     * Construtor privado: impede a criação de instâncias via operador 'new' por classes externas.
     */
    private CatalogoCache() {
        // Simulação de inicialização pesada (leitura de metadados, warming de cache, conexão central)
        this.cacheLivros = new ConcurrentHashMap<>();
        System.out.println("[CatalogoCache] Recurso pesado inicializado com sucesso.");
    }

    /**
     * Ponto de acesso global utilizando a técnica Double-Checked Locking.
     */
    public static CatalogoCache getInstance() {
        // Primeira checagem (sem lock): evita o overhead de sincronização se o Singleton já foi inicializado
        if (instance == null) {
            // Sincronização em nível de classe apenas durante a primeira concorrência de inicialização
            synchronized (CatalogoCache.class) {
                // Segunda checagem (com lock): garante que apenas uma thread faça a instanciação se várias passaram pela primeira checagem
                if (instance == null) {
                    // Sem volatile, uma thread consumidora poderia ver uma referência não-nula,
                    // porém com o estado interno do objeto ainda parcialmente inicializado
                    instance = new CatalogoCache();
                }
            }
        }
        return instance;
    }

    public void registrarLivro(Livro livro) {
        cacheLivros.put(livro.getIsbn(), livro);
    }

    public Livro buscarPorIsbn(String isbn) {
        return cacheLivros.get(isbn);
    }

    public Map<String, Livro> listarTodos() {
        return Collections.unmodifiableMap(cacheLivros);
    }
}

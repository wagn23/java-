import java.util.ArrayList;
import java.util.List;

// Classe Revista
class Revista {
    private String titulo;
    private double preco;
    private int numeroPaginas;

    public Revista(String titulo, double preco, int numeroPaginas) {
        this.titulo = titulo;
        this.preco = preco;
        this.numeroPaginas = numeroPaginas;
    }

    public String getTitulo() {
        return titulo;
    }

    public double getPreco() {
        return preco;
    }

    public int getNumeroPaginas() {
        return numeroPaginas;
    }

    @Override
    public String toString() {
        return "Revista: " + titulo + ", Preço: R$ " + preco + ", Páginas: " + numeroPaginas;
    }
}

// Classe Funcionario
class Funcionario {
    private String nome;
    private String cargo;
    private double salario;

    public Funcionario(String nome, String cargo, double salario) {
        this.nome = nome;
        this.cargo = cargo;
        this.salario = salario;
    }

    public String getNome() {
        return nome;
    }

    public String getCargo() {
        return cargo;
    }

    public double getSalario() {
        return salario;
    }

    @Override
    public String toString() {
        return "Funcionário: " + nome + ", Cargo: " + cargo + ", Salário: R$ " + salario;
    }
}

// Classe Venda
class Venda {
    private Funcionario funcionario;
    private Revista revista;
    private int quantidade;
    private double totalVenda;

    public Venda(Funcionario funcionario, Revista revista, int quantidade) {
        this.funcionario = funcionario;
        this.revista = revista;
        this.quantidade = quantidade;
        this.totalVenda = revista.getPreco() * quantidade;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Revista getRevista() {
        return revista;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getTotalVenda() {
        return totalVenda;
    }

    @Override
    public String toString() {
        return funcionario.getNome() + " vendeu " + quantidade + " unidades de " + revista.getTitulo() +
               " por R$ " + totalVenda;
    }
}

// Classe BancaRevista
class BancaRevista {
    private List<Revista> revistas;
    private List<Funcionario> funcionarios;
    private List<Venda> vendas;

    public BancaRevista() {
        this.revistas = new ArrayList<>();
        this.funcionarios = new ArrayList<>();
        this.vendas = new ArrayList<>();
    }

    // Adicionar revista à banca
    public void adicionarRevista(Revista revista) {
        revistas.add(revista);
    }

    // Adicionar funcionário à banca
    public void adicionarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
    }

    // Realizar venda
    public void realizarVenda(Funcionario funcionario, Revista revista, int quantidade) {
        Venda venda = new Venda(funcionario, revista, quantidade);
        vendas.add(venda);
    }

    // Mostrar todas as revistas
    public void exibirRevistas() {
        for (Revista revista : revistas) {
            System.out.println(revista);
        }
    }

    // Mostrar todos os funcionários
    public void exibirFuncionarios() {
        for (Funcionario funcionario : funcionarios) {
            System.out.println(funcionario);
        }
    }

    // Mostrar todas as vendas realizadas
    public void exibirVendas() {
        for (Venda venda : vendas) {
            System.out.println(venda);
        }
    }

    // Calcular total de vendas
    public double calcularTotalVendas() {
        double total = 0;
        for (Venda venda : vendas) {
            total += venda.getTotalVenda();
        }
        return total;
    }
}

// Classe Main para rodar o programa
public class Main {
    public static void main(String[] args) {
        // Criando algumas revistas
        Revista revista1 = new Revista("Revista A", 10.50, 50);
        Revista revista2 = new Revista("Revista B", 15.30, 60);
        
        // Criando alguns funcionários
        Funcionario funcionario1 = new Funcionario("José Silva", "Vendedor", 2000);
        Funcionario funcionario2 = new Funcionario("Maria Oliveira", "Caixa", 1800);

        // Criando a banca de revistas
        BancaRevista banca = new BancaRevista();
        
        // Adicionando revistas e funcionários à banca
        banca.adicionarRevista(revista1);
        banca.adicionarRevista(revista2);
        banca.adicionarFuncionario(funcionario1);
        banca.adicionarFuncionario(funcionario2);
        
        // Realizando algumas vendas
        banca.realizarVenda(funcionario1, revista1, 5);
        banca.realizarVenda(funcionario2, revista2, 3);
        
        // Exibindo dados da banca
        System.out.println("\nRevistas disponíveis:");
        banca.exibirRevistas();

        System.out.println("\nFuncionários da Banca:");
        banca.exibirFuncionarios();

        System.out.println("\nVendas realizadas:");
        banca.exibirVendas();

        // Calculando total de vendas
        System.out.println("\nTotal de vendas: R$ " + banca.calcularTotalVendas());
    }
}

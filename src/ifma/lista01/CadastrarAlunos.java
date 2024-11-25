package ifma.lista01;

public class CadastrarAlunos {
    private Aluno[] aluno;
    int size = 0;
    int tamanho;

    public CadastrarAlunos(int tamanho) {
        this.tamanho = tamanho;
        this.aluno = new Aluno[tamanho];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Aluno[] getAluno() {
        return aluno;
    }

    public void setAluno(Aluno[] aluno) {
        this.aluno = aluno;
    }

    public void adicionarNoFinal(String nome, String matricula) {
        if (size == tamanho) {
            throw new RuntimeException("Vetor Cheio!");
        }
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        aluno.setCodigo(size + 1);
        this.aluno[size] = aluno;
        size++;
    }

    public void adicionarNoInicio(String nome, String matricula) {
        if (size == tamanho) {
            throw new RuntimeException("Vetor Cheio!");
        }
        Aluno temp;
        for (int i = size - 1;i >= 0; i--){
            temp = aluno[i];
            this.aluno[i + 1] = temp;
        }
        Aluno aluno = new Aluno();
        aluno.setNome(nome);
        aluno.setMatricula(matricula);
        aluno.setCodigo(size + 1);
        this.aluno[0] = aluno;
        size++;
    }

    public void removerNoFinal() {
        if (isEmpty()) {
            throw new RuntimeException("Vetor Vazio!!");
        }

        aluno[size - 1] = null;
        size--;
    }

    public void removerNoInicio() {
        if (isEmpty()) {
            throw new RuntimeException("Vetor Vazio!");
        }
        aluno[0] = null;
        Aluno temp;
        for(int i = 1; i < size; i++){
            temp = aluno[i];
            aluno[i - 1] = temp;
        }
        size--;
    }

    public boolean verificarIndice(int indice) {
        if (isEmpty()){
            throw new RuntimeException("Vetor vazio!!");
        }
        for (int i = 0; i < size; i++){
            if (aluno[indice] == aluno[i]){
                return true;
            }
        }
        return false;
    }



    public void listar() {
        System.out.println("-------");
        for (int i = 0; i < size; i++) {
            System.out.println("Aluno: " + aluno[i].getNome());
            System.out.println("Matricula: " + aluno[i].getMatricula());
            System.out.println("Cod: " + aluno[i].getCodigo());
            System.out.println("-------");
        }
    }
}

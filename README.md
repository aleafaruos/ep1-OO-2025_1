# Sistema Acadêmico - FCTE

## Descrição do Projeto

Desenvolvimento de um sistema acadêmico para gerenciar alunos, disciplinas, professores, turmas, avaliações e frequência, utilizando os conceitos de orientação a objetos (herança, polimorfismo e encapsulamento) e persistência de dados em arquivos.

O enunciado do trabalho pode ser encontrado aqui:
- [Trabalho 1 - Sistema Acadêmico](https://github.com/lboaventura25/OO-T06_2025.1_UnB_FCTE/blob/main/trabalhos/ep1/README.md)

## Dados do Aluno

- **Nome completo:** Rafaela Santos Cerqueira
- **Matrícula:** 242015700
- **Curso:** engenharias
- **Turma:** 6

---

## Instruções para Compilação e Execução

1. **Compilação:**  
   Para compilar o projeto, que utiliza a estrutura de módulos do Java, é necessário estar no diretório raiz do projeto (onde as pastas src e lib se encontram). A compilação é realizada 
   executando o seguinte comando no terminal: javac -d bin src/sistemaA/*.java src/sistemaA/**/*.java module-info.java. Este comando é responsável por direcionar todos os arquivos 
   .class compilados para a pasta bin, além de compilar todos os arquivos .java localizados dentro de src/sistemaA e suas subpastas, e também o arquivo module-info.java, garantindo que 
   todas as classes sejam processadas corretamente.

2. **Execução:**  
   Após a compilação ser concluída com sucesso, o programa pode ser executado a partir do diretório raiz do projeto. Para isso, utilize o seguinte comando no terminal: java -p bin -m 
   sistemaA/sistemaA.Main. Este comando define o "caminho de módulos" para a execução, apontando para a pasta bin onde se encontram os arquivos compilados do projeto, e especifica que a 
   classe principal a ser iniciada é sistemaA.Main, que está localizada dentro do módulo sistemaA.

3. **Estrutura de Pastas:**  
    estrutura de pastas do projeto está organizada em três principais diretórios: src, onde se encontram os arquivos .java com o código-fonte dividido em pacotes; bin, que armazena os       arquivos .class compilados; e .settings, que contém configurações específicas do projeto. Além disso, na raiz do projeto estão os arquivos de configuração, como .classpath          
    (essencial para o caminho de classes), .project (informações do projeto), e .gitignore (para controle de versão). Dentro da pasta src/sistemaA, estão todas as classes Java 
    responsáveis pela lógica do sistema, incluindo Aluno, Disciplina, Turma, Avaliacao, Relatorio, SistemaAcademico e a classe Main. O arquivo module-info.java também está presente na 
    raiz do módulo, definindo as características do módulo Java.

3. **Versão do JAVA utilizada:**  
   A versão do JAVA utilizada para o desenvolvimento inicial e para rodar o projeto nos primeiros momentos foi a Java SE 17. No entanto, para melhor compatibilidade e para resolver 
   questões relacionadas ao ambiente de desenvolvimento, o projeto foi migrado e atualmente utiliza a Java SE 21.



---

## Vídeo de Demonstração

https://drive.google.com/file/d/1iBrYwQu-7NVTBaNThQZNco_1slB5XaW3/view?usp=drivesdk

---

## Prints da Execução

1. Menu Principal:  
   ![image](https://github.com/user-attachments/assets/72965c1f-d9b8-49a1-a6c0-0c20e7fe2fb3)


2. Cadastro de Aluno:  
   ![image](https://github.com/user-attachments/assets/cbd797b8-d952-4af9-bdc9-48c4929d38dd)


3. Relatório de Frequência/Notas:  
   ![image](https://github.com/user-attachments/assets/b9a59555-3123-4557-87ba-b60b5f39da81)


---

## Principais Funcionalidades Implementadas

- [ ] Cadastro, listagem, matrícula e trancamento de alunos (Normais e Especiais)
- [ ] Cadastro de disciplinas e criação de turmas (presenciais e remotas)
- [ ] Matrícula de alunos em turmas, respeitando vagas e pré-requisitos
- [ ] Lançamento de notas e controle de presença
- [ ] Cálculo de média final e verificação de aprovação/reprovação
- [ ] Relatórios de desempenho acadêmico por aluno, turma e disciplina
- [ ] Persistência de dados em arquivos (.txt ou .csv)
- [ ] Tratamento de duplicidade de matrículas
- [ ] Uso de herança, polimorfismo e encapsulamento

---

## Observações (Extras ou Dificuldades)

Durante o desenvolvimento do projeto, enfrentei diversas dificuldades relacionadas à utilização da biblioteca Gson para persistência dos dados. Apesar de ter criado uma classe de persistência para controlar esse processo, o Gson não funcionou corretamente em nenhum momento, mesmo após várias tentativas, incluindo a atualização da versão do Java de 17 para 21, na tentativa de resolver o problema. Como já havia feito várias alterações nas outras classes para adaptar o sistema ao uso do Gson, optei por manter a estrutura da classe de persistência, mesmo sem o funcionamento ideal da biblioteca. Além disso, a diferença entre a sintaxe e o modo de funcionamento do Java em comparação com outras linguagens que já utilizei tornou o processo mais desafiador, exigindo bastante para a adaptação e implementação do sistema.

---

## Contato

- 242015700@aluno.unb.br

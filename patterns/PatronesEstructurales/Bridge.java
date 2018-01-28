import java.util.*;

interface Question {
  
    public void nextQuestion();
    public void priorQuestion();
    public void newQuestion(String q);
    public void deleteQuestion(String q);
    public void displayQuestion();
    public void displayAllQuestions();
}

class QuestionManager {
 
  protected Question questDB;
  public String catalog;

  public QuestionManager(String catalog) {
      this.catalog = catalog;
  }

  public void next() {
      questDB.nextQuestion();
  }

  public void prior() {
      questDB.priorQuestion();
  }

  public void newOne(String quest) {
      questDB.newQuestion(quest);
  }

  public void delete(String quest) {
      questDB.deleteQuestion(quest);
  }

  public void display() {
      questDB.displayQuestion();
  }

  public void displayAll() {
      System.out.println("Cat�logo de preguntas: " + catalog);
      questDB.displayAllQuestions();
  }
}

class QuestionFormat extends QuestionManager {
  
    public QuestionFormat(String catalog){
        super(catalog);
    }

    public void displayAll() {
    
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~");
        super.displayAll();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~");
    }
}

class JavaQuestions implements Question {
  
    private List<String> questions = new ArrayList<String>();
    private int current = 0;

    public JavaQuestions() {
        questions.add("�Qu� es Java? ");
        questions.add("�Qu� es una interfaz? ");
        questions.add("�Qu� significa 'multi-plataform'? ");
        questions.add("�Qu� significa 'UFT-8'? ");
        questions.add("�Qu� significa 'abstract'? ");
        questions.add("�Qu� significa 'Thread'? ");
        questions.add("�Qu� significa 'multi-threading'? "); 
    }

    public void nextQuestion() {
        if( current <= questions.size() - 1 )
            current++;
    }

    public void priorQuestion() {
        if( current > 0 )
            current--;
    }

    public void newQuestion(String quest) {
        questions.add(quest);
    }

    public void deleteQuestion(String quest) {
        questions.remove(quest);
    }

    public void displayQuestion() {
        System.out.println( questions.get(current) );
    }

    public void displayAllQuestions() {
        for (String quest : questions) {
            System.out.println(quest);
        }
    }
}

public class Bridge {
    public static void main(String[] args) {
 
        QuestionFormat questions = new QuestionFormat("Lenguaje Java");

        questions.questDB = new JavaQuestions();
        //podemos usar otras clases de preguntas
        //questions.questDB = new CsharpQuestions();
        //questions.questDB = new CplusplusQuestions();

        questions.display();
        questions.next();
    
        questions.newOne("�Qu� es un objeto?");
        questions.newOne("�Qu� es un 'reference type'?");

        questions.displayAll();
  }
}
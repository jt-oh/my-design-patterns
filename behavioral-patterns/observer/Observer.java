import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Arrays;

class Observer {
    public static void main(String[] args) {
        MyPrompt prompt = new MyPrompt();

        prompt.registerObserver(new MyTestObserver());
        prompt.registerObserver(new CommandCountObserver());
        prompt.registerObserver(new CommandAnalyzeObserver());

        prompt.run();
    }
}

// Observer Interface
interface ObserverI<T> {
    public void update(T data);
}

// Base Subject Class
class BaseSubject<T> {
    // Templated State
    protected T state;

    // Observers
    protected ArrayList<ObserverI<T>> observers;

    public BaseSubject() {
        observers = new ArrayList<>();
    }

    public void registerObserver(ObserverI<T> observer) {
        observers.add(observer);
    }

    // Notify all observers
    protected void notifyObservers() {
        for (ObserverI<T> observer: observers) {
            observer.update(state);
        }
    }
}

// Concrete Subject Class
class MyPrompt extends BaseSubject<String> {
    public MyPrompt() {
        super();
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Shell Running...");
        System.out.println("Write your command:");

        System.out.print(">> ");
        while (scanner.hasNextLine()) {
            state = scanner.nextLine();

            notifyObservers();

            System.out.print(">> ");
        }
    }
}

// Concrete Observers
class MyTestObserver implements ObserverI<String> {
    public void update(String data) {
        System.out.println("MyTestObserver: " + data);
    }
}

class CommandCountObserver implements ObserverI<String> {
    private int count;

    public CommandCountObserver() {
        count = 0;
    }

    public void update(String data) {
        count++;
        System.out.println("CommandCountObserver: " + count);
    }
}

class CommandAnalyzeObserver implements ObserverI<String> {
    private HashMap<String, Integer> wordCount;

    public CommandAnalyzeObserver() {
        wordCount = new HashMap<>();
    }

    public void update(String data) {
        String[] words = data.split(" ");

        Arrays.stream(words)
                .map(word -> word
                        .toLowerCase()
                        .replaceAll("[^a-zA-Z0-9]", "")
                )
                .forEach(word -> {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word) + 1);
                    } else {
                        wordCount.put(word, 1);
                    }
                });

        System.out.println("CommandAnalyzeObserver: " + wordCount);
    }
}
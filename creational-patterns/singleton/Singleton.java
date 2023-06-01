class Singleton {
    public static void main(String[] args) {
        // singleton class cannot instantiated from outside
//        new SingletonClass();

        SingletonClass singleton = SingletonClass.getInstance();
        System.out.println(singleton);

        SingletonClass anotherSingleton = SingletonClass.getInstance();
        System.out.println(anotherSingleton);

        if (singleton == anotherSingleton) {
            System.out.println("identical instance!");
        }
    }
}

// Singleton class
class SingletonClass {
    // singleton instance
    private static SingletonClass instance;

    // make constructor invisible to outside
    private SingletonClass() {

    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            instance = new SingletonClass();
        }

        return instance;
    }
}
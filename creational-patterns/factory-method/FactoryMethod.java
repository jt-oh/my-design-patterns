class FactoryMethod {
    public static void main(String[] args) {
        CoffeeCreatorI creator = new AmericanoCreator();
        CoffeeI coffee = creator.createCoffee();
        System.out.println(coffee.getName() + " is " + coffee.getTaste());

        creator = new EspressoCreator();
        coffee = creator.createCoffee();
        System.out.println(coffee.getName() + " is " + coffee.getTaste());

        creator = new LatteCreator();
        coffee = creator.createCoffee();
        System.out.println(coffee.getName() + " is " + coffee.getTaste());
    }
}


// Abstract Creator
interface CoffeeCreatorI {
    // Factory Method
    public CoffeeI createCoffee();
}

// Abstract Product
interface CoffeeI {
    public String getName();
    public String getTaste();
}


// Concreate Creators/Products
class AmericanoCreator implements CoffeeCreatorI {
    // Oveerride Factory Method
    public CoffeeI createCoffee() {
        return new Americano();
    }
}

class Americano implements CoffeeI {
    @java.lang.Override
    public String getName() {
        return "Americano";
    }

    @java.lang.Override
    public String getTaste() {
        return "plain";
    }
}


class EspressoCreator implements CoffeeCreatorI {
    @java.lang.Override
    public CoffeeI createCoffee() {
        return new Espresso();
    }
}

class Espresso implements CoffeeI {
    @java.lang.Override
    public String getName() {
        return "Espresso";
    }

    @java.lang.Override
    public String getTaste() {
        return "bitter";
    }
}


class LatteCreator implements CoffeeCreatorI {
    @java.lang.Override
    public CoffeeI createCoffee() {
        return new Latte();
    }
}

class Latte implements CoffeeI {
    @java.lang.Override
    public String getName() {
        return "Latte";
    }

    @java.lang.Override
    public String getTaste() {
        return "soft";
    }
}
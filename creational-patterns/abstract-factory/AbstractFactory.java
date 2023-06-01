public class AbstractFactory {
    public static void main(String[] args) {
        AbstractDrinkFactoryI factory = new NormalDrinkFactory();

        CoffeeI coffee = factory.createCoffee();
        System.out.println("Coffee Name: " + coffee.getName());
        AdeI ade = factory.createAde();
        System.out.println("Ade Name: " + ade.getName());
        TeaI tea = factory.createTea();
        System.out.println("Tea Name: " + tea.getName());

        factory = new IceDrinkFactory();

        coffee = factory.createCoffee();
        System.out.println("Coffee Name: " + coffee.getName());
        ade = factory.createAde();
        System.out.println("Ade Name: " + ade.getName());
        tea = factory.createTea();
        System.out.println("Tea Name: " + tea.getName());
    }
}

interface AbstractDrinkFactoryI {
    public CoffeeI createCoffee();
    public AdeI createAde();
    public TeaI createTea();
}

interface CoffeeI {
    public String getName();
}

interface AdeI {
    public String getName();
}

interface TeaI {
    public String getName();
}


class NormalDrinkFactory implements AbstractDrinkFactoryI {
    public CoffeeI createCoffee() {
        return new NomralCoffee();
    }

    public AdeI createAde() {
        return new NormalAde();
    }

    public TeaI createTea() {
        return new NormalTea();
    }
}

class NomralCoffee implements CoffeeI {
    public NomralCoffee() {}

    public String getName() {
        return "normal_coffee";
    }
}

class NormalAde implements AdeI {
    public NormalAde() {}

    public String getName() {
        return "normal_ade";
    }
}

class NormalTea implements TeaI {
    public NormalTea() {}

    public String getName() {
        return "normal_tea";
    }
}


class IceDrinkFactory implements AbstractDrinkFactoryI {
    public CoffeeI createCoffee() {
        return new IceCoffee();
    }

    public AdeI createAde() {
        return new IceAde();
    }

    public TeaI createTea() {
        return new IceTea();
    }
}

class IceCoffee implements CoffeeI {
    public IceCoffee() {}

    public String getName() {
        return "ice_coffee";
    }
}

class IceAde implements AdeI {
    public IceAde() {}

    public String getName() {
        return "ice_ade";
    }
}

class IceTea implements TeaI {
    public IceTea() {}

    public String getName() {
        return "ice_tea";
    }
}
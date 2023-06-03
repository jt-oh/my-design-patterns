class Builder {
    public static void main(String[] args) {
        CoffeeCreateDirector director = new CoffeeCreateDirector();
        AbstractCoffeeBuilder builder;

        builder = new IceAmericanoBuilder();
        director.setBuilder(builder);
        director.construct();
        printResult(builder.getCoffee());

        builder = new LatteBuilder();
        director.setBuilder(builder);
        director.construct();
        printResult(builder.getCoffee());

        builder = new LuwakCoffeeBuilder();
        director.setBuilder(builder);
        director.construct();
        printResult(builder.getCoffee());
    }

    private static void printResult(Coffee coffee) {
        System.out.println("name: " + coffee.getName());
        System.out.println("base: " + coffee.getBaseName());
        System.out.println("bean: " + coffee.getBeanName());
        System.out.println("iced: " + (coffee.getIsIced() ? "ice" : ""));
        System.out.println("");
    }
}

// Director Class
// Director has responibility on the process of object creation
class CoffeeCreateDirector {
    private AbstractCoffeeBuilder builder;

    public void setBuilder(AbstractCoffeeBuilder builder) {
        this.builder = builder;
    }

    // proces of object creation
    public void construct() {
        builder.createCoffee();

        builder.createBase();
        builder.createBean();
        builder.createIce();
    }
}

// Abstract Builder
// Builder has responsibility on the representation of object
abstract class AbstractCoffeeBuilder {
    protected Coffee coffee;

    public abstract void createCoffee();
    public abstract void createBase();
    public abstract void createBean();
    public abstract void createIce();

    public Coffee getCoffee() {
        return coffee;
    }
}

// Product
class Coffee {
    private String name;
    private Base base;
    private Bean bean;
    private Ice ice;

    public Coffee(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public String getBaseName() {
        return base.getName();
    }

    public void setBean(Bean bean) {
        this.bean = bean;
    }

    public String getBeanName() {
        return bean.getName();
    }

    public void setIce(Ice ice) {
        this.ice = ice;
    }
    public boolean getIsIced() {
        return ice.isIced();
    }
}

// Gredients of Product
class Base {
    private String name;

    public Base(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Bean {
    private String name;

    public Bean(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Ice {
    private boolean iced;

    public Ice(boolean iced) {
        this.iced = iced;
    }

    public boolean isIced() {
        return iced;
    }
}

// Concrete Builders
class IceAmericanoBuilder extends AbstractCoffeeBuilder {
    @java.lang.Override
    public void createCoffee() {
        coffee = new Coffee("ice_americano");
    }

    @java.lang.Override
    public void createBase() {
        coffee.setBase(new Base("water"));
    }

    @java.lang.Override
    public void createBean() {
        coffee.setBean(new Bean("p.320"));
    }

    @java.lang.Override
    public void createIce() {
        coffee.setIce(new Ice(true));
    }
}

class LatteBuilder extends AbstractCoffeeBuilder {
    @java.lang.Override
    public void createCoffee() {
        coffee = new Coffee("latte");
    }

    @java.lang.Override
    public void createBase() {
        coffee.setBase(new Base("milk"));
    }

    @java.lang.Override
    public void createBean() {
        coffee.setBean(new Bean("p.320"));
    }

    @java.lang.Override
    public void createIce() {
        coffee.setIce(new Ice(false));
    }
}

class LuwakCoffeeBuilder extends AbstractCoffeeBuilder {
    @java.lang.Override
    public void createCoffee() {
        coffee = new Coffee("luwak_coffee");
    }

    @java.lang.Override
    public void createBase() {
        coffee.setBase(new Base("water"));
    }

    @java.lang.Override
    public void createBean() {
        coffee.setBean(new Bean("luwak"));
    }

    @java.lang.Override
    public void createIce() {
        coffee.setIce(new Ice(false));
    }
}
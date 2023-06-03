class Decorator {
    public static void main(String[] args) {
        ChristmasTreeI christmasTree = new ChristmasTree();

        christmasTree = new StarChristmasTreeDecorator(christmasTree);
        christmasTree = new GarlandsChristmasTreeDecorator(christmasTree);
        christmasTree = new OrnamentChristmasTreeDecorator(christmasTree);
        christmasTree = new TinselChristmasTreeDecorator(christmasTree);
        christmasTree = new BoxChristmasTreeDecorator(christmasTree);

        christmasTree.describe();
    }
}

interface ChristmasTreeI {
    public void describe();
}

class ChristmasTree implements ChristmasTreeI {
    @java.lang.Override
    public void describe() {
        System.out.println("It's 3-layered Christmas Tree.");
    }
}

abstract class AbstractChristmasTreeDecorator implements ChristmasTreeI {
    protected ChristmasTreeI christmasTree;

    public AbstractChristmasTreeDecorator(ChristmasTreeI tree) {
        christmasTree = tree;
    }

    @java.lang.Override
    public void describe() {
        christmasTree.describe();
    }
}

class GarlandsChristmasTreeDecorator extends AbstractChristmasTreeDecorator {
    public GarlandsChristmasTreeDecorator(ChristmasTreeI tree) {
        super(tree);
    }

    @java.lang.Override
    public void describe() {
        super.describe();
        System.out.println("Garland is on the 3rd layer!");
    }
}

class TinselChristmasTreeDecorator extends AbstractChristmasTreeDecorator {
    public TinselChristmasTreeDecorator(ChristmasTreeI tree) {
        super(tree);
    }

    @java.lang.Override
    public void describe() {
        super.describe();
        System.out.println("Tinsels are glowing from all layers.");
    }
}

class StarChristmasTreeDecorator extends AbstractChristmasTreeDecorator {
    public StarChristmasTreeDecorator(ChristmasTreeI tree) {
        super(tree);
    }

    @java.lang.Override
    public void describe() {
        super.describe();
        System.out.println("Big Star is on the top of the tree!");
    }
}

class OrnamentChristmasTreeDecorator extends AbstractChristmasTreeDecorator {
    public OrnamentChristmasTreeDecorator(ChristmasTreeI tree) {
        super(tree);
    }

    @java.lang.Override
    public void describe() {
        super.describe();
        System.out.println("Red and green ornaments are hung on leafs.");
    }
}

class BoxChristmasTreeDecorator extends AbstractChristmasTreeDecorator {
    public BoxChristmasTreeDecorator(ChristmasTreeI tree) {
        super(tree);
    }

    @java.lang.Override
    public void describe() {
        super.describe();
        System.out.println("Present Boxes are around the Tree!");
    }
}
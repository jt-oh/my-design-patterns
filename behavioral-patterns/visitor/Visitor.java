import java.util.ArrayList;

class Visitor {
    public static void main(String[] args) {
        VisitorI visitor;
        Home home = new Home();

        home.addRoom(new MainRoom());
        home.addRoom(new Kitchen());
        home.addRoom(new Bathroom());
        home.addRoom(new LivingRoom());
        home.addRoom(new SubRoom());

        System.out.println("cleaner visits home:");
        visitor = new CleanVisitor();
        home.accept(visitor);
        System.out.println("");

        System.out.println("painter visits home:");
        visitor = new PaintVisitor();
        home.accept(visitor);
        System.out.println("");

        System.out.println("price setter visits home:");
        visitor = new PriceSetVisitor();
        home.accept(visitor);
    }
}


// Element Interface
interface RoomI {
    // visitor method call for Visitor
    public void accept(VisitorI visitor);
}

// use composite pattern for rooms
class Home implements RoomI {
    ArrayList<RoomI> rooms;

    public Home() {
        rooms = new ArrayList<RoomI>();
    }

    public void accept(VisitorI visitor) {
        for (RoomI room: rooms) {
            room.accept(visitor);
        }
    }

    public void addRoom(RoomI room) {
        rooms.add(room);
    }
}

// Concrete Elements
class MainRoom implements RoomI {
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }
}

class Kitchen implements RoomI {
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }
}

class Bathroom implements RoomI {
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }
}

class LivingRoom implements RoomI {
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }
}

class SubRoom implements RoomI {
    public void accept(VisitorI visitor) {
        visitor.visit(this);
    }
}

// Visitor Interface
interface VisitorI {
    public void visit(MainRoom element);
    public void visit(Kitchen element);
    public void visit(Bathroom element);
    public void visit(LivingRoom element);
    public void visit(SubRoom element);
}

// Concrete Visitors
class CleanVisitor implements VisitorI {
    public void visit(MainRoom element) {
        System.out.println("Clean Main Room");
    }

    public void visit(Kitchen element) {
        System.out.println("Clean Kitchen");
    }

    public void visit(Bathroom element) {
        System.out.println("Clean Bathroom");
    }

    public void visit(LivingRoom element) {
        System.out.println("Clean Living Room");
    }

    public void visit(SubRoom element) {
        System.out.println("Clean Sub Room");
    }
}

class PaintVisitor implements VisitorI {
    public void visit(MainRoom element) {
        System.out.println("Paint Main Room with red");
    }

    public void visit(Kitchen element) {
        System.out.println("Paint Kitchen with blue");
    }

    public void visit(Bathroom element) {
        System.out.println("Paint Bathroom with green");
    }

    public void visit(LivingRoom element) {
        System.out.println("Paint Living Room with yellow");
    }

    public void visit(SubRoom element) {
        System.out.println("Paint Sub Room with orange");
    }
}

class PriceSetVisitor implements VisitorI {
    public void visit(MainRoom element) {
        System.out.println("Set Main Room price to $1000");
    }

    public void visit(Kitchen element) {
        System.out.println("Set Kitchen price to $500");
    }

    public void visit(Bathroom element) {
        System.out.println("Set Bathroom price to $300");
    }

    public void visit(LivingRoom element) {
        System.out.println("Set Living Room price to $2000");
    }

    public void visit(SubRoom element) {
        System.out.println("Set Sub Room price to $100");
    }
}
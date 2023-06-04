import java.util.ArrayList;

class Composite {
    public static void main(String[] args) {
        InternalNode root = new InternalNode();
        InternalNode internalNode;
        LeafNode leaf;

        leaf = new LeafNode("layer_1_leaf_1");
        root.addChild(leaf);

        leaf = new LeafNode("layer_1_leaf_2");
        root.addChild(leaf);

        internalNode = new InternalNode();
        leaf = new LeafNode("layer_2_leaf_1");
        internalNode.addChild(leaf);
        leaf = new LeafNode("leyer_2_leaf_2");
        internalNode.addChild(leaf);
        root.addChild(internalNode);

        leaf = new LeafNode("layer_1_leaf_3");
        root.addChild(leaf);

        root.trim();
    }
}

// Component Interface
interface ComponentInterface {
    public void trim();
}

// Composite Class
class InternalNode implements ComponentInterface {
    private ArrayList<ComponentInterface> childs;

    public InternalNode() {
        childs = new ArrayList<>();
    }

    @java.lang.Override
    public void trim() {
        for (ComponentInterface child: childs) {
            child.trim();
        }
    }

    public void addChild(ComponentInterface child) {
        childs.add(child);
    }

    public void removeChild(int index) {
        childs.remove(index);
    }

    public void getChild(int index) {
        childs.get(index);
    }
}

// Leaf Class
class LeafNode implements ComponentInterface {
    private String name;

    public LeafNode(String name) {
        this.name = name;
    }

    @java.lang.Override
    public void trim() {
        System.out.println(name + " is trimmed!");
    }
}
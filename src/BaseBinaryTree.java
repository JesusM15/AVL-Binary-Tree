
public class BaseBinaryTree<T extends Comparable<T>>implements BinaryTree<T> {

    protected Nodo<T> root;

    @Override
    public Nodo<T> getRoot() {
        return root;
    }

    public void setRoot(Nodo<T> root){
        this.root = root;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        appendNodeToStringRecursive(getRoot(), builder);
        return builder.toString();
    }

    public void appendNodeToStringRecursive(Nodo<T> node, StringBuilder builder) {
        appendNodeToString(node, builder);
        if (node.getLeft() != null) {
            builder.append(" L{");
            appendNodeToStringRecursive(node.getLeft(), builder);
            builder.append('}');
        }
        if (node.getRight() != null) {
            builder.append(" R{");
            appendNodeToStringRecursive(node.getRight(), builder);
            builder.append('}');
        }
    }

    public void appendNodeToString(Nodo<T> node, StringBuilder builder) {
        builder.append(node.getData());
    }
}

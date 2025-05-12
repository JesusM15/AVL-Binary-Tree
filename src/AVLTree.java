import static java.lang.Math.max;

public class AVLTree<T extends Comparable<T>> extends BinarySearchTree<T> {

    @Override
    public Nodo<T> insertNode(T data, Nodo<T> node) {
        node = super.insertNode(data, node);

        updateHeight(node);

        return rebalance(node);
    }

    @Override
    public Nodo<T> deleteNode(T data, Nodo<T> node) {
        node = super.deleteNode(data, node);

        if (node == null) {
            return null;
        }

        updateHeight(node);

        return rebalance(node);
    }

    private void updateHeight(Nodo<T> node) {
        int leftChildHeight = height(node.getLeft());
        int rightChildHeight = height(node.getRight());
        node.setHeight(max(leftChildHeight, rightChildHeight) + 1);
    }

    private Nodo<T> rebalance(Nodo<T> node) {
        int balanceFactor = balanceFactor(node);

        // Left-heavy?
        if (balanceFactor < -1) {
            if (balanceFactor(node.getLeft()) <= 0) {
                // Rotate right
                node = rotateRight(node);
            } else {
                // Rotate left-right
                node.setLeft(rotateLeft(node.getLeft()));
                node = rotateRight(node);
            }
        }

        // Right-heavy?
        if (balanceFactor > 1) {
            if (balanceFactor(node.getRight()) >= 0) {
                // Rotate left
                node = rotateLeft(node);
            } else {
                // Rotate right-left
                node.setRight(rotateRight(node.getRight()));
                node = rotateLeft(node);
            }
        }

        return node;
    }

    private Nodo<T> rotateRight(Nodo<T> node) {
        Nodo<T> leftChild = node.getLeft();

        node.setLeft(leftChild.getRight());
        leftChild.setRight(node);

        updateHeight(node);
        updateHeight(leftChild);

        return leftChild;
    }

    private Nodo<T> rotateLeft(Nodo<T> node) {
        Nodo<T> rightChild = node.getRight();

        node.setRight(rightChild.getLeft());
        rightChild.setLeft(node);

        updateHeight(node);
        updateHeight(rightChild);

        return rightChild;
    }

    private int balanceFactor(Nodo<T> node) {
        // RH - RL
        return height(node.getRight()) - height(node.getLeft());
    }

    private int height(Nodo<T> node) {
        return node != null ? node.getHeight() : -1;
    }

    @Override
    protected void appendNodeToString(Nodo<T> nodo, StringBuilder builder) {
        builder
                .append(nodo.getData())
                .append("[H=")
                .append(height(nodo))
                .append(", BF=")
                .append(balanceFactor(nodo))
                .append(']');
    }

}

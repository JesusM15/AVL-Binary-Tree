
public class BinarySearchTree<T extends Comparable<T>> extends BaseBinaryTree<T> {

    public Nodo<T> search(T data){
        return search(data, super.getRoot());
    }

    public Nodo<T> search(T data, Nodo<T> nodo){
        // si ya no hay nodo.
        if(nodo == null){
            return null;
        }

        if(data == nodo.getData()){
            return nodo;
        }else if(data.compareTo(nodo.getData()) < 0){
            return search(data, nodo.getLeft());
        }else {
            return search(data, nodo.getRight());
        }
    }

    public void insertNode(T data){
        super.setRoot(insertNode(data, super.getRoot()));
    }

    public Nodo<T> insertNode(T data, Nodo<T> nodo){
        if(nodo == null){
            nodo = new Nodo(data);
        }

        // si data < nodo.getData()
        else if(data.compareTo(nodo.getData()) < 0){
            nodo.setLeft(insertNode(data, nodo.getLeft()));
        }else if(data.compareTo(nodo.getData()) > 0){
            nodo.setRight(insertNode(data, nodo.getLeft()));
        }else {
            // cuando sea igual al data de un nodo.
            throw new IllegalArgumentException("BST contiene un nodo con esta key " + data);
        }

        return nodo;
    }

    public void deleteNode(T data){
        super.setRoot(deleteNode(data, super.getRoot()));
    }

    public Nodo deleteNode(T data, Nodo<T> nodo){
        if(nodo == null){
            return null;
        }

        if(data.compareTo(nodo.getData()) < 0){
            nodo.setLeft(deleteNode(data, nodo.getLeft()));
        }else if(data.compareTo(nodo.getData()) > 0){
            nodo.setRight(deleteNode(data, nodo.getRight()));
        }

        // nodo es el nodo eliminado

        else if(nodo.getLeft() == null && nodo.getRight() == null){
            nodo = null;
        }

        // si el nodo solo tiene un hijo remplaza el nodo por su hijo unico.
        else if(nodo.getLeft() == null){
            nodo = nodo.getRight();
        }else if(nodo.getRight() == null){
            nodo = nodo.getLeft();
        }else {
            // si el nodo tiene 2 hijos
            deleteNodeWithTwoChildren(nodo);
        }

        return nodo;
    }

    private void deleteNodeWithTwoChildren(Nodo<T> nodo){

        Nodo<T> inOrderSuccesor = findMinimun(nodo.getRight());

        nodo.setData(inOrderSuccesor.getData());

        nodo.setRight(deleteNode(inOrderSuccesor.getData(), nodo.getRight()));
    }

    private Nodo<T> findMinimun(Nodo<T> nodo){
        while(nodo.getLeft() != null){
            nodo = nodo.getLeft();
        }

        return nodo;
    }



}

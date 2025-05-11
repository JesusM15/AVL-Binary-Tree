
public class Nodo<T extends Comparable<T>>{
    // key o value
    private T data;
    private Nodo left;
    private Nodo right;
    private int height; // para arbol AVL.

    private Nodo parent; // para SimpleBinaryTree + red-black-tree
    private boolean color; // para red-black-tree

    public Nodo(T data){
        this.data = data;
    }

    public T getData(){
        return this.data;
    }

    public void setData(T data){
        this.data = data;
    }

    public void setRight(Nodo<T> right){
        this.right = right;
    }

    public Nodo<T> getRight(){
        return this.right;
    }

    public void setLeft(Nodo<T> left){
        this.left = left;
    }

    public Nodo<T> getLeft(){
        return this.left;
    }

    public int getHeight(){
        return this.height;
    }

    public void setHeight(int height){
        this.height = height;
    }

    public Nodo<T> getParent(){
        return this.parent;
    }

    public boolean getColor(){
        return this.color;
    }

    public void setColor(boolean color){
        this.color = color;
    }

    public int compareTo(T data){
        return this.data.compareTo(data);
    }
}

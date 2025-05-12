//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        tree.insertNode(10);
        tree.insertNode(20);
        tree.insertNode(4);
        tree.insertNode(9);
        tree.insertNode(6);
        tree.insertNode(8);

        System.out.println(tree);
    }
}
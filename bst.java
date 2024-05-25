public class bst<E extends Comparable<E>>{

    class TreeNode<E extends Comparable<E>>{

        private TreeNode<E> leftNode;
        private E data;
        private TreeNode<E> rightNode;

        public TreeNode(E nodeData) {
            data = nodeData;
            leftNode = rightNode = null;
        }

        public E getData() {
            return data;
        }

        public TreeNode<E> getLeftNode() {
            return leftNode;
        }

        public TreeNode<E> getRightNode() {
            return rightNode;
        }

        void insert(E insertValue) {
            if (insertValue.compareTo(data) < 0) {
                if (leftNode == null) {
                    leftNode = new TreeNode<E>(insertValue);
                } else {
                    leftNode.insert(insertValue);
                }
            } else if (insertValue.compareTo(data) > 0) {
                if (rightNode == null) {
                    rightNode = new TreeNode<E>(insertValue);
                } else {
                    rightNode.insert(insertValue);
                }
            }
        }

        boolean search(E value){
            if (value.compareTo(data) == 0) {
                return true;
            } else if (value.compareTo(data) < 0 && leftNode != null) {
                return leftNode.search(value);
            } else if (value.compareTo(data) > 0 && rightNode != null) {
                return rightNode.search(value);
            }
            return false;
        }
    }
    TreeNode<E> root;
    bst() {
        root = null;
    }
    void insert(E key) {
        if (root == null) {
            root = new TreeNode<E>(key);
        } else {
            root.insert(key);
        }
    }

    boolean search(E key) {
        if (root == null) {
            return false;
        }
        return root.search(key);
    }

    public static void main(String[] args) {
        bst<Character> bst = new bst<>();
        bst.insert('F');
        bst.insert('E');
        bst.insert('H');
        bst.insert('D');
        bst.insert('G');
        bst.insert('C');
        bst.insert('B');
        bst.insert('H');
        bst.insert('K');
        bst.insert('J');

        // Mencari karakter K dan A
        System.out.println();
        System.out.println("Hasil Pencarian:");
        System.out.println("Karakter 'K' ditemukan dalam BST: " + bst.search('K'));
        System.out.println("Karakter 'A' ditemukan dalam BST: " + bst.search('A'));
    }
}

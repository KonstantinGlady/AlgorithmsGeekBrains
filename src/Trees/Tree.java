package Trees;

public class Tree {
    private Node root;
    private int leftHeight;
    private int rightHeight;
    private static final int MAX_SIZE = 6;

    public boolean getMaxSizeLimit() {
        return ((leftHeight >= MAX_SIZE) || (rightHeight >= MAX_SIZE));
    }
    public boolean isBalanced(){
        return (leftHeight == rightHeight);
    }

    public Node find(int key) {
        Node current = root;
        while (current.id != key) {
            if (key < current.id) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
            if (current == null) {
                return null;
            }
        }
        return current;
    }

    public void insert(int id) {

        boolean leftSide = false;

        Node node = new Node();
        node.id = id;
        if (root == null) {
            root = node;
        } else {
            if (id < root.id) {
                leftSide = true;
            }
            Node current = root;
            Node parent;
            int nodeLvl = 1;
            while (true) {
                parent = current;
                nodeLvl += 1;
                if (id < current.id) {
                    current = current.leftChild;

                    if (current == null) {
                        parent.leftChild = node;
                        if (leftSide) {
                            leftHeight = nodeLvl;
                        }
                        return;
                    }
                } else {
                    current = current.rightChild;

                    if (current == null) {
                        parent.rightChild = node;
                        if (!leftSide) {
                            rightHeight = nodeLvl;
                        }

                        return;
                    }
                }
            }
        }
    }

    public boolean delete(int id) {
        Node current = root;
        Node parent = root;
        boolean isLeftChild = true;
        while (current.id != id) {
            parent = current;
            if (id < current.id) {
                isLeftChild = true;
                current = current.leftChild;
            } else {
                isLeftChild = false;
                current = current.rightChild;
            }
            if (current == null) {
                return false;
            }
        }
        if (current.leftChild == null && current.rightChild == null) {

            if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }

        } else if (current.rightChild == null) {
            if (isLeftChild) {
                parent.leftChild = current.leftChild;
            } else {
                parent.rightChild = current.leftChild;
            }
        } else if (current.leftChild == null) {
            if (isLeftChild) {
                parent.leftChild = current.rightChild;
            } else {
                parent.rightChild = current.rightChild;
            }
        } else {
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }
            successor.leftChild = current.leftChild;
        }
        return true;
    }

    public Node getSuccessor(Node node) {
        Node successorParent = node;
        Node successor = node;
        Node current = node.rightChild;
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.leftChild;
        }
        if (successor != node.rightChild) {
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = node.rightChild;
        }
        return successor;
    }

    public void displayTreeHeight() {
        System.out.println("left " + leftHeight + " right " + rightHeight);
    }

    public void display() {
        final int height = 7, width = 64;

        int len = width * height * 2 + 2;
        StringBuilder sb = new StringBuilder(len);
        for (int i = 1; i <= len; i++)
            sb.append(i < len - 2 && i % width == 0 ? "\n" : ' ');

        displayR(sb, width / 2, 1, width / 4, width, root, " ");
        System.out.println(sb);
    }

    private void displayR(StringBuilder sb, int c, int r, int d, int w, Node n,
                          String edge) {
        if (n != null) {
            displayR(sb, c - d, r + 2, d / 2, w, n.leftChild, " /");

            String s = String.valueOf(n.id);
            int idx1 = r * w + c - (s.length() + 1) / 2;
            int idx2 = idx1 + s.length();
            int idx3 = idx1 - w;
            if (idx2 < sb.length())
                sb.replace(idx1, idx2, s).replace(idx3, idx3 + 2, edge);

            displayR(sb, c + d, r + 2, d / 2, w, n.rightChild, "\\ ");
        }
    }
}


package com.gupta.java.personal.trees;

public class BinarySearchTree {
    public static class Node {
        private int key;
        private Node leftChild;
        private Node rightChild;
    }

    public static class Tree {
        private Node root;

        public void find(int inKey) {
            Node current = root;

            while (current != null) {
                if (inKey < current.key) {
                    System.out.println(inKey + " is less than " + current.key + ". Moving left of tree");
                    current = current.leftChild;
                } else if (inKey > current.key) {
                    System.out.println(inKey + " is greater than " + current.key + ". Moving right of tree");
                    current = current.rightChild;
                } else if (inKey == current.key) {
                    System.out.println("Found the key!");
                    break;
                }
            }

            if (current == null) {
                System.out.println("Key NOT found!");
            }
        }

        public void insert(int inKey) {
            Node newNode = new Node();
            newNode.key = inKey;

            if (root == null) {
                root = newNode;
            } else {
                Node current = root;
                Node parent = root;

                while (true) {
                    parent = current;

                    if (inKey < current.key) {
                        current = current.leftChild;

                        if (current == null) {
                            parent.leftChild = newNode;
                            parent.leftChild.key = inKey;
                            break;
                        }

                        continue;
                    } else if (inKey > current.key) {
                        current = current.rightChild;

                        if (current == null) {
                            parent.rightChild = newNode;
                            parent.rightChild.key = inKey;
                            break;
                        }

                        continue;
                    }
                }
            }
        }

        public void traverse(Node root) { //inOrder
            if (root != null) {
                traverse(root.leftChild);
                System.out.println(root.key);
                traverse(root.rightChild);
            }
        }

        public void delete(Object tbdKey) {}
    }

    public static void main(String[] args) {
        Tree tree = new Tree();

        tree.insert(20);
        tree.insert(23);
        tree.insert(21);
        tree.insert(50);
        tree.insert(45);
        tree.insert(33);

        //Traverse the tree
        tree.traverse(tree.root);

        //Find a key
        tree.find(45);
    }
}


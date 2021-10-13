class BinarySearchTree:
    def __init__(self):
        self.root = None
        
    class Node:
        def __init__(self, key, value, size):
            self.key = key
            self.value = value
            self.size = size
            self.left = None
            self.right = None
    
    def size(self):
        return self.sizeR(self.root)

    def sizeR(self, node):
        size = 0
        if(node != None):
            size = node.size
        return size

    def put(self, key, value):
        if(value != None):
            self.root = self.putR(self.root, key, value)

    def putR(self, node, key, value):
        if(node == None):
            node = self.Node(key, value, 1)
        else:
            if(key < node.key):
                node.left = self.putR(node.left, key, value)
            elif(key > node.key):
                node.right = self.putR(node.right, key, value)
            else:
                node.value = value
            node.size = 1 + self.sizeR(node.left) + self.sizeR(node.right)
        return node

    def __str__(self):
        keysInOrder = ""
        if(self.root == None):
            keysInOrder = "()"
        else:
            keysInOrder = self.__str__R(self.root)
        return keysInOrder

    def __str__R(self, node):
        keysInOrder = ""
        if(node == None):
            keysInOrder = "()"
        else:            
            keysInOrder = "(" + self.__str__R(node.left) + str(node.key) + self.__str__R(node.right) + ")"
        return keysInOrder


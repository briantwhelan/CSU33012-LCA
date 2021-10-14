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
    
    def lca(self, node1, node2):
        lca = None
        if((node1 != None) and (node2 != None)):
            lca = self.lcaR(self.root, node1, node2)
        return lca

    def lcaR(self, node, node1, node2):
        lca = None
        if(node != None):
            if((node.key == node1) or (node.key == node2)):
                lca = node.key
            else:
                left = self.lcaR(node.left, node1, node2)
                right = self.lcaR(node.right, node1, node2)
                if((left != None) and (right != None)):
                    lca = node.key
                else:
                    lca = right if(left == None) else left
        return lca

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


from BinarySearchTree import BinarySearchTree

def testConstructor():
    binarySearchTree = BinarySearchTree()
    assert binarySearchTree.root == None
    
def testSize():
    binarySearchTree = BinarySearchTree()
    assert binarySearchTree.size() == 0
    binarySearchTree.put(5, 5)
    assert binarySearchTree.size() == 1
    binarySearchTree.put(15, 15)
    assert binarySearchTree.size() == 2
    binarySearchTree.put(10, 10)
    assert binarySearchTree.size() == 3

def testPut():
    binarySearchTree = BinarySearchTree()
    assert print(binarySearchTree) == "()"
    binarySearchTree.put(7, 7)
    binarySearchTree.put(8, 8)
    binarySearchTree.put(3, 3)
    binarySearchTree.put(1, 1)
    binarySearchTree.put(2, 2)
    binarySearchTree.put(6, 6)
    binarySearchTree.put(4, 4)
    binarySearchTree.put(5, 5)
    assert print(binarySearchTree) == "(((()1(()2()))3((()4(()5()))6()))7(()8()))"
    binarySearchTree.put(8, 10)
    assert print(binarySearchTree) == "(((()1(()2()))3((()4(()5()))6()))7(()8()))"

def testPrint():
    binarySearchTree = BinarySearchTree()
    assert print(binarySearchTree) == "()"
    binarySearchTree.put(7, 7)
    binarySearchTree.put(8, 8)
    binarySearchTree.put(3, 3)
    binarySearchTree.put(1, 1)
    binarySearchTree.put(2, 2)
    binarySearchTree.put(6, 6)
    binarySearchTree.put(4, 4)
    binarySearchTree.put(5, 5)
    assert print(binarySearchTree) == "(((()1(()2()))3((()4(()5()))6()))7(()8()))"

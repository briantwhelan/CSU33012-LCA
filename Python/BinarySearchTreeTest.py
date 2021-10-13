from BinarySearchTree import BinarySearchTree

def testConstructor():
    binarySearchTree = BinarySearchTree()
    assert binarySearchTree.root == None
    
def testSize():
    bst = BinarySearchTree()
    assert bst.size() == 0
    bst.put(5, 5)
    assert bst.size() == 1
    bst.put(15, 15)
    assert bst.size() == 2
    bst.put(10, 10)
    assert bst.size() == 3

def testPut():
    bst = BinarySearchTree()
    assert bst.__str__() == "()"
    bst.put(7, 7)
    bst.put(8, 8)
    bst.put(3, 3)
    bst.put(1, 1)
    bst.put(2, 2)
    bst.put(6, 6)
    bst.put(4, 4)
    bst.put(5, 5)
    assert bst.__str__() == "(((()1(()2()))3((()4(()5()))6()))7(()8()))"
    bst.put(8, 10)
    assert bst.__str__() == "(((()1(()2()))3((()4(()5()))6()))7(()8()))"

def testPrint():
    bst = BinarySearchTree()
    assert bst.__str__() == "()"
    bst.put(7, 7)
    bst.put(8, 8)
    bst.put(3, 3)
    bst.put(1, 1)
    bst.put(2, 2)
    bst.put(6, 6)
    bst.put(4, 4)
    bst.put(5, 5)
    assert bst.__str__() == "(((()1(()2()))3((()4(()5()))6()))7(()8()))"

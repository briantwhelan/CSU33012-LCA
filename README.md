# CSU33012-LCA
## Overview
I have implemented the LCA algorithm in both Java and Python, with Python being a language I had never used previously. For my Java implementation, I used JUnit to test my code, while for the Python implementation I used pytest.

## My Approach
My approach was to build a binary search tree data structure in a test-driven manner and then implement a simple LCA algorithm on this data structure. I focused on doing all of this is a test-driven manner, making the tests first and then working on the actual code to pass the tests.  My Python implementation was basically a translation of my Java code, which was challenging in itself given how unfamiliar I was with the python syntax.

## Extension to incorporate DAGs
After reviewing the new requirements, it was clear that my BinarySearchTree data structure was not capable of handling directed acyclic graphs and moreover, not easily adaptable to this requirement. Hence, I decided to discard this implementation and build a new data structure, DirectedGraph, to enable the extension to the specification to be implemented.

I started by getting the data structure working as intended and then went about getting my LCA algorithm to work against all the previous test cases I had used in my BinarySearchTree implementation. I then added a series of additional tests which were not handled with the BinarySearchTree but should be covered given the specification. Implementing LCA on DAGs was therefore well-structured and easy to do once the basics were in place. All methods were preceded by appropriate JUnit tests as before, embracing a test-driven approach.

## Any Questions?
Feel free to send me an email with any questions: whelanb8@tcd.ie

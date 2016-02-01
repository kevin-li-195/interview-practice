import math

class Node:
    val = 0
    next = None

    def __init__(self, data, node=None):
        self.val = data
        self.next = node

    def printNodes(self):
        while self != None:
            print(str(self.val))
            self = self.next

    # Question 2.4 : Partition a linked list around value x, such that all nodes less
    # than x come before all nodes greater than or equal to x
    # Input: head of linked list. Returns: void
    def partition(self, dat):
        runner = self
        if runner == None:
            return

        runner2 = self.next
        if runner2 == None:
            return

        
        lastNode = self
        while lastNode.next != None:
            lastNode = lastNode.next

        while runner2 != None:
            if runner.val < dat:
                print("if")
                runner = runner.next
                runner2 = runner2.next
            else:
                print("else")
                lastNode.next = runner
                runner.next = None
                runner = runner2
                runner2 = runner.next

# Question 2.5 : You have two numbers represented by a linked list, where each node
# contains a single digit. The digits are stored in reverse order, such that the 1's digit
# is at the head of list. Write a function that adds the two numbers and returns the sum as a linked list.
def addLists(a, b):
    exp = 0
    leftOp = 0
    rightOp = 0
    while a != None:
        leftOp += a.val*(10**exp)
        exp += 1
        a = a.next
    exp = 0
    while b != None:
        rightOp += b.val*(10**exp)
        exp += 1
        b = b.next
    exp -= 1
    sum = leftOp + rightOp
    leftMost = sum//(10**exp)
    nextNode = Node(leftMost)
    sum -= leftMost*(10**exp)
    exp -= 1
    while exp >= 0:
        quotient = sum//(10**exp)
        nextNode = Node(quotient, nextNode)
        sum -= quotient*(10**exp)
        exp -= 1
    return nextNode

# Question 2.6 : Given a circular linked list, implement an algorithm which returns the node at the
# beginning of the loop. Definition of a circular linked list: A (corrupt) linked list in which
# a node's pointer points to an earlier node, so as to make a loop in the linked list.
def getLoop(node):
    head = node
    runner = node
    head = head.next
    runner = runner.next.next
    while head != runner:
        print(node.val)
        head = head.next
        runner = runner.next.next
    # Now head and runner are both in the loop.

    head = node

    while head != runner:
        print("Head is " + str(head.val) + " and runner is " + str(runner.val))
        head = head.next
        runner = runner.next
    return head

# Question 2.7 : Check if linked list is a palindrome
def isPalindrome(node):
    head = node
    newList = Node(head.val)
    head = head.next
    while head != None:
        newList = Node(head.val, newList)
        head = head.next
    while node != None and newList != None:
        if node.val != newList.val:
            return False
        node = node.next
        newList = newList.next
    return True

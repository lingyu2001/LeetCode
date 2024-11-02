# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def length(self, head):
        p = head
        sz = 0
        while p:
            sz += 1
            p = p.next
        return sz

    def sortedListToBST(self, head: Optional[ListNode]) -> Optional[TreeNode]:
        self.head = head
        sz = self.length(head)
        return self.convert(0, sz - 1)

    def convert(self, lo, hi):
        if lo > hi:
            return None
        mid = lo + (hi - lo) // 2
        left = self.convert(lo, mid - 1)
        node = TreeNode(self.head.val)
        node.left = left
        self.head = self.head.next
        right = self.convert(mid + 1, hi)
        node.right = right
        return node

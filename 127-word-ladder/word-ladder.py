from collections import deque, defaultdict

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: list) -> int:
        # Convert wordList to a set for O(1) lookups
        wordSet = set(wordList)
        if endWord not in wordSet:
            return 0
        
        # BFS initialization
        queue = deque([(beginWord, 1)])  # Each element is a tuple (word, depth)
        visited = set([beginWord])

        while queue:
            current_word, depth = queue.popleft()

            # Generate all possible one-letter transformations
            for i in range(len(current_word)):
                for c in 'abcdefghijklmnopqrstuvwxyz':
                    transformed_word = current_word[:i] + c + current_word[i+1:]

                    # Check if the transformed word is the endWord
                    if transformed_word == endWord:
                        return depth + 1

                    # If transformed_word is in the wordSet and not visited
                    if transformed_word in wordSet and transformed_word not in visited:
                        visited.add(transformed_word)
                        queue.append((transformed_word, depth + 1))
        
        # If we exit the loop without finding endWord
        return 0

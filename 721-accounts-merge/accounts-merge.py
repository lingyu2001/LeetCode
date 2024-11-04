from typing import List
from collections import defaultdict

class Solution:
    def DFS(self, mergedAccount: List[str], email: str):
        self.visited.add(email)
        # Add the email to the current component's emails
        mergedAccount.append(email)
        
        if email not in self.adjacent:
            return
        
        for neighbor in self.adjacent[email]:
            if neighbor not in self.visited:
                self.DFS(mergedAccount, neighbor)

    def accountsMerge(self, accountList: List[List[str]]) -> List[List[str]]:
        self.visited = set()
        self.adjacent = defaultdict(list)
        # Build the adjacency list
        for account in accountList:
            accountFirstEmail = account[1]
            for email in account[2:]:
                self.adjacent[accountFirstEmail].append(email)
                self.adjacent[email].append(accountFirstEmail)
        
        # Traverse over all accounts to find connected components
        mergedAccounts = []
        for account in accountList:
            accountName = account[0]
            accountFirstEmail = account[1]
            
            # Perform DFS if email is not visited yet
            if accountFirstEmail not in self.visited:
                mergedAccount = [accountName]
                self.DFS(mergedAccount, accountFirstEmail)
                mergedAccount[1:] = sorted(mergedAccount[1:])  # Sort emails alphabetically
                mergedAccounts.append(mergedAccount)
        
        return mergedAccounts

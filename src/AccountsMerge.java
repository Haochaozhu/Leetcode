import java.util.*;

/**
 * Given a list accounts, each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name,
 * and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some email that
 * is common to both accounts. Note that even if two accounts have the same name, they may belong to different people as people
 * could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the
 * rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Example 1:
 * Input:
 * accounts = [["John", "johnsmith@mail.com", "john00@mail.com"], ["John", "johnnybravo@mail.com"],
 * ["John", "johnsmith@mail.com", "john_newyork@mail.com"], ["Mary", "mary@mail.com"]]
 * Output: [["John", 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com'],
 * ["John", "johnnybravo@mail.com"], ["Mary", "mary@mail.com"]]
 * Explanation:
 * The first and third John's are the same person as they have the common email "johnsmith@mail.com".
 * The second John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Note:
 *
 * The length of accounts will be in the range [1, 1000].
 * The length of accounts[i] will be in the range [1, 10].
 * The length of accounts[i][j] will be in the range [1, 30].
 */
public class AccountsMerge {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> ans = new ArrayList<>();
        Map<String, Set<String>> graph = new HashMap<>();
        Map<String, String> table = new HashMap<>(); // Email <-> Username mapping
        for (List<String> account: accounts) {
            String username = account.get(0);
            for (int i = 1; i < account.size(); i += 1) {
                if (!graph.containsKey(account.get(i))) graph.put(account.get(i), new HashSet<>());
                table.put(account.get(i), username);
                if (i == 1) continue;
                graph.get(account.get(i)).add(account.get(i - 1));  // add adj[]
                graph.get(account.get(i - 1)).add(account.get(i)); // add adj[]
            }
        }
        Set<String> visited = new HashSet<>();
        for (String email : table.keySet()) { //do dfs search for its neighbors and add them.
            ArrayList temp = new ArrayList();
            if (visited.add(email)) {
                dfs(email, visited, temp, graph);
                Collections.sort(temp);
                temp.add(0, table.get(email));
                ans.add(temp);
            }
        }
        return ans;
    }
    private void dfs(String email, Set<String> visited, ArrayList<String> temp, Map<String, Set<String>> graph) {
        temp.add(email);
        Set<String> neighbor = graph.get(email);
        for (String neighb : neighbor) {
            if (visited.add(neighb)) {
                dfs(neighb, visited, temp, graph);
            }
        }
    }
}

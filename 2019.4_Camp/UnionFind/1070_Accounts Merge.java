class UnionFind {
    private int[] father = null;
    
    public UnionFind(int n) {
        father = new int[n];
        for (int i = 0; i < n; i++) {
            father[i] = i;
        }
    }
    
    public int find (int a) {
        if (father[a] == a) {
            return a;
        }
        return father[a] = find(father[a]);
    } 
    
    public void connect (int id1, int id2) {
        int father1 = find(id1);
        int father2 = find(id2);
        if (father2 != father1) {
            father[father1] = father2;
        }
    }
}

public class Solution {
    /**
     * @param accounts: List[List[str]]
     * @return: return a List[List[str]]
     */

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        List<List<String>> res = new ArrayList<>();
        if (accounts == null || accounts.size() == 0) {
            return res;
        }
        
        UnionFind union_find = new UnionFind(accounts.size());
        
        //通过map emailToId 合并有相同email的ID；
        Map<String, Integer> emailToId = new HashMap<>();
        for (int i = 0; i < accounts.size(); i++) {
            List<String> account = accounts.get(i);
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (!emailToId.containsKey(email)) {
                    emailToId.put(email, i);
                } else {
                    union_find.connect(i, emailToId.get(email));
                }
            }
        }
        
        //通过map idToEmail 列出所有结果
        Map<Integer, List<String>> idToEmail = new HashMap<>();
        for (String email : emailToId.keySet()) {
            int fatherID = union_find.find(emailToId.get(email));
            if (!idToEmail.containsKey(fatherID)) {
                idToEmail.put(fatherID, new ArrayList<>());
            } 
            
            idToEmail.get(fatherID).add(email);
        }
        
        //按照顺序整理结果输出map到res
        for (int id : idToEmail.keySet()) {
            List<String> account = new ArrayList<>();
            account.add(accounts.get(id).get(0));
            
            List<String> emails = idToEmail.get(id);
            Collections.sort(emails);
            
            account.addAll(emails);
            res.add(account);
        }
        
        return res;
    }
}

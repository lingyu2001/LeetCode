class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < emails[i].length(); j++) {
                // c == '.' -> ignore this dot and continue;
                char c = emails[i].charAt(j);
                if (c == '.') {
                    continue;
                } else if (c == '+') {
                    j++;
                    while (j < emails[i].length() && emails[i].charAt(j) != '@') {
                        j++;
                    }
                    j--;
                } else if (c == '@') {
                    sb.append(emails[i].substring(j, emails[i].length()));
                    break;
                } else {
                    sb.append(c);
                }
                // c == '+' -> go to the index where the @ is
            }
            // System.out.println(sb.toString());
            if (!set.contains(sb.toString())) {
                    set.add(sb.toString());
            }
        }
        return set.size();
    }
}
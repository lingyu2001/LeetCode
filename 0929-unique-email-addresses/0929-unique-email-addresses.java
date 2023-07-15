class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (int i = 0; i < emails.length; i++) {
            String[] split = emails[i].split("@");
            String local = split[0];
            String domain = split[1];
            String[] splitLocal = local.split("\\+");
            String legalLocal = splitLocal[0];
            legalLocal = legalLocal.replace(".","");
            String newString = legalLocal + "@" + domain;
            if (!set.contains(newString)) set.add(newString);
        }
        return set.size();
    }
}
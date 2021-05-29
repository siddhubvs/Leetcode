class Solution {
    public int[][] reconstructQueue(int[][] people) {
        if (people == null || people.length <= 1) {
            return people;
        } 
        
        List<int[]> queue = new ArrayList<>();
        Arrays.sort(people, new PersonComparator());
        for (int i = 0; i < people.length; i++) {
            queue.add(people[i][1], new int[] {people[i][0], people[i][1]});
        }
        for (int i = 0; i < people.length; i++) {
            people[i][0] = queue.get(i)[0];
            people[i][1] = queue.get(i)[1];
        }
        
        return people;
    }
}

class PersonComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] p1, int[] p2) {
        return p2[0] - p1[0] != 0 ? p2[0] - p1[0] : p1[1] - p2[1];
    
    }
}

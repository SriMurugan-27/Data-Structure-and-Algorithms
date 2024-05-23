package interval;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class InsertInterval {

    public static class Interval{
        private int start;
        private int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public void printList(List<Interval> list){
        for(Interval i : list){
            System.out.print("[" + i.start + ", " + i.end + "]");
        }
        System.out.println();
    }

    public List<Interval> insert(List<Interval> list, Interval newInterval){
        if(list == null || list.isEmpty()){
            return list;
        }

        list.sort(Comparator.comparingInt(in -> in.start));
        List<Interval> result = new LinkedList<>();
        int i = 0;

        while(i < list.size() && list.get(i).end < newInterval.start){
            result.add(list.get(i));
            i++;
        }

        while(i < list.size() && list.get(i).start <= newInterval.end){
            Interval current = list.get(i);
            newInterval.start = Math.min(current.start, newInterval.start);
            newInterval.end = Math.max(current.end, newInterval.end);
            i++;
        }

        result.add(newInterval);
        while(i < list.size()){
            result.add(list.get(i));
            i++;
        }

        return result;
    }

    public static void main(String[] args) {
        List<Interval> li = new LinkedList<>();
        li.add(new Interval(8, 10));
        li.add(new Interval(1, 3));
        li.add(new Interval(5, 7));

        InsertInterval i = new InsertInterval();
        i.printList(li);

        List<Interval> ans = i.insert(li, new Interval(4, 9));
        i.printList(ans);
    }
}

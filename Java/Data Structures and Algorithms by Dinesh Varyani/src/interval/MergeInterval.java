package interval;

import java.util.*;

public class MergeInterval {
    public static class Interval{
        private final int start;
        private final int end;

        public Interval(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    public void printList(List<Interval> li){
        for(Interval i : li){
            System.out.print("[" + i.start + ", " + i.end + "]");
        }
        System.out.println();
    }


    public List<Interval> merge(List<Interval> list){
        if(list.size() < 2) return list;
        list.sort(Comparator.comparingInt(in -> in.start));
        List<Interval> result = new LinkedList<>();
        int start = list.get(0).start;
        int end = list.get(0).end;

        for(int i = 1; i < list.size(); i++){
            Interval current = list.get(i);
            if(current.start <= end){
                end = Math.max(current.end, end);
            }else{
                result.add(new Interval(start, end));
                start = current.start;
                end = current.end;
            }
        }
        result.add(new Interval(start, end));
        return result;
    }

    public static void main(String[] args) {
        List<Interval> li = new LinkedList<>();
        li.add(new Interval(2, 6));
        li.add(new Interval(1, 3));
        li.add(new Interval(8, 10));

        MergeInterval i = new MergeInterval();
        i.printList(li);

        List<Interval> result = i.merge(li);
        i.printList(result);
    }
}

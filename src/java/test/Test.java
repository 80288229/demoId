package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Test {

  public static void main(String[] args) {
    int[] w = {8, 10, 1, 9, 4, 3};
    ArrayList<Integer> nums = new ArrayList<>();
    for (int i : w) {
      nums.add(i);
    }

    Comparator<Integer> comparator = new Comparator<Integer>() {

      @Override
      public int compare(Integer o1, Integer o2) {
        /*按员工编号正序排序*/
        return o1 - o2;
        /*按员工编号逆序排序*/
        //return o2.getEmpno()-o1.getEmpno();
        /*按员工姓名正序排序*/
        //return o1.getEname().compareTo(o2.getEname());
        /*按员工姓名逆序排序*/
        //return o2.getEname().compareTo(o1.getEname());
      }

    };

    Collections.sort(nums, comparator);
  }

}

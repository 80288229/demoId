package Algorithm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 一般背包问题 贪心算法
 */
public class Pest {

  Integer id;//序号
  Integer w;//重量
  Integer p;//价值

  public Pest(Integer id, Integer w, Integer p) {
    this.id = id;
    this.w = w;
    this.p = p;
  }

  @Override
  public String toString() {
    return "Pest{" +
        "id=" + id +
        ", w=" + w +
        ", p=" + p +
        '}';
  }

  static List<Pest> commonPackage(int[] w, int[] p, int m) {
    // 构造物体对象列表（将入参存储在List<Pest>中）
    List<Pest> Pests = new ArrayList<>();
    for (int i = 0; i < w.length; i++) {
      Pests.add(new Pest(i + 1, w[i], p[i]));
    }
    // 根据性价比排序（从高到低排序）
    Collections.sort(Pests, new Comparator<Pest>() {
      @Override
      public int compare(Pest b1, Pest b2) {
        return b2.p / b2.w - b1.p / b1.w;
      }
    });
    // 将物体按照性价比从高到低依次加入背包
    int rest = m;// 剩余重量
    int i = 0;
    List<Pest> results = new ArrayList<>();// 存放结果集
    for (; i < Pests.size(); i++) {
      if (rest < Pests.get(i).w) {
        break;
      }
      Pest curPest = Pests.get(i);
      results.add(curPest);
      rest -= curPest.w;
    }
    // 计算最后一个物体能放入的部分
    Pest lastPest = Pests.get(i);
    results.add(new Pest(lastPest.id, rest, (lastPest.p * rest / lastPest.w)));
    return results;
  }

  public static void main(String[] args) {
    int[] w = {8, 10, 1, 9, 4, 3};
    int[] p = {2, 3, 4, 5, 6, 7};
    List<Pest> pests = commonPackage(w, p, 22);
    for (Pest pest : pests) {
      System.out.println(pest.toString());
    }


  }
}

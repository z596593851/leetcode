package com.hxm;

import java.util.*;

/**
 * 整数拆分
 */
class UniqueList extends ArrayList{

    @Override
    public boolean equals(Object o) {
        UniqueList comp = (UniqueList) o;
        Collections.sort(this);
        Collections.sort(comp);
        if (this.isEmpty() || comp.isEmpty() || this.size() != comp.size())
            return false;
        for (int i = 0; i < this.size(); i++){
            if (this.get(i)!=comp.get(i)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 0;
    }
}

public class IntegerDivide {
    static Set<UniqueList> result=new HashSet<>();
    public void divide(int a, UniqueList list){
        for(int i=1;i<=a/2; i++){
            list.add(i);
            divide(a-i,list);
            list.remove(list.size()-1);
        }
        list.add(a);
        UniqueList subList=new UniqueList();
        subList.addAll(list);
//        Collections.addAll(subList,new Object[list.size()]);
//        Collections.copy(subList,list);
        result.add(subList);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        IntegerDivide integerDivide=new IntegerDivide();
        integerDivide.divide(5,new UniqueList());
        for(List<Integer>list:result){
            for(int i:list){
                System.out.print(i);
            }
            System.out.println("");
        }
    }
}

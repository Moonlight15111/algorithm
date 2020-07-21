package com.moonlight.algorithm.train;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一堆数据：部门ID.部门名字,上级部门ID;部门ID.部门名字,上级部门ID;.....
 * 输出从根部门到最后一个部门的路径
 * 输入的部门不会小于三个,有且只有一个跟部门且根部门的上级部门ID为0
 * @ClassName DeptTree
 * @Description: TODO
 * @Author Moonlight
 * @Date 2020/7/21 22:08
 * @Version V1.0
 **/
public class DeptTree {

    private static List<Dept> deptList = new ArrayList<>();

    public static void main(String[] args) {
        String s = "1,A,0;2,B,1;3,C,1;4,D,2";
        parseData(s);
        Dept dept = builderDeptTree();
        System.out.println(deptList);
        System.out.println(dept);
    }

    public static void parseData(String data){
        if (data == null || "".equals(data) || data.split(";").length < 3) {
            return;
        }
        String[] deptArr = data.split(";");

        String[] deptDataArr;
        Dept d;
        for (String dept : deptArr) {
            deptDataArr = dept.split(",");
            d = new Dept();
            d.setId(Integer.valueOf(deptDataArr[0]));
            d.setName(deptDataArr[1]);
            d.setPid(Integer.valueOf(deptDataArr[2]));
            d.setSubDept(new ArrayList<>());
            deptList.add(d);
        }
    }

    public static Dept builderDeptTree(){
        if (deptList == null || deptList.size() == 0) {
            return null;
        }
        Dept root = null;

        for (Dept dept : deptList) {
            if (dept.getPid() == 0) {
                root = dept;
                break;
            }
        }

        recursionBuilder(root, deptList);

        return root;
    }

    private static void recursionBuilder(Dept root, List<Dept> deptList) {
        for (Dept dept : deptList) {
            if (dept.getPid().equals(root.getId())) {
                root.getSubDept().add(dept);
                recursionBuilder(dept, deptList);
            }
        }
    }


    @Data
   static class Dept {
       private String name;
       private Integer id;
       private Integer pid;
       private List<Dept> subDept;
   }
}

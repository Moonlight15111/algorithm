# algorithm

moonlight 练习算法与JVM相关知识的项目

#### 介绍
moonlight study algorithm project

#### 归并排序

1.  整体是递归，左边排好序 + 右边排好序 + merge 让整体上变得有序

#### 快速排序

1.  主要思想是分区Partition
2.  选定一个数（或两个）作为轴，小于等于轴的数放在数组的左边，大于轴的数放在数组的右边
3.  荷兰国旗问题

#### 堆

1.  本质上是一个完全二叉树，如果每棵子树的最大值都在顶部就是大根堆，
    如果每棵子树的最小值都在顶部就是小根堆
2.  从上到下建堆，时间复杂度为O(N*logN)，从下到上，时间复杂度为O(N) 
3.  先组成一个大根堆形式，然后把堆的最大值和堆末尾的值交换，然后在减少堆的大小之后去调整堆，
    一直周而复始，时间复杂度为O(N*logN) 

#### 前缀树

1.  字符从前到后的加到一棵多叉树上，如果没有路就新建，如有路就复用
2.  沿途节点的pass值增加1，每个字符串结束时来到的节点end值增加1

#### 桶排序

1.  不基于比较的排序，使用辅助空间进行排序
2.  计数排序
3.  基数排序

#### 排序算法稳定性

		      时间复杂度	   额外空间复杂度  稳定性
1.  选择排序		O(N^2)			O(1)		无
2.  冒泡排序		O(N^2)			O(1)		有
3.  插入排序		O(N^2)			O(1)		有
4.  归并排序		O(N*logN)		O(N)		有
5.  随机快排		O(N*logN)		O(logN)		无
6.  堆排序		O(N*logN)		O(1)		无
7.  计数排序		O(N)			O(M)		有
8.  基数排序		O(N)			O(N)		有

#### 链表问题技巧

1.  使用容器(哈希表、数组等)
2.  快慢指针 

#### 二叉树

1.  先序：头左右  中序：左头右  后序：左右头  本质都是基于递归序

#### 贪心

1.  局部最功利的标准，总是做出在当前看来是最好的选择
2.  如何证明局部最功利的标准可以得到全局最优解

#### 并查集

1.  每个节点都有一条往上指的指针，节点a往上找到的根节点，叫做a所在集合的代表元
2.  查询x和y是否属于同一个集合，就是看看找到的代表元是不是一个
3.  把x和y各自所在集合的所有点合并成一个集合，
    只需要小集合的代表点挂在大集合的代表点的下方即可
    
#### 图

1.  由点的集合和边的集合构成
2.  虽然存在有向图和无向图的概念，但实际上都可以用有向图来表达
3.  边上可能带有权值
4.  邻接表法
5.  邻接矩阵法
# 简介
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;数据结构与算法的学习笔记

# 目录

* 数据结构
  * [树](#tree)

# 数据结构

<a name="tree"></a>

## 树

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;树（Tree）是n（n≥0）个节点的有限集合，当n=0时，为空树；n>0时，为非空树。任意一棵非空树，满足：

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;1.有且仅有一个称之为根的节点；

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;2.除根节点外的其余节点可分为m（m>0）个互不相交的有限集T1，T2，...，Tm，其中每一个集合本身又是一棵树，并且成为根的子树（SubTree）。

### 名词解释
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**节点**——节点包含数据元素及若干指向子树的分支信息。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**节点的度**——节点拥有的子树的个数。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**树的度**——树中节点的最大度数。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**终端节点**——度为0的节点，又称为**叶子**。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**分支节点**——度大于0的节点。除了叶子都是分支节点。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**内部节点**——除了树根和叶子都是内部节点。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**节点的层次**——从根到该节点的层数（根节点为第1层）。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**树的深度（或高度）**——指所有节点中最大的层数。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**路径**——树中两个节点之间的所经过的节点序列。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**路径长度**——两节点之间路径上经过的边数。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**双亲、孩子**——节点的子树的根称为该节点的孩子。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**兄弟**——双亲相同的节点互称兄弟。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**堂兄弟**——双亲是兄弟的节点互称堂兄弟。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**祖先**——即从该节点到树根经过的所有节点，称为该节点的祖先。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**子孙**——节点的子树中的所有节点都称为该节点的子孙。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**有序树**——节点的各子树从左至右有序，不能互换位置。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**无序树**——节点各子树可互换位置。

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;**森林**——由m（m≥0）棵不相交的树组成的集合。

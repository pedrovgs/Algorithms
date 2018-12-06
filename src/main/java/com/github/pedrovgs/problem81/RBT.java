/*
 * Copyright (C) 2014 Pedro Vicente Gómez Sánchez.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.github.pedrovgs.problem81;

import com.github.pedrovgs.sortingalgorithm.SortingAlgorithm;

/**
 * Given an array full of integers implement a quick sort algorithm to sort the content inside
 * the array.
 *
 * @author jsroyal
 */

  /**
   * Quicksort (sometimes called partition-exchange sort) is an efficient sorting algorithm, serving
   * as a systematic method for placing the elements of an array in order. Developed by Tony Hoare
   * in 1959 and published in 1961, it is still a commonly used algorithm for sorting. When
   * implemented well, it can be about two or three times faster than its main competitors, merge
   * sort and heapsort.
   *
   * Quicksort is a comparison sort, meaning that it can sort items of any type for which a
   * "less-than" relation (formally, a total order) is defined. In efficient implementations it is
   * not a stable sort, meaning that the relative order of equal sort items is not preserved.
   * Quicksort can operate in-place on an array, requiring small additional amounts of memory to
   * perform the sorting.
   *
   * Mathematical analysis of quicksort shows that, on average, the algorithm takes O(n log n)
   * comparisons to sort n items. In the worst case, it makes O(n2) comparisons, though this
   * behavior is rare.
   */

import java.util.ArrayList;

public class RBT{
	
	int count=0;
    private final boolean RED = false;
    private final boolean BLACK = true;
    
    private final Node NIL = new Node(-999);
    
    public Node root = NIL;
    
    public class Node {
        int data;
        boolean color=BLACK;
        Node left, right, parent;

        Node(int data) {
            this.data = data;
            this.left=NIL;
            this.right=NIL;
            this.parent=NIL;
        } 
    }

    public void insert(int n) {
    	Node node = new Node(n);
        Node temp = root;
        if (root == NIL) {
            root = node;
            node.color = BLACK;
            node.parent = NIL;
        } else {
            node.color = RED;
            while (true) {
            	if(n>temp.data) {
            		if(temp.right!=NIL) {
            			temp = temp.right;
            		}else {
                        temp.right = node;
                        node.parent = temp;
                        break;
            		}
            	}else {
            		if(temp.left!=NIL) {
            			temp = temp.left;
            		}else {
                        temp.left = node;
                        node.parent = temp;
                        break;
            		}
            	}
            }
            makeRBT(node);
        }
    }

    private void makeRBT(Node node) {
        while (node.parent.color == RED) {
            Node s = NIL;
            if (node.parent == node.parent.parent.right) {
            	s = node.parent.parent.left;
                if (s != NIL && s.color == RED) {//case1
                   s.color = BLACK;
                   node.parent.parent.color = RED;
                   node.parent.color=BLACK;
                   node = node.parent.parent;
                   continue;
               }
               if (node == node.parent.left) {//case2-1
                   node = node.parent;
                   rotateRight(node);//->case2-2
               }//case2-2
               node.parent.color = BLACK;
               node.parent.parent.color = RED;
               rotateLeft(node.parent.parent);
            } else {
            	s = node.parent.parent.right;
            	if (s != NIL && s.color == RED) {//case1 : parent and s is all red
            	    s.color = BLACK;
            	    node.parent.color=BLACK;
            	    node.parent.parent.color = RED;
            	    node = node.parent.parent;
            	    continue;
            	} 
            	if (node == node.parent.right) {//case2-1
            	    node = node.parent;
            	    rotateLeft(node);//->case2-2
            	}//case2-2 
            	node.parent.color = BLACK;
            	node.parent.parent.color = RED;
            	rotateRight(node.parent.parent);
            }
        }
        root.color = BLACK;//root always black
    }

    private void rotateLeft(Node node) {
        if (node.parent == NIL) {
            Node right = root.right;
            root.right = right.left;
            right.left.parent = root;
            root.parent = right;
            right.left = root;
            right.parent = NIL;
            root = right;
        } else {
        	if (node == node.parent.right) {
        		node.parent.right = node.right;
            } else {
            	node.parent.left = node.right; 
            }
            node.right.parent = node.parent;
            node.parent = node.right;
            if (node.right.left != NIL) {
                node.right.left.parent = node;
            }
            node.right = node.right.left;
            node.parent.left = node;
        }
    }

   private void rotateRight(Node node) {
        if (node.parent == NIL) {
            Node left = root.left;
            root.left = root.left.right;
            left.right.parent = root;
            root.parent = left;
            left.right = root;
            left.parent = NIL;
            root = left;        	
        } else {
            if (node == node.parent.right) {
            	node.parent.right = node.left;
            } else {
            	node.parent.left = node.left; 
            }
            node.left.parent = node.parent;
            node.parent = node.left;
            if (node.left.right != NIL) {
                node.left.right.parent = node;
            }
            node.left = node.left.right;
            node.parent.right = node;
        }
    }
    
	public Node Search(Node x,int k) {
		count++;
		if(x==null || x.data==k) {
			return x;
		}
		if(k>x.data) {
			return Search(x.right,k);
		}else {
			return Search(x.left,k);
		}
	}
	
	public int getCount() {
		return count;
	}
    
    public void inorder(Node n) {
        if (n == NIL) {
            return;
        }
        inorder(n.left);
        System.out.print("data: "+n.data+((n.color==BLACK)?"| color: Red\n":"| color: Black\n"));
        inorder(n.right);
    }
    
	public void get_Sorted_List(Node n, ArrayList<Integer> arr) {
		if(n==NIL) return;
		if(n.left !=null)
			get_Sorted_List(n.left,arr);
		arr.add(n.data);
		if(n.right !=null)
			get_Sorted_List(n.right,arr);
	}
 
}
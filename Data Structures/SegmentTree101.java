import java.util.*;
public class SegmentTree101 {

    static void createTree(int[] inp ,int[] tree, int start ,int end , int treeNodeIndex){

        if(start == end){
            tree[treeNodeIndex] = inp[start];
            return;
        }

        int mid = (start+end)/2;

        createTree(inp,tree,start,mid,2*treeNodeIndex);
        createTree(inp,tree,mid+1,end,(2*treeNodeIndex)+1);

        tree[treeNodeIndex] = tree[treeNodeIndex*2] + tree[treeNodeIndex*2+1];

    }

    static void updateTree(int[] inp, int[] tree,int start , int end , int treeNodeIndex , int idx , int value){

        if(start==end){
            // we have reached the node that needs to be changed
            tree[treeNodeIndex] = value;
            return;
        }


        int mid = (start + end) / 2 ;

        if(idx > mid){
            // going towards the right subtree
            updateTree(inp,tree,mid+1,end,2*treeNodeIndex+1,idx,value);
        }else{
            // going towards the left subtree
            updateTree(inp,tree,start,mid,2*treeNodeIndex,idx,value);
        }

        tree[treeNodeIndex] = tree[2*treeNodeIndex] + tree[2*treeNodeIndex + 1];

    }

    static int query(int[] tree,int start , int end , int treeNodeIndex , int left , int right){


        // range is completely out of given NodeIndex
        if(right < start || end < left){
            return 0;
        }

        // completely inside the given Node Range
        if(start>=left && end<=right){
            return tree[treeNodeIndex];
        }

        // partially inside ans Partially outside the given Range
        int mid = (start + end)/2 ;

        int ans1 = query(tree,start,mid,2*treeNodeIndex,left,right);
        int ans2 = query(tree,mid+1,end,2*treeNodeIndex+1,left,right);

        return ans1+ans2 ;



    }

    public static void main(String[] args) {

        Scanner fs = new Scanner(System.in);
        int n = fs.nextInt();

        int inp[] = new int[n];
        int tree[] = new int[4*n];
        for(int i=0 ; i<n ; i++){
            inp[i] = fs.nextInt();
        }
        createTree(inp,tree,0,n-1,1);
        for(int i=0 ; i<4*n ; i++){
            System.out.println(tree[i]);
        }

    }
}
